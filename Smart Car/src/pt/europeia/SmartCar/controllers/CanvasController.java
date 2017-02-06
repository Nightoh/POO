package pt.europeia.SmartCar.controllers;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import pt.europeia.SmartCar.models.Object;
import pt.europeia.SmartCar.models.Refill;

public class CanvasController extends AnimationTimer{

	@FXML
	public Canvas canvas;

	private static GraphicsContext gc;
	
	public static Object object1= new Object();
	public static Object object2= new Object();
	public static Refill refill=new Refill();

	@FXML
	public void initialize() {

		
		gc = canvas.getGraphicsContext2D();	
		start();


	}

	/**
	 * Draws Canvas Background
	 * @param gc
	 */
	public static void drawBg(GraphicsContext gc) {
		
		gc.setFill(Color.LIGHTGREEN);
		gc.fillRect(0,0,800,600);

	}

	
	
	/**
	* Draws the Soldier on the Canvas
	* @param gc
	*/
	public static void drawSol(GraphicsContext gc) {
		
		if (!SoldierController.soldier.isInsideCar()) {
			gc.setFill(Color.BLACK);
			gc.fillOval(SoldierController.soldier.getX(), SoldierController.soldier.getY(), 20, 20);
		}
		

	}

	/**
	 * 
	 * @param gc
	 */
	public void drawScale(GraphicsContext gc){
		int numberY=100;
		int numberX=100;
		
		gc.setStroke(Color.BLACK);
		
		for (int i=0;i<6;i++){
			gc.strokeLine(0, numberY*i, 800, numberY*i);
			gc.strokeText(Integer.toString(numberY*i), 0, numberY*i);
			}
			for (int i=0;i<8;i++){
			gc.strokeLine(numberX*i, 0, numberX*i, 600);
			gc.strokeText(Integer.toString(numberX*i), numberX*i, 20);
			}
		
	}
	
	public void drawGarage(GraphicsContext gc){
		gc.setFill(Color.DARKCYAN);
		gc.fillRect(SoldierController.garage.getX(), SoldierController.garage.getY(),
				SoldierController.garage.getWidth(), SoldierController.garage.getHeight());
		
		gc.setFill(Color.DARKBLUE);
		gc.fillRect(SoldierController.garage.getWallLeftX(), SoldierController.garage.getWallLeftY(),
				SoldierController.garage.getWallLeftWidth(), SoldierController.garage.getWallLeftHeight());
		
		gc.fillRect(SoldierController.garage.getWallRightX(), SoldierController.garage.getWallRightY(),
				SoldierController.garage.getWallRightWidth(), SoldierController.garage.getWallRightHeight());
		
		gc.fillRect(SoldierController.garage.getWallDownX(), SoldierController.garage.getWallDownY(),
				SoldierController.garage.getWallDownWidth(), SoldierController.garage.getWallDownHeight());
		
	}

	
	
	/**
	 * Draws a Car on the Canvas
	 * @param gc
	 */
	public void drawCar(GraphicsContext gc) {
			
		gc.setFill(Color.RED);
		gc.fillOval(SoldierController.car.getX(), SoldierController.car.getY(),
				SoldierController.car.getWidth(),SoldierController.car.getHeight());
	}
	
	
	public void drawRefill(GraphicsContext gc){
		gc.setFill(Color.CHOCOLATE);
		gc.fillRect(refill.getX(), refill.getY(), refill.getWidth(),refill.getHeight());
	}
	
	public void drawFuel(GraphicsContext gc, double fuel) {
		
		int fuelLVL;
		
		if (fuel<=100&& fuel>80){
			gc.setStroke(Color.GREEN);
			gc.setFill(Color.GREEN);
			fuelLVL=5;
		}
		else if (fuel<=80&& fuel>60){
			gc.setStroke(Color.GREEN);
			gc.setFill(Color.GREEN);
			fuelLVL=4;
		}
		else if (fuel<=60&& fuel>40){
			gc.setStroke(Color.DARKGOLDENROD);
			gc.setFill(Color.DARKGOLDENROD);
			fuelLVL=3;
		}
		else if (fuel<=40&& fuel>20){
			gc.setStroke(Color.DARKGOLDENROD);
			gc.setFill(Color.DARKGOLDENROD);
			fuelLVL=2;
		}
		
		else if(fuel<=20&&fuel>0){
			gc.setStroke(Color.RED);
			gc.setFill(Color.RED);
			fuelLVL=1;
				}
		else {
			gc.setStroke(Color.BLACK);
			fuelLVL=0;
				}
		
		gc.strokeRect(725, 497, 60, 77);

		
		for(int i=0; i<fuelLVL;i++){
			gc.fillRect(730,560-15*i,50,10);
		}
		
			}
	
	public void drawObj(GraphicsContext gc){
		
		gc.setFill(Color.FORESTGREEN);	
		gc.fillRect(object1.getCoordX1(), object1.getCoordY1(), object1.getWidth(), object1.getHeight());
		gc.fillRect(object2.getCoordX2(), object2.getCoordY2(), object2.getWidth(), object2.getHeight());
		
	}

	
	public static GraphicsContext getGc() {
		return gc;
	}

	
	
	public void setGc(GraphicsContext gc) {
		CanvasController.gc = gc;
	}

	

	/**
	 * Is constantly refreshing the Canvas
	 */
	@Override
	public void handle(long arg0) {

		drawBg(gc);
		drawScale(gc);
		drawObj(gc);
		drawRefill(gc);
		drawSol(gc);
		drawCar(gc);
		drawGarage(gc);
		drawFuel(gc, SoldierController.car.getFuel());
		
		if (SoldierController.soldier.isInsideCar()) {
			SoldierController.soldier.setX(SoldierController.car.getX());
			SoldierController.soldier.setY(SoldierController.car.getY());
		}
		
	}
}
