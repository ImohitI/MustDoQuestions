package edu.dsa.custdsa;
import java.util.*;

class Pair {
	public int first;
	public int second;

	public Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
}

// We will use a linkedlist of a pair of integers
// where the first integer will be the key
// and the second integer will be the value
class KeyValuePairLL extends LinkedList<Pair> {
};

class LRUCache {
	int cacheCapacity;
	// Our hashmap will store a keys and interators to the LinkedList nodes
	HashMap<Integer, LinkedListNode<Pair>> cacheMap = new HashMap<Integer, LinkedListNode<Pair>>();

	KeyValuePairLL cacheList = new KeyValuePairLL();

	// Constructor that sets the size of the cache
	public LRUCache(int size) {
		this.cacheCapacity = size;
	}

	int get(int key) {
		LinkedListNode<Pair> foundIter;

		// Check if the key exists in the cache hashmap
		if (cacheMap.containsKey(key))
			foundIter = cacheMap.get(key);
		// If the key doesn't exist, we return -1
		else
			return -1;

		LinkedListNode<Pair> listIterator = foundIter;

		// If the key exists, we need to move it to the front of the list
		cacheList.remove(foundIter);
		cacheList.addFirst(listIterator);

		return listIterator.data.second;
	}

	void set(int key, int value) {
		// Check if the key exists in the cache hashmap
		// If the key exists
		if (cacheMap.containsKey(key)) {
			LinkedListNode<Pair> foundIter = cacheMap.get(key);
			LinkedListNode<Pair> listIterator = foundIter;

			// Move the node corresponding to key to front of the list
			cacheList.remove(foundIter);
			cacheList.addFirst(listIterator);

			// We then update the value of the node
			listIterator.data.second = value;
			return;
		}

		// If key does not exist and the cache is full
		if (cacheMap.size() == cacheCapacity) {
			// We will need to evict the LRU entry

			// Get the key of the LRU node
			// The first element of each cache entry is the key
			int keyTmp = cacheList.getLast().data.first;

			// This is why we needed to store a <key, value> pair in the cacheList
			// We would not have been able to get the key if we had just stored the
			// values

			// Remove the last node in list
			cacheList.removeLast();

			// Remove the entry from the cache
			cacheMap.remove(keyTmp);
		}

		// The addFirst function inserts a new element at the front
		// of the list in constant time
		cacheList.insertAtHead(new Pair(key, value));

		// We set the value of the key as the list begining
		// since we added the new element at head of the list
		if (cacheMap.containsKey(key)) {
			cacheMap.replace(key, cacheList.getFirst());
		} else {
			cacheMap.put(key, cacheList.getFirst());
		}
	}

	// Prints the current state of the cache
	void print() {

		System.out.print("Cache current size: " + cacheList.size() + ", ");
		System.out.print("Cache contents: {");
		LinkedListNode<Pair> iter = cacheList.getFirst();
		while (iter != null) {
			Pair pair = iter.data;
			System.out.print("{" + pair.first + ": " + pair.second + "}");
			iter = iter.next;
			if (iter != null)
			{
				System.out.print(", ");
			}
		}
		System.out.print("}\n");
		System.out.println(new String(new char[100]).replace('\0', '-'));
	}

	public static void main(String[] args) {
		// Creating a cache of size 2
		int cacheCapacity = 2;
		LRUCache cache = new LRUCache(cacheCapacity);
		System.out.println("Initial state of cache");
		System.out.println("Cache capacity: " + cacheCapacity);
		cache.print();

		int[] keys = {10, 10, 15, 20, 15, 25, 5};
		String[] values = {"20", "get", "25", "40", "get", "85", "5"};
		for (int i = 0; i < keys.length; i++) {
			if (values[i] == "get") {
				System.out.println("Getting by Key: " + keys[i]);
				System.out.println("Cached value returned: " + (cache.get(keys[i])));
			} else {
				System.out.println("Setting cache: Key: " + keys[i] + ", Value: " + values[i]);
				cache.set(keys[i], Integer.parseInt(values[i]));
			}
			cache.print();
		}
	}
}