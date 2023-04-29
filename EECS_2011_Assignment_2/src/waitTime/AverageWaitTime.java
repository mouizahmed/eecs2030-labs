package waitTime;

import java.util.*;

public class AverageWaitTime {
	//we will probably need input/output as well as error checking for anything that is not a  
	//positive integer
	//Also just give 3 options (1. SJF 2. RR 3. Priority RR) and take integer input to choose an 
	//algorithm
	//need inputs for time variables, process number (1, 2, 3, ..), and algorithm option

	public static void main() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Number of processes: ");
		int np = sc.nextInt();

		for(int i = 0; i<np; i++) {
			// loop over the number of processes and addNode for each process
		}
	}

	Node head;

	class Node{
		Node next;
		int arrivaltime;
		int bursttime;
		int timequantum;
		int processpriority;

		public Node() {

		}
	}
	// i think we can just default unused variables to zero since we wont use them anyway
	//(like time quantum for SJF)
	public void addNode() {

	}

	//Probably best to solve everything below using recursion since we're using SLL
	static void sjfAvgWaitTime() { //Method to calculate average wait time for SJF Algorithm

	}

	static void rrAvgWaitTime() { //Method to calculate average wait time for round robin

	}

	static void prrAvgWaitTime() {//Method to calculate average wait time for priority round robin 

	}
}