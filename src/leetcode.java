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
    static public class ListNode {
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
                            cursor += magic - interval;
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

    //problem 7
    //Reverse Integer
    static class Solution7 {
        //my without consider overflow
        //        public int reverse(int x) {
        //            ArrayList<Integer> array = new ArrayList<Integer>();
        //            while (x / 10 != 0) {
        //                array.add(x % 10);
        //                x = x / 10;
        //            }
        //            array.add(x);
        //            int res = 0;
        //            Iterator<Integer> it = array.iterator();
        //            while (it.hasNext()) {
        //                res = res * 10  + it.next();
        //            }
        //            return res;
        //        }
        public int reverse(int x) {
            int result = 0;

            while (x != 0) {
                int tail = x % 10;
                int newResult = result * 10 + tail;
                if ((newResult - tail) / 10 != result) {
                    return 0;
                }
                result = newResult;
                x = x / 10;
            }

            return result;
        }
    }

    //problem 9
    // Palindrome Number
    static class Solution9 {
        public boolean isPalindrome(int x) {
            if (x < 0) return false;
            boolean flag = false;
            int res = 0;
            int source = x;
            while (x != 0) {
                res = res * 10 + x % 10;
                x = x / 10;
            }
            if (res == source)
                flag = true;
            return flag;
        }
    }

    //problem 13
    //Roman to Integer
    static class Solution13 {
        public int romanToInt(String s) {
            if (s == null || s.length() == 0)
                return -1;
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);
            int length = s.length(), result = map.get(s.charAt(length - 1));
            for (int i = length - 2; i >= 0; i--) {
                if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                    result += map.get(s.charAt(i));
                } else {
                    result -= map.get(s.charAt(i));
                }
            }
            return result;
        }
    }

    //problem 14
    // Longest Common Prefix
    static class Solution14 {
        // #1 (Horizontal scanning)
        public String longestCommonPrefix(String[] strs) {
            if (strs == null) return "";
            String prefix = strs[0];
            for (int i = 1; i < strs.length; i++) {
                while (strs[i].indexOf(prefix) != 0) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                    if (prefix.isEmpty()) return "";
                }
            }
            return prefix;
        }

        // #2 (Vertical scanning)
        public String longestCommonPrefix2(String[] strs) {
            if (strs == null || strs.length == 0) return "";
            for (int i = 0; i < strs[0].length(); i++) {
                char c = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (i == strs[j].length() || strs[j].charAt(i) != c)
                        return strs[0].substring(0, i);
                }
            }
            return strs[0];
        }

        // #3 (Divide and conquer)
        public String longestCommonPrefix3(String[] strs) {
            if (strs == null || strs.length == 0) return "";
            return longestCommonPrefix(strs, 0, strs.length - 1);
        }

        private String longestCommonPrefix(String[] strs, int l, int r) {
            if (l == r) {
                return strs[l];
            } else {
                int mid = (l + r) / 2;
                String lcpLeft = longestCommonPrefix(strs, l, mid);
                String lcpRight = longestCommonPrefix(strs, mid + 1, r);
                return commonPrefix(lcpLeft, lcpRight);
            }
        }

        String commonPrefix(String left, String right) {
            int min = Math.min(left.length(), right.length());
            for (int i = 0; i < min; i++) {
                if (left.charAt(i) != right.charAt(i))
                    return left.substring(0, i);
            }
            return left.substring(0, min);
        }
    }

    //problem 15
    //3 sum
    static class Solution15 {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length == 0) return res;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i - 1 >= 0 && nums[i] == nums[i - 1]) continue; //avoid duplicates
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left + 1 < right && nums[left] == nums[left + 1]) {//avoid duplicates
                            left++;
                        }
                        while (right - 1 > left && nums[right] == nums[right - 1]) {//avoid duplicates
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return res;
        }
    }

    //problem 16
    //3 sum close
    static class Solution16 {
        public int threeSumClosest(int[] nums, int target) {
            int res = nums[0] + nums[1] + nums[nums.length - 1];
            for (int i = 0; i < nums.length - 2; i++) {
                int left = i + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                    if (Math.abs(sum - target) < Math.abs(res - target))
                        res = sum;
                }
            }
            return res;
        }
    }

    //problem 17
    //Letter Combinations of a Phone Number
    static class Solution17 {
        //fifo queue
        public List<String> letterCombinations(String digits) {
            LinkedList<String> ll = new LinkedList<>();
            if (digits.length() == 0) return ll;
            String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            ll.add("");
            for (int i = 0; i < digits.length(); i++) {
                int x = Character.getNumericValue(digits.charAt(i));
                while (ll.peek().length() == i) {
                    String t = ll.remove();
                    for (char s : mapping[x].toCharArray())
                        ll.add(t + s);
                }
            }
            return ll;
        }
    }

    //problem 18
    //4 sum
    static class Solution18 {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums.length == 0) return res;
            for (int i = 0; i < nums.length; i++) {

            }

            return res;
        }
    }

    //problem 19
    //Remove Nth Node From End of List
    //O(N)
    static class Solution19 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode res = head, pren = head, curn = head;
            int cur = 1;
            if (head == null) return head;
            while (head != null) {
                if (cur <= n) {
                    head = head.next;
                    cur++;
                } else if (cur == n + 1) {
                    curn = curn.next;
                    head = head.next;
                    cur++;
                } else {
                    pren = pren.next;
                    curn = curn.next;
                    head = head.next;
                    cur++;
                }
            }
            if (cur - 1 == n) {
                return res.next;
            } else {
                pren.next = curn.next;
            }
            return res;
        }

        //more simple
        public ListNode removeNthFromEnd1(ListNode head, int n) {

            ListNode start = new ListNode(0);
            ListNode slow = start, fast = start;
            slow.next = head;

            //Move fast in front so that the gap between slow and fast becomes n
            for (int i = 1; i <= n + 1; i++) {
                fast = fast.next;
            }
            //Move fast to the end, maintaining the gap
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            //Skip the desired node
            slow.next = slow.next.next;
            return start.next;
        }
    }

    //problem 20
    //Valid Parentheses
    //use stack to validate
    static class Solution20 {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<Character>();
            for (char a : s.toCharArray()) {
                if (a == '{')
                    stack.push('}');
                else if (a == '(')
                    stack.push(')');
                else if (a == '[')
                    stack.push(']');
                else if (stack.isEmpty() || stack.pop() != a)
                    return false;
            }
            return stack.isEmpty();
        }

        //use num map char
        public boolean isValid1(String s) {
            Stack<Integer> p = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                int q = "(){}[]".indexOf(s.substring(i, i + 1));
                if (q % 2 == 1) {
                    if (p.isEmpty() || p.pop() != q - 1) return false;
                } else p.push(q);
            }
            return p.isEmpty();
        }
    }

    //problem 21
    //Merge Two Sorted Lists
    static class Solution21 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(0);
            ListNode curr = head;
            while (l1 != null || l2 != null) {
                if (l1 != null && l2 != null && l1.val < l2.val) {
                    curr.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else if (l1 != null && l2 != null && l1.val > l2.val) {
                    curr.next = new ListNode(l2.val);
                    l2 = l2.next;
                } else if (l1 == null) {
                    curr.next = new ListNode(l2.val);
                    l2 = l2.next;
                } else if (l2 == null) {
                    curr.next = new ListNode(l1.val);
                    l1 = l1.next;
                }
                curr = curr.next;
            }
            return head.next;
        }

        //using recursion
        public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
    }

    //problem 22
    //Generate Parentheses
    static class Solution22 {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<String>();
            generate(res, "", n, n);
            return res;
        }

        public void generate(List<String> res, String s, int left, int right) {
            if (left == 0 && right == 0)
                res.add(s);
            if (left > 0)
                generate(res, s + "(", left - 1, right);
            if (left < right)
                generate(res, s + ")", left, right - 1);
        }
    }

    //problem 23
    //Merge k Sorted Lists
    static class Solution23 {
        //Merge with Divide And Conquer
        public ListNode mergeKLists(ListNode[] lists) {
            return mergeKLists(lists, 0, lists.length - 1);
        }

        public ListNode mergeKLists(ListNode[] lists, int start, int end) {
            if (start == end) return lists[start];
            else if (start < end) {
                int mid = (start + end) / 2;
                ListNode l1 = mergeKLists(lists, start, mid);
                ListNode l2 = mergeKLists(lists, mid + 1, end);
                return merge2Lists(l1, l2);
            } else return null;
        }

        public ListNode merge2Lists(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            if (l1.val < l2.val) {
                l1.next = merge2Lists(l1.next, l2);
                return l1;
            } else {
                l2.next = merge2Lists(l1, l2.next);
                return l2;
            }
        }

        //Optimize Approach 2 by Priority Queue
        //priority queue to find the small num
        public ListNode mergeKLists2(ListNode[] lists) {
            if (lists == null || lists.length == 0) return null;
            PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length,
                    new Comparator<ListNode>() {
                        @Override
                        public int compare(ListNode o1, ListNode o2) {
                            return o1.val - o2.val;
                        }
                    });
            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;
            for (ListNode node : lists)
                if (node != null)
                    queue.add(node);
            while (!queue.isEmpty()) {
                tail.next = queue.poll();
                tail = tail.next;
                if (tail.next != null)
                    queue.add(tail.next);
            }
            return dummy.next;
        }


    }

    //problem 24
    //Swap Nodes in Pairs
    static class Solution24 {
        //recursion
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode n = head.next;
            head.next = swapPairs(head.next.next);
            n.next = head;
            return n;
        }

        //iteration
        public ListNode swapPairs1(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode current = dummy;
            while (current.next != null && current.next.next != null) {
                ListNode first = current.next;
                ListNode second = current.next.next;
                first.next = second.next;
                current.next = second;
                current.next.next = first;
                current = current.next.next;
            }
            return dummy.next;
        }
    }

    //problem 25
    //Reverse Nodes in k-Group
    class Solution25 {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode curr = head;
            int count = 0;
            while (curr != null && count != k) {//find the k+1 node
                curr = curr.next;
                count++;
            }
            if (count == k) {
                curr = reverseKGroup(curr, k);//reverse list with k+1 node as head
                // head - head-pointer to direct part,
                // curr - head-pointer to reversed part;
                while (count-- > 0) {
                    ListNode tmp = head.next;
                    head.next = curr;
                    curr = head;
                    head = tmp;
                }
                head = curr;
            }
            return head;
        }
    }

    //problem 26
    //Remove Duplicates from Sorted Array
    class Solution26 {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) return 0;
            int i = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] != nums[i]) {
                    i++;
                    nums[i] = nums[j];
                }
            }
            return i + 1;
        }
    }

    //problem 28
    //Implement strStr()
    static class Solution28 {
        //需要考虑输入的多种情况,me
        public int strStr(String haystack, String needle) {
            int res = -1;
            if (haystack.length() < needle.length())
                return res;
            if (needle.length() == 0)
                return 0;
            for (int i = 0; i <= haystack.length() - needle.length(); i++) {
                int tmp = i;
                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(tmp) == needle.charAt(j) && j == needle.length() - 1)
                        return i;
                    else if (haystack.charAt(tmp) == needle.charAt(j))
                        tmp++;
                    else
                        break;
                }
            }
            return res;
        }

        //other
        public int strStrRe(String haystack, String needle) {
            for (int i = 0; ; i++) {
                for (int j = 0; ; j++) {
                    if (j == needle.length()) return i;
                    if (i + j == haystack.length()) return -1;
                    if (needle.charAt(j) != haystack.charAt(i + j)) break;
                }
            }
        }
    }

    //problem 30
    //Substring with Concatenation of All Words
    class Solution30 {
        public List<Integer> findSubstring(String s, String[] words) {

        }
    }



    public static void main(String[] args) {
        Solution28 s = new Solution28();
        System.out.println(s.strStr("hello", "ll"));
    }
}
