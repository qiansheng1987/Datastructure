/**  
 * @Project: Datastructure
 * @Title: ArrayQuick.java
 * @Package advanceSort.quickSort
 * @Description: TODO
 * @author qsdepth@foxmail.com
 * @date 2014-12-23 下午2:24:41
 * @Copyright: 2014 
 * @version V1.0  
 */

package advanceSort.quickSort;

/**
 * @ClassName ArrayQuick
 * @Description 
 * 	<p>
 * 		快速排序
 * 	</p>
 * @author qsdepth@foxmail.com
 * @date 2014-12-23
 */

public class ArrayQuick {
	
	private long[] theArray;
	private int nElems;
	
	public ArrayQuick(int max) {
		theArray = new long[max];
		nElems = 0;
	}
	
	public void insert(long value) {
		theArray[nElems] = value;
		nElems++;
	}
	
	public void display() {
		System.out.print("A: ");
		for (int i = 0; i < nElems; i++) {
			System.out.print(theArray[i] + " ");
		}
		System.out.println("");
	}
	
	public void quickSort() {
		recQuickSort(0, nElems-1);
	}
	
	public void recQuickSort(int left, int right) {
		if (right - left <= 0) { //if size ==1 alread sorted
			return ;
		}  else {
			long pivot = theArray[right]; //选择最右端的数据作为pivot
			int partition = patitionIt(left, right, pivot);
			recQuickSort(left, partition-1);
			recQuickSort(partition+1, right);
		}
	}
	
	public int patitionIt(int left, int right, long pivot) {
		
		int leftPtr = left - 1;
		int rightPtr = right;
		
		while (true) {
			while (theArray[++leftPtr] < pivot) {
				;//(nop)
			}
			while (rightPtr >0 && theArray[--rightPtr] > pivot) {
				;//(nop)
			}
			
			if (leftPtr >= rightPtr) {
				break;
			} else {
				swap(leftPtr, rightPtr);
			}
		}
		swap(leftPtr, right); //将pivot插入的对应的位置
		return leftPtr;
	}
	
	public void swap(int dev1, int dev2) {
		long temp = theArray[dev1];
		theArray[dev1] = theArray[dev2];
		theArray[dev2] = temp;
	}
	
	public static void main(String[] args) {
		int maxSize = 18;
		ArrayQuick arr;
		arr = new ArrayQuick(maxSize);
		for (int i = 0; i < maxSize; i++) {
			long n = (int)(Math.random()*99);
			arr.insert(n);
		}
		arr.display();
		arr.quickSort();
		arr.display();
	}
	
}






























