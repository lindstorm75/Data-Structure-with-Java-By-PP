class MyQueue {
    private int size;
    private int firstPointer, secondPointer;
    private int[] arr;
    MyQueue(int size) {
        this.size = size;
        this.firstPointer = 0;
        this.secondPointer = -1;
        this.arr = new int[this.size];
    }
    void enqueue(int data) {
        if (this.size - 1 == this.secondPointer) {
            System.err.println("The queue is full");
            return;
        }
        this.arr[++this.secondPointer] = data;
    }
    int dequeue() {
        if (this.secondPointer != - 1) {
            this.firstPointer++;
        }
        return this.arr[this.firstPointer];
    }
    int peek() {
        return this.arr[0];
    }
    boolean isEmpty() {
        return this.secondPointer == -1;
    }
    boolean isFull() {
        return this.size - 1 == this.secondPointer;
    }
    int size() {
        return this.size;
    }
    void undo() {
        if (this.secondPointer != -1) {
            this.firstPointer--;
        }
    }
}

public class Queue {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(5);
        myQueue.enqueue(1);                     // Insert data using enqueue()
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        System.out.println(myQueue.size());     // 5
        System.out.println(myQueue.peek());     // First one, 1
        System.out.println(myQueue.dequeue());  // Get and delete, 1
        System.out.println(myQueue.peek());     // 2
        myQueue.undo();                         // firstPointer moves backward once
        System.out.println(myQueue.peek());     // 1
        myQueue.enqueue(5);                     // Works just fine
        myQueue.enqueue(6);                     // "The queue is full"
        System.out.println(myQueue.isEmpty());  // false
        System.out.println(myQueue.isFull());   // true
        System.out.println(myQueue.dequeue());  // 2
        System.out.println(myQueue.dequeue());  // 3
        System.out.println(myQueue.dequeue());  // 4
    }
}