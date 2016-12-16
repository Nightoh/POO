package pt.europeia.SmartCar.controllers;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pt.europeia.SmartCar.application.Main;
import pt.europeia.SmartCar.models.Soldier;
import pt.europeia.SmartCar.models.SoldadoDAO;

public class LoginController {
	
	@FXML
	private TextField id;
	
	@FXML
	private TextField password;
	
	private static Text welcome;
	
	private static Soldier soldier;
	
	@FXML
	public void initialize() {
		soldier = new Soldier(null, null, null, null, null, 0);
		welcome = new Text();
	}
	
	public void login() {
		
		soldier.setId( Integer.parseInt(id.getText()));
		soldier.setPassword( password.getText() );	
		
		soldier = SoldadoDAO.getSoldier(soldier);
		
		welcome.setText("Welcome " + soldier.getPatente() +" "+ soldier.getNome() + "!");
		
		Stage stage = new Stage();
		StackPane root = new StackPane();
		Scene scene = new Scene(root,400,80);
		root.getChildren().add(welcome);
		stage.setScene(scene);
		Main.closeLogStage();
		stage.show();
	}

}
