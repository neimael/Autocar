package controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import ConnectionDB.ControlDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class lost_ticketController {
	@FXML
    private Label available_ticket;
	
	@FXML
    private AnchorPane lost;
	private Parent fxml;
	
    @FXML
    private TextField cin;
     @FXML
     private Connection conn;
     private PreparedStatement statement;
     private ResultSet result;
    @FXML
    void extract_ticket(ActionEvent event) throws IOException, DocumentException {
         
    	
		
			 
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

    @FXML
   public void search_ticket(ActionEvent event) throws IOException, DocumentException {
       try {
    	   conn = ControlDB.createConnection();
       	
       	String sql = "SELECT Cin FROM client WHERE Cin=?";
   		
   		 statement = conn.prepareStatement(sql);
   		 statement.setString(1,cin.getText());
   		 
   		 result = statement.executeQuery();
   		 if(result.next()==false) {
   			 JOptionPane.showMessageDialog(null, "Wrong Card number/code !", "Error Message",JOptionPane.ERROR_MESSAGE);
   			 
   		 }else {
   			 ImageIcon icon = new ImageIcon("C:\\Users\\EliteBook\\Downloads.png");
   	        JOptionPane.showMessageDialog(null, "Client Trouvable.", 
   	                "Customized Dialog", JOptionPane.INFORMATION_MESSAGE, icon);
   	                       extract_ticket(event);
   		 }
       }catch(SQLException e) {
    		 System.out.println("SQLException: " + e.getMessage());
 	         System.out.println("SQLState: " +  e.getSQLState());
 	         System.out.println("travelError: " + e.getErrorCode());
       }
    }
    
    @FXML
    void back(MouseEvent event) {
    	lost.getScene().getWindow().hide();
    	Stage choice = new Stage();
    	try {
    		fxml = FXMLLoader.load(getClass().getResource("/application/Choice.fxml"));
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
