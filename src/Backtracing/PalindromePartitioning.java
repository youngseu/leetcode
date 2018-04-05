package Backtracing;

import java.util.ArrayList;
import java.util.List;

//131 problem
//Palindrome Partitioning
//Given a string s, partition s such that every substring of the partition is a palindrome.
//
//Return all possible palindrome partitioning of s.
//
//For example, given s = "aab",
//Return
//[
//  ["aa","b"],
//  ["a","a","b"]
//]
public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtracing(res, new ArrayList<>(), s);
        return res;
    }

    public static void backtracing(List<List<String>> res, List<String> list, String s) {
        if (s.length() == 0) res.add(new ArrayList<>(list));
        for (int i = 0; i < s.length(); i++) {
            if (isValid(s.substring(0, i + 1))) {
                list.add(s.substring(0, i + 1));
                backtracing(res, list, s.substring(i + 1));
                list.remove(list.size() - 1);
            }
        }
    }

    public static boolean isValid(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r)
            if(s.charAt(l++) != s.charAt(r--)) return false;
        return true;
    }

    public static void main(String[] args) {
        partition("aab");
    }
}
