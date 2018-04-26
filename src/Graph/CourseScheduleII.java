package Graph;

import java.util.*;

//210 problem
//Course Schedule II
public class CourseScheduleII {
    //BFS
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //邻接链表
        ArrayList[] graph = new ArrayList[numCourses];
        //节点入度
        int[] degree = new int[numCourses];
        //拓扑排序
        int[] order = new int[numCourses];
        //入度为零队列
        Queue<Integer> queue = new ArrayDeque();
        //次序
        int visitOrder = 0;

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            //入度增加
            degree[prerequisites[i][0]]++;
            //邻接表构建
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            int from = queue.poll();
            order[visitOrder++] = from;
            for (int i = 0; i < graph[from].size(); i++) {
                int next = (int) graph[from].get(i);
                degree[next]--;
                if (degree[next] == 0) {
                    queue.add(next);
                }
            }

        }
        return visitOrder == numCourses ? order : new int[0];
    }

    //DFS,性能比BFS差
    private int[] findOrder2(int numCourses, int[][] prerequisites) {
        //能够完成访问的节点
        boolean[] canfinish = new boolean[numCourses];
        //被访问过的节点
        boolean[] visitedList = new boolean[numCourses];
        List<Integer> res = new ArrayList<>();
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, prerequisites, visitedList, canfinish, res)) {
                return new int[0];
            }
        }
        //倒序
        for (int i = 0; i < numCourses; i++) {
            result[i] = res.get(numCourses - i - 1);
        }
        return result;
    }

    private boolean dfs(int course, int[][] prerequisites, boolean[] visitedList, boolean[] canFinish, List<Integer> res) {
        if (canFinish[course]) return true;
        if (visitedList[course]) return false;
        visitedList[course] = true;
        for (int[] pair : prerequisites) {
            if (pair[1] == course) {
                if (!dfs(pair[0], prerequisites, visitedList, canFinish, res)) {
                    return false;
                }
            }
        }
        visitedList[course] = false;
        canFinish[course] = true;
        res.add(course);
        return true;
    }
}
