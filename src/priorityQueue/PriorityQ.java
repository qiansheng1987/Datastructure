/**  
 * @Project: Datastructure
 * @Title: PriorityQ.java
 * @Package priorityQueue
 * @Description: TODO
 * @author qsdepth@foxmail.com
 * @date 2014-12-18 ����4:50:08
 * @Copyright: 2014 
 * @version V1.0  
 */

package priorityQueue;

/**
 * @ClassName PriorityQ
 * @Description �������ݵ����ȼ�����
 * 				��ʵ�ֵ����ȼ������У����������ҪO(N)��ʱ�临�Ӷ�
 * 				ɾ��������Ҫ O(1)��ʱ�临�Ӷ�
 * 				���Ҳ�����ҪO(1)��ʱ�临�Ӷȡ�
 * @author qsdepth@foxmail.com
 * @date 2014-12-18
 */

public class PriorityQ {
	
	private int maxSize;
	private long[] queArray;
	private int nItems;
	
	/**
	 * 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @param s
	 */
	public PriorityQ(int s) {
		maxSize = s;
		queArray = new long[maxSize];
		nItems = 0;
	}
	
	/**
	 * 
	* @Title: insert 
	* @Description: ����
	* @param @param item     
	* @return void     
	* @throws
	 */
	public void insert(long item) {
		
		int i;
		if (nItems == 0) { //������û������
			queArray[nItems++] = item;
		} else {
			for (i = nItems-1; i >=0 ; i--) {
				if (item > queArray[i]) {
					queArray[i+1] = queArray[i];
				} else {
					break;
				}
			}
			queArray[i+1] = item;
			nItems++;
		}
	}
	
	public long remove() { //remove minumun item
		return queArray[--nItems];
	}
	
	public long peakWin() { //peak minumun item
		return queArray[nItems-1];
	}
	
	public boolean isEmpty() {
		return (nItems == 0);
	}
	
	public boolean isFull() {
		return (nItems == maxSize);
	}
	
	public static void main(String[] args) {
		PriorityQ pq = new PriorityQ(5);
		pq.insert(30);
		pq.insert(50);
		pq.insert(10);
		pq.insert(40);
		pq.insert(20);
		while (!pq.isEmpty()) {
			long item = pq.remove();
			System.out.print(item + " ");
		}
		System.out.println(" ");
	}
}























