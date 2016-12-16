package pt.europeia.SmartCar.controllers;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import pt.europeia.SmartCar.models.Object;

public class CanvasController extends AnimationTimer{

	@FXML
	public Canvas canvas;

	private static GraphicsContext gc;
	
	public static Object object1= new Object();
	public static Object object2= new Object();

	Image jeep = new Image("resourses/jeepfx.png",150,0,true,false);

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
		
		gc.setFill(Color.BLACK);
		gc.fillOval(SoldierController.soldier.getX(), SoldierController.soldier.getY(), 20, 20);

	}
	
	public void drawGarage(GraphicsContext gc){
		gc.setFill(Color.DARKCYAN);
		gc.fillRect(SoldierController.getGarage().getX(), SoldierController.getGarage().getY(), 90, 10);
		
		gc.setFill(Color.DARKBLUE);
		gc.fillRect(0, 500, 90, 100);
	}

	
	
	/**
	 * Draws a Car on the Canvas
	 * @param gc
	 */
	public void drawCar(GraphicsContext gc) {
			
		gc.setFill(Color.RED);
		gc.fillOval(SoldierController.car.getX(), SoldierController.car.getY(), 50,50);
		
	}
	
	
	public void drawRefill(GraphicsContext gc){
		gc.setFill(Color.CHOCOLATE);
		gc.fillRect(670, 30, 110,80);
	}
	
	public void drawFuel(GraphicsContext gc, double fuel) {
		
		if(fuel<=100&&fuel>80){
		gc.setStroke(Color.GREEN);
		gc.strokeRect(725, 437, 60, 77);
		gc.setFill(Color.GREEN);
		gc.fillRect(730,500,50,10);
		gc.fillRect(730,485,50,10);
		gc.fillRect(730,470,50,10);
		gc.fillRect(730,455,50,10);
		gc.fillRect(730,440,50,10);
		}
		
		if(fuel<=80&&fuel>60){
		gc.setStroke(Color.GREEN);
		gc.strokeRect(725, 437, 60, 77);
		gc.setFill(Color.GREEN);
		gc.fillRect(730,500,50,10);
		gc.fillRect(730,485,50,10);
		gc.fillRect(730,470,50,10);
		gc.fillRect(730,455,50,10);
			}
		
		if(fuel<=60&&fuel>40){
		gc.setStroke(Color.DARKGOLDENROD);
		gc.strokeRect(725, 437, 60, 77);
		gc.setFill(Color.DARKGOLDENROD);
		gc.fillRect(730,500,50,10);
		gc.fillRect(730,485,50,10);
		gc.fillRect(730,470,50,10);
			}
		
		if(fuel<=40&&fuel>20){
		gc.setStroke(Color.DARKGOLDENROD);
		gc.strokeRect(725, 437, 60, 77);
		gc.setFill(Color.DARKGOLDENROD);
		gc.fillRect(730,500,50,10);
		gc.fillRect(730,485,50,10);
			}
		
		if(fuel<=20&&fuel>0){
		gc.setStroke(Color.RED);
		gc.strokeRect(725, 437, 60, 77);
		gc.setFill(Color.RED);
		gc.fillRect(730,500,50,10);
			}
		
		if(fuel<=0){
		gc.setStroke(Color.BLACK);
		gc.strokeRect(725, 437, 60, 77);
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
		
		drawObj(gc);
		drawRefill(gc);
		drawSol(gc);
		drawCar(gc);
		drawGarage(gc);
		drawFuel(gc, SoldierController.car.getFuel());
		
	}
}
