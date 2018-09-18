package Niuke.util;

import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<Double> treeSet = new TreeSet<>();
        treeSet.add(1.11);
        treeSet.add(2.22);
        treeSet.add(3.33);
        System.out.println(treeSet.contains(1.110));
    }
}
