/*
	This program is to demonstrate how to find shortest path
	using Dijstra's algorithm
*/

public class ShortestPath {
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		node1.printNode();
	}
}

// Represent a node with value and its parent
class Node {
	private int value;
	private int parent;
	public Node(int value) {
		this.value = value;
		this.parent = value;
	}
	public void printNode() {
		System.out.println("Node:" + this.value + " Parent:" + this.parent);
	}
}

// Represent an edge with from node, to node and cost
class Edge {
	private int from;
	private int to;
	private double cost;
	public Edge(int from, int to, double cost) {
		this.from = from;
		this.to = to;
		this.cost = cost;
	}
}