import java.util.LinkedList;
import java.util.Arrays;
import java.lang.Math;
import java.util.ArrayList;

public class Hash {
	public static void main(String[] args) {
		HashTable myHashTable = new HashTable(10);
		myHashTable.add(10);
		myHashTable.add(5);
		myHashTable.add(99);
		myHashTable.add(2);
		myHashTable.add(12);	// Will replace 2 since both have the same hash value
		myHashTable.printHashTable();
	}
}

class HashTable {
	private ArrayList<LinkedList<Integer>> hashTable;

	public HashTable(int size) {
		hashTable = new ArrayList<LinkedList<Integer>>(size);
		for (int i = 0; i < hashTable.size(); i++) {
			hashTable.add(new LinkedList<Integer>());
		}
		System.out.println(hashTable);
	}

	// Create hash value in range 0 to 9
	private int hashFunction(int element) {
		return (int) (Math.pow(element, 2) + 2 * element + 2) % 10;
	}

	public void add(int element) {
		int hash = hashFunction(element);
		LinkedList<Integer> tmp = hashTable.get(hash);
		tmp.add(element);
		hashTable.set(hash, tmp);
		System.out.println(element + " has been added to the hash table");
	}

	private void separateChaining(int element, int hash) {
		
	}

	public void printHashTable() {
		System.out.println(hashTable);
	}
}