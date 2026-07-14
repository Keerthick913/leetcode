// Last updated: 14/07/2026, 16:15:51
class Solution {
    List<List<Integer>> adj= new ArrayList<>();
    public void createAdj(int u, int v)
    {
        adj.get(v).add(u);
    }
    public boolean dfs(int i, int[]visited, int[]dfs_visited)
    {
        visited[i]=1;
        dfs_visited[i]=1;
        List<Integer>neighbour=adj.get(i);
        for(int j:neighbour)
        {
            if(visited[j]==-1)
            {
                if(dfs(j, visited, dfs_visited))
                {
                    return true;
                }
            }
            else if(visited[j]==1 && dfs_visited[j]==1)
            {
                return true;
            }
        }
        dfs_visited[i]=-1;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited=new int[numCourses];
        int dfs_visited[]= new int[numCourses];
        for(int i=0; i<numCourses; i++)
        {
            visited[i]=-1;
            dfs_visited[i]=-1;
            adj.add(new ArrayList<Integer>());
        }
        for(int[] edge: prerequisites)
        {
            int u=edge[0];
            int v=edge[1];
            createAdj(u, v);
        }
        for(int i=0; i<numCourses; i++)
        {
            if(visited[i]==-1)
            {
                if(dfs(i, visited, dfs_visited))
                {
                    return false;
                }
            }
        }
        return true;

    }
}