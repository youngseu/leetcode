package ArrayorList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//890 problem
//Find and Replace Pattern
//You have a list of words and a pattern, and you want to know which words in words matches the pattern.
//A word matches the pattern if there exists a permutation of letters p so that after replacing every
//letter x in the pattern with p(x), we get the desired word.
//(Recall that a permutation of letters is a bijection from letters to letters: every letter maps to
//another letter, and no two letters map to the same letter.)
//Return a list of the words in words that match the given pattern.
//You may return the answer in any order.
//Example 1:
//Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
//Output: ["mee","aqq"]
//双map分别处理以下两种情况
//(word, pattern) = ("aa", "xy")和(word, pattern) = ("ab", "xx")
public class FindandReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (match(word, pattern)) res.add(word);
        }
        return res;
    }

    public boolean match(String word, String pattern) {
        HashMap<Character, Character> w2p = new HashMap<>();
        HashMap<Character, Character> p2w = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (!w2p.containsKey(w)) w2p.put(w, p);
            if (!p2w.containsKey(p)) p2w.put(p, w);
            if (w2p.get(w) != p || p2w.get(p) != w) return false;
        }
        return true;
    }
}
