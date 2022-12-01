package controllers;

import java.io.IOException;

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
    void extract_ticket(ActionEvent event) {

    }

    @FXML
    void search_ticket(ActionEvent event) {

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
    		Image image = new Image("img/WhatsApp_Image_2022-10-22_at_12.54.26-removebg-preview.png");
			choice.getIcons().add(image);
    		choice.setResizable(false);
    		choice.show();
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }
}
