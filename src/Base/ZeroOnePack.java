package Base;

public class ZeroOnePack {
    public int maxValue(int capacity, int num, int[] value, int[] weight) {
        int[][] memo = new int[num + 1][capacity + 1];
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j >= weight[i]) {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i - 1][j - weight[i]] + value[i]);
                } else {
                    memo[i][j] = memo[i - 1][j];
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= capacity; i++) {
            max = Math.max(max, memo[num][i]);
        }
        return max;
    }

    public int maxValue2(int capacity, int num, int[] value, int[] weight) {
        int[] memo = new int[capacity + 1];
        for (int i = 1; i <= num; i++) {
            for (int j = capacity; j > 0; j--) {
                if (j - weight[i] >= 0) {
                    memo[j] = Math.max(memo[j], memo[j - weight[i]] + value[i]);
                } else
                    memo[j] = memo[j - 1];
            }
        }
        int max = 0;
        for (int i = 1; i <= capacity; i++) {
            max = Math.max(max, memo[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        ZeroOnePack bagZeroOne = new ZeroOnePack();
        int[] value = new int[]{0, 2, 10, 6, 3, 7, 8};
        int[] weight = new int[]{0, 1, 6, 2, 2, 5, 4};
        System.out.println(bagZeroOne.maxValue(12, 6, value, weight));
        System.out.println(bagZeroOne.maxValue2(12, 6, value, weight));
    }
}
