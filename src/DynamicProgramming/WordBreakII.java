package DynamicProgramming;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//140 problem
//Word Break II
//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
//add spaces in s to construct a sentence where each word is a valid dictionary word. Return all
//such possible sentences.
//Example 1:
//Input:
//s = "catsanddog"
//wordDict = ["cat", "cats", "and", "sand", "dog"]
//Output:
//[
//  "cats and dog",
//  "cat sand dog"
//]
public class WordBreakII {
    //返回s可切割的所有子序列
    List<String> dfs(String s, List<String> wordDict, HashMap<String, LinkedList<String>> map) {
        //memo 存在则直接返回
        if (map.containsKey(s)) return map.get(s);

        LinkedList<String> res = new LinkedList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                //递归得到子序列
                List<String> sublist = dfs(s.substring(word.length()), wordDict, map);
                for (String sub : sublist) {
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        map.put(s, res);
        return res;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<>());
    }
}
