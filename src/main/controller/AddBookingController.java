package main.controller;

import main.controller.Seats;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class AddBookingController implements Initializable {
    @FXML
    private TextField IDField;
    @FXML
    private TextField FNameField;
    @FXML
    private TextField LNameField;
    @FXML
    private TextField AgeField;
    @FXML
    private TextField UsernameField;
    @FXML
    private TextField BookingField;
    @FXML
    private Button ClearField;
    @FXML
    private Button SubmitField;
    @FXML
    private Label IDLabel;
    @FXML
    private Label FNameLabel;
    @FXML
    private Label LNameLabel;
    @FXML
    private Label AgeLabel;
    @FXML
    private Label UsernameLabel;
    @FXML
    private Label BookingLabel;

    AddBookingController c = new AddBookingController();


    public boolean isFieldsEmpty() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
        if ("".equals(FNameField.getText()) || "".equals(LNameField.getText())
                || ("".equals(IDField.getText())) || ("".equals(AgeField.getText()))
                || ("".equals(UsernameField.getText())) || ("".equals(IDField.getText())))
            System.out.println("Inside if in isFieldsEmpty() ");

        return true;
    }

    @FXML
    private void SubmitField(ActionEvent event) {
        System.out.println("submitAction clicked");

                }
            }