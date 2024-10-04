package edu.dsa.custdsa;
import java.util.*;

class TimeStamp {
	HashMap<String, List<String>> valuesDict;
	HashMap<String, List<Integer>> timestampDict;
	public TimeStamp() {
		valuesDict = new HashMap<String, List<String>> ();
		timestampDict = new HashMap<String, List<Integer>> ();
	}

	// Set TimeStamp data variables
	public void setValue(String key, String value, int timestamp) {
		// Check if the given key already exists in the values dictionary.
		if (valuesDict.containsKey(key)) {
			// Check if the given value of the key already exists in the values dictionary.
			if (value != valuesDict.get(key).get(valuesDict.get(key).size() - 1)) {
				// Store values for the given key in the values dictionary.
				valuesDict.get(key).add(value);
				// Store timestamp for the given key in the timestamp dictionary.
				timestampDict.get(key).add(timestamp);
			}
		} else {
			// Store value and key for the given key in the values dictionary.
			valuesDict.put(key, new ArrayList<String> ());
			valuesDict.get(key).add(value);
			timestampDict.put(key, new ArrayList<Integer> ());
			// Store timestamp for the given key in the timestamp dictionary.
			timestampDict.get(key).add(timestamp);
		}
	}

	// Find the index of right most occurrence of the given timestamp using binary search
	public int searchIndex(int n, String key, int timeStamp) {

		int left = 0;
		int right = n;
		int mid = 0;
		while (left<right) {
			// It will return the mid of the current dictionary.
			mid = left + (right - left) / 2;
			// Increase index value if required index is less than the
            // current index otherwise decrease it.
			if (!(timestampDict.get(key).get(mid) > timeStamp)) left = mid + 1;
			else right = mid;
		}
		return left - 1;
	}

	// Get the value for the given key and timestamp
	public String getValue(String key, int timeStamp) {
		int index = 0;
		// Check if the given key is present in the values dictionary.
		if (!valuesDict.containsKey(key)) {
			// Return empty string if item does not exist.
			return "";
		} else {
			// Find the right most occurrence of the given timestamp.
			index = searchIndex(timestampDict.get(key).size(), key, timeStamp) ;
		}
		
		// If the timestamp exist in the timestamp dictionary, return the
        // value with that timestamp.
		if (index > -1) {
			return valuesDict.get(key).get(index);
		}
		// Return empty string if the timestamp does not exist.
		return "";
	}

	// Driver code
	public static void main(String args[]) {
		TimeStamp ts = new TimeStamp();
		int num = 1;
		List<Triplet> input = Arrays.asList(new Triplet("course", "OOP", 3), new Triplet("course", "PF", 5), new Triplet("course", "OS", 7), new Triplet("course", "ALGO", 9), new Triplet("course", "DB", 10));
		for (int i = 0; i<input.size(); i++) {
			System.out.println(num + ".\tAdd value: (" + '"' + input.get(i).course + '"' + ", " + '"' + input.get(i).cName + '"' + ", " + input.get(i).id + ")");
			ts.setValue(input.get(i).course, input.get(i).cName, input.get(i).id);
			int randomInt = (int) Math.floor(Math.random() * (10 - 1 + 1) + 1);
			System.out.println("\n\tGet value for:");
			System.out.println("\t\tKey = course  \n\t\tTimestamp = " + randomInt);
			System.out.println("\n\tReturned value = " + '"' + ts.getValue("course", randomInt) + '"');
			num += 1;
			System.out.println(new String(new char[100]).replace('\0', '-'));
		}
	}
}
