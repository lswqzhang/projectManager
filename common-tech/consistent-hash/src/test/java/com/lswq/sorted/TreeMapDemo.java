package com.lswq.sorted;

import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapDemo {

    public static void main(String[] args) {
        // creating maps
        SortedMap<Integer, String> treeMap = new TreeMap<>();


        // populating tree map
        treeMap.put(-1, "two");
        treeMap.put(1, "one");
        treeMap.put(7, "three");
        treeMap.put(6, "six");
        treeMap.put(5, "five");

        System.out.println("Getting tail map");
        SortedMap<Integer, String> treemapincl = treeMap.tailMap(3);
        System.out.println("Tail map values: " + treemapincl);
    }

}
