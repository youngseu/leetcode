package Niuke.jingdong;

import java.util.*;

//找一个节点，和它不相连的节点都划到一个集合里面，然后验证一下这个集合和剩下的节点之间是否满足要求，如果满足，在
//考虑剩下的节点，先选一个出来，不相连的划分到一个集合中...循环操作直到所有的节点都划分完就可以了
public class MultipartiteGraph {
    public static class Node {
        public int value;
        public ArrayList<Node> nexts;
        public boolean pass;

        public Node(int value) {
            this.value = value;
            nexts = new ArrayList<>();
            pass = false;
        }
    }

    public static void process(Scanner in) {
        int n = in.nextInt();
        int m = in.nextInt();

        HashMap<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i + 1, new Node(i + 1));
        }

        for (int i = 0; i < m; i++) {
            int f = in.nextInt();
            int s = in.nextInt();
            Node nf = map.get(f);
            Node ns = map.get(s);
            nf.nexts.add(ns);
            ns.nexts.add(nf);
        }

        Node n1 = map.get(1);
        map.remove(1);
        List<Node> xl = n1.nexts;
        List<Node> nxl = new ArrayList<>();

        for (Map.Entry<Integer, Node> entry : map.entrySet()) {
            if (!xl.contains(entry.getValue())) {
                nxl.add(entry.getValue());
            }
        }

        boolean pan = false;
        for (Node node : nxl) {
            for (Node node1 : xl) {
                if (!node.nexts.contains(node1)) {
                    pan = true;
                    break;
                }
            }
        }
        if (pan) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            process(in);
        }
    }
}
