package Tree234;

public class Tree234 {
	
	private Node root = new Node();
	
	public int find(long key) {
		Node curNode = root;
		int childNumber;
		
		while (true) {
			if ((childNumber = curNode.findItem(key)) != -1) { //find it
				return childNumber;
			} else if (curNode.isLeaf()) { //can't find it
				return -1;
			} else { //search deeper
				curNode = getNextChild(curNode, key);
			}
		}
	}
	
	//insert a DataItem
	public void insert(long dValue) {
		Node curNode = root;
		DataItem tempItem = new DataItem(dValue);
		
		while (true) {
			if (curNode.isFull()) { //if node full
				split(curNode); //split it
				curNode = curNode.getParent(); // back up 
				curNode = getNextChild(curNode, dValue); //search once
			} else if (curNode.isLeaf()) { // if node is leaf 
				break;
			} else { // node is not full, not a leaf , so go to lower level
				curNode = getNextChild(curNode, dValue);
			}
		}
		
		curNode.insertItem(tempItem);// insert new DataItem
	}
	
	public void split(Node thisNode) {
		//assumes node is full
		DataItem itemB,itemC;
		Node parent, child2, child3;
		int itemIndex;
		
		itemC = thisNode.removeItem();//remove items from this node
		itemB = thisNode.removeItem();
		child2 = thisNode.disconnectChild(2);// remove children from this node
		child3 = thisNode.disconnectChild(3);
		Node newRight = new Node(); //make new node
		
		if (thisNode == root) { //if this is the root
			root = new Node();
			parent = root; //root is our parent
			root.connectChild(0, thisNode);
		} else { // this node is not the root
			parent = thisNode.getParent(); //get parent;
		}
		
		//deal with parent
		itemIndex = parent.insertItem(itemB);// item B to parent
		int n = parent.getNumItems(); //total items?
		
		//move parent's connections on child to the right
		for (int j = n-1; j < itemIndex; j--) { 
			Node temp = parent.disconnectChild(j);
			parent.connectChild(j+1, temp);
		}
		
		parent.connectChild(itemIndex+1, newRight); //connect newRigth to parent
		
		//deal with newRight
		newRight.insertItem(itemC); // itemC to newRight
		newRight.connectChild(0, child2);
		newRight.connectChild(1, child3);
	}
	
	public void displayTree() {
		recDisplayTree(root, 0, 0);
	}
	
	private void recDisplayTree(Node thisNode, int level, int childNumber) {
		System.out.print("level=" + level + " child=" + childNumber + " ");
		thisNode.displayNode();
		
		int numItems = thisNode.getNumItems();
		for (int i = 0; i < numItems+1; i++) {
			Node nextNode = thisNode.getChild(i);
			if (nextNode != null) {
				recDisplayTree(nextNode, level+1, i+1);
			} else {
				return ;
			}
		}
	}
	
	
	public Node getNextChild(Node theNode, long theValue) {
		int j;
		//assumes node is not empty, not full, not a leaf;
		int numItems = theNode.getNumItems();
		for (j = 0; j < numItems; j++) { // for each item in node  are we less?
			if (theValue < theNode.getItem(j).dData) {
				return theNode.getChild(j); //return left child
			}
		}
		return theNode.getChild(j); // we're greater , so return right child
	}
	
	public static void main(String[] args) {
		Tree234 theTree = new Tree234();
		theTree.insert((long)50);
		theTree.insert((long)40);
		theTree.insert((long)60);
		theTree.insert((long)30);
		theTree.insert((long)70);
		
		theTree.displayTree();
	}
}






































