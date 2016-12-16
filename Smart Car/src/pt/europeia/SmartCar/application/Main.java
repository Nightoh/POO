package pt.europeia.SmartCar.application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	
	private static Stage logStage;


	@Override
	public void start(Stage primaryStage) {
		try {

			primaryStage.setTitle("SmartWorld Simulator");
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../views/Canvas.fxml"));
			Scene scene = new Scene(loader.load());
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
			

		} catch(Exception e) {
			e.printStackTrace();
		}
		login();
	}

	
	@FXML
    public void login() {
  
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../views/LoginUI.fxml"));
		try {
			Scene scene = new Scene(loader.load());
			logStage = new Stage();
			logStage.setScene(scene);
			logStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}	
    }

	public static void closeLogStage() {
		logStage.close();
	}


	public static void main(String[] args) {
		launch(args);
	}


}
