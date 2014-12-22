/**
 * 
 */
package link;

/**
 * @author qsdepth@foxmail.com
 *
 */
public class DoublyLinkedList {
	
	public DLink first;
	public DLink last;
	
	public DoublyLinkedList() {
		this.first = null;
		this.last = null;
	}
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	/**
	 * 向前遍历
	 */
	public void displayForward() {
		System.out.print("List (first-->last):");
		DLink current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}
	
	/**
	 * 向后遍历
	 */
	public void displayBackward() {
		System.out.print("List (last-->first):");
		DLink current = last;
		while (current != null) {
			current.displayLink();
			current = current.previous;
		}
		System.out.println("");
	}
	
	/**
	 * 在链表头插入连接点
	 */
	public void insertFirst(long dd) {
		DLink newLink = new DLink(dd);
		if (isEmpty()) {
			last = newLink;
		} else {
			first.previous = newLink;
		}
		newLink.next = first;
		first = newLink;
	}
	
	/**
	 * 在某一个节点之后插入节点
	 */
	public void insertLast(long dd) {
		DLink newLink = new DLink(dd);
		if (isEmpty()) {
			first = newLink;
		} else {
			last.next = newLink;
			newLink.previous = last;
			newLink.next = null;
		}
		last = newLink;
	}
	
	/**
	 * 删除第一个节点
	 */
	public DLink deleteFirst() {
		DLink temp = first;
		if (first.next == null) { //if only on item
			last = null;
		} else {
			first.next.previous = null;
		}
		first = first.next;
		return temp;
	}
	
	/**
	 * 删除最后一个节点
	 */
	public DLink deleteLast() {
		DLink temp = last;
		if (first.next == null) { //if only one item
			first = null;
		} else {
			last.previous.next = null;
		}
		last = last.previous;
		return temp;
	}
	
	/**
	 * 在某个节点之后插入节点
	 */
	public boolean insertAfter(long key, long dd) {
		DLink current = first; //start at beginning
		while (current.dData != key) { //until match is found
			current = current.next;
			if (current == null) { //didn't find it
				return false;
			}
		}
		DLink newLink = new DLink(dd); // make new link
		if (current == last) { //if last link
			newLink.next = null;
			last = newLink;
		} else {
			newLink.next = current.next;
			current.next.previous = newLink;
		}
		newLink.previous = current;
		current.next = newLink;
		return true;
	}
	
	/**
	 * 删除指定的节点
	 */
	public DLink deleteKey(long key) {
		DLink current = first; // start at beginning
		while (current.dData != key) {
			current = current.next; //move to new link
			if (current == null) { //didn't find it
				return null;
			}
		}
		if (current == first) {
			first = current.next;
		} else {
			current.previous.next = current.next;
		}
		
		if (current == last) {
			last = current.previous;
		} else {
			current.next.previous = current.previous;
		}
		return current;
	}
	
	/**
	 * 测试类
	 */
	public static void main(String[] args) {
		DoublyLinkedList theList = new DoublyLinkedList();
		theList.insertFirst(22);
		theList.insertFirst(44);
		theList.insertFirst(66);
		
		theList.insertLast(11);
		theList.insertLast(33);
		theList.insertLast(55);
		
		theList.displayForward();
		theList.displayBackward();
		
		theList.deleteFirst();
		theList.deleteLast();
		theList.deleteKey(11);
		
		theList.displayForward();
		
		theList.insertAfter(22, 77);
		theList.insertAfter(33, 88);
		
		theList.displayForward();
	}
	
	
}
































