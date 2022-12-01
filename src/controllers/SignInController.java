package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import ConnectionDB.ControlDB;
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
import javafx.stage.StageStyle;

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
    
    private Connection conn;
    private PreparedStatement statement;
    private ResultSet result;
    
    @FXML
    private AnchorPane sign_in;
	private Parent fxml;

    @FXML
    void signIn(ActionEvent event) throws SQLException {
    	
    	Stage choice = new Stage();
    	
    	conn = ControlDB.createConnection();
    	
    	String sql = "SELECT Cin,password FROM client WHERE Cin = ? and password = ?";
		
		 statement = conn.prepareStatement(sql);
		 statement.setString(1,cin.getText());
		 statement.setString(2, password.getText());
		 result = statement.executeQuery();
		 
		 if(result.next()) {
			 
			 
			 try {
				 JOptionPane.showMessageDialog(null, "Successfully Login !", "Success Message",JOptionPane.INFORMATION_MESSAGE);
		    		fxml = FXMLLoader.load(getClass().getResource("/application/Choice.fxml"));
		    		Scene scene = new Scene(fxml);
		    		 sign_in.getScene().getWindow().hide();
		    		choice.setScene(scene);
		    		choice.initStyle(StageStyle.UNDECORATED);
		    		Image image = new Image("img/icon.png");
					choice.getIcons().add(image);
		    		choice.setResizable(false);
		    		choice.show();
		    	} catch(IOException e) {
		    		e.printStackTrace();
		    	}
			
		    	
		 }
		 else {
			 JOptionPane.showMessageDialog(null, "Wrong Password/CIN !", "Error Message",JOptionPane.ERROR_MESSAGE);
		 }
		 
		 
		 
		 
    	
    	
    }
    
    @FXML
    void back(ActionEvent event) {
    	sign_in.getScene().getWindow().hide();
    	Stage choice = new Stage();
    	try {
    		fxml = FXMLLoader.load(getClass().getResource("/application/home.fxml"));
    		Scene scene = new Scene(fxml);
    		choice.initStyle(StageStyle.UNDECORATED);
    		choice.setScene(scene);
    		Image image = new Image("img/icon.png");
			choice.getIcons().add(image);
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
    		choice.initStyle(StageStyle.UNDECORATED);
    		choice.setResizable(false);
    		Image image = new Image("img/icon.png");
			choice.getIcons().add(image);
    		choice.setScene(scene);
    		choice.show();
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }

}
