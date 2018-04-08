package DivideAndConquer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//241 problem
//Different Ways to Add Parentheses
//Given a string of numbers and operators, return all possible results from computing all the different possible ways
//to group numbers and operators. The valid operators are +, - and *.
//Example 2
//Input: "2*3-4*5"
//
//(2*(3-(4*5))) = -34
//((2*3)-(4*5)) = -14
//((2*(3-4))*5) = -10
//(2*((3-4)*5)) = -10
//(((2*3)-4)*5) = 10
//Output: [-34, -14, -10, -10, 10]
public class DifferentWaystoAddParentheses {
    Map<String, List<Integer>> map;

    public List<Integer> diffWaysToCompute(String input) {
        map = new HashMap<>();
        return helper(input, 0, input.length());

    }

    private List<Integer> helper(String input, int start, int end) {
        String expression = input.substring(start, end);
        if (map.containsKey(expression)) {
            return map.get(expression);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = start; i < end; i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = helper(input, start, i);
                List<Integer> right = helper(input, i + 1, end);
                for (Integer l : left) {
                    for (Integer r : right) {
                        if (c == '+') {
                            res.add(l + r);
                        } else if (c == '-') {
                            res.add(l - r);
                        } else {
                            res.add(l * r);
                        }

                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.parseInt(input.substring(start, end)));
        }
        map.put(expression, res);
        return res;
    }
}
