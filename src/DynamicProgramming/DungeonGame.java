package DynamicProgramming;

//174 problem
//Dungeon Game
//The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon.
//The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially
//positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
//The knight has an initial health point represented by a positive integer. If at any point his health
//point drops to 0 or below, he dies immediately.
//Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering
//these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's
//health (positive integers).
//In order to reach the princess as quickly as possible, the knight decides to move only rightward or
//downward in each step.
//Write a function to determine the knight's minimum initial health so that he is able to rescue the
//princess.
//For example, given the dungeon below, the initial health of the knight must be at least 7 if he
//follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
//-2(K) -3	 3
//-5   -10	 1
//10	30	-5(P)
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] health = new int[row][col];
        health[row - 1][col - 1] = Math.max(1 - dungeon[row - 1][col - 1], 1);
        for (int r = row - 2; r >= 0; r--)
            health[r][col - 1] = Math.max(health[r + 1][col - 1] - dungeon[r][col - 1], 1);
        for (int c = col - 2; c >= 0; c--)
            health[row - 1][c] = Math.max(health[row - 1][c + 1] - dungeon[row - 1][c], 1);
        for (int r = row - 2; r >= 0; r--) {
            for (int c = col - 2; c >= 0; c--) {
                int down = Math.max(health[r + 1][c] - dungeon[r][c], 1);
                int left = Math.max(health[r][c + 1] - dungeon[r][c], 1);
                health[r][c] = Math.min(down, left);
            }
        }
        return health[0][0];
    }
}
