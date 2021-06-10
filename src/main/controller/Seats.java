package main.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import main.project.DataBase;
import main.controller.User;
import main.project.Seats;


public class Seats implements Initializable {

    @FXML
    private TableView<Seats> tableView;
    @FXML
    private TableColumn<Seats, String> c1;
    @FXML
    private TableColumn<Seats, String> c2;
    @FXML
    private TableColumn<Seats, String> c3;
    @FXML
    private TableColumn<Seats, String> c4;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        List<main.project.Seats> Seats = DataBase.getseats();

        for (int i = 0; i < Seats.size(); i++) {
            System.out.println("aa" + Seats.get(i));
        }
        c1.setCellValueFactory(new PropertyValueFactory("seatNo"));
        c2.setCellValueFactory(new PropertyValueFactory("seat_Position"));
        c3.setCellValueFactory(new PropertyValueFactory("Check_In_Date"));
        c4.setCellValueFactory(new PropertyValueFactory("isEmpty"));
        try {
            tableView.getItems().addAll(Seats);
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtUsername.setText(login.LoginController.user.getUsername());
    }

}