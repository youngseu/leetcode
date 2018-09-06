package Niuke.util;

import java.util.TreeSet;

//floor(E e) 方法返回在这个集合中小于或者等于给定元素的最大元素，如果不存在这样的元素,返回null.
//ceiling(E e) 方法返回在这个集合中大于或者等于给定元素的最小元素，如果不存在这样的元素,返回null.
//参数：
//e这是要匹配的值。
//异常：
//NullPointerException--如果指定的元素为null，并且此set使用自然顺序，或者其比较器不允许使用null元素，抛出此异常。
//ClassCastException--如果指定元素不能与元素相比，当前存在于一组抛出此异常。
public class TreeSetDemo {
    public static void main(String[] args) {
        // creating a TreeSet
        TreeSet<Integer> treeadd = new TreeSet<Integer>();

        // adding in the tree set
        treeadd.add(12);
        treeadd.add(11);
        treeadd.add(16);
        treeadd.add(15);

        // getting the floor value for 13
        System.out.println("Floor value for 13: " + treeadd.floor(13));
        System.out.println("Ceiling value for 13: " + treeadd.ceiling(13));
    }
}