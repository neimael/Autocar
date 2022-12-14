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

    private Connection conn;
    private PreparedStatement statement;
    
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
    		Image image = new Image("img/icon.png");
			choice.getIcons().add(image);
    		choice.setResizable(false);
    		choice.initStyle(StageStyle.UNDECORATED);
    		choice.show();
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    
    private ResultSet result;

    @FXML
    void signUp(ActionEvent event) throws SQLException {
    	
    	Stage choice = new Stage();
    	conn = ControlDB.createConnection();
		 
		 String Name = name.getText();
		 String CIN = cin.getText();
		 String Phone = phone_number.getText();
		 String Email = email.getText();
		 String Password = password.getText();
		 
		 String check = "SELECT Cin FROM client WHERE Cin = ?";
		 statement = conn.prepareStatement(check);
		 statement.setString(1,cin.getText());
		 result = statement.executeQuery();
		 
    	if (Name.trim().isEmpty() || CIN.trim().isEmpty() || Password.trim().isEmpty() || Phone.trim().isEmpty() || Email.trim().isEmpty()) {
    		JOptionPane.showMessageDialog(null, "Please Enter all of your informations !", "Error Message",JOptionPane.ERROR_MESSAGE);
    	}
    	else if (result.next()) {
    		JOptionPane.showMessageDialog(null, "CIN Already exists !", "Error Message",JOptionPane.ERROR_MESSAGE);
    	}
    	else {
    		try {
        		
       		 String sql = "INSERT INTO client (name,Cin,Tele,Email,password) VALUES('"+Name+"','"+CIN+"','"+Phone+"','"+Email+"','"+Password+"')";
       		
       		 statement = conn.prepareStatement(sql);
       		 statement.execute();
       		 
       		 JOptionPane.showMessageDialog(null, "Successfully Create new Account !", "Success Message",JOptionPane.INFORMATION_MESSAGE);
       		 
       		
       		fxml = FXMLLoader.load(getClass().getResource("/application/Choice.fxml"));
       		Scene scene = new Scene(fxml);
       		Image image = new Image("img/icon.png");
   			choice.getIcons().add(image);
       		choice.setScene(scene);
       		choice.initStyle(StageStyle.UNDECORATED);
       		choice.setResizable(false);
       		choice.show();
       	} catch(IOException e) {
       		e.printStackTrace();
       	}
       	sign_up.getScene().getWindow().hide();
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
