package edu.dsa.greedytech;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MinRefulStops {

    public static int minRefuelStops(int target, int startFuel, int[][] stations) {

        if (startFuel >= target) return 0;

        //Create Max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int i = 0, n = stations.length, stops = 0, maxDistance = startFuel;

        //loop until car reaches target
        while (maxDistance < target) {
            // if there are still stations and next one is within range, add its fuel capacity to max heap
            if (i < n && stations[i][0] <= maxDistance) {
                maxHeap.add(stations[i][1]);
                i++;
            }
            //if there are no more stations and we reach the target, return -1
            else if (maxHeap.isEmpty()) {
                return -1;
            }
            // otherwise fill up  at the highest fuel station and increment stops
            else {
                maxDistance += maxHeap.poll();
                stops++;
            }
        }

        return stops;
    }

    public static void main(String[] args) {
        int[] target = {120, 15, 570, 1360};
        int[] startFuel = {10, 3, 140, 380};
        int[][][] stations = {
                            {{10, 60},{20, 25},{30, 30},{60, 40}},
                            {{2, 5},{3, 1},{6, 3},{12,6 }},
                            {{140, 200}, {160, 130}, {310, 200}, {330, 250}},
                            {{310, 160}, {380, 620}, {700, 89}, {850, 190}, {990, 360}}
                            };
        for(int i=0;i<target.length;i++){
            System.out.print(i+1);
            System.out.println(".\tStations: "+Arrays.deepToString(stations[i]));
            System.out.println("\tTarget fuel: "+target[i]);
            System.out.println("\tStart fuel: "+startFuel[i]);
            System.out.println("\tMinimum number of Refueling stops: "+minRefuelStops(target[i], startFuel[i],stations[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }   
    }
    
}
