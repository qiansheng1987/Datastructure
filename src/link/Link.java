package link;

public class Link {
	
	public int iDate;
	public double dData;
	public Link next;
	
	public Link(int id, double dd) {
		this.iDate = id;
		this.dData = dd;
	}
	
	public void displayLink() {
		System.out.print("{" + iDate + ", " + dData + "}");
	}

}
