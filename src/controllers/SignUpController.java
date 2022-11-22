package controllers;

import java.io.IOException;

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

public class SignUpController {

    @FXML
    private TextField cin;

    @FXML
    private TextField email;

    @FXML
    private ImageView show_pass;
    
    @FXML
    private TextField name;
    
    @FXML
    private TextField pass_text;

    @FXML
    private PasswordField password;
    
	private Parent fxml;

	@FXML
    private ToggleButton show_btn;
	
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
    		choice.setResizable(false);
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
    		choice.setResizable(false);
    		choice.show();
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    
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

}
