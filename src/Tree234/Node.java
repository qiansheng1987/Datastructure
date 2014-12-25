package Tree234;

public class Node {
	
	private static final int ORDER = 4;
	public int numItems; //节点包含的数据项（最多为3个）
	public Node parent;
	public Node childArray[] = new Node[ORDER];
	public DataItem itemArray[] = new DataItem[ORDER-1]; //数据项比子节点树少1
	
	//connect child to this node
	public void connectChild(int childNum, Node child) {
		childArray[childNum] = child;
		if (child != null) {
			child.parent = this;
		}
	}
	
	//disconnect child from this node ,return it
	public Node disconnectChild(int childNum) {
		Node tempNode = childArray[childNum];
		childArray[childNum] = null;
		return tempNode;
	}
	
	public Node getChild(int childNum) {
		return childArray[childNum];
	}
	
	public Node getParent() {
		return parent;
	}
	
	public boolean isLeaf() {
		return ((childArray[0] == null) ? true : false);
	}
	
	public int getNumItems() {
		return numItems;
	}
	
	public DataItem getItem(int index) {
		return itemArray[index];
	}
	
	public boolean isFull() {
		return ((numItems == ORDER-1) ? true : false);
	}
	
	public int findItem(long key) { //return index of
		for (int i = 0; i < ORDER-1; i++) {
			if (itemArray[i] == null) {
				break;
			} else if (itemArray[i].dData == key) {
				return i;
			}
		}
		return -1; //没有找到返回-1
	};
	
	public int insertItem(DataItem newItem) {
		numItems++;
		long newKey = newItem.dData;
		
		for (int i = ORDER-2; i >=0 ; i--) {
			if (itemArray[i] == null) { //if item null go left one cell
				break;
			} else {
				long itsKey = itemArray[i].dData;
				if (newKey < itsKey) { //插入的数据比当前的值小，所有元素向右移动
					itemArray[i+1] = itemArray[i];
				} else {
					itemArray[i+1] = newItem;
					return (i+1);
				}
			}
		}
		
		itemArray[numItems-1] = newItem;
		return 0;
	}
	
	//test
	public static void main(String[] args) {
		DataItem item = new DataItem((long)50);
		DataItem item1 = new DataItem((long)52);
		Node node = new Node();
		node.insertItem(item1);
		node.insertItem(item);
		//node.displayNode();
		
		node.removeItem();
		node.displayNode();
		node.removeItem();
		node.displayNode();
	}
	
	//remove largest item
	public DataItem removeItem() {
		DataItem temp = itemArray[numItems-1];
		itemArray[numItems-1] = null;
		numItems--;
		return temp;
	}
	
	public void displayNode() { //format "/24/56/78"
		for (int i = 0; i < numItems; i++) {
			itemArray[i].displayItem();
			System.out.println("");
		}
	}
	
	
}










































