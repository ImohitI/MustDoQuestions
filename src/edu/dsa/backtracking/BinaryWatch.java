package edu.dsa.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryWatch {

    // Recursive function to generate possible times on the binary watch
    private static void binaryWatchRec(int position, int hours, int minutes, int enabled, List<String> result) {
        // Base case: If no more LEDs can be turned on
        if (enabled == 0) {
            // Check if the current hours and minutes are valid
            if (hours <= 11 && minutes <= 59) {
                // Format the time and add it to result array
                String time = hours + ":" + (minutes < 10 ? "0" : "") + minutes;
                result.add(time);
            }
            // End the recursion
            return;
        }

        // Loop through all the positions from current position to 9
        for (int i = position; i < 10; i++) {
            // Store the current values of hours and minutes to restore after recursion
            int h = hours;
            int m = minutes;

            // For positions 0 to 3 (bits for hours), add the corresponding power of 2 to hours
            if (i <= 3)
                hours += (int) Math.pow(2, i);
            // For positions 4 to 9, we turn on the corresponding bit for minutes (i-4 to map to 0-5 range)
            else
                minutes += (int) Math.pow(2, i - 4);

            // Recursive call to turn on the next LED at position i + 1
            // Consequently, we reduce the number of enabled LEDs by 1
            binaryWatchRec(i + 1, hours, minutes, enabled - 1, result);

            // Backtrack: Restore hours and minutes to previous values
            hours = h;
            minutes = m;
        }
    }

    public static List<String> readBinaryWatch(int enabled) {
        // Result array to store all possible times
        List<String> result = new ArrayList<>();

        // Start the recursion with 0 hours, 0 minutes, and the specified enabled LEDs
        binaryWatchRec(0, 0, 0, enabled, result);

        return result;
    }    

    public static void main(String[] args) {
        int[] inputs = {1, 2, 0, 3, 10};

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tenabled: " + inputs[i] + "\n");
            List<String> result = readBinaryWatch(inputs[i]);
            System.out.print("\tPossible times: [");
            for (int j = 0; j < result.size(); j++) {
                System.out.print("\"" + result.get(j) + "\"");
                if (j < result.size() - 1)
                    System.out.print(", ");
            }
            System.out.println("]");
            System.out.println(String.join("", Collections.nCopies(100, "-")));
        }
    }   
    
    public List<String> readBinaryWatch2(int num) {
        ArrayList<String> results = new ArrayList<>();

        for (int hour = 0; hour < 12; hour++) {
            for (int minute=0; minute<60; minute++) {
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == num) {
                    if (minute < 10) {
                        results.add(String.format("%d:0%d", hour, minute));
                    } else {
                    results.add(String.format("%d:%d", hour, minute));
                    }
                }
            }
        }
        return results;
    }
}
