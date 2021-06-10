package main.model;

import main.SQLConnection;
import java.sql.*;
import java.sql.Connection;


public class ForgotPasswordModel {
    Connection connection;

    public ForgotPasswordModel() {

        connection = SQLConnection.connect();
        if (connection == null)
            System.exit(1);

    }

    public Boolean isDbConnected() {
        try {
            return !connection.isClosed();
        } catch (Exception e) {
            return false;
        }
    }
    public void forgetPass(String text, String ID, String Secret, String newPassword) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Statement stmt =null;
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate("INSERT INTO employeeID (Password) " +
                    "values ('" + newPassword +"');");
            System.out.println("UPDATE INTO account (newPassword) values '"+ newPassword);

        }
        catch (SQLException e){
            e.printStackTrace();

        }
        stmt.close();
    }
}

