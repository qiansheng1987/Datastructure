/**
 * 
 */
package link;

/**
 * @author qsdepth@foxmail.com
 * @date 2014-12-19
 * @des 
 * <p>
 * 	有序链表
 * 		在有序链表中插入和删除某一项最多需要O(N)次比较（平均N/2），可以在O(1)的
 * 		时间内找到或者删除最小值，因为它总在表头。
 * 应用场景：
 * 		如果一个应用频繁地存取最小项，且不需要快速的插入，那么有序链表是一个有效的方案
 * 		（优先级队列可以用有序链表来实现）
 * </p>
 */
public class SortedList {
	
	private Link first;
	
	public SortedList() {
		this.first = null;
	}
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	public void insert(int iData, double dData) {
		
		Link newLink = new Link(iData, dData);
		Link previous = null; //start and first
		Link current = first;
		
		while (current != null && iData>current.iDate) { //untill end of list, move to next Item;
			previous = current;
			current = current.next;
		}
		
		if (previous == null) { // at the begin of list
			first = newLink;
		} else {
			previous.next = newLink;
		}
		newLink.next = current;
	}
	
	public Link remove() {
		Link temp = first; //save the first item;
		first = first.next;
		return temp;
	}
	
	public void displayList() {
		System.out.println("List (first --> last):");
		Link current = first; // start at begining of list
		while (current != null) { // untill end of list;
			current.displayLink();
			current = current.next; // move to next link
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		
		SortedList theSortedList = new SortedList();
		theSortedList.insert(20, 20.00);
		theSortedList.insert(40, 40.00);

		theSortedList.displayList();
		
		theSortedList.insert(10, 10.00);
		theSortedList.insert(30, 30.00);
		
		theSortedList.displayList();
		
		theSortedList.remove();
		theSortedList.displayList();
	}
}	




































