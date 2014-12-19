package link;

/**
 * 
 * @ClassName firstLastList
 * @Description
 * <p>
 * 	双端队列，与传统的链表相比，增加了一个新的特性，即对最后一个链接点的引用，就像对第一个链接点的引用一样。
 * 	优点：方便在链表尾部插入链接点
 * 	不足：不能有助于删除最后一个链接点，因为没有一个引用指向倒数第二个链接点。
 * 		如果最后一个链接点被删除，倒数第二个链接点的next字段应该变成null值。
 * </p>
 * @author qsdepth@foxmail.com
 * @date 2014-12-19
 */
public class FirstLastList {
	
	private Link first;
	private Link last;
	
	public FirstLastList() {
		this.first = null;
		this.last = null;
	}
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	/**
	 * 
	* @Title: insertFirt 
	* @Description: 
	* <p>
	* 	 需要注意待插入的链表为空是的情况。
	* </p>
	* @param @param in
	* @param @param dd     
	* @return void     
	* @throws
	 */
	public void insertFirst(int in, double dd ) {
		Link newLink = new Link(in, dd);
		if (isEmpty()) {
			last = newLink; //newLink <-- last
		}
		newLink.next = first;// newLink --> old first
		first = newLink; //first -->newLink
		
	}
	
	
	/**
	 * 
	* @Title: insertLast 
	* @Description: TODO
	* <p>
	* 	 需要注意待插入的链表为空是的情况。
	* </p>
	* @param @param in
	* @param @param dd     
	* @return void     
	* @throws
	 */
	public void insertLast(int in, double dd) {
		Link newLink = new Link(in, dd);
		if (isEmpty()) {
			first = newLink;
		}
		last.next = newLink;
		last = newLink;
	}
	
	public double deleteFirst() {
		double temp = first.dData;
		if (first.next == null) { //if only one item
			last = null; // last --> null
		}
		first = first.next;
		return temp;
	}
	
	public void displayList() {
		System.out.println("List (first --> last):");
		Link current = first; //start at beginning
		while (current != null) { //until end of list
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		FirstLastList theList = new FirstLastList();
		theList.insertFirst(22, 22.00);
		theList.insertFirst(33, 33.00);
		theList.insertFirst(44, 44.00);
		 
		theList.insertLast(55, 55.00);
		theList.insertLast(66, 66.00);
		theList.insertLast(77, 77.00);
		
		theList.displayList();
		
		theList.deleteFirst();
		theList.displayList();
	}
	
}	






















