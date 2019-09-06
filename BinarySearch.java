public class BinarySearch {
    public static void main(String[] args) {
        Node root = new Node(5);
        root.addChild(root, new Node(2));
        root.addChild(root, new Node(8));
        System.out.println(root.getKey());
        System.out.println(root.getLeftChild().getKey());
        System.out.println(root.getRightChild().getKey());
        root.addChild(root, new Node(1));
        System.out.println(root.getLeftChild().getLeftChild().getKey());
        root.addChild(root, new Node(4));
        System.out.println(root.getLeftChild().getRightChild().getKey());
        root.addChild(root, new Node(3));
        System.out.println(root.getLeftChild().getRightChild().getLeftChild().getKey());
        root.addChild(root, new Node(6));
        System.out.println(root.getRightChild().getLeftChild().getKey());
        root.addChild(root, new Node(7));
        System.out.println(root.getRightChild().getLeftChild().getRightChild().getKey());
    }
}

class Node {
    private int key;
    private Node left;
    private Node right;
    public Node(int key) {
        this.key = key;
    }
    void addChild(Node root, Node child) {
        if (child.getKey() >= root.getKey()) {
            if (root.getRightChild() != null)
                root.addChild(root.getRightChild(), child);
            else {
                if (child.getKey() >= root.getKey())
                    root.setRightChild(child);
                else
                    root.setLeftChild(child);
            }
        } else {
            if (root.getLeftChild() != null)
                root.addChild(root.getLeftChild(), child);
            else {
                if (child.getKey() >= root.getKey())
                    root.setRightChild(child);
                else
                    root.setLeftChild(child);
            }
        }
    }
    public int getKey() {
        return this.key;
    }
    public void setLeftChild(Node child) {
        this.left = child;
    }
    public void setRightChild(Node child) {
        this.right = child;
    }
    public Node getLeftChild() {
        return this.left;
    }
    public Node getRightChild() {
        return this.right;
    }
}