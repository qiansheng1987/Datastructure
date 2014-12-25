package hashTable;

public class Link {
	private int iData;
	public Link next; //next link in List
	
	public Link(int it) {
		this.iData = it;
		this.next = null;
	}
	
	public int getKey() {
		return iData;
	}
	
	public void displayLink() {
		System.out.print(iData + " ");
	}
	
}
