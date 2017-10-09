package array;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaxAreaOfIsland {
    /* Solution1: BFS */
    public static int maxAreaOfIslandBFS(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int maxArea = Integer.MIN_VALUE;

        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int area = bfs(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    private static int bfs(int[][] grid, int i, int j) {

        int rows = grid.length;
        int cols = grid[0].length;

        int[] xDir = {0, 1, 0, -1};
        int[] yDir = {1, 0, -1, 0};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        grid[i][j] = 2;
        int area = 1;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];

            for (int k = 0; k < 4; k++) {
                int adjX = x + xDir[k];
                int adjY = y + yDir[k];

                if (isValid(grid, adjX, adjY)) {
                    queue.offer(new int[] {adjX, adjY});
                    grid[adjX][adjY] = 2;
                    area++;
                }
            }
        }
        return area;
    }

    private static boolean isValid(int[][] grid, int x, int y) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (x < 0 || x >= rows) return false;
        if (y < 0 || y >= cols) return false;
        if (grid[x][y] != 1) return false;

        return true;
    }

    /* Solution2 - DFS, recursive */
    public int maxAreaOfIslandDFSRec(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxArea = Math.max(maxArea, dfsRec(grid, visited, i, j));
            }
        }
        return maxArea;
    }

    private int dfsRec(int[][] grid, boolean[][] visited, int x, int y) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (x < 0 || x >= rows || y < 0 || y >= cols || visited[x][y] || grid[x][y] == 0) {
            return 0;
        }

        visited[x][y] = true;

        return (dfsRec(grid, visited, x + 1, y) +
                dfsRec(grid, visited, x - 1, y) +
                dfsRec(grid, visited, x, y + 1) +
                dfsRec(grid, visited, x, y - 1) + 1);
    }

    /* Solution3 - DFS, Iterative */
    public int maxAreaOfIslandDFS(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int[] xDir = {0, 1, 0, -1};
        int[] yDir = {1, 0, -1, 0};
        int maxArea = 0;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int area = 0;
                    Stack<int[]> stack = new Stack<>();
                    stack.push(new int[] {i, j});
                    visited[i][j] = true;

                    while (!stack.empty()) {
                        int[] cell = stack.pop();
                        int x = cell[0];
                        int y = cell[1];
                        area++;

                        for (int k = 0; k < 4; k++) {
                            int adjX = x + xDir[k];
                            int adjY = y + yDir[k];

                            if (adjX >= 0 && adjX < rows && adjY >= 0 && adjY < cols && grid[adjX][adjY] == 1 && !visited[adjX][adjY]) {
                                stack.push(new int[] {adjX, adjY});
                                visited[adjX][adjY] = true;
                            }
                        }
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        maxAreaOfIsland(grid);
    }
}
