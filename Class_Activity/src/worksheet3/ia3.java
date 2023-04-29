package worksheet3;

public class ia3 {
	   public static void main(String[] arg) {
	             Car herCar = new Car();
	      Car hisCar = new Car();

	      Car myCar = hisCar;
	      hisCar = null;
	      myCar = herCar;
	      herCar = hisCar;
	      
	      myCar.x = 1;
	      
	       }
	}
	class Car {

		public int x;
	      
	      
	}
