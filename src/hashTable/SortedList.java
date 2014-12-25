package hashTable;

public class SortedList {
	
	private Link first; // ref to first list item
	
	public SortedList() {
		this.first = null;
	}
	
	public void insert(Link theLink) {
		int key = theLink.getKey();
		Link previous = null; // start at first
		Link current = first;
		
		while (current != null && key > current.getKey()) {
			previous = current;
			current = current.next; //go to next item
		}
		
		if (previous == null) {
			first = theLink;
		} else {
			previous.next = theLink;
		}
		theLink.next = current;
	}
	
	public void delete(int key) {
		Link previous = null;
		Link current = first;
		
		while (current != null && key != current.getKey()) {
			previous = current;
			current = current.next;
		}
		
		if (previous == null) {
			first = first.next;
		} else {
			previous.next = current.next;
		}
	}
	
	public Link find(int key) {
		Link current = first;
		while (current != null && current.getKey() <= key) {
			if (current.getKey() == key) {
				return current;
			}
			current = current.next;
		}
		return null;
	}
	
	public void displayList() {
		System.out.println("List (first --> last):");
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}
	
	
}



































