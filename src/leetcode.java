import java.util.*;

/**
 * Created by yang on 17-10-16.
 */
public class leetcode {
    // 1 problem
    static class Solution1 {
        // two-pass hash table
        public int[] twoSum1(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                // not the num twice
                if (map.containsKey(complement) && map.get(complement) != i) {
                    return new int[]{i, map.get(complement)};
                }
            }
            throw new IllegalArgumentException("no two sum solution");
        }

        //one-pass hash table
        public int[] twoSum2(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    return new int[]{map.get(complement), i};
                }
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("no two sum solution");
        }
    }

    //2 problem
    //Add Two Numbers

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution2 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode ln = new ListNode(0);
            ListNode curr = ln;
            int flag = 0;
            while (l1 != null || l2 != null) {
                int x = l1 != null ? l1.val : 0;
                int y = l2 != null ? l2.val : 0;
                int sum = x + y + flag;
                flag = sum / 10;
                sum = sum % 10;
                curr.next = new ListNode(sum);
                curr = curr.next;
                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }
            if (flag == 1) curr.next = new ListNode(1);
            return ln.next;

        }
    }

    // 3 problem
    //Longest Substring Without Repeating Characters
    static class Solution3 {
        //brute force
        public int lengthOfLongestSubstring1(String s) {
            int n = s.length();
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    if (allUnique(s, i, j)) {
                        ans = Math.max(ans, j - i);
                    }
                }
            }
            return ans;
        }

        public boolean allUnique(String s, int start, int end) {
            Set<Character> set = new HashSet<>();
            for (int i = start; i < end; i++) {
                Character ch = s.charAt(i);
                if (set.contains(ch)) {
                    return false;
                }
                set.add(ch);
            }
            return true;
        }

        //sliding window
        //[i,j)
        public int lengthOfLongestSubstring2(String s) {
            int n = s.length();
            Set<Character> set = new HashSet<>();
            int ans = 0, i = 0, j = 0;
            while (i < n && j < n) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j++));
                    ans = Math.max(ans, j - i);
                } else {
                    set.remove(s.charAt(i++));
                }
            }
            return ans;
        }

        //sliding windoe optimized
        //[i,j)
        public int lengthOfLongestSubstring3(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int n = s.length(), ans = 0;
            for (int i = 0, j = 0; j < n; j++) {
                if (map.containsKey(s.charAt(j))) {
                    //start next one
                    i = Math.max(map.get(s.charAt(j)) + 1, i);
                }
                ans = Math.max(ans, j - i + 1);
                map.put(s.charAt(j), j);
            }
            return ans;
        }

        //use array as table
        //assuming ascii 128
        public int lengthOfLongestSubstring4(String s) {
            int n = s.length(), ans = 0;
            int[] index = new int[128];//current index of character
            for (int i = 0, j = 0; j < n; j++) {
                i = Math.max(index[s.charAt(j)] + 1, j);
                ans = Math.max(ans, j - i + 1);
                index[s.charAt(j)] = j;
            }
            return ans;
        }
    }

    // 4 problem
    static class Solution4 {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            double mid = 0;
            int array[] = Arrays.copyOf(nums1, nums1.length + nums2.length);
            System.arraycopy(nums2, 0, array, nums1.length, nums2.length);
            Arrays.sort(array);
//            int m = nums1.length, n = nums2.length;
//            while (n>0) nums1[m + n -1] = (nums2[n -1]>nums1[m-1])?nums2[--n]:nums1[--m];
            int total = nums1.length + nums2.length;
            if (total % 2 == 1) {
                mid = array[total / 2];
            } else {
                mid = (double) (array[total / 2 - 1] + array[total / 2]) / 2;
            }
            return mid;
        }
    }

    // 5 problem
    static class Solution5 {
        //Longest Palindromic Substring
        //Brute Force
        public String longestPalindrome1(String str) {
            int start = 0;
            int length = 0;
            int res_s = 0;
            int res_l = 0;
            if (str.length() == 1) return str;
            for (int i = 0; i < str.length(); i++) {
                for (int j = i; j < str.length(); j++) {
                    boolean flag = true;
                    start = i;
                    length = j - i + 1;
                    int s = i, e = j;
                    while (s < e) {
                        if (str.charAt(s++) != str.charAt(e--)) {
                            flag = false;
                        }
                    }
                    if (flag && (s == e || s - e == 1)) {
                        if (length > res_l) {
                            res_s = start;
                            res_l = length;
                        }
                    }
                }
            }
            return String.copyValueOf(str.toCharArray(), res_s, res_l);
        }

        //Dynamic Programming
        public String longestPalindrome2(String str) {
            if (str == null || str.length() == 0) {
                return "";
            }
            int start = 0, end = 0, l = 0;
            int length = str.length();
            boolean[][] a = new boolean[length][length];
            //子问题规模的扩大
            for (int i = 0; i < str.length(); i++) {
                for (int j = 0; j <= i; j++) {
                    if (str.charAt(i) == str.charAt(j) && (i - j <= 2 || a[j + 1][i - 1]))
                        a[j][i] = true;
                    if (a[j][i] && i - j + 1 > l) {
                        l = i - j + 1;
                        start = j;
                        end = i;
                    }
                }
            }
            //sunstring using
            return str.substring(start, end + 1);
        }

        //Expand Around Center
        public String longestPalindrome3(String s) {
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                int len1 = expandAroundCenter(s, i, i);
                int len2 = expandAroundCenter(s, i, i + 1);
                int len = Math.max(len1, len2);
                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        private int expandAroundCenter(String s, int left, int right) {
            int L = left, R = right;
            while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
                L--;
                R++;
            }
            return R - L - 1;
        }
    }

    //problem 6
    //ZigZag Conversion
    //找规律
    static class Solution6 {
        public String convert(String s, int numRows) {
            if (numRows == 1) return s;
            if (s.length() == 1) return s;
            StringBuffer res = new StringBuffer();
            int length = s.length();
            int magic = numRows * 2 - 2;
            for (int i = 0; i < numRows; i++) {
                if (i == 0 || i == numRows - 1) {
                    for (int j = 0; j * magic + i < length; j++) {
                        res.append(s.charAt(j * magic + i));
                    }
                } else {
                    int interval = magic - i * 2;
                    int cursor = i;
                    for (int j = 0; cursor < length; j++) {
                        if (cursor < numRows) {
                            res.append(s.charAt(cursor));
                            cursor += interval;
                        } else if (j % 2 == 1) {
                            res.append(s.charAt(cursor));
                            cursor += magic -interval;
                        } else {
                            res.append(s.charAt(cursor));
                            cursor += interval;
                        }
                    }
                }
            }
            return res.toString();
        }
    }

    public static void main(String[] args) {
        Solution6 s = new Solution6();
        System.out.println(s.convert("AB", 1));
    }
}
