package pt.europeia.SmartCar.controllers;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import pt.europeia.SmartCar.application.Main;
import pt.europeia.SmartCar.application.MsgManager;
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
	
	/**
	 *
	 * 
	 */
	public void login() {
		
		try {
			soldier = SoldadoDAO.getSoldier(Integer.parseInt(id.getText()),password.getText());
		}catch (Exception e) {
			MsgManager.aviso("BD error", "O ID ou a Password que introduziu não estão correctas", "Introduza um ID e uma Password válidas");
			return;
		}
		
		welcome.setText("Welcome " + soldier.getPatente() +" "+ soldier.getNome() + "!");
		
		StackPane root = new StackPane();
		Scene scene = new Scene(root,400,80);
		root.getChildren().add(welcome);
		Main.closeLogStage();
		Main.changeLogScene(scene);
		Main.logDone = true;
		Main.main(null);
		
	}

}