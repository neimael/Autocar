package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import ConnectionDB.ControlDB;
import javafx.event.ActionEvent;

import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.input.MouseEvent;

public class paiementController {
	@FXML
	private AnchorPane pin;
	
	private Parent fxml;

	@FXML
    private ToggleButton show_btn;
	
	@FXML
    private TextField pass_text;
	
	@FXML
	private TextField card_number;
	
	@FXML
	private PasswordField card_code;

	
	@FXML
    private ImageView show_pass;
	
	@FXML
    void show(ActionEvent event) {
    	if(show_btn.isSelected()) {
    		show_pass.setImage(new Image ("img/invisile.png"));
    		pass_text.setText(card_code.getText());
    		pass_text.setVisible(true);
    		return;
    	}
    	else {
    		show_pass.setImage(new Image ("img/visible.png"));
    		card_code.setText(pass_text.getText());
    		pass_text.setVisible(false);
    	}
    }
	
	private Connection conn;
    private PreparedStatement statement;
    private ResultSet result;
    
	// Event Listener on Button.onAction
	@FXML
	public void insert_pin(ActionEvent event) throws SQLException, IOException, DocumentException {
    	
    	conn = ControlDB.createConnection();
    	
    	String sql = "SELECT numCard,codepin FROM paiement WHERE numCard = ? and codepin = ?";
		
		 statement = conn.prepareStatement(sql);
		 statement.setString(1,card_number.getText());
		 statement.setString(2,card_code.getText());
		 result = statement.executeQuery();
		 
		 if(result.next()) {
			 
			 Document doc = new Document();
			 PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("src/pdf_ticket/ticket.pdf"));
			 doc.open();
			 Paragraph para = new Paragraph("Ticket of Travel !");
			 doc.add(para);
			 doc.close();
			 writer.close();
			 
			 System.out.println("Ticket generated Successfully !");
			 
		     Stage choice = new Stage();

			 
			 JOptionPane.showMessageDialog(null, "Successfully paid !", "Success Message",JOptionPane.INFORMATION_MESSAGE);
			


		    	
		 }
		 else {
			 JOptionPane.showMessageDialog(null, "Wrong Card number/code !", "Error Message",JOptionPane.ERROR_MESSAGE);
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
    		Image image = new Image("img/icon.png");
			choice.getIcons().add(image);
    		choice.setResizable(false);
    		choice.show();
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
	}
}
