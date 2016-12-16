package pt.europeia.SmartCar.application;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class MsgManager {
	public static void aviso(String tipoErro, String aviso, String solucao) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle(tipoErro);
		alert.setHeaderText(aviso);
		alert.setContentText(solucao);
		alert.showAndWait();
	}
	
	public static boolean check(String tipo, String aviso, String solucao) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(tipo);
		alert.setHeaderText(aviso);
		alert.setContentText(solucao);
		Optional<ButtonType> result = alert.showAndWait();
		return result.get() == ButtonType.OK;
	}
	
}
