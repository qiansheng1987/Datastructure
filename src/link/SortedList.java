/**
 * 
 */
package link;

/**
 * @author qsdepth@foxmail.com
 * @date 2014-12-19
 * @des 
 * <p>
 * 	��������
 * 		�����������в����ɾ��ĳһ�������ҪO(N)�αȽϣ�ƽ��N/2����������O(1)��
 * 		ʱ�����ҵ�����ɾ����Сֵ����Ϊ�����ڱ�ͷ��
 * Ӧ�ó�����
 * 		���һ��Ӧ��Ƶ���ش�ȡ��С��Ҳ���Ҫ���ٵĲ��룬��ô����������һ����Ч�ķ���
 * 		�����ȼ����п���������������ʵ�֣�
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




































