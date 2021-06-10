package main.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import main.model.ForgotPasswordModel;
import main.model.RegisterModel;

import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class ForgottenPassword {

    private ForgotPasswordModel forgotPasswordModel = new ForgotPasswordModel();
    @FXML
    private TextField txtID;
    @FXML
    private TextField txtnewPassword;
    @FXML
    private TextField txtSecret;



    public void ForgottenPassword(ActionEvent event) {

        try {
            ForgotPasswordModel.forgetPass; txtID.getText(); txtnewPassword.getText(); txtSecret.getText(); ;
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}