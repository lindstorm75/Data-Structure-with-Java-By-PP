import java.util.Arrays;

public class UnionFind {
	private static Edge[] myEdge = new Edge[10];
	private static Node[] myNode = new Node[8];
	private static Edge[] solution = new Edge[10];

	public static void main(String[] args) {
		// Initialize nodes and edges, sorted order
		myEdge[0] = new Edge(0, 1, 2);
		myEdge[1] = new Edge(3, 2, 2);
		myEdge[2] = new Edge(3, 5, 2);
		myEdge[3] = new Edge(6, 4, 3);
		myEdge[4] = new Edge(7, 5, 3);
		myEdge[5] = new Edge(1, 4, 4);
		myEdge[6] = new Edge(0, 6, 5);
		myEdge[7] = new Edge(4, 7, 6);
		myEdge[8] = new Edge(7, 3, 8);
		myEdge[9] = new Edge(2, 4, 15);
		for (int i = 0; i < myNode.length; i++) {
			myNode[i] = new Node(i);
		}
		int bucketIndex = 0;

		for (int i = 0; i < myEdge.length; i++) {
			if (union(myNode[myEdge[i].getFrom()], myNode[myEdge[i].getTo()])) {
				solution[bucketIndex] = myEdge[i];
				bucketIndex++;
			}
		}

		int totalCost = 0;
		for (Edge edge : solution) {
			if (edge != null) {
				System.out.print(edge.getCost() + ", ");
				totalCost += edge.getCost();
			}
		}

		System.out.println();
		System.out.println("Total Cost: " + totalCost);

		// There should be only 1 root node which is the starting one, 0
		for (Node node : myNode) {
			if (node.hasParent()) {
				System.out.println(node.getParent().getValue() + " -> " + node.getValue());
			}
		}

		// Afrer running Path Compression, all nodes should point to the root node
		pathCompression(myNode);
		for (Node node : myNode) {
			if (node.hasParent()) {
				System.out.println(node.getParent().getValue() + " -> " + node.getValue());
			}
		}
	}

	// Union two nodes into one with greater size
	public static boolean union(Node a, Node b) {
		if (find(a).getGroup() == find(b).getGroup()) return false;
		if (find(a).getSize() >= find(b).getSize()) {
			find(b).setParent(a);
			// System.out.println("Root of " + a.getValue() + ": " + find(a).getGroup() + ", root of " + b.getValue() + ": " + find(b).getGroup());
			// System.out.println("Size of root node:" + find(b).getSize());
		} else {
			find(a).setParent(b);
		}
		find(a).setSize(find(a).getSize() + 1);
		return true;
	}

	// Finds the root of given node
	public static Node find(Node target) {
		Node tmp = target;
		while (tmp.hasParent()) {
			tmp = tmp.getParent();
		}
		return tmp;
	}

	// Makes all nodes to point to the root
	public static void pathCompression(Node[] myNode) {
		Node root = find(myNode[0]);
		System.out.println("Root: " + root.getValue());
		System.out.println("Starting Path Compression:");
		for (Node node : myNode) {
			node.setParent(root);
		}
	}
}

// Edge class represents an edge, user must
// provide from node, to node and edge cost
class Edge {
	private int from, to, cost;

	public Edge(int from, int to, int cost) {
		this.from = from;
		this.to = to;
		this.cost = cost;
	}

	public int getFrom() {
		return this.from;
	}

	public int getTo() {
		return this.to;
	}

	public int getCost() {
		return this.cost;
	}
}

class Node {
	private int value;
	private int group;
	private int size;
	private Node parent;

	public Node(int value) {
		this.value = value;
		this.group = value;
		this.size = 1;
	}

	public int getValue() {
		return this.value;
	}

	public boolean hasParent() {
		return this.parent != null;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Node getParent() {
		return this.parent;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public int getGroup() {
		return this.group;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}
}