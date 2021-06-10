package main.model;

import main.SQLConnection;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.String;

public class RegisterModel {
    Connection connection;

    public RegisterModel(){

        connection = SQLConnection.connect();
        if (connection == null)
            System.exit(1);

    }

    public Boolean isDbConnected(){
        try {
            return !connection.isClosed();
        }
        catch(Exception e){
            return false;
        }
    }
    public void isRegister(String text, String username, String password, String question, String answer, String role, String firstName, String lastName) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Statement stmt =null;
        try {
            stmt = connection.createStatement();
            stmt.execute("INSERT INTO employee (username,password,question,answer,role,first_name,last_name) " +
                    "values ('"+ username + "', '" + password +"', '" + question +"', '" + answer + "', '" + role + "', '" + firstName + "', '" + lastName + "');");
            System.out.println("INSERT INTO account (username, password, email, country, gender, first_name, last_name,activation) values ('"+ username + "', '" + password + "', '" + question + "', '" + answer + "', '" + role + "', '" + firstName + "', '" + lastName + "',0)");

        }
        catch (SQLException e){
            e.printStackTrace();

        }
        stmt.close();
    }
}
