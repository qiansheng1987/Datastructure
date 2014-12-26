/**  
 * @Project: Datastructure
 * @Title: LinkHashTable.java
 * @Package hashTable
 * @Description: TODO
 * @author qsdepth@foxmail.com
 * @date 2014-12-25 ÏÂÎç4:22:13
 * @Copyright: 2014 
 * @version V1.0  
 */

package hashTable;

/**
 * @ClassName LinkHashTable
 * @Description 
 * 	<p>
 * 		Á´µØÖ··¨
 * 	</p>
 * @author qsdepth@foxmail.com
 * @date   2014-12-25
 */

public class LinkHashTable {
	private SortedList[] hashArray;
	private int arraySize;
	
	public LinkHashTable(int size) {
		arraySize = size;
		hashArray = new SortedList[arraySize];
		for (int i = 0; i < arraySize; i++) {
			hashArray[i] = new SortedList();
		}
	}
	
	public void displayTable() {
		for (int i = 0; i < arraySize; i++) {
			hashArray[i].displayList();
		}
	}
	
	public int hashFunc(int key) {
		return key % arraySize;
	}
	
	public void insert(Link theLink) {
		int key = theLink.getKey();
		int hashVal = hashFunc(key);
		hashArray[hashVal].insert(theLink);
	}
	
	public void delete(int key) {
		int hashVal = hashFunc(key);
		hashArray[hashVal].delete(key);
	}
	
	public Link find(int key) {
		int hashVal = hashFunc(key);
		Link theLink = hashArray[hashVal].find(key);
		return theLink;
	}
	
}































