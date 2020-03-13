package com.algoexpert.arraysproblems;

import java.util.LinkedList;
import java.util.List;

public class MoveElementsToEnd {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(2);

        moveElementsToEnd(list,2);
    }
    public static List<Integer> moveElementsToEnd(List<Integer> array, int toMove){

        int lIndex =0;
        int rIndex =array.size()-1;

        while(lIndex<array.size() && rIndex>0 && lIndex < rIndex){

            if(array.get(lIndex)==toMove && array.get(rIndex)!= toMove){
               // System.out.println(" peeche bhejo");
                array.set(lIndex, array.get(rIndex));
                array.set(rIndex, toMove);
                lIndex++;
                rIndex--;
            }else if(array.get(lIndex)!=toMove){
               // System.out.println("left moves forward");
                lIndex++;
            }else if(array.get(rIndex)==toMove){
               // System.out.println("right moves backward");
                rIndex--;
            }
            //System.out.println(" lIndex "+lIndex+" rIndex "+rIndex );
        }

       /* for(int x:array){
            System.out.println(" "+x);
        }*/
        return array;
    }
}
