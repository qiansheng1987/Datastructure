package link;

/**
 * 
 * @author qsdepth@foxmail.com
 * @des    Ë«ÏòÁ´±í
 *
 */
public class DLink {

	public long dData;
	public DLink next;
	public DLink previous;
	
	public DLink(long d) {
		dData = d;
	}
	
	public void displayLink() {
		System.out.print(dData + " ");
	}
}



















