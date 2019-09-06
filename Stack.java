class MyStack {
    private int size;
    private int pointer;
    private int[] arr;
    MyStack(int size) {
        this.size = size;
        this.pointer = -1;
        arr = new int[this.size];
    }
    void push(int data) {
        if (this.size - 1 == this.pointer) {
            System.err.println("The stack is full");
            return; 
        }
        this.arr[++this.pointer] = data;
    }
    int size() {
        return this.size;
    }
    int peek() {
        return this.arr[this.pointer];
    }
    int pop() {
        return this.arr[this.pointer--];
    }
    boolean isEmpty() {
        return this.pointer == -1;
    }
    boolean isFull() {
        return (this.size - 1) == this.pointer;
    }
    void undo() {
        if (this.pointer != - 1) {
            this.pointer++;
        }
    }
}

public class Stack {
    public static void main(String[] args) {
        MyStack myStack = new MyStack(6);
        myStack.push(1);                        // Insert data using push()
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        System.out.println(myStack.size());     // 6
        System.out.println(myStack.isEmpty());  // false
        System.out.println(myStack.isFull());   // false
        System.out.println(myStack.peek());     // 5
        System.out.println(myStack.pop());      // Get last element, the pointer moves back, 5
        System.out.println(myStack.pop());      // 4
        myStack.push(6);
        myStack.push(7);
        System.out.println(myStack.isFull());   // true
        System.out.println(myStack.peek());     // 7
        myStack.push(8);                        // "The stack is full
        System.out.println(myStack.pop());      // 7
        System.out.println(myStack.peek());     // 6
        myStack.undo();                         // The pointer moves forward once
        System.out.println(myStack.peek());     // 7
    }
}