/**  
 * @Project: Datastructure
 * @Title: Heap.java
 * @Package heap
 * @Description: TODO
 * @author qsdepth@foxmail.com
 * @date 2014-12-26 ÏÂÎç2:19:53
 * @Copyright: 2014 
 * @version V1.0  
 */

package heap;

import java.util.ArrayList;

/**
 * @ClassName Heap
 * @Description TODO
 * @author qsdepth@foxmail.com
 * @date 2014-12-26
 */

public class Heap {
	
	private Node[] heapArray;
	private int maxSize; //size of array
	private int currentSize; //number of nodes in array;
	
	public Heap(int mx) {
		maxSize = mx;
		currentSize = 0;
		heapArray = new Node[maxSize];
	}
	
	public boolean isEmpty() {
		return (currentSize == 0);
	}
	
	public boolean isFull() {
		return (currentSize == maxSize);
	}
	
	public boolean insert(int key) {
		if (isFull()) { // if array is full
			return false;
		}
		Node newNode = new Node(key); // make a new node
		heapArray[currentSize] = newNode; // put it at the end
		trickUp(currentSize++);
		return true;
	}
	
	public Node remove() {
		ArrayList<String> list = null;
		Node root = heapArray[0];
		heapArray[--currentSize] = root; //last --> root
		trickDown(0);
		return root;
	}
	
	public void trickUp(int index) {
		int parent = (index -1)/2;
		Node bottom = heapArray[index];
		while (index > 0 && heapArray[parent].getKey() < bottom.getKey()) {
			heapArray[index] = heapArray[parent];
			index = parent; //move index up
			parent = (parent -1)/2; //move parent up
		}
		heapArray[index] = bottom;
	}
	
	public void trickDown(int index) {
		int largerChild;
		Node top = heapArray[index]; //save root;
		
		while (index < currentSize/2) { //while node has at least one child
			int leftChild = 2*index + 1;
			int rightChild = leftChild + 1;
			
			if (rightChild < currentSize && //rightChild exists?
					heapArray[leftChild].getKey() < heapArray[rightChild].getKey()) {
				largerChild = rightChild;
			} else {
				largerChild = leftChild;
			}
			
			if (top.getKey() >= heapArray[largerChild].getKey()) {
				break;
			} else {
				heapArray[index] = heapArray[largerChild];
				index = largerChild; //go down
			}
			
			heapArray[index] = top; // root to index
		}
	} 
	
	public boolean change(int index, int newValue) {
		if (index < 0 || index >= currentSize) {
			return false;
		}
		int oldValue = heapArray[index].getKey(); //remenber old
		heapArray[index].setKey(newValue); //change to new
		
		if (oldValue < newValue) {
			trickUp(index);
		} else {
			trickDown(index);
		}
		return true;
	}
	
	public void displayHeap() {
		System.out.println("heapArra: ");
		for (int i = 0; i < currentSize; i++) {
			System.out.println(heapArray[i].getKey() + " ");
		}
	}
	
	
}


























