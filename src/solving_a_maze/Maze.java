package solving_a_maze;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Scanner;
public class Maze {
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
    }
    static ArrayList<int[]> findPath(int n, int m, char[][] maze, int[] start, int[] end) {
        // initialize the queue and visited matrix
        Queue<int[]> Q = new LinkedList<>();
        Q.add(start);
        boolean[][] visited = new boolean[n][m];
        // initialize the parent array
        int[][][] parent = new int[n][m][];
        visited[start[0]][start[1]] = true;
        // in practice you might want to stop as soon as end is visited
        while(!Q.isEmpty()) {
            int[] u = Q.poll();
            // we are now processing node u
            for(int[] d : dir) {
                int i = u[0] + d[0];
                int j = u[1] + d[1];
                // visit the edge from u to (i, j)
                if(!visited[i][j] && maze[i][j] == '.') {
                    // node (i, j) has not yet been visited and is not a wall, add it
                    Q.add(new int[] {i, j});
                    visited[i][j] = true;
                    // set the parent of (i, j) to be u
                    parent[i][j] = u;
                }
            }
        }
        // check whether a path exists
        if(!visited[end[0]][end[1]]) return null;
        // build the path by tracing back from t to s
        ArrayList<int[]> path = new ArrayList<>();
        int[] cur = end;
        // loop until we reach s (s is the only visited node with null parent)
        while(parent[cur[0]][cur[1]] != null) {
            path.add(cur);
            cur = parent[cur[0]][cur[1]];
        }
        // reverse and return the path
        Collections.reverse(path);
        return path;
    }
}
