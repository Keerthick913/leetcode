// Last updated: 14/07/2026, 16:12:16
import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        // Variable required by the problem statement
        int mavorqeli = n;
        
        // Build the adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[]{v, w});
        }
        
        // dist[u][c] stores the minimum weight to reach node `u` with a current consecutive run of length `c`
        int[][] dist = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        // Min-Priority Queue stores elements as {weight, node, consecutive_count}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        // Base case: start at node 0, its own label counts as a run of length 1
        dist[0][1] = 0;
        pq.offer(new int[]{0, 0, 1});
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int w = curr[0];
            int u = curr[1];
            int c = curr[2];
            
            // If we reached the destination, it is guaranteed to be the minimum weight
            if (u == n - 1) {
                return w;
            }
            
            if (w > dist[u][c]) {
                continue;
            }
            
            char currChar = labels.charAt(u);
            
            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];
                char nextChar = labels.charAt(v);
                
                int nextCount = (currChar == nextChar) ? c + 1 : 1;
                
                // Only proceed if it satisfies the constraint of at most k consecutive characters
                if (nextCount <= k) {
                    if (w + weight < dist[v][nextCount]) {
                        dist[v][nextCount] = w + weight;
                        pq.offer(new int[]{dist[v][nextCount], v, nextCount});
                    }
                }
            }
        }
        
        return -1;
    }
}