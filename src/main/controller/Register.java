package main.controller;

        import java.awt.Color;
        import java.awt.EventQueue;
        import java.awt.Font;
        import java.awt.Image;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.sql.*;

        import javafx.fxml.FXML;
        import javafx.scene.control.TextField;
        import main.model.RegisterModel;
        import main.model.ForgotPasswordModel;

        import java.net.URL;
        import java.sql.SQLException;
        import java.util.ResourceBundle;
        import java.lang.String;




public class Register {
    private RegisterModel registerModel = new RegisterModel();
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtRole;
    @FXML
    private TextField txtQuestion;
    @FXML
    private TextField txtAnswer;
    @FXML
    private TextField txtID;


    public void Register(ActionEvent event) {
        try {
            registerModel.isRegister(txtUsername.getText(), txtPassword.getText(), txtQuestion.getText()
                    , txtAnswer.getText(), txtID.getText(), txtRole.getText(), txtFirstName.getText(), txtLastName.getText());
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}