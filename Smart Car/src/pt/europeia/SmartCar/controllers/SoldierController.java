package pt.europeia.SmartCar.controllers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import pt.europeia.SmartCar.models.Garage;
import pt.europeia.SmartCar.models.SmartCar;
import pt.europeia.SmartCar.models.Soldier;

public class SoldierController implements Runnable{

	public static Soldier soldier = new Soldier(null, null, null, null, null, 0);

	public static SmartCar car = new SmartCar();
	
	private static Garage garage = new Garage();
	
	double move = 10;

	boolean w = false;
	boolean s = false;
	boolean a = false;
	boolean d = false;

	private static Socket listener;
	private static ObjectInputStream in;


	@FXML
	private TextField coordXTF;

	@FXML 
	private TextField coordYTF;


	@FXML
	private ComboBox<Speed> speedCB;	


	@FXML
	public void initialize() {

		speedCB.getItems().setAll( Speed.values() );
		speedCB.getSelectionModel().selectedItemProperty().addListener(
				(obs,oldVal,newVal) -> {
					if (newVal == Speed.Slow){
						car.setSpeedX(1);
						car.setSpeedY(1);

					} else if (newVal == Speed.Moderate){
						car.setSpeedX(2);
						car.setSpeedY(2);

					}else if (newVal == Speed.Fast){
						car.setSpeedX(3);
						car.setSpeedY(3);

					} 
				});
		speedCB.setValue(Speed.Moderate);
		coordXTF.setText("0");
		coordYTF.setText("0");

		new Thread(this).start();

	}
	
	public void open() {
		
		Timeline time = new Timeline();
		time.getKeyFrames().add(new KeyFrame(Duration.millis(80), (event) -> {
			if (garage.getX() < 80) {
				garage.setX(garage.getX() + 1);
			}
			if (garage.getX() == 80) {
				garage.setOpen(true);;
				time.stop();
			}

		}));
		time.setCycleCount(Timeline.INDEFINITE);
		time.play();
	}

	public void close() {
		Timeline time = new Timeline();
		time.getKeyFrames().add(new KeyFrame(Duration.millis(80), (event) -> {
			if (garage.getX() > 0) {
				garage.setX(garage.getX() - 1);
			}
			if (garage.getX() == 0) {
				garage.setX(0);
				garage.setOpen(false);
				time.stop();
			}

		}));
		time.setCycleCount(Timeline.INDEFINITE);
		time.play();
	}



	public void north() {

		if (soldier.getY() >= 0) {
			soldier.addY(-move);
		}
	}

	public void south() {

		if (soldier.getY() < 580) {
			soldier.addY(move);
		}
		
		if (soldier.getY()>=470 && garage.isOpen()==false && soldier.getX()<= garage.getX()+88) {
			soldier.setY(470);;
		}
	}

	public void west() {

		if (soldier.getX() >= 0) {
			soldier.addX(-move);
		}
		
	}

	public void east() {

		if (soldier.getX() < 780) {
			soldier.addX(move);
		}
		
	}

	@FXML
	public void destination() {

		String currSpeed = speedCB.getSelectionModel().getSelectedItem().toString();

		String x= coordXTF.getText();
		String y= coordYTF.getText();

		double destX= Integer.parseInt(x);
		double destY= Integer.parseInt(y);

		car.destination(destX, destY, currSpeed, car.getFuel());

	}

	public void summon() {

		String currSpeed = speedCB.getSelectionModel().getSelectedItem().toString();

		if (soldier.getX() <= 0 || soldier.getY() == 0) {
			car.summon(soldier.getX() + 10, soldier.getY() + 10, currSpeed, car.getFuel());
		} else if (soldier.getX() <= 780 || soldier.getY() >= 570) {
			car.summon(soldier.getX() - 40, soldier.getY() - 38, currSpeed, car.getFuel());
		}

	}


	public void onPress(KeyEvent event) {

		if (event.getCode() == KeyCode.W)
			w = true;

		if (event.getCode() == KeyCode.S)
			s = true;

		if (event.getCode() == KeyCode.A)
			a = true;

		if (event.getCode() == KeyCode.D)
			d = true;

		if (w)
			north();

		if (a)
			west();

		if (s)
			south();

		if (d)
			east();

	}


	public void onRelease(KeyEvent event) {

		if (event.getCode() == KeyCode.W)
			w = false;

		if (event.getCode() == KeyCode.S)
			s = false;

		if (event.getCode() == KeyCode.A)
			a = false;

		if (event.getCode() == KeyCode.D)
			d = false;

	}

	@Override
	public void run() {

		try {

			String currSpeed = speedCB.getSelectionModel().getSelectedItem().toString();
			ServerSocket serv = new ServerSocket(12345);
			Object command = new Object();
			listener = serv.accept();
			in = new ObjectInputStream(listener.getInputStream());

			while (true) { 

				if ( (command = in.readObject()) != null) {

					if (command.equals("summon")) {

						car.summon(soldier.getX(), soldier.getY(), currSpeed, car.getFuel());

					} else {

						/*String cmd = (String) command;
						String x = cmd;
						String y = (String) in.readObject();
						car.destination(Integer.parseInt(x) , Integer.parseInt(y) , currSpeed, car.getFuel());*/
					}

					/*ObjectOutputStream out = new ObjectOutputStream(listener.getOutputStream());
					out.writeObject(car.getFuel());*/

				}


				if (!listener.isConnected()) {
					break;
				}

			}

			new Thread(this).start();

		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static Garage getGarage() {
		return garage;
	}

	public static void setGarage(Garage garage) {
		SoldierController.garage = garage;
	}

}
