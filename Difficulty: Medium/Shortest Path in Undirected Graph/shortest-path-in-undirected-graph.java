class Solution {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int n = adj.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();
        dist[src] = 0;
        q.add(src);

        while(!q.isEmpty()) {
            int curr = q.poll();

            for(int neighbor : adj.get(curr)) {
                if(dist[neighbor] == Integer.MAX_VALUE) {
                    dist[neighbor] = dist[curr] + 1;
                    q.add(neighbor);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }

        return dist;
    }
}
