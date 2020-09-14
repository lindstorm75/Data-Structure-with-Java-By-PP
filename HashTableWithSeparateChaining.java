import java.util.Arrays;
import java.lang.Math;

public class HashTableWithSeparateChaining {
	public static void main(String[] args) {
		HashTable myHashTable = new HashTable(10);
		myHashTable.insert(10);
		myHashTable.insert(5);
		myHashTable.insert(2);
		myHashTable.insert(12);				// Since H(12) = 2, 12 will be chained to 2
		myHashTable.insert(15);				// Chained to
		myHashTable.printHashTable();

		System.out.println("Contains 12: " + myHashTable.contains(12));
		System.out.println("Contains 15: " + myHashTable.contains(15));
		System.out.println("Contains 17: " + myHashTable.contains(17));
	}
}

class MyLinkedList {
	private int value;
	private MyLinkedList next;

	public MyLinkedList(int value) {
		this.value = value;
		this.next = null;
	}

	// Add next linkedlist to the current one
	public void addNext(int element) {
		this.next = new MyLinkedList(element);
	}

	// Check if there's a next linkedlist or not
	public boolean hasNext() {
		return !(this.next == null);
	}

	// Get current linkedlist value
	public int getVal() {
		return this.value;
	}

	// Get the next linkedlist
	public MyLinkedList getNext() {
		return this.next;
	}
}

class HashTable {
	private MyLinkedList[] hashTable;

	public HashTable(int size) {
		hashTable = new MyLinkedList[size];
	}

public void insert(int element) {
	int hash = hashFunction(element);
	if (hashTable[hash] == null) {
		hashTable[hash] = new MyLinkedList(element);
	} else {
		MyLinkedList tmp = hashTable[hash];
		while (tmp.hasNext()) {
			tmp = tmp.getNext();
		}

		tmp.addNext(element);
	}
}

	// Turns any element into hash value in range of 0 to 9
	private int hashFunction(int element) {
		return (int) (Math.pow(element, 2) + 2 * element + 2) % 10;
	}

	// Check whether hash table has given element
	public boolean contains(int element) {
		int hash = hashFunction(element);
		MyLinkedList target = hashTable[hash];
		while (target != null) {
			if (target.getVal() == element) return true;
			target = target.getNext();
		}
		return false;
	}

	// Prints out the hash table
	public void printHashTable() {
		System.out.print("[");
		for (int i = 0; i < hashTable.length; i++) {
			if (hashTable[i] != null) {
				if (i == hashTable.length - 1) {
					System.out.print(hashTable[i].getVal());
					continue;
				}
				System.out.print(hashTable[i].getVal() + ", ");
			} else {
				if (i == hashTable.length - 1) {
					System.out.print("null");
					continue;
				}
				System.out.print("null, ");
			}
		}
		System.out.println("]");
	}
}