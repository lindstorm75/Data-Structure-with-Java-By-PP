import java.lang.Math;
import java.util.Arrays;

public class HashTableWithOpenAddressing {
	public static void main(String[] args) {

		// Linear Probling
		System.out.println("Linear Probling:");
		HashTableWithLinearProbling myHashTable = new HashTableWithLinearProbling(10);
		myHashTable.add(10);	// 100 + 20 + 2 % 10 = 2
		myHashTable.add(5);		// 25 + 10 + 2 % 10  = 7
		myHashTable.add(2);		// 4 + 4 + 2 				 = 0
		myHashTable.add(12);	// 144 + 24 + 2 % 10 = 0
		myHashTable.add(22);	// 									 = 0
		// Predicted array = [2, 12, 10, 22, 0, 0, 0, 5, 0, 0]
		myHashTable.printHashTable();

		// Quadratic Probling
		System.out.println("Quadratic Probling:");
		HashTableWithQuadraticProbling myHashTable2 = new HashTableWithQuadraticProbling(10);
		myHashTable2.add(10);	// 100 + 20 + 2 % 10 = 2
		myHashTable2.add(5);	// 25 + 10 + 2 % 10  = 7
		myHashTable2.add(2);	// 4 + 4 + 2 				 = 0
		myHashTable2.add(12);	// 144 + 24 + 2 % 10 = 0, shifted to 0 + 1**1 = 1
		myHashTable2.add(22);	// 									 = 0, shuted to 0 + 2**2 = 4, 1 was not avaiable
		// Predicted array = [2, 12, 10, 0, 22, 0, 0, 5, 0, 0]
		myHashTable2.printHashTable();

	}
}

// Hash class with hashtable array, hashFunction
// and a method to print the array out.
class Hash {
	protected int[] hashTable;

	protected int hashFunction(int element) {
		// Create hash range from 0 to 9
		return (int) (Math.pow(element, 2) + 2 * element + 2) % 10;
	}

	public void printHashTable() {
		System.out.println(Arrays.toString(hashTable));
	}
}

class HashTableWithLinearProbling extends Hash {
	public HashTableWithLinearProbling(int size) {
		hashTable = new int[size];
	}

	// Linear Probling
	public void insert(int element) {
		int hash = hashFunction(element);
		while (hashTable[hash] != 0) {
			hash++;
		}

		hashTable[hash] = element;
	}
}

class HashTableWithQuadraticProbling extends Hash {
	public HashTableWithQuadraticProbling(int size) {
		hashTable = new int[size];
	}

	// Quadratic Probling
	public void insert(int element) {
		int hash = hashFunction(element);
		int i = 1;
		while (hashTable[hash] != 0) {
			// Set hash value to the default value
			hash -= Math.pow(i - 1, 2);
			hash += Math.pow(i, 2);
			i++;
		}

		hashTable[hash] = element;
	}
}