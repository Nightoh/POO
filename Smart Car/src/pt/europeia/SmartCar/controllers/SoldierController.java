package pt.europeia.SmartCar.controllers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import pt.europeia.SmartCar.models.Garage;
import pt.europeia.SmartCar.models.Sensors;
import pt.europeia.SmartCar.models.SmartCar;
import pt.europeia.SmartCar.models.Soldier;

public class SoldierController implements Runnable{

	public static Soldier soldier = new Soldier(null, null, null, null, null, 0);

	public static SmartCar car = new SmartCar();

	public static Garage garage = new Garage();

	double move;

	boolean w = false;
	boolean s = false;
	boolean a = false;
	boolean d = false;
	boolean e = false;

	private static Socket listener;
	private static ObjectInputStream in;
	private static ObjectOutputStream out;


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

	public void open_close() {

		Timeline time = new Timeline();
		time.getKeyFrames().add(new KeyFrame(Duration.millis(80), (event) -> {
			if (garage.getX() < garage.getWallRightX() && !garage.isOpen()) {
				garage.setX(garage.getX() + 1);

				if (garage.getX() == garage.getWallRightX()) {
					time.stop();
					garage.setOpen(true);
				}
			}	

			if (garage.getX() > garage.getWallLeftX() && garage.isOpen()) {
				garage.setX(garage.getX() - 1);
				if (garage.getX() == garage.getWallLeftX()) {
					time.stop();
					garage.setOpen(false);
				}		
			}



		}));
		time.setCycleCount(Timeline.INDEFINITE);
		time.play();
	}

	public void north() {

		if (soldier.getY() > 0) {

			if (!soldier.isInsideCar()) { 
				soldier.addY(-move);

			} else {
				soldier.addY(-move);
				car.setY(soldier.getY());
			}
		}
		if (soldier.getY() <= garage.getWallLeftY() && !garage.isOpen() && soldier.getX()<= garage.getX()+garage.getWidth() && soldier.getY() >= garage.getWallRightY()-20) {
			soldier.setY(garage.getWallRightY()+10);
		} else if(soldier.getY() <= garage.getWallRightY() && garage.isOpen()  && soldier.getX() >=  garage.getX()-10 && soldier.getX() <=  garage.getWallRightX()+8 && soldier.getY() >= garage.getWallRightY()-20){
			soldier.setY(garage.getWallRightY()+10);
		}
	}

	public void south() {

		if (soldier.getY() < 580) {

			if (!soldier.isInsideCar()) { 
				soldier.addY(move);

			} else {
				soldier.addY(move);
				car.setY(soldier.getY());
			}
		}

		if (soldier.getY() >= garage.getWallLeftY()-20 && !garage.isOpen() && soldier.getX() <= garage.getWallRightX() && soldier.getY() <= garage.getWallLeftY() ) {
			soldier.setY(garage.getWallLeftY()-20);
		} else if(soldier.getY() >= garage.getWallRightY()-20 && garage.isOpen()  && soldier.getX() >=  garage.getX()-10 && soldier.getX() <=  garage.getWallRightX()+8 && soldier.getY() <= garage.getWallRightY()){
			soldier.setY(garage.getWallRightY()-20);
		} else if(soldier.getY() >= garage.getWallLeftY()+100 && soldier.getX()<= garage.getWallDownX() + 80 ){
			soldier.setY(garage.getWallLeftY()+100);
		} else if (soldier.getY() >= garage.getWallLeftY()-20 && soldier.getX() <= garage.getWallLeftX()){
			soldier.setY(garage.getWallLeftY()-20);
		}
	}

