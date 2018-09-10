package Niuke.netease.game;

import java.util.ArrayList;
import java.util.Scanner;

class Duan {
    public int start;
    public int end;
    public boolean flag;

    public Duan(int start, int end, boolean flag) {
        this.start = start;
        this.end = end;
        this.flag = flag;
    }
}

public class fourth {
    public static boolean dfs(ArrayList<Duan> list, int tEnd, int count) {
        if (count == list.size()) return true;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).start == tEnd && !list.get(i).flag) {
                int t = list.get(i).end;
                list.get(i).flag = true;
                if (dfs(list, t, count + 1)) return true;
                list.get(i).flag = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            int length = sc.nextInt();
            ArrayList<Duan> list = new ArrayList<>();
            for (int j = 0; j < length; j++) {
                list.add(new Duan(sc.nextInt(), sc.nextInt(), false));
            }
            boolean flag = false;
            for (int j = 0; j < length; j++) {
                list.get(j).flag = true;
                if (dfs(list, list.get(i).end, 1)) {
                    flag = true;
                    list.get(j).flag = false;
                    break;
                }
                list.get(j).flag = false;
            }
            if (flag) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
