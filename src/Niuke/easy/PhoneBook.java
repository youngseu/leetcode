package Niuke.easy;

import java.util.Scanner;
//电话簿
//题目描述
//继MIUI8推出手机分身功能之后，MIUI9计划推出一个电话号码分身的功能：首先将电话号码中的每个数字加上8取个
//位，然后使用对应的大写字母代替 （"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN",
//"EIGHT", "NINE"）， 然后随机打乱这些字母，所生成的字符串即为电话号码对应的分身。
//输入描述:
//第一行是一个整数T（1 ≤ T ≤ 100)表示测试样例数；接下来T行，每行给定一个分身后的电话号码的分身（长度
//在3到10000之间）。
//输出描述:
//输出T行，分别对应输入中每行字符串对应的分身前的最小电话号码（允许前导0）。
//示例1
//输入
//4
//EIGHT
//ZEROTWOONE
//OHWETENRTEO
//OHEWTIEGTHENRTEO
//输出
//0
//234
//345
//0345
public class PhoneBook {
    //要先依次解码具有独一无二字符的数字，具有这样特点的数字有五个分别是FOUR(U),SIX(X),
    //TWO(W),EIGHT(G),ZERO(Z),可以根据独特字符的个数直接判断有多少个相应的数字，例如有
    //3个U那么就一定有3个FOUR...,解码完成这五个数字之后另外的数字也会由于这些数字的移除
    //而具有了独一无二的字符，这样的数字有FIVE(F)，THREE(T),FIVE找到之后，只有SEVEN含
    //有V,所以又可以依据V字符的个数解码SEVEN的个数，最后剩下的ONE和NINE也具有了自己的
    //标志性字符分别是ONE(O),NINE(I)，需要注意的是原始数字和最终出现的数字还有一个转换
    //的过程（加8取个位数），所以还要相应转换回去。最后要注意的是，要求每行字符串对应的
    //分身前的最小电话号码，不要傻傻的按照字典序排序，这样时间复杂度过高，对于这个问题
    //可以用桶排序，10个bucket分别用于统计0-9出现的次数，最终桶中存储的结果依次输出就是
    //所有组合中最小的数字
    public static void handle(String str) {
        str = str.toLowerCase();
        int[] hash = new int[10];
        StringBuffer sb = new StringBuffer(str);
        while (sb.toString().contains("z")) {//zero
            //2
            hash[2]++;
            sb.deleteCharAt(sb.indexOf("z"));
            sb.deleteCharAt(sb.indexOf("e"));
            sb.deleteCharAt(sb.indexOf("r"));
            sb.deleteCharAt(sb.indexOf("o"));
        }
        while (sb.toString().contains("x")) {//six
            hash[8]++;
            sb.deleteCharAt(sb.indexOf("s"));
            sb.deleteCharAt(sb.indexOf("i"));
            sb.deleteCharAt(sb.indexOf("x"));
        }
        while (sb.toString().contains("s")) {//seven
            hash[9]++;
            sb.deleteCharAt(sb.indexOf("s"));
            sb.deleteCharAt(sb.indexOf("e"));
            sb.deleteCharAt(sb.indexOf("v"));
            sb.deleteCharAt(sb.indexOf("e"));
            sb.deleteCharAt(sb.indexOf("n"));
        }
        while (sb.toString().contains("u")) {//four
            hash[6]++;
            sb.deleteCharAt(sb.indexOf("f"));
            sb.deleteCharAt(sb.indexOf("o"));
            sb.deleteCharAt(sb.indexOf("u"));
            sb.deleteCharAt(sb.indexOf("r"));
        }
        while (sb.toString().contains("f")) {//five
            hash[7]++;
            sb.deleteCharAt(sb.indexOf("f"));
            sb.deleteCharAt(sb.indexOf("i"));
            sb.deleteCharAt(sb.indexOf("v"));
            sb.deleteCharAt(sb.indexOf("e"));
        }
        while (sb.toString().contains("g")) {//eight
            hash[0]++;
            sb.deleteCharAt(sb.indexOf("e"));
            sb.deleteCharAt(sb.indexOf("i"));
            sb.deleteCharAt(sb.indexOf("g"));
            sb.deleteCharAt(sb.indexOf("h"));
            sb.deleteCharAt(sb.indexOf("t"));
        }
        while (sb.toString().contains("w")) {//two
            hash[4]++;
            sb.deleteCharAt(sb.indexOf("t"));
            sb.deleteCharAt(sb.indexOf("w"));
            sb.deleteCharAt(sb.indexOf("o"));
        }
        while (sb.toString().contains("h") && !sb.toString().contains("g")) {//three
            hash[5]++;
            sb.deleteCharAt(sb.indexOf("t"));
            sb.deleteCharAt(sb.indexOf("h"));
            sb.deleteCharAt(sb.indexOf("r"));
            sb.deleteCharAt(sb.indexOf("e"));
            sb.deleteCharAt(sb.indexOf("e"));
        }
        while (sb.toString().contains("o") && !sb.toString().contains("z")) {//one
            hash[3]++;
            sb.deleteCharAt(sb.indexOf("o"));
            sb.deleteCharAt(sb.indexOf("n"));
            sb.deleteCharAt(sb.indexOf("e"));
        }
        while (sb.toString().contains("n")) {//nine
            hash[1]++;
            sb.deleteCharAt(sb.indexOf("n"));
            sb.deleteCharAt(sb.indexOf("i"));
            sb.deleteCharAt(sb.indexOf("n"));
            sb.deleteCharAt(sb.indexOf("e"));
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j <= hash[i]; j++) {
                System.out.print(i);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++)
                handle(sc.next());
        }
    }

}
