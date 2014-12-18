package sort;

public class ArrayIns {
	
	private long[] a; 
	private int nElems; //数据量
	
	public ArrayIns(int max) {
		a = new long[max];
		nElems = 0;
	}
	
	public void insert(long value) {
		a[nElems] = value;
		nElems++;
	}
	
	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.print(a[i] + " ");
			System.out.println(" ");
		}
	}
	
	
	/**
	 * 
	* @Title: insertSort 
	* @Description: TODO
	* @param  在外层的for循环中，out变量从1开始，向右移动，它标记了未排序部分的最左端的数据，而在
	* 内层的while循环中，in变量从out变量开始，向左移动，直到temp变量小于in所指的数组数据项，或者它已经不能再往左移动为止
	* while循环的每一趟都向右移动了一个已经排序的数据项。   
	* @return void     
	* @throws
	 */
	public void insertSort() {
		
		int in, out;
		for (out = 1; out < nElems ; out++) { //未排序的元素
			long temp = a[out];
			in = out;
			while (in>0 && a[in-1] >= temp) {
				a[in] = a[in-1];
				--in;
			}
			a[in] = temp;
		}
	}
	
	public static void main(String[] args) {
		int maxSize = 100;
		ArrayIns arr = new ArrayIns(maxSize);
		arr.insert(39);
		arr.insert(23);
		arr.insert(200);
		arr.insert(6000);
		arr.insert(120);
		arr.insert(400);
		arr.insert(560);
		System.out.println("排序前的显示：");
		arr.display();
		System.out.println("排序后的结构显示： ");
		arr.insertSort();
		arr.display();
	}
}


































