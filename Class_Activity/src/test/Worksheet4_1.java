package test;

public class Worksheet4_1 {
	static int counter = 0;
	int timer;
	
	public static void main (String[] args) {
		Worksheet4_1 obj1 = new Worksheet4_1();
		obj1.setCounter();
		obj1.setTimer(10);
		System.out.println("Counter = " + counter + "\tTimer = " + obj1.timer);
		Worksheet4_1 obj2 = new Worksheet4_1();
		obj2.setCounter();
		obj2.setTimer(counter);
		System.out.println("Counter = " + counter + "\tTimer = " + obj2.timer);
		obj2.resetCounter();
		System.out.println(Worksheet4_1.counter);
		char grades[];
		grades = new char[2];
		grades[0] = 'D';
		grades[1] = (char) ((int) grades[0] -1);
		
		char grades2[];
		grades2 = new char[2];
		grades2[0] = grades[0]--;
		grades2[1] = --grades[1];
		System.out.println("grades0 " + grades[0]);
		System.out.println("grades1 " + grades[1]);
		

	}
	
	public Worksheet4_1() {
		this.timer = 0;
	}
	
	public void setCounter() {
		this.counter++;
	}
	
	public void resetCounter() {
		this.counter = 0;
	}
	
	public void setTimer(int second) {
		this.timer = second;
	}
}