	public void west() {

		if (soldier.getX() > 0) {

			if (!soldier.isInsideCar()) { 
				soldier.addX(-move);

			} else {
				soldier.addX(-move);
				car.setX(soldier.getX());
			}
		}
		if (soldier.getX() <= garage.getWallRightX()+10 && soldier.getY() > garage.getWallLeftY()-20 && soldier.getX() >= garage.getWallRightX()-20) {
			soldier.setX(garage.getWallRightX()+10);
		} else if(soldier.getX() <= garage.getWallLeftWidth() && soldier.getY() > garage.getWallLeftY()-20){
			soldier.setX(garage.getWallLeftWidth());
		} else if(soldier.getX() <= garage.getX()+86 && garage.isOpen() && soldier.getY() > garage.getWallLeftY()-20 && soldier.getY() <= garage.getWallLeftY()+8 && soldier.getX() >= garage.getWallRightX()) {
			soldier.setX(garage.getWallRightX()+90);
		}
	}

	public void east() {

		if (soldier.getX() < 780) {

			if (!soldier.isInsideCar()) { 
				soldier.addX(move);

			} else {
				soldier.setX(car.getX());
				soldier.addX(move);
				car.setX(soldier.getX());
			}
		}
		if (soldier.getX() >= garage.getWallRightX()-20 && soldier.getY() > garage.getWallLeftY()-20 && soldier.getX() <=garage.getWallRightX()+90) {
			soldier.setX(60);
		}

	}

	@FXML
	public void destination() {


		String x= coordXTF.getText();
		String y= coordYTF.getText();

		double destX= Integer.parseInt(x);
		double destY= Integer.parseInt(y);

		car.destination(destX, destY, car.getFuel());

	}

	public void summon() {

		if (!soldier.isInsideCar()) {

			if (soldier.getX() >= 0 && soldier.getY() <= 0) {
				car.summon(soldier.getX() - 40, soldier.getY() + 8, car.getFuel());
			}  else if (soldier.getX() <= 0 && soldier.getY() >= 0){
				car.summon(soldier.getX() + 40, soldier.getY() + 8, car.getFuel());
			}else if (soldier.getX() <= 780 || soldier.getY() <= 570) {
				car.summon(soldier.getX() - 40, soldier.getY() - 38, car.getFuel());
			}

		}

	}

	public void enterLeaveCar() {

		if (soldier.getX() >= car.getX() && soldier.getX() <= car.getX()+50
				&& soldier.getY() >= car.getY() && soldier.getY() <= car.getY()+50) { 

			if (!soldier.isInsideCar()) {
				soldier.setX(car.getX());
				soldier.setY(car.getY());
				soldier.setInsideCar(true);
			} else {
				soldier.setInsideCar(false);
			}
		}

	}

	public void park(){

		car.park();
	}

	public void stop(){
		Sensors.setStopped(true);

	}

	public void pause_restart(){
		if(Sensors.isMovement()){
			Sensors.setMovement(false);
		}else{
			Sensors.setMovement(true);
		}
	}


	public void onPress(KeyEvent event) {

		if (event.getCode() == KeyCode.E)
			e = true;

		if (event.getCode() == KeyCode.W)
			w = true;

		if (event.getCode() == KeyCode.S)
			s = true;

		if (event.getCode() == KeyCode.A)
			a = true;

		if (event.getCode() == KeyCode.D)
			d = true;

		if (soldier.isInsideCar()) {
			if (car.getFuel()>0){
				move = car.getSpeedX();
				car.setFuel(car.getFuel()-(car.getSpeedX()/15));
			}
		} else {
			move = 1;
		}

		if (e)
			enterLeaveCar();

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

		if (event.getCode() == KeyCode.E)
			e = false;

	}


	@Override
	public void run() {

		try {

			ServerSocket serv = new ServerSocket(12345);
			String command;
			listener = serv.accept();
			out = new ObjectOutputStream(listener.getOutputStream());
			in = new ObjectInputStream(listener.getInputStream());

			while (true) { 

				if ( (command = (String) in.readObject()) != null) {

					if (command.equals("summon")) {

						car.summon(soldier.getX(), soldier.getY(), car.getFuel());

					} else if (command.contains("::")) {
						
						String x = command.substring( 0 , command.indexOf(":"));
						String y =  command.substring( command.lastIndexOf(":") + 1 , command.length());
						car.destination(Integer.parseInt(x) , Integer.parseInt(y) , car.getFuel());
					}
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


}
