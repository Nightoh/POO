package pt.europeia.SmartCar.models;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import pt.europeia.SmartCar.controllers.CanvasController;
import pt.europeia.SmartCar.controllers.SoldierController;

public class Sensors {
	
private static boolean stopped=false;
	
public static boolean isStopped() {
	return stopped;
}
public static void setStopped(boolean stopped) {
	Sensors.stopped = stopped;
}

private static boolean movement=true;

public static boolean isMovement() {
	return movement;
}
public static void setMovement(boolean movement) {
	Sensors.movement = movement;
}

private static boolean isParked=false;
private static boolean inPosition=false;

public static boolean isInPosition() {
	return inPosition;
}
public static void setInPosition(boolean inPosition) {
	Sensors.inPosition = inPosition;
}
public static boolean isParked() {
	return isParked;
}
public static void setParked(boolean isParked) {
	Sensors.isParked = isParked;
}

private static boolean object1X=true;
private static boolean object1Y=true;
private static boolean object2X=true;
private static boolean object2Y=true;
private static boolean garageX=true;
private static boolean garageY=true;


public static boolean isObject1X() {
	return object1X;
}
public static void setObject1X(boolean object1x) {
	object1X = object1x;
}
public static boolean isObject1Y() {
	return object1Y;
}
public static void setObject1Y(boolean object1y) {
	object1Y = object1y;
}
public static boolean isObject2X() {
	return object2X;
}
public static void setObject2X(boolean object2x) {
	object2X = object2x;
}
public static boolean isObject2Y() {
	return object2Y;
}
public static void setObject2Y(boolean object2y) {
	object2Y = object2y;
}
public static boolean isGarageX() {
	return garageX;
}
public static void setGarageX(boolean garageX) {
	Sensors.garageX = garageX;
}
public static boolean isGarageY() {
	return garageY;
}
public static void setGarageY(boolean garageY) {
	Sensors.garageY = garageY;
}


public static void sensors(double stepX, double stepY, double x, double y){
			
		
		double carX= SoldierController.car.getX();
		double carY=SoldierController.car.getY();
		double carOtherX= SoldierController.car.getX()+SoldierController.car.getWidth();
		double carOtherY=SoldierController.car.getY()+SoldierController.car.getHeight();
		
		double object1X= CanvasController.object1.getCoordX1();
		double object1OtherX= CanvasController.object1.getCoordX1()+CanvasController.object1.getWidth();
		double object1Y= CanvasController.object1.getCoordY1();
		double object1OtherY= CanvasController.object1.getCoordY1()+CanvasController.object1.getHeight();

		double object2X= CanvasController.object2.getCoordX2();
		double object2OtherX= CanvasController.object2.getCoordX2()+CanvasController.object2.getWidth();
		double object2Y= CanvasController.object2.getCoordY2();
		double object2OtherY= CanvasController.object2.getCoordY2()+CanvasController.object2.getHeight();
		
		double garageX=SoldierController.garage.getWallLeftX();
		double garageOtherX=SoldierController.garage.getWallRightX()+SoldierController.garage.getWallRightWidth();
		double garageY= SoldierController.garage.getWallLeftY();
		double garageOtherY=SoldierController.garage.getWallLeftY()+SoldierController.garage.getWallLeftHeight();
		
		
	
		
if (movement && !isParked){
	
	

		
		if (carOtherX+10>=object1X && carX-10<=object1OtherX
				&& carOtherY>=object1Y && carY<=object1OtherY
				||
				carOtherX>=object1X && carX<=object1OtherX
				&& carOtherY+10>=object1Y && carY-10<=object1OtherY
				||
				carOtherX+10>=object2X && carX-10<=object2OtherX
				&& carOtherY>=object2Y && carY<=object2OtherY
				||
				carOtherX>=object2X && carX<=object2OtherX
				&& carOtherY+10>=object2Y && carY-10<=object2OtherY
				||
				carOtherX+10>=garageX && carX-10<=garageOtherX
				&& carOtherY>=garageY && carY<=garageOtherY
				||
				carOtherX>=garageX && carX<=garageOtherX
				&& carOtherY+10>=garageY && carY-10<=garageOtherY
		){
		
		
		
		/////object 1
			
			if (carOtherX+10>=object1X && carX-10<=object1OtherX
				&& carOtherY>=object1Y && carY<=object1OtherY){
				if(carOtherY>y){
					SoldierController.car.setY(carY+stepY*(-1));
					}
					if (carY<y){
					SoldierController.car.setY(carY+stepY);	
					}
					if(carY==y){
						Sensors.setMovement(false);
						Sensors.setObject1X(false);
						Sensors.pullBack1(stepX,stepY,carX,carY);
					}
					}
			
			if (carOtherX>=object1X && carX<=object1OtherX
					&& carOtherY+10>=object1Y && carY-10<=object1OtherY){
				if(carOtherX>x){
					SoldierController.car.setX(carX+stepX*(-1));
					}
					if (carX<x){
					SoldierController.car.setX(carX+stepX);	
					}
					if(carX==x){
						Sensors.setMovement(false);
						Sensors.setObject1Y(false);
						Sensors.pullBack1(stepX,stepY,carX,carY);

					}
					}
			
		/////object 2
			
			
			if (carOtherX+10>=object2X && carX-10<=object2OtherX
					&& carOtherY>=object2Y && carY<=object2OtherY){
					if(carOtherY>y){
						SoldierController.car.setY(carY+stepY*(-1));
						}
						if (carY<y){
						SoldierController.car.setY(carY+stepY);	
						}
						if(carY==y){
							Sensors.setMovement(false);
							Sensors.setObject2X(false);
							Sensors.pullBack2(stepX,stepY,carX,carY);
						}
						}
				
				if (carOtherX>=object2X && carX<=object2OtherX
						&& carOtherY+10>=object2Y && carY-10<=object2OtherY){
					if(carOtherX>x){
						SoldierController.car.setX(carX+stepX*(-1));
						}
						if (carX<x){
						SoldierController.car.setX(carX+stepX);	
						}
						if(carX==x){
							Sensors.setMovement(false);
							Sensors.setObject2Y(false);
							Sensors.pullBack2(stepX,stepY,carX,carY);

						}
						}
				
			/////garage
				
				
				if (carOtherX+10>=garageX && carX-10<=garageOtherX
						&& carOtherY>=garageY && carY<=garageOtherY){
						if(carOtherY>y){
							SoldierController.car.setY(carY+stepY*(-1));
							}
							if (carY<y){
							SoldierController.car.setY(carY+stepY);	
							}
							if(carY==y){
								Sensors.setMovement(false);
								Sensors.setGarageX(false);
								Sensors.pullBackGar(stepX,stepY,carX,carY);
							}
							}
					
					if (carOtherX>=garageX && carX<=garageOtherX
							&& carOtherY+10>=garageY && carY-10<=garageOtherY){
						if(carOtherX>x){
							SoldierController.car.setX(carX+stepX*(-1));
							}
							if (carX<x){
							SoldierController.car.setX(carX+stepX);	
							}
							if(carX==x){
								Sensors.setMovement(false);
								Sensors.setGarageY(false);
								Sensors.pullBackGar(stepX,stepY,carX,carY);

							}
							}
				
				

		
		
		
		}else{
			
			if (carX!= x){
				if(carX<=x){
				SoldierController.car.setX(carX+stepX);
				}
				if (carX>=x){
				SoldierController.car.setX(carX+stepX*(-1));	
				}
				}
				
			if (carY!= y){
				if(carY<=y){
				SoldierController.car.setY(carY+stepY);
				}
				if (carY>=y){
				SoldierController.car.setY(carY+stepY*(-1));	
				}			
				}
			
			
			
		}
	}

}

public static void pullBack1(double stepX, double stepY, double positionX, double positionY){	
	
	Timeline time = new Timeline();
	time.getKeyFrames().add(new KeyFrame(Duration.millis(20),
			(event)-> {
				
				double carX= SoldierController.car.getX();
				double carY=SoldierController.car.getY();
	
	
	if(!Sensors.isObject1X()){
		if(carY<positionY+CanvasController.object1.getHeight()+50){
			SoldierController.car.setY(carY+stepY);	
		}
		if(carY>=positionY+CanvasController.object1.getHeight()+50){
		Sensors.setMovement(true);
		Sensors.setObject1X(true);
		}
	}
	
	if(!Sensors.isObject1Y()){
		if(carX<positionX+CanvasController.object1.getWidth()+50){
			SoldierController.car.setX(carX+stepX);	
		}
		if(carX>=positionX+CanvasController.object1.getWidth()+50){
		Sensors.setMovement(true);
		Sensors.setObject1Y(true);
		}
	}
	
			}));
	
	
	time.setCycleCount(Timeline.INDEFINITE);
	time.play();
	
}


public static void pullBack2(double stepX, double stepY, double positionX, double positionY){	
	
	Timeline time = new Timeline();
	time.getKeyFrames().add(new KeyFrame(Duration.millis(20),
			(event)-> {
				
				double carX= SoldierController.car.getX();
				double carY=SoldierController.car.getY();
	
	if(!Sensors.isObject2X()){
		if(carY<positionY+CanvasController.object2.getHeight()+50){
			SoldierController.car.setY(carY+stepY);	
		}
		if(carY>=positionY+CanvasController.object2.getHeight()+50){
		Sensors.setMovement(true);
		Sensors.setObject2X(true);
		}
	}
	
	if(!Sensors.isObject2Y()){
		if(carX<positionX+CanvasController.object2.getWidth()+50){
			SoldierController.car.setX(carX+stepX);	
		}
		if(carX>=positionX+CanvasController.object2.getWidth()+50){
		Sensors.setMovement(true);
		Sensors.setObject2Y(true);
		}
	}
	
			}));
	
	
	time.setCycleCount(Timeline.INDEFINITE);
	time.play();
	
}

public static void pullBackGar(double stepX, double stepY, double positionX, double positionY){	
	
	Timeline time = new Timeline();
	time.getKeyFrames().add(new KeyFrame(Duration.millis(20),
			(event)-> {
				
				double carX= SoldierController.car.getX();
				double carY=SoldierController.car.getY();
	
	if(!Sensors.isGarageX()){
		if(carY<positionY+SoldierController.garage.getWallLeftHeight()+50){
			SoldierController.car.setY(carY+stepY);	
		}
		if(carY>=positionY+SoldierController.garage.getWallLeftHeight()+50){
		Sensors.setMovement(true);
		Sensors.setGarageX(true);
		}
	}
	
	if(!Sensors.isGarageY()){
		if(carX<positionX+SoldierController.garage.getWallLeftWidth()+50){
			SoldierController.car.setX(carX+stepX);	
		}
		if(carX>=positionX+SoldierController.garage.getWallLeftWidth()+50){
		Sensors.setMovement(true);
		Sensors.setGarageY(true);
		}
	}
	
			}));
	
	
	time.setCycleCount(Timeline.INDEFINITE);
	time.play();
	
}


public static void parking (double stepX, double stepY){
	
	Timeline time = new Timeline();
	time.getKeyFrames().add(new KeyFrame(Duration.millis(20),
			(event)-> {
				
				double firstX=SoldierController.garage.getWallLeftX()+SoldierController.garage.getWallLeftWidth()+10;
				double firstY=SoldierController.garage.getWallLeftY()-SoldierController.car.getHeight()-50;
				double carX= SoldierController.car.getX();
				double carY=SoldierController.car.getY();
				double garageY= SoldierController.garage.getWallLeftY();
				
		if (!inPosition){
			sensors(stepX, stepY, firstX, firstY);
				
				if(carX<firstX+3 && carX>firstX-3 && carY<firstY+3 && carY>firstY-3)
				setInPosition(true);
			}

		if(inPosition && SoldierController.garage.isOpen()&& !isParked()){
				
				if(carY<garageY+50){
					SoldierController.car.setY(carY+stepY);
					}	
				if (carY<garageY+53&& carY>garageY+48){
					setParked(true);
					time.stop();
				}
		}
		
		if(inPosition && SoldierController.garage.isOpen()&& isParked()){
			
			if(carY>firstY){
				SoldierController.car.setY(carY+stepY*(-1));
				}	
			if (carY>firstY-3&& carY<firstY+3){
				setInPosition(false);
				setParked(false);
				time.stop();
				
				
			}
		}
	
			}));
	
	
	time.setCycleCount(Timeline.INDEFINITE);
	time.play();

}
}