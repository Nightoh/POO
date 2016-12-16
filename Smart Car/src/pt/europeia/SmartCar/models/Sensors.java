  package pt.europeia.SmartCar.models;

import pt.europeia.SmartCar.controllers.CanvasController;
import pt.europeia.SmartCar.controllers.SoldierController;

public class Sensors {
	
	
public static void sensors(int stepX, int stepY, double x, double y){
			
		
		double coordX= SoldierController.car.getX();
		double coordY=SoldierController.car.getY();
		
		
		if (coordX>= CanvasController.object1.getCoordX1()-50 && coordX<= CanvasController.object1.getCoordX1()+ CanvasController.object1.getWidth()+50
				&& coordY>= CanvasController.object1.getCoordY1()-20 && coordY<= CanvasController.object1.getCoordY1()+CanvasController.object1.getHeight()+20
				||
				coordX>= CanvasController.object1.getCoordX1()-20 && coordX<= CanvasController.object1.getCoordX1()+ CanvasController.object1.getWidth()+20
				&& coordY>= CanvasController.object1.getCoordY1()-50 && coordY<= CanvasController.object1.getCoordY1()+CanvasController.object1.getHeight()+50
				||
				coordX>= CanvasController.object2.getCoordX2()-50 && coordX<= CanvasController.object2.getCoordX2()+ CanvasController.object2.getWidth()+50
				&& coordY>= CanvasController.object2.getCoordY2()-20 && coordY<= CanvasController.object2.getCoordY2()+CanvasController.object2.getHeight()+20
				||
				coordX>= CanvasController.object2.getCoordX2()-20 && coordX<= CanvasController.object2.getCoordX2()+ CanvasController.object2.getWidth()+20
				&& coordY>= CanvasController.object2.getCoordY2()-50 && coordY<= CanvasController.object2.getCoordY2()+CanvasController.object2.getHeight()+50
		){
		
		
		
		/////object 1
	if(coordX>= CanvasController.object1.getCoordX1()-50 && coordX<= CanvasController.object1.getCoordX1()+ CanvasController.object1.getWidth()+50
		&& coordY>= CanvasController.object1.getCoordY1()-30 && coordY<= CanvasController.object1.getCoordY1()+CanvasController.object1.getHeight()+30
		 && coordY>= y-100 && coordY<= y+100){
		stepY= stepY*(-1);
			SoldierController.car.setY(coordY+stepY);	
			}
			
		
		
		if(coordX>= CanvasController.object1.getCoordX1()-30 && coordX<= CanvasController.object1.getCoordX1()+ CanvasController.object1.getWidth()+30
		&& coordY>= CanvasController.object1.getCoordY1()-50 && coordY<= CanvasController.object1.getCoordY1()+CanvasController.object1.getHeight()+50
	    && coordX>= x-150 && coordX<= x+150){
			stepX=stepX*(-1);
			SoldierController.car.setX(coordX+stepX);
	
				
		}
		
		if(coordX>= CanvasController.object1.getCoordX1()-50 && coordX<= CanvasController.object1.getCoordX1()+ CanvasController.object1.getWidth()+50
				&& coordY>= CanvasController.object1.getCoordY1()-20 && coordY<= CanvasController.object1.getCoordY1()+CanvasController.object1.getHeight()+20){
			SoldierController.car.setY(coordY+stepY);

		}
		
		if(coordX>= CanvasController.object1.getCoordX1()-20 && coordX<= CanvasController.object1.getCoordX1()+ CanvasController.object1.getWidth()+20
				&& coordY>= CanvasController.object1.getCoordY1()-50 && coordY<= CanvasController.object1.getCoordY1()+CanvasController.object1.getHeight()+50){
			SoldierController.car.setX(coordX+stepX);
		}
		
		
		/////object2
		if(coordX>= CanvasController.object2.getCoordX2()-50 && coordX<= CanvasController.object2.getCoordX2()+ CanvasController.object2.getWidth()+50
		&& coordY>= CanvasController.object2.getCoordY2()-30 && coordY<= CanvasController.object2.getCoordY2()+CanvasController.object2.getHeight()+30
	 	&& coordY>= y-100 && coordY<= y+100){
			stepY= stepY*(-1);
			SoldierController.car.setY(coordY+stepY);		
		}
		
		if(coordX>= CanvasController.object2.getCoordX2()-30 && coordX<= CanvasController.object2.getCoordX2()+ CanvasController.object2.getWidth()+30
		&& coordY>= CanvasController.object2.getCoordY2()-50 && coordY<= CanvasController.object2.getCoordY2()+CanvasController.object2.getHeight()+50
		&& coordX>= x-100 && coordX<= x+100){
			stepX=stepX*(-1);
			SoldierController.car.setX(coordX+stepX);
					

		}
		
		if(coordX>= CanvasController.object2.getCoordX2()-50 && coordX<= CanvasController.object2.getCoordX2()+ CanvasController.object2.getWidth()+50
				&& coordY>= CanvasController.object2.getCoordY2()-20 && coordY<= CanvasController.object2.getCoordY2()+CanvasController.object2.getHeight()+20){
			SoldierController.car.setY(coordY+stepY);
		
		}
		
		if(coordX>= CanvasController.object2.getCoordX2()-20 && coordX<= CanvasController.object2.getCoordX2()+ CanvasController.object2.getWidth()+20
				&& coordY>= CanvasController.object2.getCoordY2()-50 && coordY<= CanvasController.object2.getCoordY2()+CanvasController.object2.getHeight()+50){
			SoldierController.car.setX(coordX+stepX);
		}
		
		
		
		
		
		}else{
			
			if (coordX!= x){
				SoldierController.car.setX(coordX+stepX);
				}
				
			if (coordY!= y){
				SoldierController.car.setY(coordY+stepY);
			}
			
		
			
			
		}
	}

}





