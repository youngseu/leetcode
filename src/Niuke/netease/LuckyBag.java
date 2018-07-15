package Niuke.netease;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//幸运的袋子
//题目描述
//一个袋子里面有n个球，每个球上面都有一个号码(拥有相同号码的球是无区别的)。如果一个袋子是幸运的当且仅当所有球的
//号码的和大于所有球的号码的积。
//例如：如果袋子里面的球的号码是{1, 1, 2, 3}，这个袋子就是幸运的，因为1 + 1 + 2 + 3 > 1 * 1 * 2 * 3
//你可以适当从袋子里移除一些球(可以移除0个,但是别移除完)，要使移除后的袋子是幸运的。现在让你编程计算一下你可以获
//得的多少种不同的幸运的袋子。
//输入描述:
//第一行输入一个正整数n(n ≤ 1000)
//第二行为n个数正整数xi(xi ≤ 1000)
//输出描述:
//输出可以产生的幸运的袋子数
//输入
//3
//1 1 1
//输出
//2
//思路：题目可以转化成求符合条件的集合真子集个数。每次从全集中选择若干元素（小球）组成子集（袋子）。集合子集个
//数为2^n个，使用dfs必然超时。且此题有重复元素，那么就搜索剪枝。
//对于任意两个正整数a,b如果满足 a+b>a*b，则必有一个数为1.可用数论证明：
//设a=1+x,b=1+y，则1+x+1+y>(1+x)*(1+y)，--->  1>x*y，则x，y必有一个为0，即a,b有一个为1.
//推广到任意k个正整数，假设a1,a2,...ak，如果不满足给定条件，即和sum小于等于积pi，
//如果此时再选择一个数b,能使其满足sum+b > pi*b，则，b必然为1，且为必要非充分条件。
//反之，如果选择的b>1，则sum+b <=pi*b，即a1,a2,...,ak,b不满足给定条件。（搜索剪枝的重要依据）
//
//因此，将球按标号升序排序。每次从小到大选择，当选择到a1,a2,...,ak-1时满足给定条件，而再增加选择ak时不满足条
//件（ak必然大于等于max(a1,a2,...,ak-1)），继续向后选择更大的数，必然无法满足！因此，可以进行剪枝。
//如果有多个1，即当k=1时，sum(1)>pi(1)不满足，但下一个元素仍为1，则可以满足1+1>1*1，所以要判断当前ak是否等于1
public class LuckyBag {
    public static int sum = 0;

    public static int dfs_backtracing(int[] nums, int index, int sum, int mult) {
        int count = 0;
        for (int i = index; i < nums.length; i++) {
            sum += nums[i];
            mult *= nums[i];
            if (sum > mult) {
                count += 1 + dfs_backtracing(nums, i + 1, sum, mult);
            } else if (nums[i] == 1) {
                count += dfs_backtracing(nums, i + 1, sum, mult);
            } else
                break;
            sum -= nums[i];
            mult /= nums[i];
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return count;
    }

    public static int backtracing(int[] nums, int index) {
        sum++;
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            backtracing(nums, i + 1);
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        String[] line = br.readLine().trim().split(" ");
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(line[i]);
        }
        Arrays.sort(nums);
        System.out.println(dfs_backtracing(nums, 0, 0, 1));

        //全部遍历
        System.out.println(backtracing(nums, 0));
    }
}
