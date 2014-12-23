package advanceSort.partition;

/**
 * 
 * @ClassName ArrayPar
 * @Description 
 * 	<p>
 * 		����
 * 			�������ݾ��ǰ����ݷ�Ϊ���飬ʹ�����ùؼ��ִ����ض�ֵ����������һ�飬ʹ�����йؼ���С���ض�ֵ������������һ�顣
 * 			����ָ�뿪ʼʱ�ֱ�����������ˣ�Ȼ�������ƶ����������ڹؼ��ֻ����Ҳ�С�ڹؼ��֣�ֹͣ�ƶ����������ݣ���
 * 			����ָ������ʱ��������ɡ�
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
			//leftPtr < right��ֹ����ȫ��С��pivot ���ܵ��µ�����Խ�����
			while (leftPtr < right && theArray[++leftPtr] < pivot) { //find bigger item
				;//�ղ�������������
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
















