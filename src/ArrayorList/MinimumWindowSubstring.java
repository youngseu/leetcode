package ArrayorList;

import java.util.HashMap;
import java.util.Map;

//76 problem
//Minimum Window Substring
//Given a string S and a string T, find the minimum window in S which will contain all the characters
//in T in complexity O(n).
//Example:
//Input: S = "ADOBECODEBANC", T = "ABC"
//Output: "BANC"
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        // Dictionary which keeps a count of all the unique characters in t
        Map<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count = dict.getOrDefault(t.charAt(i), 0);
            dict.put(t.charAt(i), count + 1);
        }

        // Number of unique characters in t, which need to be present in the desired window.
        int require = dict.size();
        int l = 0, r = 0;

        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency.
        // e.g. if t is "AABC" then the window must have two A's, one B and one C.
        // Thus formed would be = 3 when all these conditions are met.
        int formed = 0;

        // Dictionary which keeps a count of all the unique characters in the current window.
        Map<Character, Integer> windowCounts = new HashMap<>();

        int[] ans = {-1, 0, 0};

        while (r < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            // If the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1.
            if (dict.containsKey(c) && windowCounts.get(c).intValue() == dict.get(c).intValue())
                formed++;

            while (l <= r && formed == require) {
                c = s.charAt(l);
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dict.containsKey(c) && windowCounts.get(c).intValue() < dict.get(c).intValue())
                    formed--;
                l++;
            }
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
