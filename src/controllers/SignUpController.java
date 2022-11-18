package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SignUpController {

    @FXML
    private TextField cin;

    @FXML
    private TextField email;

    @FXML
    private TextField name;

    @FXML
    private TextField password;
	private Parent fxml;

    @FXML
    private TextField phone_number;

    @FXML
    private AnchorPane sign_up;

    @FXML
    void signIn(ActionEvent event) {
    	sign_up.getScene().getWindow().hide();
    	Stage choice = new Stage();
    	try {
    		fxml = FXMLLoader.load(getClass().getResource("/application/SignIn.fxml"));
    		Scene scene = new Scene(fxml);
    		choice.setScene(scene);
    		choice.show();
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void signUp(ActionEvent event) {
    	sign_up.getScene().getWindow().hide();
    	Stage choice = new Stage();
    	try {
    		fxml = FXMLLoader.load(getClass().getResource("/application/Choice.fxml"));
    		Scene scene = new Scene(fxml);
    		choice.setScene(scene);
    		choice.show();
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }

}
