package graphs_pathfinding;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.BitSet;
import java.util.Collections;
public class Graphs {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        LinkedList<Integer>[] g = new LinkedList[n];
        for(int i = 0; i < n; i++) {
            g[i] = new LinkedList<>();
        }
        for(int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            g[u].add(v);
        }
        // do something with g

        int s = scanner.nextInt();
        int t = scanner.nextInt();
        ArrayList<Integer> path = findPath(g,s,t);
        StringBuilder sb = new StringBuilder();
        if (path != null){
            for (int num : path) {
                sb.append(num);
                if (num != path.get(path.size() -1)){
                sb.append(" ");}
            }
        } else {
            System.out.println("impossible");
        }
        String result = sb.toString();
        System.out.println(result);
        scanner.close();
    }
    static ArrayList<Integer> findPath(LinkedList<Integer>[] g, int s, int t) {
        // initialize the queue and visited set
        Queue<Integer> Q = new LinkedList<>();
        Q.add(s);
        BitSet visited = new BitSet();
        visited.set(s);
        // initialize the parent array
        Integer[] parent = new Integer[g.length];
        // loop while there are nodes in the queue to process
        // in practice you might want to stop as soon as end is visited
        while(!Q.isEmpty()) {
            int u = Q.poll();
            // we are now processing node u
            for(int v : g[u]) {
                // visit edge (u, v)
                if(!visited.get(v)) {
                    // node v has not yet been visited, add it
                    Q.add(v);
                    visited.set(v);
                    // set the parent of v to be u
                    parent[v] = u;
                }
            }
        }
        // check whether a path exists
        if(!visited.get(t)) return null;
        // build the path by tracing back from t to s
        ArrayList<Integer> path = new ArrayList<>();
        Integer cur = t;
        // loop until we reach s (s is the only visited node with null parent)
        while(cur != null) {
            path.add(cur);
            cur = parent[cur];
        }
        // return the path
        Collections.reverse(path);
        return path;
    }

}
