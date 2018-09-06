package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

//118 problem
//Pascal's Triangle
//Given a non-negative integer numRows, generate the firstExtended numRows of Pascal's triangle.
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;

        res.add(new ArrayList<>());
        res.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = res.get(i - 1);
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(preRow.get(j - 1) + preRow.get(j));
            }
            row.add(1);
            res.add(row);
        }
        return res;
    }
}
