package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import ConnectionDB.ControlDB;
import javafx.event.ActionEvent;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.input.MouseEvent;

public class paiementController {
	@FXML
	private AnchorPane pin;
	
	private Parent fxml;

	@FXML
	private TextField card_number;
	@FXML
	private TextField card_code;

	
	private Connection conn;
    private PreparedStatement statement;
    private ResultSet result;
    
	// Event Listener on Button.onAction
	@FXML
	public void insert_pin(ActionEvent event) throws SQLException, IOException {
    	
    	conn = ControlDB.createConnection();
    	
    	String sql = "SELECT numCard,codepin FROM paiement WHERE numCard = ? and codepin = ?";
		
		 statement = conn.prepareStatement(sql);
		 statement.setLong(1,Integer.parseInt(card_number.getText()));
		 statement.setLong(2, Integer.parseInt(card_code.getText()));
		 result = statement.executeQuery();
		 
		 if(result.next()) {
			 
			 
			 JOptionPane.showMessageDialog(null, "Successfully paid !", "Success Message",JOptionPane.INFORMATION_MESSAGE);
			
		    	
		 }
		 else {
			 JOptionPane.showMessageDialog(null, "Wrong Card number/code !", "Error Message",JOptionPane.INFORMATION_MESSAGE);
		 }
	}
	// Event Listener on ImageView.onMousePressed
	@FXML
	public void back(MouseEvent event) {
		pin.getScene().getWindow().hide();
    	Stage choice = new Stage();
    	try {
    		fxml = FXMLLoader.load(getClass().getResource("/application/latest_travel.fxml"));
    		Scene scene = new Scene(fxml);
    		choice.initStyle(StageStyle.UNDECORATED);
    		choice.setScene(scene);
    		choice.setResizable(false);
    		choice.show();
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
	}
}
