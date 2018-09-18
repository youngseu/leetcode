package Niuke.util;

import java.util.*;

public class HashMapTest {
    public static void main(String[] args) {
//        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> tresMap = new TreeMap<>((o1, o2) -> o1.compareTo(o2));
        tresMap.put("c", 1);
        tresMap.put("b", 2);
        tresMap.put("a", 3);
        System.out.println();
    }
}
