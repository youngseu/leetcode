package Niuke.didi.contest;

import java.util.*;

public class third {
    static int sum = 0;

    public static void combination(List<Integer> candidates) {

        List<Integer> mem = new LinkedList<>();
        bchelper(mem, candidates, 0);
    }

    public static void bchelper(List<Integer> mem, List<Integer> candicates, int times) {
        if (times == candicates.size()) {
            if (mem.size() == candicates.size())
                sum++;
            return;
        } else {
            for (int i = 0; i < candicates.size(); i++) {
                //避免重复元素
                int y = candicates.get(i);
                if (i > 0 && candicates.get(i) == candicates.get(i - 1) || candicates.get(i) == 0 || (mem.size() > 0 && mem.get(mem.size() - 1) == candicates.get(i)))
                    continue;
                mem.add(candicates.get(i));
                candicates.set(i, 0);
                //每个元素只用一次
                bchelper(mem, candicates, times + 1);
                mem.remove(mem.size() - 1);
                candicates.set(i, y);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] tmp = str.split(" ");
        List<Integer> candidates = new LinkedList<>();
        for (int i = 0; i < Integer.parseInt(tmp[0]); i++)
            candidates.add(1);
        for (int i = 0; i < Integer.parseInt(tmp[1]); i++)
            candidates.add(2);
        for (int i = 0; i < Integer.parseInt(tmp[2]); i++)
            candidates.add(3);
        combination(candidates);
        System.out.print(sum);
        sum = 0;
    }
}
