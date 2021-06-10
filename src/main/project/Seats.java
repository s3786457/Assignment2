package main.project;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

import main.controller.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Entity
@Table(name = "seat")

public class Seats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seatNo")
    private int seatNo;
    @Column(name = "seat_Position")
    private String seat_Position;
    @Column(name = "Check_In_Date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date Check_In_Date;
    @Column(name = "isEmpty")
    private boolean isEmpty;

    public Seats(String seat_Position, Date Check_In_Date, boolean isEmpty) {
        this.seat_Position = seat_Position;
        this.Check_In_Date = Check_In_Date;
        this.isEmpty = isEmpty;
    }

    public Seats() {
    }

    public boolean isIsEmpty() {
        return isEmpty;
    }

    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setRoomID(int seatNo) {
        this.seatNo = seatNo;
    }

    public String getSeat_Position() {
        return seat_Position;
    }

    public void setSeat_Position(String seat_Position) {
        this.seat_Position = seat_Position;
    }


    public Date getCheck_In_Date() {
        return Check_In_Date;
    }

    public void setCheck_In_Date(Date Check_In_Date) {
        this.Check_In_Date = Check_In_Date;
    }

    @Override
    public String toString() {
        return "Seat{" + "seatNo=" + seatNo + ", seat_Positon=" + seat_Position + ", Check_In_Date=" + Check_In_Date + ", isEmpty=" + isEmpty + '}';
    }

    public static void SeatBooking(User user, Seats seats, int seatNo) {
        System.out.println("in Seat booking() ...");
        AddBookingController(user, seats, seatNo);
        System.out.println("Seat booking done ...");
    }

    public static int CheckIn(User user, Seats s, int seatNo) {

        System.out.println("in Checkin() ...");
        //save guest
        System.out.println("SaveUser() ...");
        User.SaveUser(user);

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Seats.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session = factory.getCurrentSession();
            session.beginTransaction();


            System.out.println("\nGetting seat with id: " + seatNo);

            Seats seats = (Seats) session.get(Seats.class, seatNo);

            System.out.println("Updating Room...");
            seats.setIsEmpty(s.isIsEmpty());
            seats.setCheck_In_Date(s.getCheck_In_Date());

            session.getTransaction().commit();

            System.out.println("Check In Complete!");
        } finally {
            factory.close();

        }
        public void CancelBooking(int seatNo) {
            System.out.println("in Cancel Booking() ...");
            CheckOut(seatNo);

        }
        public static int CheckOut(int seatNo) {
            System.out.println("in Check Out() ...");
            int flag = 1;
            System.out.println("Excute delete User() ... ");
            User.deleteUser(seatNo);

            // create session factory
            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Seats.class)
                    .buildSessionFactory();

            // create session
            Session session = factory.getCurrentSession();
            try {

                session = factory.getCurrentSession();
                session.beginTransaction();


                System.out.println("\nGetting room with id: " + seatNo);

                Seats room = (Seats) session.get(Seats.class, seatNo);

                if (room == null) {
                    return -1;
                } else {
                    if (room.isIsEmpty() == true) {
                        flag = 0;
                    }

                    System.out.println("Updating Room...");
                    room.setIsEmpty(true);
                    room.setCheck_Out_Date(new Date());
                }
                // commit the transaction
                session.getTransaction().commit();

                System.out.println("CheckOut Done!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                factory.close();
            }
            return flag;
        }

    }
    }
