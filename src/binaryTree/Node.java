package binaryTree;

public class Node {
	int iData;
	double fData;
	Node leftChild;
	Node rightChild;
	
	public Node(int iData, double fData) {
		this.iData = iData;
		this.fData = fData;
	}
	
	public void display() {
		System.out.print("{");
		System.out.print(iData);
		System.out.print(",");
		System.out.print(fData);
		System.out.print("}");
	}
}
