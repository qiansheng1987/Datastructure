package sort;

public class ArrayIns {
	
	private long[] a; 
	private int nElems; //������
	
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
	* @param  ������forѭ���У�out������1��ʼ�������ƶ����������δ���򲿷ֵ�����˵����ݣ�����
	* �ڲ��whileѭ���У�in������out������ʼ�������ƶ���ֱ��temp����С��in��ָ������������������Ѿ������������ƶ�Ϊֹ
	* whileѭ����ÿһ�˶������ƶ���һ���Ѿ�����������   
	* @return void     
	* @throws
	 */
	public void insertSort() {
		
		int in, out;
		for (out = 1; out < nElems ; out++) { //δ�����Ԫ��
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
		System.out.println("����ǰ����ʾ��");
		arr.display();
		System.out.println("�����Ľṹ��ʾ�� ");
		arr.insertSort();
		arr.display();
	}
}


































