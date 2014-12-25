/**  
 * @Project: Datastructure
 * @Title: HashTable.java
 * @Package hashTable
 * @Description: TODO
 * @author qsdepth@foxmail.com
 * @date 2014-12-25 下午1:09:58
 * @Copyright: 2014 
 * @version V1.0  
 */

package hashTable;

/**
 * @ClassName HashTable
 * @Description 
 * 	<p>
 * 		线性探测哈希表的Java代码
 * 	</p>
 * @author qsdepth@foxmail.com
 * @date 2014-12-25
 */

public class HashTable {
	
	private DataItem[] hashArray; // array holds hash table
	private int arraySize;
	private DataItem nonItem; // for deleted items
	
	public HashTable(int size) {
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonItem = new DataItem(-1);
	}
	
	public void displayTable() {
		System.out.println("Table: ");
		if (arraySize == 0) {
			System.out.println("hashTable为空");
		} else {
			for (int i = 0; i < arraySize; i++) {
				if (hashArray[i] != null) {
					System.out.print(hashArray[i].getKey() + " ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println("");
		}
	}
	
	/*
	 * hash function
	 */
	public int hashFunc(int key) {
		return key % arraySize;
	}
	
	/*
	 * insert data
	 */
	public void insert(DataItem item) {
		int key = item.getKey();
		int hashVal = hashFunc(key);
		
		while (hashArray[hashVal] != null && hashArray[hashVal].getKey()!= -1) {
			++hashVal; // go to next cell
			hashVal %= arraySize; //wraparound if necessary
		}
		hashArray[hashVal] = item;
	}
	
	/*
	 * delete a DataItem
	 */
	public DataItem delete(int key) {
		
		int hashVal = hashFunc(key);
		while (hashArray[hashVal] != null) {
			if (hashArray[hashVal].getKey() == key) {
				DataItem temp = hashArray[hashVal];
				hashArray[hashVal] = nonItem;
				return temp;
			}
			++hashVal; // go to next cell
			hashVal %= arraySize;
		}
		return null; //can't find item;
	}
	
	/*
	 * find a DataItem
	 */
	public DataItem find(int key) {
		int hashVal = hashFunc(key);
		while (hashArray[hashVal] != null) {
			if (hashArray[hashVal].getKey() != key) {
				++hashVal; // go to next cell
				hashVal %= arraySize; //wrap around if neccessary
			}
			return hashArray[hashVal];
		}
		return null;
	}
	
	public static void main(String[] args) {
		HashTable hash = new HashTable(10);
		DataItem item = new DataItem(20);
		DataItem item1 = new DataItem(3450);
		DataItem item2 = new DataItem(20);
		DataItem item3 = new DataItem(550);
		DataItem item4 = new DataItem(340);
		hash.insert(item);
		hash.insert(item1);
		hash.insert(item2);
		hash.insert(item3);
		hash.insert(item4);
		
		hash.displayTable();
		
		DataItem item6 = new DataItem(20);
		hash.insert(item6);
		
		hash.displayTable();
	}
}




























