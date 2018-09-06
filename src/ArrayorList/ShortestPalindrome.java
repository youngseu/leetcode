package ArrayorList;

//214 problem
//Shortest Palindrome
//Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it. Find
//and return the shortest palindrome you can find by performing this transformation.
//Example 1:
//Input: "aacecaaa"
//Output: "aaacecaaa"
//Example 2:
//Input: "abcd"
//Output: "dcbabcd"
public class ShortestPalindrome {
    //brute force O(n^2)
    public String shortestPalindrome(String s) {
        int length = s.length();
        String revese = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < length; i++) {
            if (s.substring(0,length-1)==revese.substring(i))
                return revese.substring(0, i) + s;
        }
        return "";
    }
}
