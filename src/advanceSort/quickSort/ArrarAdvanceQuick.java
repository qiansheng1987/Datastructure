package advanceSort.quickSort;

/**
 * 
 * @ClassName ArrarAdvanceQuick
 * @Description 
 * 	<p>
 * 		改进的快速排序
 * 	</p>
 * @author qsdepth@foxmail.com
 * @date 2014-12-23
 */
public class ArrarAdvanceQuick {
	
	private long[] theArray;
	private int nElems;
	
	public ArrarAdvanceQuick(int max) {
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
	
	public void swap(int dev1, int dev2) {
		long temp = theArray[dev1];
		theArray[dev1] = theArray[dev2];
		theArray[dev2] = temp;
	}
	
	public void quickSort() {
		recQuickSort(0, nElems-1);
	}
	
	public void recQuickSort(int left, int right) {
		int size = right - left + 1;
		if (size <= 3) { // manual sort if small
			manualSort(left, right);
		} else { //quickSort if large
			long median = medianOf3(left, right);
			int partition = patitionIt(left, right, median);
			recQuickSort(left, partition-1);
			recQuickSort(partition+1, right);
		}
	}
	
	public void manualSort(int left, int right) {
		int size = right-left+1;
		if (size <= 1) {
			return ; //no sort necesary
		} 
		
		if (size == 2) { // sort left and right
			if (theArray[left] > theArray[right]) {
				swap(left, right);
			} else {
				return ;
			}
		} else { //size ==3  sort left, center, right
			if (theArray[left] > theArray[right-1]) { 
				swap(left, right-1); //exchange left and center
			}
			if (theArray[left] > theArray[right]) {
				swap(left, right);
			}
			if (theArray[right-1] > theArray[right]) {
				swap(right-1, right);
			}
		}
	}
	
	/**
	 * 
	* @Title: medianOf3 
	* @Description: 三数据项取中"划分
	* @return void     
	* @throws
	 */
	public long medianOf3(int left, int right) {
		int center = (left + right)/2;
		if (theArray[left] > theArray[center]) {
			swap(left, center);
		}
		
		if (theArray[left] > theArray[right]) {
			swap(left, right);
		}
		
		if (theArray[center] > theArray[right]) {
			swap(center, right);
		}
		
		swap(center, right-1); //put pivot on right
		return theArray[right-1];
	}
	
	
	public int patitionIt(int left, int right, long pivot) {
		
		int leftPtr = left;
		int rightPtr = right - 1;
		
		while (true) {
			while (theArray[++leftPtr] < pivot) {
				;//(nop)
			}
			while (theArray[--rightPtr] > pivot) {
				;//(nop)
			}
			
			if (leftPtr >= rightPtr) {
				break;
			} else {
				swap(leftPtr, rightPtr);
			}
		}
		swap(leftPtr, right-1); //将pivot插入的对应的位置
		return leftPtr;
	}
	
	public static void main(String[] args) {
		int maxSize = 18;
		ArrarAdvanceQuick arr;
		arr = new ArrarAdvanceQuick(maxSize);
		for (int i = 0; i < maxSize; i++) {
			long n = (int)(Math.random()*99);
			arr.insert(n);
		}
		arr.display();
		arr.quickSort();
		arr.display();
	}
	
	
	
}




























