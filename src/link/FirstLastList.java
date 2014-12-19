package link;

/**
 * 
 * @ClassName firstLastList
 * @Description
 * <p>
 * 	˫�˶��У��봫ͳ��������ȣ�������һ���µ����ԣ��������һ�����ӵ�����ã�����Ե�һ�����ӵ������һ����
 * 	�ŵ㣺����������β���������ӵ�
 * 	���㣺����������ɾ�����һ�����ӵ㣬��Ϊû��һ������ָ�����ڶ������ӵ㡣
 * 		������һ�����ӵ㱻ɾ���������ڶ������ӵ��next�ֶ�Ӧ�ñ��nullֵ��
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
	* 	 ��Ҫע������������Ϊ���ǵ������
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
	* 	 ��Ҫע������������Ϊ���ǵ������
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






















