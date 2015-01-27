package recursion;

/**
 * 
 * @ClassName MergeSort
 * @Description 归并排序
 * @author qsdepth@foxmail.com
 * @date 2014-12-22
 */
public class MergeSort {
	public static void merge(int[] arrayA, int sizeA,
						int[] arrayB, int sizeB,
						int[] arrayC){
		int aDex = 0;
		int bDex = 0;
		int cDex = 0;
		
		while (aDex < sizeA && bDex < sizeB) { //数组A，B都没有检索完
	        if (arrayA[aDex] < arrayB[bDex]) {
	        	arrayC[cDex++] = arrayA[aDex++];
	        } else {
	        	arrayC[cDex++] = arrayB[bDex++];
	        }
        }
		
		while (aDex < sizeA) { // arrayB is empty
	        arrayC[cDex++] = arrayA[aDex++];
        }
		
		while (bDex < sizeB) {
	        arrayC[cDex++] = arrayB[bDex++];
        }
	}
	
	public static void display(int[] array, int size) {
		for (int i = 0; i < array.length; i++) {
	        System.out.print(array[i] + ",");
        }
	}
	
	public static void main(String[] args) {
	    int[] arrayA = {2,4,56,79,3333};
	    int[] arrayB = {4,534,234234,677777};
	    int[] arrayC = new int[arrayA.length + arrayB.length];
	    merge(arrayA, arrayA.length, arrayB, arrayB.length, arrayC);
	    display(arrayC, 9);
    }
}
































