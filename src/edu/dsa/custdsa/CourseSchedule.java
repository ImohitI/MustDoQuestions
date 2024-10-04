package edu.dsa.custdsa;

import java.util.*;
import java.util.LinkedList;

class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int counter = 0;
        if (numCourses <= 0)
          return false;

        // Initialize the graph
        // count of incoming prerequisites
        HashMap<Integer, Integer> inDegree = new HashMap<>(); 
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<Integer>());
        }

        // b. Build the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0], child = prerequisites[i][1];
            graph.get(parent).add(child); // put the child into it's parent's list
            inDegree.put(child, inDegree.get(child) + 1); // increment child's inDegree
        }

        // c. Find all sources i.e., all vertices with 0 in-degrees
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0)
                sources.add(entry.getKey());
        }

        // d. For each source, increment the counter and subtract one from
        //  all of its children's in-degrees
        // if a child's in-degree becomes zero, add it to the sources queue
        while (!sources.isEmpty()) {
            int vertex = sources.poll();
            counter++;
            // get the node's children to decrement their in-degrees
            List<Integer> children = graph.get(vertex); 
            for (int child : children) {
              inDegree.put(child, inDegree.get(child) - 1);
              if (inDegree.get(child) == 0)
                sources.add(child);
            }
        }

        // topological sort is not possible if the counter is not equal to numCourses
        return counter == numCourses;
    }
    // Driver code
    public static void main(String[] args) {

        int[][][] prereq = {
                  {{1, 0}, {2, 1}},
                  {{1, 0}, {0, 1}},
                  {{1, 0}, {2, 1}, {3, 2}, {4, 3}},
                  {{1, 0}, {2, 1}, {3, 2}, {4, 3}, {0, 4}},
                  {{2, 0}, {2, 1}, {3, 2}, {4, 2}, {3, 1}}
        };
        int[] courses = {3, 2, 10, 5, 5};

        for(int i=0;i<courses.length;i++){
            System.out.println((i + 1)+ ".\tNumber of courses: "+ courses[i]);
            System.out.println("\tNumber of pre-requisites: "+ Arrays.deepToString(prereq[i]));
            System.out.println("\tOutput: "+ canFinish(courses[i], prereq[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
      }
}