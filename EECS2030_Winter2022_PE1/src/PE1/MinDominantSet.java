package PE1;

import java.util.ArrayList;
/* PLEASE DO NOT MODIFY A SINGLE STATEMENT IN THE TEXT BELOW.
READ THE FOLLOWING CAREFULLY AND FILL IN THE GAPS

I hereby declare that all the work that was required to 
solve the following problem including designing the algorithms
and writing the code below, is solely my own and that I received
no help in creating this solution and I have not discussed my solution 
with anybody. I affirm that I have read and understood
the Senate Policy on Academic honesty at 
https://secretariat-policies.info.yorku.ca/policies/academic-honesty-senate-policy-on/
and I am well aware of the seriousness of the matter and the penalties that I will face as a 
result of committing plagiarism in this assignment.

BY FILLING THE GAPS,YOU ARE SIGNING THE ABOVE STATEMENTS.

Full Name: Mouiz Ahmed
Student Number: 218105536
Course Section: Z
*/

/**
 * This class computes all possible combinations based on the arrangement of
 * buildings and vending machines and determines which combinations are correct.
 * 
 * @author Mouiz Ahmed
 * @version 1.0
 *
 */

public class MinDominantSet {
	int[][] buildings;
	ArrayList<Integer[]> combination;
	private int size;

	/**
	 * The main method. This is not used.
	 * @param args is the the command line arguments.
	 */
	public static void main(String[] args) {
		/*
		 * We don't need this method to solve the problem. I kept it here just in case
		 * you need to test your code differently.
		 */
	}

	/**
	 * This constructor stores the instance variable combination with type ArrayList
	 * and defines it to its default value. This takes no parameters.
	 */

	public MinDominantSet() {
		// insert your code here for task 0
		this.combination = new ArrayList<Integer[]>();
	}

	/**
	 * This constructor stores the instance variable combination with type
	 * ArrayList<Integer[]> and defines it to its default value. This constructor
	 * also initializes the instance variable buildings with type int Array[][] with
	 * the specified size provided from the parameter.
	 * 
	 * @param size      is an integer that is used to specify the size of the
	 *                  buildings 2D array.
	 * @param buildings is a double array that is used to store the contents within
	 *                  it into the instance variable to be used throughout the
	 *                  class. It represents the distance between buildings with
	 *                  values 0 or 1.
	 */
	public MinDominantSet(int size, int[][] buildings) {
		// insert your code here for task 2
		this.combination = new ArrayList<Integer[]>();
		this.size = size;
		this.buildings = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				this.buildings[i][j] = buildings[i][j];
			}
		}
	}

	/**
	 * This method creates all possible combinations of vending machines (number
	 * provided as parameter) inside the number of buildings provided as parameter.
	 * It does this recursively with the help of a helper function.
	 * 
	 * @param n is an integer that specifies the number of buildings (size)
	 *          available to form possible combinations.
	 * @param r is an integer that specifies the number of vending machines (how
	 *          many buildings have vending machines per combination).
	 */
	void combination(int n, int r) {
		// insert your code here for task1
		// Note: this method or its helper must be recursive.
		helper(combination, new Integer[r], 0, n - 1, 0);

	}

	/**
	 * This is the first recursive helper method that computes the list of
	 * combinations and its respective values within each combination based on n and
	 * r values.
	 * 
	 * @param combination is an ArrayList<Integer[]> that is used to store the
	 *                    combinations within an array list with each element
	 *                    representing a combination with appropriate values within
	 *                    it.
	 * @param data        is an Integer array that is used to store the values of
	 *                    each combination into an array which is then added to the
	 *                    combinations array list as an element.
	 * @param start       is an integer that represents the beginning of the
	 *                    recursive call (first).
	 * @param end         is an integer that represents the end of the recursive
	 *                    calls (last). The method stops calling itself after it has
	 *                    reached this value. This is incremented after each call.
	 * @param index       is an integer that represents the index of each call,
	 *                    which is incremented after each call (index for each data
	 *                    array value for combination values).
	 */
	private void helper(ArrayList<Integer[]> combination, Integer data[], int start, int end, int index) {

		if (index == data.length) {
			Integer[] combinations = data.clone();
			combination.add(combinations);
		} else {
			int max = Math.min(end, end + 1 - data.length + index);
			for (int i = start; i <= max; i++) {
				data[index] = i;
				helper(combination, data, i + 1, end, index + 1);
			}
		}

	}

	/**
	 * This method computes whether each combination within the array list is valid.
	 * It compares each value within the combination with the adjacency matrix
	 * (buildings 2d array) and determines if the combination is correct. It does
	 * this with the help of a recursive helper function. If a combination is not
	 * valid, it is removed from the array list.
	 * 
	 * @param numMachine is an integer that represents the number of vending
	 *                   machines available per arrangement of buildings. This is
	 *                   used to determine the number of values per combination.
	 * @return This method returns a boolean value of true or false using the
	 *         recursive helper method. True if there are valid combinations left
	 *         available in array list combinations. False if the array list
	 *         combinations is empty.
	 */
	public boolean isEnough(int numMachine) {
		// insert your code here for task 3
		// you may want to change the return value

		combination(this.size, numMachine);

		int index = 0;
		int end = combination.size();

		boolean outcome = helper2(numMachine, index, end);

		return outcome;

	}

	/**
	 * This is a recursive helper method that compares the values within each
	 * combination with the buildings 2D array (adjacency matrix). The function
	 * recalls itself after verifying each combination. If a combination is not
	 * valid, it will remove the combination from the ArrayList combination
	 * variable. At the end, if the ArrayList still has combinations remaining, it
	 * will return true, and vice versa.
	 * 
	 * @param numMachine is an integer that specifies the number of vending machines
	 *                   available within the arrangement of buildings (represents r
	 *                   in combination).
	 * @param index      is an integer that marks the first instance of the
	 *                   recursive call.
	 * @param end        is an integer that marks the last instance of the recursive
	 *                   call. Once the method reaches this, it will stop calling
	 *                   the method.
	 * @return This method returns a boolean value of true or false based on if
	 *         there are valid combinations available or not.
	 */
	private boolean helper2(int numMachine, int index, int end) {

		if (index < combination.size()) {
			ArrayList<Integer> del = new ArrayList<Integer>();
			double sum = 0;

			// Loops through each value in combination
			for (int j = 0; j < (numMachine); j++) {
				// Loops through all buildings
				for (int k = 0; k < (this.size); k++) {
					if (buildings[combination.get(0)[j]][k] == 0) {
						// Loops through the other values in the combination
						j += 1;
						for (int n = 1; n < (numMachine); n++) { // fix
							if (buildings[combination.get(0)[n]][k] == 0) {

								del.add(buildings[combination.get(0)[n]][k]);

								for (int p = 0; p < del.size(); p++) {
									sum += del.get(p);
								}
							}
							if (sum == 0 && del.size() > 0) {
								combination.remove(0);
							}
						}
					}

				}
			}
			helper2(numMachine, index + 1, combination.size());
		}

		if (combination.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method prints the content of the combination. we don't need this method
	 * to solve this problem, however it is there to help you see the content of the
	 * list, when you check for the correctness of your code.
	 */
	void print() {

		for (int i = 0; i < combination.size(); i++) {
			for (int j = 0; j < combination.get(i).length; j++) {
				System.out.print(combination.get(i)[j] + "\t");
			}
			System.out.println();
		}
	}

} // end of MinDominantSet
