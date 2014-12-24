package binaryTree;

public class Tree {

	private Node root;
	
	public Node find(int key) {
		Node current = root;
		if (key < current.iData) {
			current = current.leftChild;
		} else {
			current = current.rightChild;
		}
		if (current == null) { //not find 
			return null;
		}
		return current;
	}
	
	public void insert(int id, double dd) {
		Node newNode = new Node(id, dd);
		if (root == null) {
			root = newNode;
		} else {
			Node current = root;
			Node parent;
			while (true) {
				parent = current;
				if (id < current.iData) { //go left
					current = current.leftChild;
					if (current == null) { //at the end of line
						parent.leftChild = newNode;
						return ;
					}
				} else { // go right
					current = current.rightChild;
					if (current == null) { //at the end of line
						parent.rightChild = newNode;
					}
				}
			}
		}
		
	}
	
	public void delete(int key) {
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		
		//�ҽ��
		while (current.iData != key) {
			parent = current;
			if (key < current.iData) { //��������
				isLeftChild = true;
				current = current.leftChild;
			} else {
				isLeftChild = false;
				current = current.rightChild;
			}
			if (current == null) { //û�з���
				//return false;
			}
		}
		
		
		if (current.leftChild == null && current.rightChild == null) { //if no children ,simple delete it
			if (current == root) {
				root = null;
			} else if (isLeftChild) {
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			}
		} else if (current.rightChild == null) { //ɾ��ֻ��һ�����ӽ��Ľ�� 
			if (current == root) {
				root = current.leftChild;
			} else if (isLeftChild) {
				parent.leftChild = current.leftChild;
			} else {
				parent.rightChild = current.leftChild;
			}
		} else if (current.leftChild == null) { //ɾ��ֻ��һ���Һ��ӽ��Ľ�� 
			if (current == root) {
				root = current.rightChild;
			} else if (isLeftChild) {
				parent.leftChild = current.rightChild;
			} else {
				parent.rightChild = current.rightChild;
			}
		}
		//ɾ���������ӽڵ�Ľڵ�
		
		
		
	}
	
	//�Һ�̽ڵ㣬�����ز���delNode�ĺ�̽ڵ㣩
	private Node getSucessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild;
		
		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		
		if (successor != delNode.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}
	
	
}





































