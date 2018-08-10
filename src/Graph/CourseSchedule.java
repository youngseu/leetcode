package Graph;

import java.util.ArrayList;
import java.util.LinkedList;

//207 problem
//Course Schedule
public class CourseSchedule {
    //use edge list delegate graph
    //BFS
    //邻接表的遍历为广度优先遍历
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        //每个节点的入度
        int[] degree = new int[numCourses];
        //入度为0的节点
        LinkedList queue = new LinkedList();
        //遍历的节点
        int count = 0;
        //邻接链表
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            //入度增加
            degree[prerequisites[i][0]]++;
            //邻接表构建
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        //初始化节点度数
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
                count++;
            }
        }
        //删除入度为0的节点，调整所有其他节点度数
        while (queue.size() != 0) {
            int course = (int) queue.poll();
            for (int i = 0; i < graph[course].size(); i++) {
                int point = (int) graph[course].get(i);
                degree[point]--;
                if (degree[point] == 0) {
                    queue.add(point);
                    count++;
                }
            }
        }
        if (count == numCourses)
            return true;
        else
            return false;
    }

    //DFS,find a circle
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, i))
                return false;
        }
        return true;
    }

    private boolean dfs(ArrayList[] graph, boolean[] visited, int course) {
        if (visited[course])
            return false;
        else
            visited[course] = true;

        for (int i = 0; i < graph[course].size(); i++) {
            if (!dfs(graph, visited, (int) graph[course].get(i)))
                return false;
        }
        visited[course] = false;
        return true;
    }

    //DFS,mem record part result
    private boolean canFinish3(int numCourses, int[][] prerequisites) {
        //能够完成访问的节点
        boolean[] canfinish = new boolean[numCourses];
        //被访问过的节点
        boolean[] visitedList = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!canFinishThisCourse(i, prerequisites, visitedList, canfinish)) {
                return false;
            }
        }
        return true;
    }

    private boolean canFinishThisCourse(int course, int[][] prerequisites, boolean[] visitedList, boolean[] canFinish) {
        if (canFinish[course]) return true;
        if (visitedList[course]) return false;
        visitedList[course] = true;
        for (int[] pair : prerequisites) {
            if (pair[1] == course) {
                if (!canFinishThisCourse(pair[0], prerequisites, visitedList, canFinish)) {
                    return false;
                }
            }
        }
        visitedList[course] = false;
        canFinish[course] = true;
        return true;
    }
}
