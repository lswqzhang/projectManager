package com.lswq.sorted;

import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapDemo {

    public static void main(String[] args) {
        // creating maps
        TreeMap<Integer, String> treemap = new TreeMap<Integer, String>();


        // populating tree map
        treemap.put(-1, "two");
        treemap.put(1, "one");
        treemap.put(7, "three");
        treemap.put(6, "six");
        treemap.put(5, "five");

        System.out.println("Getting tail map");
        SortedMap<Integer, String> treemapincl = treemap.tailMap(3);
        System.out.println("Tail map values: " + treemapincl);
    }

}
