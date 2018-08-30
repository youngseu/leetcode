package DynamicProgramming;

import java.util.List;

//139 problem
//Word Break
//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
//determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//Example 2:
//Input: s = "applepenapple", wordDict = ["apple", "pen"]
//Output: true
//Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
//             Note that you are allowed to reuse a dictionary word.
//Example 3:
//Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//Output: false
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] flags = new boolean[s.length() + 1];
        //dp记录每一位的可达性
        flags[0] = true;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (flags[j] && wordDict.contains(s.substring(j, i))) {
                    flags[i] = true;
                    break;
                }
            }
        }
        return flags[s.length()];
    }
}
