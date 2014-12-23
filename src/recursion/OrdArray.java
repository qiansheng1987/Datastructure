package recursion;

/**
 * 
 * @ClassName OrdArray
 * @Description ��������
 * @author qsdepth@foxmail.com
 * @date 2014-12-22
 */
public class OrdArray {
	
	private long[] a;
	private int nElems;
	
	public OrdArray(int max) {
		a = new long[max];
		nElems = 0;
	}
	
	public int size() {
		return nElems;
	}
	
	public int find(long searchKey) {
		return recFind(searchKey, 0, nElems-1);
	}
	
	/**
	 * 
	* @Title: recFind 
	* @Description: ʹ�õݹ���в���
	* @param @param searchKey
	* @param @param lowerBound
	* @param @param upperBound
	* @param @return     
	* @return int     
	* @throws
	 */
	private int recFind(long searchKey, int lowerBound, int upperBound) {
		int middle;
		middle = (lowerBound + upperBound)/2;
		if (a[middle] == searchKey) {
			return middle;
		} else if (lowerBound > upperBound) { //can't find it
			return nElems;
		} else {
			if (a[middle] < searchKey) {
				lowerBound = middle + 1;
				return recFind(searchKey, middle+1, upperBound);
			} else {
				return recFind(searchKey, lowerBound, middle-1);
			}
		}
	}
	
	
	public void insert(long value) {
		int j;
		for (j = 0; j < nElems; j++) { //�ҵ��������ݵĲ����j
			if (a[j]>value) {
				break;
			} 
		}
		for (int k=nElems; k>j; k--) { //����ͳһ������һλ��Ϊ������ڳ��ռ�
			a[k] = a[k-1];
		}
		a[j] = value; //��������
		nElems++;
	}
	
	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}
	
	
	public static void main(String[] args) {
		int maxSize = 100;
		OrdArray arr;
		arr = new OrdArray(maxSize);
		
		arr.insert(72);
		arr.insert(9);
		arr.insert(45);
		arr.insert(128);
		arr.insert(54);
		arr.insert(99);
		arr.insert(144);
		arr.insert(135);
		
		arr.display();
	}
	
	
	
}




















