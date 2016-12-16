package pt.europeia.SmartCar.models;

import java.util.Random;

public class Object {
	
	Random number= new Random();
	
	private double coordX1= 50+number.nextInt(300);
	private double coordY1= 50+number.nextInt(200);
	private double coordX2= 400+number.nextInt(200);
	private double coordY2= 300+number.nextInt(200);

	
	private int width= 20+number.nextInt(50);
	private int height= 20+number.nextInt(50);
	
	

	public double getCoordX1() {
		return coordX1;
	}

	public void setCoordX1(double coordX1) {
		this.coordX1 = coordX1;
	}

	public double getCoordY1() {
		return coordY1;
	}

	public void setCoordY1(double coordY1) {
		this.coordY1 = coordY1;
	}

	public double getCoordX2() {
		return coordX2;
	}

	public void setCoordX2(double coordX2) {
		this.coordX2 = coordX2;
	}

	public double getCoordY2() {
		return coordY2;
	}

	public void setCoordY2(double coordY2) {
		this.coordY2 = coordY2;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}


}