package pt.europeia.SmartCar.models;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import pt.europeia.SmartCar.controllers.Coordinates;

public class SmartCar implements Coordinates, Runnable{

	private double coordX;
	private double coordY;
	private int speedX;
	private int speedY;
	private double fuel=100;
	Calendar calendar = Calendar.getInstance(); 
	
	
	public int getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}
	

	public int getSpeedY() {
		return speedY;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	public double getFuel() {
		return fuel;
	}

	public void setFuel(double fuel) {
		this.fuel = fuel;
	}

	@Override
	public double getX() {

		return coordX;
	}

	@Override
	public void setX(double x) {

		this.coordX = x;

	}

	@Override
	public double getY() {

		return coordY;
	}

	@Override
	public void setY(double y) {

		this.coordY = y;

	}	


	/**Summon Car to user location 
	 * @param x
	 * @param y
	 */
	
	
	public void destination (double x, double y, String speed, double fuel){
		
		
		ArrayList<Double> coords= new ArrayList<Double>(2);
		coords.add(coordX);
		coords.add(coordY);	
		
		Timeline time = new Timeline();
		time.getKeyFrames().add(new KeyFrame(Duration.millis(20),
				(event)-> {
                 
									
		if(fuel>=Math.sqrt((Math.pow(x-coordX, 2))+Math.pow(y-coordY, 2))/30){
						
			
		if (coordX<= x && coordY<= y){
			Sensors.sensors(speedX,speedY, x, y);
			}
			
		else if (coordX>= x && coordY<= y){
				Sensors.sensors(speedX*(-1),speedY, x, y);
				}
			
		else if (coordX<= x && coordY>= y){
				Sensors.sensors(speedX,speedY*(-1), x, y);
				}
			
		else if (coordX>= x && coordY>= y){
				Sensors.sensors(speedX*(-1),speedY*(-1), x, y);
				}
			
				
			if ((coordX >= (x-3)&&coordX <= (x+3)) && (coordY >= (y-3)&&coordY <= (y+3)))
				time.stop();
			
			this.fuel= fuel-((Math.sqrt((Math.pow(x-coords.get(0), 2))+Math.pow(y-coords.get(1), 2))/30)
					-(Math.sqrt((Math.pow(x-coordX, 2))+Math.pow(y-coordY, 2))/30));
			
		}
		
		if ((coordX>=650 && coordX<=800)&&(coordY>=0 &&coordY<=110)){
			
			setFuel(100);
		}
			


			
				}));
		
		
		time.setCycleCount(Timeline.INDEFINITE);
		time.play();
		
		
	}
	
	
	
	
	

	public void summon(double x, double y, String speed, double fuel) {
		
		ArrayList<Double> coords= new ArrayList<Double>(2);
		coords.add(coordX);
		coords.add(coordY);
		

		Timeline time = new Timeline();
		time.getKeyFrames().add(new KeyFrame(Duration.millis(20),
				(event)-> {

					
					if(fuel>=Math.sqrt((Math.pow(x-coordX, 2))+Math.pow(y-coordY, 2))/30){
						
						if (coordX<= x && coordY<= y){
							Sensors.sensors(speedX,speedY, x, y);
							}
							
						else if (coordX>= x && coordY<= y){
								Sensors.sensors(speedX*(-1),speedY, x, y);
								}
							
						else if (coordX<= x && coordY>= y){
								Sensors.sensors(speedX,speedY*(-1), x, y);
								}
							
						else if (coordX>= x && coordY>= y){
								Sensors.sensors(speedX*(-1),speedY*(-1), x, y);
								}
						
						
					if ((coordX >= (x-12)&&coordX <= (x+12)) && (coordY >= (y-12)&&coordY <= (y+12)) )
						time.stop();
					
					this.fuel= fuel-((Math.sqrt((Math.pow(x-coords.get(0), 2))+Math.pow(y-coords.get(1), 2))/30)
							-(Math.sqrt((Math.pow(x-coordX, 2))+Math.pow(y-coordY, 2))/30));
					}
					
					if ((coordX>=650 && coordX<=700)&&(coordY>=0 &&coordY<=50)){
						
						this.fuel=100;
					}
					
					
					
				}));

		time.setCycleCount(Timeline.INDEFINITE);
		time.play();
	}


	/**
	 * Listen for commands from the soldier controller of the car
	 */
	@Override
	public void run() {

		try {

			ServerSocket serv = new ServerSocket(12345);
			while (true) {

				Socket listener = serv.accept();
				ObjectInputStream in = new ObjectInputStream(listener.getInputStream());


			}

		} catch (IOException e) {

			e.printStackTrace();
		}



	}

}
