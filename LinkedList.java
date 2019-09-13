public class LinkedList {
    public static void main(String[] args) {
        /* Test LinkedList */
        
        // Creation and Insertion
        LinkedListNode myLL = new LinkedListNode(5, null, null);
        LinkedListNode.insert(myLL, new LinkedListNode(6, null, null));
        System.out.println(myLL.getNext());             // null
        System.out.println(myLL.getKey());              // 5
        System.out.println(myLL.getHead().getKey());    // 6
        LinkedListNode myLL2 = new LinkedListNode(2, null, null);
        LinkedListNode.insert(myLL, myLL2);                       // Insert between two nodes
        System.out.println(myLL.getHead().getKey());              // 2
        System.out.println(myLL.getHead().getHead().getKey());    // 6
        System.out.println(myLL.getHead().getNext().getKey());    // 5

        // Searching
        System.out.println(LinkedListNode.search(myLL, 6).getKey());    // Seart for 6 in myLL, LL object
        System.out.println(LinkedListNode.search(myLL, 1));             // Seart for 1 in myLL, null
    }
}

class LinkedListNode {
    private LinkedListNode head;
    private LinkedListNode next;
    private int key;
    public LinkedListNode(int key, LinkedListNode head, LinkedListNode next) {
        this.head = head;
        this.next = next;
        this.key = key;
    }
    public static void insert(LinkedListNode L, LinkedListNode x) {
        if (L.head == null) {
            L.head = x;
            x.next = L;
        } else {
            x.head = L.head;
            x.next = L;
            L.head = x;
        }
    }
    public static LinkedListNode search(LinkedListNode L, int key) {
        LinkedListNode temp = L;
        while (temp != null && temp.getKey() != key) {
            temp = temp.head;
        }
        return temp;
    }
    LinkedListNode getHead() {
        return this.head;
    }
    LinkedListNode getNext() {
        return this.next;
    }
    int getKey() {
        return this.key;
    }
}