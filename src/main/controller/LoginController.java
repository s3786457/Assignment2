package main.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import main.model.LoginModel;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.io.IOException;


public class LoginController implements Initializable {
    public LoginModel loginModel = new LoginModel();
    @FXML
    private Label isConnected;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    private Hyperlink createAccountLabel;
    private Object e;


    // Check database connection
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (loginModel.isDbConnected()) {
            isConnected.setText("Connected");

        } else {
            isConnected.setText("Not Connected");

        }

    }

    public void Login(ActionEvent event) {

        try {
            if (loginModel.isLogin(txtUsername.getText(), txtPassword.getText())) {

                isConnected.setText("Logged in successfully");
            } else {
                isConnected.setText("username and password is incorrect");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

            @FXML private Button RegisterEvent;

            @FXML public void RegisterEvent(ActionEvent event){
            Scene scene = toRegister.getScene();
            Window window = scene.getWindow();
            Stage primaryStage = (Stage) window;

            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("../view/register.fxml"));
            } catch (IOException e) {
                System.out.println("FXML file error");
            }
            Scene register = new Scene(root, 372, 406);

            primaryStage.setScene(register);

            primaryStage.setTitle("Register Form");
        }
        }
    }




