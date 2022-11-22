package controllers;

import java.io.IOException;

import javax.script.Bindings;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SignInController {

	@FXML
    private ToggleButton show_btn;
	
    @FXML
    private TextField cin;
    
    @FXML
    private TextField pass_text;

    @FXML
    private PasswordField password;

    @FXML
    void show(ActionEvent event) {
    	if(show_btn.isSelected()) {
    		show_pass.setImage(new Image ("img/invisile.png"));
    		pass_text.setText(password.getText());
    		pass_text.setVisible(true);
    		return;
    	}
    	else {
    		show_pass.setImage(new Image ("img/visible.png"));
    		password.setText(pass_text.getText());
    		pass_text.setVisible(false);
    	}
    }
    
    @FXML
    private ImageView show_pass;
    
    @FXML
    private AnchorPane sign_in;
	private Parent fxml;

    @FXML
    void signIn(ActionEvent event) {
    	sign_in.getScene().getWindow().hide();
    	Stage choice = new Stage();
    	try {
    		fxml = FXMLLoader.load(getClass().getResource("/application/Choice.fxml"));
    		Scene scene = new Scene(fxml);
    		choice.setScene(scene);
    		choice.setResizable(false);
    		choice.show();
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    
    @FXML
    void back(ActionEvent event) {
    	sign_in.getScene().getWindow().hide();
    	Stage choice = new Stage();
    	try {
    		fxml = FXMLLoader.load(getClass().getResource("/application/home.fxml"));
    		Scene scene = new Scene(fxml);
    		choice.setScene(scene);
    		choice.setResizable(false);
    		choice.show();
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    
    @FXML
    void signUp(ActionEvent event) {
    	sign_in.getScene().getWindow().hide();
    	Stage choice = new Stage();
    	try {
    		fxml = FXMLLoader.load(getClass().getResource("/application/SignUp.fxml"));
    		Scene scene = new Scene(fxml);
    		choice.setResizable(false);
    		choice.setScene(scene);
    		choice.show();
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }

}
