package advanceSort.shellSort;

/**
 * 
 * @ClassName ArraySh
 * @Description 
 * 	<p>
 * 		ϣ������
 * 			������򣬱��Ĳ��õļ������Ϊ:h = 3h+1�����۲��ú��ּ�����У�
 * 			��������𽥼��ٵ�1����ʱ���һ��������һ����ͨ�Ĳ�������
 *  </p>
 * @author qsdepth@foxmail.com
 * @date 2014-12-23
 */
public class ArraySh {
	
	private long[] theArray;
	private int nElems;
	
	public ArraySh(int max) {
		theArray = new long[max];
		nElems = 0;
	}
	
	public void insert(long value) {
		theArray[nElems] = value;
		nElems++;
	}
	
	public void display() {
		System.out.println("A=");
		for (int i = 0; i < nElems; i++) {
			System.out.print(theArray[i] + " ");
		}
		System.out.println("");
	}
	
	public void shellSort() {
		int inner, outer;
		long temp;
		
		int h = 1; //find inital value of h
		while (h <= nElems/3) {
			h = h*3 + 1; //(1,4,13,40,121....);
		}
		
		while (h>0) { //decreasing h, until h = 1
			for (outer = h; outer < nElems; outer++) {
				temp = theArray[outer];
				inner = outer;
				
				while (inner > h-1 && theArray[inner-h] >= temp) {
					theArray[inner] = theArray[inner-h];
					inner -= h;
				}
				theArray[inner] = temp;
			} // end for
			h = (h -1) / 3; //decrease h
		}
	}
	
	
	public static void main(String[] args) {
		int maxSize = 10000;
		ArraySh arr;
		arr = new ArraySh(maxSize);
		for (int i = 0; i < maxSize; i++) {
			long n = (int)(Math.random()*90);
			arr.insert(n);
		}
		arr.display();
		arr.shellSort();
		arr.display();
	}
	
}







































