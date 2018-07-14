package Math;

import java.util.ArrayList;
import java.util.List;

//60 problem
//Permutation Sequence
//The set [1,2,3,...,n] contains a total of n! unique permutations.
//By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
//"123"
//"132"
//"213"
//"231"
//"312"
//"321"
//Given n and k, return the kth permutation sequence.
//Given n will be between 1 and 9 inclusive.
//Given k will be between 1 and n! inclusive.
//Input: n = 3, k = 3
//Output: "213"
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        k--;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);

        int factorial = 1;
        for (int i = 2; i < n; i++) factorial *= i;

        StringBuilder res = new StringBuilder();
        int times = n - 1;
        while (times >= 0) {
            int indexInList = k / factorial;
            res.append(list.get(indexInList));
            list.remove(indexInList);

            k = k % factorial;
            if (times != 0)
                factorial /= times;
            times--;
        }

        return res.toString();
    }
}
