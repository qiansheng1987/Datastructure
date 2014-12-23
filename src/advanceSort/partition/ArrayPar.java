package advanceSort.partition;

/**
 * 
 * @ClassName ArrayPar
 * @Description 
 * 	<p>
 * 		划分
 * 			划分数据就是把数据分为两组，使得所用关键字大于特定值的数据项在一组，使得所有关键字小于特定值的数据项在列一组。
 * 			两个指针开始时分别在数组的两端，然后相向移动，当左侧大于关键字或者右侧小于关键字，停止移动并交换数据，当
 * 			两个指针相遇时，划分完成。
 * 	</p>
 * @author qsdepth@foxmail.com
 * @date 2014-12-23
 */
public class ArrayPar {
	
	private long[] theArray;
	private int nElems;
	
	public ArrayPar(int max) {
		theArray = new long[max];
		nElems = 0;
	}
	
	public void insert(long value) {
		theArray[nElems] = value;
		nElems++;
	}
	
	public int size() {
		return nElems;
	}
	
	public void display() {
		System.out.print("A: ");
		for (int i = 0; i < nElems; i++) {
			System.out.print(theArray[i] + " ");
		}
		System.out.println("");
	}
	
	public int partitionIt(int left, int right, long pivot) {
		int leftPtr = left - 1;
		int rightPtr = right + 1;
		
		while (true) {
			//leftPtr < right防止左则全部小于pivot 可能导致的数组越界情况
			while (leftPtr < right && theArray[++leftPtr] < pivot) { //find bigger item
				;//空操作不做任务工作
			}
			while (rightPtr > left && theArray[--rightPtr] > pivot) { //find smaller item
				; //(nop)
			}
			if (leftPtr >= rightPtr) {
				break;
			} else {
				swap(leftPtr, rightPtr);
			}
		}
		return leftPtr;
	}
	
	public void swap(int dex1, int dex2) {
		long temp;
		temp = theArray[dex1];
		theArray[dex1] = theArray[dex2];
		theArray[dex2] = temp;
	}
	
	public static void main(String[] args) {
		ArrayPar parArr = new ArrayPar(10);
		parArr.insert(10);
		parArr.insert(49);
		parArr.insert(234);
		parArr.insert(1);
		parArr.insert(45);
		parArr.insert(8000);
		parArr.insert(24);
		parArr.insert(590);
		parArr.insert(123);
		
		parArr.display();
		
		long pivot = 10;
		System.out.print("Pivot is" + pivot);
		int size  = parArr.size();
		int partDex = parArr.partitionIt(0, size-1, pivot);
		System.out.println(", Partition is at index " + partDex);
		parArr.display();
		
	}
	
}
















