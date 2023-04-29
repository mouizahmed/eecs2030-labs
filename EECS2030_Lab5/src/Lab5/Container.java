package Lab5;

public class Container {
	// Do not change the value of the following constants.
	protected final int ORIGINAL_SIZE = 10;
	protected Object[] list; // is a container that stores the element of MyList
	protected Object[] set; // is a container that stores the element of MySet
	protected int size; // this variable holds the actual number of elements that are stored in either
						// of the containers (i.e. MyList or MySet).

	/**
	 * This method adds the <code> obj </code> to the end of the container.
	 * 
	 * @param obj is the object that is added to the container.
	 */
	void add(Object obj) {
		System.out.println("The object was added to the contianer");
	}

	/**
	 * This method removes the <code> obj </code> from the container. It shifts all
	 * the elements to make sure that removal of the element does not create a whole
	 * in the container.
	 * 
	 * @param obj is the object that is removed from the container.
	 * @return It returns the object that was removed.
	 */
	Object remove(Object obj) {
		System.out.println("The object was removed from the container.");
		return obj;
	}

	/**
	 * This method returns true if the container is empty.
	 * 
	 * @return It returns true if the container is empty, otherwise false.
	 */
	boolean isEmpty() {
		// you may want to change this return value
		if (size > 0)
			return false;
		else
			return true;
	}

	/**
	 * This method returns the number of elements stored in the container.
	 * 
	 * @return It returns the number of elements in the container.
	 */
	int getSize() {
		// you may want to change this return value.
		return this.size;
	}

}

/**
 * 
 * This class simulates an ArrayList, where you can add unlimited number of
 * elements to the list.
 *
 */
class MyList extends Container {
	/**
	 * This is the default constructor that sets all the instance variables to their
	 * defualt value.
	 */
	public MyList() {
		list = new Object[ORIGINAL_SIZE];
		size = 0;
	}

	/**
	 * This method returns the element that is stored at index <code> index </code>.
	 * 
	 * @param index is the<code> index </code> at which the element is accessed and
	 *              returned.
	 * @return it returns the element stored at the given <code> index </code>.
	 */
	public Object get(int index) {
		// insert your code here. You may want to change the return value.
		if (index < 0 || index >= size) {
			return null;
		} else {
			return this.list[index];
		}
	}

	/**
	 * This method overrides the <code> add </code> method defined in class
	 * <code> container</code>. By adding the <code> obj </code> to the back of the
	 * <code> list </code> array. The original size of the <code> array </code> is
	 * defined by <code> ORIGINAL_SIZE </code>, however, it is possible that more
	 * elements is added to this array. In case the array does not have enough
	 * capacity to add one more element, it grows itself by doubling the size of
	 * <code> list </code> array.
	 */
	@Override
	void add(Object obj) {
		// insert your code here
		if (size >= ORIGINAL_SIZE) { // or this.list.length*
			Object[] list2 = new Object[list.length * 2];

			for (int i = 0; i < size; i++) {
				list2[i] = list[i];
			}
			list2[size] = obj;
			list = list2;
			size++;

		} else {
			list[size] = obj;
			size++;
		}

	}

	/**
	 * This method removes the first occurrence of <code> obj </code> from
	 * <code> list </code>
	 * 
	 * @pre <code> obj </code> exists in the <code>list</code> array.
	 * 
	 */
	@Override
	Object remove(Object obj) {
		// insert your code here. You may want to change the return value.

		int objE = 0;

		// loop through list array to find index of obj
		for (int i = 0; i < size; i++) {
			if (list[i].equals(obj)) {
				objE = i;
				break;
			}
		}

		// replace index with the next
		for (int i = objE; i < size; i++) {
			list[i] = list[i + 1];
		}
		--size;

		return obj;

	}

	/**
	 * This method returns the elements of the MyList in a form of [obj1 obj2 obj3
	 * ...]
	 */
	@Override
	public String toString() {
		// insert your code here. You may want to change the return value.
		String array = "[";

		for (int i = 0; i < size - 1; i++) {
			array += list[i];
			array += " ";
		}

		array += list[size - 1];
		array += "]";

		return array;
	}

}

class MySet extends Container {
	public MySet() {
		set = new Object[ORIGINAL_SIZE];
		size = 0;
	}

	/**
	 * This method overrrides the <code> add </code> method defined in class
	 * <code> container</code>. By adding the <code> obj </code> to the back of the
	 * <code> set </code> array. The original size of the <code> set </code> is
	 * defined by <code> ORIGINAL_SIZE </code>, however, it is possible that more
	 * elements is added to this set. In case the set does not have enough capacity
	 * to add one more element, it grows itself by doubling the size of
	 * <code> set </code> array.
	 */

	@Override
	void add(Object obj) {
		// insert your code here.

		boolean duplicate = false;

		for (int i = 0; i < size; i++) {
			if (set[i].equals(obj) == true) {
				duplicate = true;
			}

		}

		if (duplicate == false) {
			if (size >= ORIGINAL_SIZE) { // or this.list.length*
				Object[] set2 = new Object[set.length * 2];

				for (int i = 0; i < size; i++) {
					set2[i] = set[i];
				}

				set2[size] = obj;
				set = set2;
				size++;

			} else {
				set[size] = obj;
				size++;
			}
		}

	}

	/**
	 * This method removes the first occurrence of <code> obj </code> from
	 * <code> set </code>
	 * 
	 * @pre <code> obj </code> exists in the <code>set</code> array.
	 * 
	 */
	@Override
	Object remove(Object obj) {
		// insert your code here. You may want to change the return value.
		int objE = 0;

		// loop through list array to find index of obj
		for (int i = 0; i < size; i++) {
			if (set[i].equals(obj)) {
				objE = i;
				break;
			}
		}

		// replace index with the next
		for (int i = objE; i < size; i++) {
			set[i] = set[i + 1];
		}
		--size;

		return obj;
	}

	/**
	 * This method returns the elements of the MySet in a form of [obj1 obj2 obj3
	 * ...]
	 */

	@Override
	public String toString() {
		// insert your code here. You may want to change the return value.
		String array = "[";

		for (int i = 0; i < size - 1; i++) {
			array += set[i];
			array += " ";
		}

		array += set[size - 1];
		array += "]";

		return array;
	}

}
