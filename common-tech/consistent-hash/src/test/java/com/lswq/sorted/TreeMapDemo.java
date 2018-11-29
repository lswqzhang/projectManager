package com.lswq.sorted;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class TreeMapDemo {

    @Test
    public void treeMapTest() {
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


    @Test
    public void mapTest() {
        // creating maps
        Map<Integer, String> map = new HashMap<>();


        // populating tree map
        for (int i = 0; i < 1001; i++) {
            map.put(i, "two");
        }

        System.err.println(map.size());


        System.out.println("Getting tail map");
    }


    @Test
    public void skipListTest() {
        ConcurrentSkipListMap<Integer, String> skipList = new ConcurrentSkipListMap<>();
        skipList.put(1, "aa");
        skipList.put(2, "bb");
        skipList.put(3, "cc");
        skipList.put(4, "dd");
        skipList.put(5, "ee");
        skipList.put(6, "ff");
        skipList.put(7, "aa");
        skipList.put(8, "bb");
        skipList.put(9, "cc");
        skipList.put(10, "dd");
        skipList.put(11, "ee");
        skipList.put(12, "ff");
        skipList.put(13, "dd");
        skipList.put(14, "ee");
        skipList.put(15, "ff");
        skipList.put(16, "dd");
        skipList.put(17, "ee");
        skipList.put(18, "ff");
        skipList.put(19, "ff");
        ConcurrentNavigableMap<Integer, String> integerStringConcurrentNavigableMap = skipList.tailMap(5);
        Iterator<Integer> iterator = integerStringConcurrentNavigableMap.keySet().iterator();
        while (iterator.hasNext()) {
            System.err.println(iterator.next());
        }
    }

}
