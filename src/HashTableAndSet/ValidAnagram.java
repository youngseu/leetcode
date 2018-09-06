package HashTableAndSet;

import java.util.Arrays;

//242 problem
//Valid Anagram
//Given two strings s and t , write a function to determine if t is an anagram of s.
//Example 1:
//Input: s = "anagram", t = "nagaram"
//Output: true
//Example 2:
//Input: s = "rat", t = "car"
//Output: false
public class ValidAnagram {
    //sort
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    //hashtable
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i : count) {
            if (i != 0) return false;
        }
        return true;
    }
}
