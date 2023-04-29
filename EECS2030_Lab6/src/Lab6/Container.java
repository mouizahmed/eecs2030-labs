package Lab6;

import java.util.*;
import java.io.*;
/**
 * This class is a container that holds an unlimited number of 
 * String objects. It is able to remove objects and add objects.
 */

public class Container {
	// No instance variable should be defined for this class. 


	/**
	 * Reads the given file and add it into a list. 
	 * Each element of the list contains one line of the file. 
	 * @param fileName is the name of the file that is read in this method. 
	 */

	public static final List<String> readFile(String fileName) {
		// add your code here. You may change the return value.
		List<String> list = new ArrayList<String>();
		
		Scanner scannerObject;
		try {
			scannerObject = new Scanner(new File(fileName));
			while (scannerObject.hasNextLine()) {
				list.add(scannerObject.nextLine());
			}
			scannerObject.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return list;
		
	}
		
	/**
	 * This method adds the <code> obj </code> to the container.
	 * @param obj is the object that is added to the container.
	 */
	
	void add(Object object) {
		// insert your code here
		System.out.println("The object was added to the contianer");
	}

	/**
	 * This method removes the object from the container
	 * @return returns the removed object.
	 */
	Object remove() {
		// insert your code here. You may want to change the return value. 
		System.out.println("The object was removed from the container.");
		return null;
	}

	/**
	 * @return It returns the number of elements in the container.
	 */
	int getSize() {
		// insert your code here. You may need to change the return value. 
		return 0;
	}

}

/**
 * 
 * This class simulates a Queue, which is a data structure that insert and remove data 
 * by FIFO (first-in, first-out) rule
 *
 */
class Queue extends Container{
	ArrayList<String> queue; 
	
	/**
	 * This is the constructor that initializes the <code> queue </code>
	 * with all the strings in the <code> fileName </code> that is labeled 
	 * by "Queue"
	 * @param fileName is the name of the file that is read.  
	 */
	public Queue(String fileName) {
		List<String> list = Container.readFile(fileName);
		this.queue = new ArrayList<String>();
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).contains("Queue")) {
				String elementQ = list.get(i).toString().replace("Queue", "");
				String elementS = elementQ.replaceAll(" ", "");
				queue.add(elementS);
			}
		}
		
	}
	
	/**
	 * This method adds the object into the Queue. 
	 * Please note that the rule of the queue insertion/removal is 
	 * First in, First out. 
	 * @param obj is the object that is added to the queue. 
	 */
	@Override
	public void add(Object obj) {
		// insert your code here
		queue.add((String) obj);
	}
	/**
	 * This method removes an object from the Queue. 
	 * Please note that the rule of the queue insertion/removal is 
	 * First in, First out. 
	 */
	@Override
	public Object remove() {
		// insert your code here. You may want to change the return value. 
		
		Object removedE = queue.get(0);
		queue.remove(0);
		
		return removedE; 
	}
	/**
	 * @return returns the object which is in front of the queue.
	 */
	public Object top() {
		// insert your code here. You may want to change the return value.
		return queue.get(0);
	}
	
	/**
	 * Returns the number of items in the queue.
	 */
	@Override 
	public int getSize(){
		// insert your code here. You may want to change the return value. 
		return queue.size();
	}
}

/**
 * 
 * This class simulates a Stack, which is a data structure that insert and remove data 
 * by FILO (first-in, last-out) rule
 *
 */
class Stack extends Container{
	ArrayList<String> stack; 
	
	/**
	 * This is the constructor that initializes the <code> stack </code>
	 * with all the strings in the <code> fileName </code> that is labeled 
	 * by "Stack"
	 * @param fileName is the name of the file that is read.  
	 */
	public Stack(String fileName) {
		// insert your code here.
		stack = new ArrayList<String>();
		List<String> list = Container.readFile(fileName);

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).contains("Stack")) {
				String elementQ = list.get(i).toString().replace("Stack", "");
				String elementS = elementQ.replaceAll(" ", "");
				stack.add(elementS);
			}
		}

	}

	/**
	 * This method removes an object from the stack. 
	 * Please note that the rule of the stack insertion/removal is 
	 * First in, Last out. 
	 */

	@Override
	public void add(Object obj) {
		// insert your code here.
		stack.add((String) obj);
	}
	
	/**
	 * This method removes an object from the stack. 
	 * Please note that the rule of the stack insertion/removal is 
	 * First in, Last out. 
	 */

	@Override
	public Object remove() {
		// insert your code here. You may want to change the return value. 
		int index = stack.size()-1;
		Object removedE = stack.get(index);
		
		stack.remove(index);
		
		return removedE;  	
	}
	/**
	 * @return returns the object which is on top of the stack.
	 */
	
	public Object top() {
		// insert your code here. You may want to change the return value. 
		int index = stack.size()-1;
		return stack.get(index); 
	}
	/**
	 * Returns the number of items in the stack.
	 */
	@Override 
	public int getSize() {
		// insert your code here. You may want to change the return value. 
	      return stack.size();
	}
}