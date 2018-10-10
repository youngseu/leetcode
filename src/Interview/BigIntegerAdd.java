package Interview;


class Node {
    int value;
    Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node(int value) {
        this.value = value;
    }
}

public class BigIntegerAdd {
    public static Node reverseList(Node head) {
        Node pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static Node addTwo(Node n1, Node n2) {
        Node reverseN1 = reverseList(n1);
        Node reverseN2 = reverseList(n2);
        Node resvereN3 = new Node(0);
        int nextval = 0;
        while (reverseN1.next != null || reverseN2.next != null) {
            int x1 = (n1 == null ? 0 : reverseN1.value);
            int x2 = (n1 == null ? 0 : reverseN2.value);
            resvereN3.next.value = (x1 + x2 + nextval) % 10;
            nextval = (x1 + x2 + nextval) / 10;
            reverseN1 = reverseN1.next;
            reverseN2 = reverseN2.next;
            resvereN3 = resvereN3.next;
        }
        Node resultN = reverseList(resvereN3.next);
        return resultN;
    }

    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
       /* Node n1 = new Node(1, null);
        Node n2 = new Node(1, null);*/
        Node head1 = null, head2 = null;
        Node n1 = null, n2 = null;
        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                n1 = new Node(i + 2);
                n2 = new Node(i + 3);
                head1 = n1;
                head2 = n2;
            } else {
                n1.next = new Node(i + 2);
                n2.next = new Node(i + 3);
                n1 = n1.next;
                n2 = n2.next;
            }


        }
        Node result = addTwo(head1, head2);
        while (result.next != null) {
            System.out.print(result.value);
            result = result.next;
        }


    }

}
