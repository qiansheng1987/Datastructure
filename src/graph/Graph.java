/**  
 * @Project: Datastructure
 * @Title: Graph.java
 * @Package graph
 * @Description: TODO
 * @author qsdepth@foxmail.com
 * @date 2014-12-29 上午9:54:53
 * @Copyright: 2014 
 * @version V1.0  
 */

package graph;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;


/**
 * @ClassName Graph
 * @Description 
 * 	<p>
 * 		如何添加边取决于用邻接矩阵还是用邻接表，假定在顶点1和顶点2之间加一条边
 * 		使用邻接矩阵：adjMat[1][2] = 1; adjMat[2][1] = 1
 * 		使用邻接表： 把1加到3的链表中，然后把3加到1的链表中。
 * 	<p>
 * @author qsdepth@foxmail.com
 * @date 2014-12-29
 */

public class Graph {
	
	private final int MAX_VERTS = 20; //最大顶点数
	private Vertex vertexList[] ; //array of verties
	private int adjMat[][]; //adjacency matrix
	private int nVerts; //current number of vertices
	private StackX theStack;
	private char sortedArray[];
	
	
	public Graph() {
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for (int i = 0; i < MAX_VERTS; i++) {
			for (int j = 0; j < MAX_VERTS; j++) {
				adjMat[i][j] = 0;
			}
		}
		theStack = new StackX(1000);
		sortedArray = new char[MAX_VERTS];
	}
	
	//增加顶点
	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	//增加边
	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
	//增加有向边
	public void addDirectionEdge(int start, int end) {
		adjMat[start][end] = 1;
	}
	
	//拓扑排序
	public void topo() {
		int orig_nVerts = nVerts; //remember how many verts
		while (nVerts > 0) { //while vertices remain
			int currentVertex = noSuccessors();
			if (currentVertex == -1) { //must be a cycle
				System.out.println("Error: Graph has cycless");
				return ;
			}
			//insert vertex label in sorted array(start at end)
			sortedArray[nVerts-1] = vertexList[currentVertex].label; 
			deleteVertex(currentVertex);//delete vertex
		}
		
		System.out.print("Topologically sorted order: ");
		for (int i = 0; i < orig_nVerts; i++) {
			System.out.print(sortedArray[i]);
		}
		System.out.println("");
	}
	
	public void deleteVertex(int delVert) {
		if (delVert != nVerts - 1) { //if not last vertex
			
			for (int j = delVert; j < nVerts-1; j++) { //delete from vertexList
				vertexList[j] = vertexList[j+1];
			}
			
			for (int row = delVert; row < nVerts-1; row++) {
				moveRowUp(row, nVerts);
			}
			
			for (int col = delVert; col < nVerts-1; col++) {
				moveColLeft(col, nVerts-1);
			}
		}
		nVerts--;
	}
	
	public void moveRowUp(int row, int length) {
		for (int col = 0; col < length; col++) {
			adjMat[row][col] = adjMat[row+1][col];
		}
	}
	
	private void moveColLeft(int col, int length) {
		for (int row = 0; row < length; row++) {
			adjMat[row][col] = adjMat[row][col+1];
		}
	}
	
	//判断顶点有没有后继顶点
	public int noSuccessors() {
		boolean isEdge;
		for (int row = 0; row < nVerts; row++) {
			isEdge = false;
			//check edges
			for (int col = 0; col < nVerts; col++) {
				if (adjMat[row][col] > 0) {
					isEdge = true;
					break;
				}
			}
			
			if (!isEdge) { // if no edegs, has no successors
				return row;
			}
		}
		return -1;
	}
	
	public void displayVertex(int v) {
		System.out.println(vertexList[v].label);
	}
	
	/**
	 * 
	* @Title: getAdjUnVisitedVertex 
	* @Description: 找到与某一个顶点邻接的并且没有访问过的顶点
	* @param @param v
	* @param @return     
	* @return int     
	* @throws
	 */
	public int getAdjUnVisitedVertex(int v) {
		for (int i = 0; i < nVerts; i++) {
			if (adjMat[v][i] == 1 && vertexList[i].hasVisited == false) {
				return i;
			}
		}
		return -1;
	}
	
	
	//深度优先遍历
	public void dfs() {
		vertexList[0].hasVisited = true; // begin at vertex 0;
		displayVertex(0);
		theStack.push(0);
		
		while (! theStack.isEmpty()) {
			int v = getAdjUnVisitedVertex(theStack.peak());
			if (v == -1) {
				theStack.pop();
			} else {
				vertexList[v].hasVisited = true;
				displayVertex(v);
				theStack.push(v);
			}
		}
		
		for (int i = 0; i < nVerts; i++) { //reset flag;
			vertexList[i].hasVisited = false;
		}
	}
	
	
	public static void main(String[] args) {
		//图的深度搜索
//		Graph theGraph = new Graph();
//		theGraph.addVertex('A');
//		theGraph.addVertex('B');
//		theGraph.addVertex('C');
//		theGraph.addVertex('D');
//		theGraph.addVertex('E');
//		
//		theGraph.addEdge(0, 1);//AB
//		theGraph.addEdge(1, 2);//BC
//		theGraph.addEdge(0, 3);//AD
//		theGraph.addEdge(3, 4);//DE
//		
//		System.out.print("Visits: ");
//		theGraph.dfs();
//		System.out.println();
		
		//拓扑排序测试
		Graph theGraph = new Graph();
		theGraph.addVertex('A'); //0
		theGraph.addVertex('B'); //1
		theGraph.addVertex('C'); //2
		theGraph.addVertex('D'); //3
		theGraph.addVertex('E'); //4
		theGraph.addVertex('F'); //5
		theGraph.addVertex('G'); //6
		
		theGraph.addDirectionEdge(0, 3); //ad
		theGraph.addDirectionEdge(0, 4); //ae
		theGraph.addDirectionEdge(1, 4); //be
		theGraph.addDirectionEdge(2, 5); //cf
		theGraph.addDirectionEdge(3, 6); // dg
		theGraph.addDirectionEdge(4, 6); //eg
		theGraph.addDirectionEdge(5, 7); //fh
		theGraph.addDirectionEdge(6, 7); //gh
		
		theGraph.topo();
	}
}


























