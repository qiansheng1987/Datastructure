package link;

public class LinkList {
	
	private Link first;
	
	/**
	 * 
	* <p>Title: </p> 
	* <p>Description: 
	* 	当first得值为null时，就表明链表中没有数据项，如果有，first字段中应该存有对第一个连接点的引用值
	* </p>
	 */
	public LinkList() {
		this.first = null;
	}
	
	public boolean isEmpty() {
		return (first == null);
	}
	
	public void insertFirst(int id, double dd) {
		Link newLink = new Link(id, dd); //make new link
		newLink.next = first; //newLink -->old first
		first = newLink; //first --> newLink
	}
	
	public Link deleteFirst() {
		Link deleteLink = null;
		if (!isEmpty()) {
			deleteLink = first;
			first = first.next;
		}
		return deleteLink;
	}
	
	public Link find(int key) {
		Link current = first;
		while (current.iDate != key) {
			if (current.next == null) {
				return null;
			} else {
				current = current.next;
			}
		}
		return current;
	}
	
	public Link delete(int key) {
		Link current = first;
		Link previous = first;
		while (current.iDate != key) {
			if (current.next == null) {
				return null;
			} else {
				previous = current;
				current = current.next;
			}
		}
		
		if (current == first) {
			first = first.next;
		} else {
			previous.next = current.next;
		}
		return current;
	}
	
	public void insertAfter(int key) {
		Link addLink = new Link(100, 100.00);
		//Link current = first;
		//Link previous = first;
		
		/*while (current.next != null) {
			int i = current.iDate;
			if (current.iDate != key) {
				previous = current;
				current = current.next;
			} else {
				if (current == first) {
					addLink.next = first.next;
					first = addLink;
				} else {
					previous.next = addLink;
					addLink.next = current.next;
					break;
				}
			}
		}*/
	}
	
	/**
	 * 
	* @Title: displayList 
	* @Description: 
	* <p>
	* 	从first开始，沿着引用链从一个链结点到下一个链接点，变量current按照顺序指向（引用）
	* 	每一个链接点。
	* </p>
	* @param      
	* @return void     
	* @throws
	 */
	public void displayList() {
		System.out.println("List (first-->last):");
		Link current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		 
		LinkList theList = new LinkList();
		theList.insertFirst(22, 2.99);
		theList.insertFirst(44, 4.99);
		theList.insertFirst(66, 6.99);
		theList.insertFirst(88, 8.99);
		
		theList.displayList();
		theList.insertAfter(88);
		theList.displayList();
		System.out.println("sdf");
		
//		Link f = theList.find(44);
//		f.displayLink();
//		theList.delete(44);
//		theList.displayList();
//		while (!theList.isEmpty()) {
//			Link alink = theList.deleteFirst();
//			System.out.println("Deleted");
//			alink.displayLink();
//			System.out.println("");
//		}
//		
//		theList.displayList();
	}
}






































