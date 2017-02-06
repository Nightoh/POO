package pt.europeia.SmartCar.models;

import pt.europeia.SmartCar.controllers.Coordinates;

public class Garage implements Coordinates {
	
	private double wallLeftX=0;
	private double wallLeftY=470;
	private double wallLeftWidth=10;
	private double wallLeftHeight=120;
	
	private double wallRightX=wallLeftX+80;
	private double wallRightY=wallLeftY;
	private double wallRightWidth=wallLeftWidth;
	private double wallRightHeight=wallLeftHeight;
	
	private double wallDownX=wallLeftX;
	private double wallDownY=wallLeftY+wallLeftHeight;
	private double wallDownWidth=Math.abs(wallRightX+ wallRightWidth-wallLeftX);
	private double wallDownHeight=wallLeftWidth;
	
	private double coorX = wallLeftX ;
	private double coorY = wallLeftY;
	private double width=90;
	private double height=10;
	private boolean open=false;

	
	
	


	
	
	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}


	@Override
	public double getX() {

		return coorX;
	}

	@Override
	public void setX(double x) {
		coorX = x;
	}

	@Override
	public double getY() {

		return coorY;
	}

	@Override
	public void setY(double y) {
		coorY = y;
	}

	public double getWallLeftX() {
		return wallLeftX;
	}

	public void setWallLeftX(double wallLeftX) {
		this.wallLeftX = wallLeftX;
	}

	public double getWallLeftY() {
		return wallLeftY;
	}

	public void setWallLeftY(double wallLeftY) {
		this.wallLeftY = wallLeftY;
	}

	public double getWallLeftWidth() {
		return wallLeftWidth;
	}

	public void setWallLeftWidth(double wallLeftWidth) {
		this.wallLeftWidth = wallLeftWidth;
	}

	public double getWallLeftHeight() {
		return wallLeftHeight;
	}

	public void setWallLeftHeight(double wallLeftHeight) {
		this.wallLeftHeight = wallLeftHeight;
	}

	public double getWallRightX() {
		return wallRightX;
	}

	public void setWallRightX(double wallRightX) {
		this.wallRightX = wallRightX;
	}

	public double getWallRightY() {
		return wallRightY;
	}

	public void setWallRightY(double wallRightY) {
		this.wallRightY = wallRightY;
	}

	public double getWallRightWidth() {
		return wallRightWidth;
	}

	public void setWallRightWidth(double wallRightWidth) {
		this.wallRightWidth = wallRightWidth;
	}

	public double getWallRightHeight() {
		return wallRightHeight;
	}

	public void setWallRightHeight(double wallRightHeight) {
		this.wallRightHeight = wallRightHeight;
	}

	public double getWallDownX() {
		return wallDownX;
	}

	public void setWallDownX(double wallDownX) {
		this.wallDownX = wallDownX;
	}

	public double getWallDownY() {
		return wallDownY;
	}

	public void setWallDownY(double wallDownY) {
		this.wallDownY = wallDownY;
	}

	public double getWallDownWidth() {
		return wallDownWidth;
	}

	public void setWallDownWidth(double wallDownWidth) {
		this.wallDownWidth = wallDownWidth;
	}

	public double getWallDownHeight() {
		return wallDownHeight;
	}

	public void setWallDownHeight(double wallDownHeight) {
		this.wallDownHeight = wallDownHeight;
	}

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

}
