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
import pt.europeia.SmartCar.controllers.CanvasController;
import pt.europeia.SmartCar.controllers.Coordinates;

public class SmartCar implements Coordinates {

	private double coordX;
	private double coordY;
	private double speedX;
	private double speedY;
	private double fuel=100;
	private double width=50;
	private double height=50;
	
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getSpeedX() {
		return speedX;
	}

	public void setSpeedX(double speedX) {
		this.speedX = speedX;
	}
	

	public double getSpeedY() {
		return speedY;
	}

	public void setSpeedY(double speedY) {
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
	public void destination (double x, double y, double fuel){
		
		
		ArrayList<Double> coords= new ArrayList<Double>(2);
		coords.add(coordX);
		coords.add(coordY);	
		
		Timeline time = new Timeline();
		time.getKeyFrames().add(new KeyFrame(Duration.millis(20),
				(event)-> {
                 
									
		if(fuel>=Math.sqrt((Math.pow(x-coordX, 2))+Math.pow(y-coordY, 2))/30){
			
			Sensors.sensors(speedX, speedY, x, y);
			
			if(!Sensors.isStopped()){	
				
			if ((coordX >= (x-3)&&coordX <= (x+3)) && (coordY >= (y-3)&&coordY <= (y+3)))
				time.stop();
			
			}else{
				time.stop();
				Sensors.setStopped(false);
			}
			
			this.fuel= fuel-((Math.sqrt((Math.pow(x-coords.get(0), 2))+Math.pow(y-coords.get(1), 2))/30)
					-(Math.sqrt((Math.pow(x-coordX, 2))+Math.pow(y-coordY, 2))/30));
			
		}
		
		if ((coordX>=CanvasController.refill.getX()-width && coordX<=CanvasController.refill.getX()+CanvasController.refill.getWidth())
				&&(coordY>=CanvasController.refill.getY()-height &&coordY<=CanvasController.refill.getY()+CanvasController.refill.getHeight())){
			
			setFuel(100);
		}
			


			
				}));
		
		
		time.setCycleCount(Timeline.INDEFINITE);
		time.play();
		
		
	}
	
public void park(){
		
		Sensors.parking(speedX, speedY);
	}
	

	public void summon(double x, double y, double fuel) {
	
		
		ArrayList<Double> coords= new ArrayList<Double>(2);
		coords.add(coordX);
		coords.add(coordY);
		

		Timeline time = new Timeline();
		time.getKeyFrames().add(new KeyFrame(Duration.millis(20),
				(event)-> {
					
					
					
					if(fuel>=Math.sqrt((Math.pow(x-coordX, 2))+Math.pow(y-coordY, 2))/30){
						
						
						Sensors.sensors(speedX, speedY, x, y);
						
			
			if(!Sensors.isStopped()){			
						
					if ((coordX >= (x-32)&&coordX <= (x+width+12)) && (coordY >= (y-32)&&coordY <= (y+height+12)) )
						time.stop();
			}else{
				time.stop();
				Sensors.setStopped(false);
			}
					this.fuel= fuel-((Math.sqrt((Math.pow(x-coords.get(0), 2))+Math.pow(y-coords.get(1), 2))/30)
							-(Math.sqrt((Math.pow(x-coordX, 2))+Math.pow(y-coordY, 2))/30));
					}
					
					if ((coordX>=CanvasController.refill.getX()-width && coordX<=CanvasController.refill.getX()+CanvasController.refill.getWidth())
							&&(coordY>=CanvasController.refill.getY()-height &&coordY<=CanvasController.refill.getY()+CanvasController.refill.getHeight())){
						
						setFuel(100);
					}
					
					
					
				}));

		time.setCycleCount(Timeline.INDEFINITE);
		time.play();
	}
}
