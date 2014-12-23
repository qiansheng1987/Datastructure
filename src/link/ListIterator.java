package link;

public class ListIterator {
	
	private Link current;
	private Link previous;
	private LinkList ourList;
	
	public ListIterator(LinkList list) {
		ourList = list;
		reset();
	}
	
	public void reset() {
		current = ourList.getFirst();
		previous = null;
	}
	
	public boolean atEnd() {
		return (current.next == null);
	}
	
	public void nextLink() {
		previous = current;
		current = current.next;
	}
	
	public Link getCurrent() {
		return current;
	}
	
	public void insertAfter(int iData, double dData) {
		Link newLink = new Link(iData, dData);
		if (ourList.isEmpty()) {
			ourList.setFirst(newLink);
			current = newLink;
		} else {
			newLink.next = current.next;
			current.next = newLink;
			nextLink();
		}
	}
	
	public void insertBefore(int iData, double dData) {
		Link newLink = new Link(iData, dData);
		if (previous == null) { // empty list
			newLink.next = ourList.getFirst();
			ourList.setFirst(newLink);
		} else {
			newLink.next = previous.next;
			previous.next = newLink;
			current = newLink;
		}
	}
	
	public long deleteCurrent() {
		int value = current.iDate;
		if (previous == null) { // begining of list
			ourList.setFirst(current.next);
			reset();
		} else {
			previous.next = current.next;
			if (atEnd()) {
				reset();
			} else {
				current = current.next;
			}
		}
		return value;
	}
	
	
}



































