/**
 * @author Leon Lu
 * @version 1.1 5/8/2022
 * Due Date: 5/9/2022 (Monday)
 * This program is used to simulate ArrayList without the import
 */
public class ArrayList<T> implements List<T> {

	private static final int DEFAULT_INITIAL_CAPACITY = 11;
	
	private T[] data; //Stores the item added to the list
	private int size;  //Tracks how many items have been added to the list
	
	/**
	 * Constructs an ArrayList using the default capacity
	 */
	public ArrayList() {
		// TODO Complete Constructor
		this.data = (T[]) new Object[0];
		this.size = 0;
	}

	/**
	 * Constructs an ArrayList with an 'initialCapacity'
	 * 
	 * If 'initalCapacity' is non-positive use the default capacity
	 * 
	 * @param initialCapacity - the integer for the array list
	 */
	public ArrayList(int initialCapacity) {
		// TODO Complete Constructor
		
		// If the initialCapacity is non-positive, create array with size of 0
		if(initialCapacity < 0)
		{
			this.ArrayList();
		}
		else
		{
			this.data = (T[]) new Object[initialCapacity];
			this.size = 0;
		}
	}

	@Override
	/**
	 * Add an element to the data array
	 */
	public void add(T item, int index) {
		// TODO Auto-generated method stub
		
		// Check if index is positive number or within the array size.
		// If index does not fulfill the requirements, the method will not add anything
		if(index < 0 && index > data.length)
		{
			System.out.println("Index either not positive number or is beyond the size of the array");
		}
		
		else
		{
			//Create a temporary array that will hold both data elements and newly added item
			T[] tempArray = (T[]) new Object[ data.length+1]; 
			
			// For loop to copy all elements before the target index
			for(int i = 0; i < index; i++)
			{
				tempArray[i] = data[i];
			}
			
			// Add item to the target index
			tempArray[index] = item;
			
			// Add elements after the target index
			for(int i = index + 1; i <= data.length; i++)
			{
				tempArray[i] = data[i - 1];
			}
			
			// Finally reassign the new array to this instance array
			this.data = tempArray;
			this.size++;
		}
	}

	@Override
	/**
	 * Empty data array by removing the elements
	 */
	public void clear() {
		// TODO Auto-generated method stub

		for(int i = 0; i <= data.length; i++)
		{
			data[i] = null;
		}
		this.size = 0;
	}

	@Override
	/**
	 * @return true/false - return true if data array has the item; return false if array does not have item
	 */
	public boolean contains(Object item) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i <= data.length; i++)
		{
			if(data[i] == item)
			{
				return true;
			}
		}
		return false;
	}

	@Override
	/**
	 * @return data[index] = return the element found within the index of element
	 */
	public T get(int index) {
		if(data.length == 0 || index >= data.length)
		{
			return null;
		}
		else
		{
			return data[index];
		}
	}

	@Override
	/**
	 * @return itemloc - Return the integer where the element is located in data
	 */
	public int indexOf(Object item) {
		// TODO Auto-generated method stub
		
		boolean hasFound = false; //Boolean to check if the item has been found
		int itemloc = -1; //Index where the item is found. -1 indicates that item is not found on the array
		
		for(int i = 0; i < data.length; i++)
		{
			if(item == data[i])
			{
				hasFound = true;
				itemloc = i;
			}
		}
		
		if (hasFound == true)
		{
			return itemloc;
		}
		else
		{
			return -1;
		}
	}
	
	@Override
	/**
	 * @return true/false - return one of the two booleans if data is empty or not
	 */
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		// Checks if the array is empty
		if(data.length == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	/**
	 * @return size - return the size of the array
	 */
	public int size() {
		// TODO Auto-generated method stub
		if(data.length == 0)
		{
			return 0;
		}
		else
		{
			return data.length;
		}
	}
}

