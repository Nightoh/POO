package pt.europeia.SmartCar.models;

import pt.europeia.SmartCar.controllers.Coordinates;

public class Garage implements Coordinates {

	double coorX = 0 ;
	double coorY = 490;
	private boolean open;
	
	
	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public void addX(double x) {
		coorX += x;
	}

	public void addY(double y) {
		coorY += y;
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

}
