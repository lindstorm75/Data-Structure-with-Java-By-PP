public class BinarySearchTree {
    public static void main(String[] args) {
        BSTNode root = new BSTNode(5);
        BSTNode.addChild(root, new BSTNode(2));
        BSTNode.addChild(root, new BSTNode(8));
        // System.out.println(root.getKey());
        // System.out.println(root.getLeftChild().getKey());
        // System.out.println(root.getRightChild().getKey());
        BSTNode.addChild(root, new BSTNode(1));
        // System.out.println(root.getLeftChild().getLeftChild().getKey());
        BSTNode.addChild(root, new BSTNode(4));
        // System.out.println(root.getLeftChild().getRightChild().getKey());
        BSTNode.addChild(root, new BSTNode(3));
        // System.out.println(root.getLeftChild().getRightChild().getLeftChild().getKey());
        BSTNode.addChild(root, new BSTNode(6));
        // System.out.println(root.getRightChild().getLeftChild().getKey());
        BSTNode.addChild(root, new BSTNode(7));
        // System.out.println(root.getRightChild().getLeftChild().getRightChild().getKey());

        // Print all of the node's keys
        BSTNode.inorder(root);              // Node's keys from minimum to maximum

        // Minimum
        // System.out.println(BSTNode.minimum(root));    // 1

        // Maximum
        // System.out.println(BSTNode.maximum(root));    // 8
    }
}

class BSTNode {
    private int key;
    private BSTNode left;
    private BSTNode right;
    public BSTNode(int key) {
        this.key = key;
    }
    public static void addChild(BSTNode root, BSTNode child) {
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
    public static void inorder(BSTNode root) {
        if (root != null) {
            inorder(root.getLeftChild());
            System.out.println(root.getKey());
            inorder(root.getRightChild());
        }
    }
    public static int minimum(BSTNode root) {
        while (root.getLeftChild() != null) {
            root = root.getLeftChild();
        }
        return root.getKey();
    }
    public static int maximum(BSTNode root) {
        while (root.getRightChild() != null) {
            root = root.getRightChild();
        }
        return root.getKey();
    }
    public int getKey() {
        return this.key;
    }
    public void setLeftChild(BSTNode child) {
        this.left = child;
    }
    public void setRightChild(BSTNode child) {
        this.right = child;
    }
    public BSTNode getLeftChild() {
        return this.left;
    }
    public BSTNode getRightChild() {
        return this.right;
    }
}
