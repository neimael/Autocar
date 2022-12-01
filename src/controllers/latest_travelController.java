package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.input.MouseEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.image.Image;

public class latest_travelController {
	@FXML
	private AnchorPane result_travel;
	@FXML
	private TableColumn name_company;
	@FXML
	private TableColumn route;
	@FXML
	private TableColumn dep_time;
	@FXML
	private TableColumn arr_time;
	@FXML
	private TableColumn price;
	
	private Parent fxml;

	// Event Listener on Button.onAction
	@FXML
	public void reserver(ActionEvent event) {
		result_travel.getScene().getWindow().hide();
    	Stage choice = new Stage();
    	try {
    		fxml = FXMLLoader.load(getClass().getResource("/application/paiement.fxml"));
    		Scene scene = new Scene(fxml);
    		choice.setScene(scene);
    		choice.setResizable(false);
    		Image image = new Image("img/icon.png");
			choice.getIcons().add(image);
    		choice.initStyle(StageStyle.UNDECORATED);
    		choice.show();
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
	}
	// Event Listener on ImageView.onMousePressed
	@FXML
	public void back(MouseEvent event) {
		result_travel.getScene().getWindow().hide();
    	Stage choice = new Stage();
    	try {
    		fxml = FXMLLoader.load(getClass().getResource("/application/travel.fxml"));
    		Scene scene = new Scene(fxml);
    		choice.setScene(scene);
    		Image image = new Image("img/icon.png");
			choice.getIcons().add(image);
    		choice.initStyle(StageStyle.UNDECORATED);
    		choice.setResizable(false);
    		choice.show();
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
	}
}
