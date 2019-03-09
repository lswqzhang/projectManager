package com.lswq.sorted;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class TreeMapDemo {

    @Test
    public void treeMapTest() {
        // creating maps
        SortedMap<Integer, String> treeMap = new TreeMap<>((o1, o2) -> {
            if (null == o2) {
                return -1;
            }
            return o2.compareTo(o1);
        });


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

    @Test
    public void treeMapKeyObj() {
        SortedMap<TreeMapKey, String> treeMap = new TreeMap<>();
        treeMap.put(new TreeMapKey(), "First");
        treeMap.firstKey();
    }

    @Test
    public void listLambda() {
        List<Integer> list = new ArrayList();
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(6);
        list.add(3);

        list.stream().distinct().sorted(Comparator.comparing(Integer::intValue).reversed()).forEach((i) -> System.out.println(i));
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


    @Test
    public void sortStackByStack() {
        
        Stack<Integer> stackData = new Stack<>();
        stackData.push(3);
        stackData.push(7);
        stackData.push(1);
        stackData.push(4);
        stackData.push(8);
        sortStackByAnother(stackData);
        stackData.stream().forEach(System.out::println);
    }

    public void sortStackByAnother(Stack<Integer> stack){
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()){
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek()<cur){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()){
            stack.push(help.pop());
        }
    }

}
