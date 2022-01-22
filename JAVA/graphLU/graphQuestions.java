

import java.util.*;
public class graphQuestions {

    //200
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs_island(grid, dir, i, j);
                    count++;
                }
            }
        }

        return count;
    }
    
    public void dfs_island(char[][] grid, int[][] dir, int i, int j) {
        grid[i][j] = '0';
        for (int d = 0; d < 4; d++) {
            int r = i + dir[d][0];
            int c = j + dir[d][1];

            if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == '1') {
                dfs_island(grid, dir, r, c);
            }
        }
    }

    //695

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length; 
        
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    int[] Acount = new int[1];
                    dfsAreaOfIsland(grid, dir, i, j, Acount);
                    if(Acount[0]>max){
                        max = Acount[0];
                    }
                }
            }
        }
        return max;
    }
    
    public void dfsAreaOfIsland(int[][] grid, int[][] dir, int i, int j, int[] count){
       
        grid[i][j] = 0;
        count[0] = count[0]+1;
        for(int d =0; d<4; d++){
            int r = i + dir[d][0];
            int c = j+ dir[d][1];
            
            if(r>=0 && c>=0 && r<grid.length && c< grid[0].length && grid[r][c]==1){
              
               dfsAreaOfIsland(grid, dir, r,c,count);
            }
        }
        
      
    }
    //463
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count =0, c2 =0;
         int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int i=0; i<n ;i++){
            for(int j=0; j<m ;j++){
                if(grid[i][j]==1){
                    count++;
                    for(int d =0 ; d<4 ; d++){
                       int r = i + dir[d][0];
                       int c = j + dir[d][1];
            
                      if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]== 1){
                             c2++;
                    }
                }
                    
                }
            }
        }
        return 4*count - c2;
    }
    //130
     public void solve(char[][] board) {
       int n = board.length, m = board[0].length;

        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || j == 0 || i == n - 1 || j == m - 1) && board[i][j] == 'O') {
                    surroundedDFS(board, i, j, dir);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '#')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        } 
    }
    public void surroundedDFS(char[][] grid, int i, int j, int[][] dir) {
        grid[i][j] = '#';
        int n = grid.length, m = grid[0].length;
        for (int d = 0; d < 4; d++) {
            int r = i + dir[d][0];
            int c = j + dir[d][1];

            if (r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 'O')
                surroundedDFS(grid, r, c, dir);
        }

    }

    //1905
    boolean flag = true;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;
        int count=0;
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid1[i][j]==1 && grid2[i][j] == 1){
                     flag = true;
                    dfs(grid1, grid2, i, j, dir);
                    if(flag) count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(int[][] grid1, int[][] grid2, int i, int j, int[][] dir){
        if(grid1[i][j]==0) flag = false;
        for(int d =0; d<4; d++){
            int r = i + dir[d][0];
            int c = j + dir[d][1];
            if(r>=0 && c>=0 && r<grid1.length && c<grid1[0].length && grid2[r][c] ==1){
                grid2[r][c]=0;
                dfs(grid1,grid2,r,c,dir);
            }
        }
    }
  //1905 

  public int countSubIslands_02(int[][] grid1, int[][] grid2) {
    int n = grid1.length;
    int m = grid1[0].length;
    int count=0;
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            if(grid2[i][j] == 1){
               count+= dfs_02(grid1, grid2, i, j, dir)? 1 : 0;
                
            }
        }
    }
    return count;
}

public boolean dfs_02(int[][] grid1, int[][] grid2, int i, int j, int[][] dir){
    grid2[i][j]= 0;
    boolean res = true;
    for(int d =0; d<4; d++){
        int r = i + dir[d][0];
        int c = j + dir[d][1];
        if(r>=0 && c>=0 && r<grid1.length && c<grid1[0].length && grid2[r][c] ==1){
        
            res = dfs_02(grid1,grid2,r,c,dir) && res;
        }
       
    }
     return res && grid1[i][j]==1;
}

  // 806 lintcode
  HashSet<String> S = new HashSet<>();
    String temp = "";
    int x=0,y=0;
    public int numberofDistinctIslands(int[][] grid) {
        // write your code here
        int n = grid.length; 
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!vis[i][j] && grid[i][j]==1){
                    temp = "";
                    x=i;
                    y=j;
                    dfs(grid,dir,i,j,vis);
                    S.add(temp);
                }
            }
        }
        return S.size();
    }
    public void dfs(int[][] grid, int[][] dir, int i, int j, boolean[][] vis){
        grid[i][j] = 0;
        vis[i][j]= true;
        temp += (i-x) +" "+(j-y);
        for(int d =0; d<4; d++){
            int r = i + dir[d][0];
            int c = j + dir[d][1];
            if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]==1 && !vis[r][c]){
                dfs(grid,dir,r,c, vis);
            }
        }
      
    }

    //lintcode 
    public  int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public  String[] dirS={"D","U","R","L"};
    public  int n,m;
    public  StringBuilder sb;

    public  int numberofDistinctIslands02(int[][] grid){
        n=grid.length;
        m=grid[0].length;
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    sb=new StringBuilder();
                    numDistinctIslands(grid,i,j);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    public  void numDistinctIslands(int[][] grid,int i,int j){
        grid[i][j]=0;
        for(int d=0;d<4;d++){
            int r=i+dir[d][0];
            int c=j+dir[d][1];

            if(r>=0 && c>=0 && r<n && c<m && grid[r][c]==1){
                sb.append(dirS[d]);
                numDistinctIslands(grid,r,c);
            }
        }
        sb.append("b");
    }
    //207
    //BFS
    public boolean canFinish(int n, int[][] prerequisites) {
        List<Integer>[] graph = new List[n];
        Queue<Integer> que = new LinkedList<>();
        int[] indeg = new int[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int arr[]: prerequisites){
            graph[arr[1]].add(arr[0]);
            indeg[arr[0]]++;
        }
        for(int i=0; i<n; i++){
            if(indeg[i]==0){
                que.add(i);
            }
        }
        int count=0;
            
        while(!que.isEmpty())
        {
                int curr = que.poll();
            for(int k: graph[curr]){
                
                indeg[k]-=1;
                if(indeg[k]==0)
                    que.add(k);   
            }
                count++;
         }
            if(count!=n)
                return false; 
        
     return true;
        
    }

    //DFS
    public boolean canFinish_02(int numCourses, int[][] prerequisites) {
        
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        
        for(int i=0; i<numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] pre : prerequisites) {
            graph[pre[0]].add(pre[1]);
        }
        
        int[] visited = new int[numCourses];
        
        for(int i=0; i<numCourses; i++) {
            if( !dfs(i, visited, graph))
                return false;
        }
        
        return true;
    }
    // 1 :- not visited , 2:- visited , 0:- on the path
    public boolean dfs(int src, int[] visited, ArrayList<Integer>[] graph) {
        
        if(visited[src] == 1) {
            return false;
        }
    
        if(visited[src] == 2) {
            return true;
        }
         
        visited[src] = 1;
        
        for(int n : graph[src]) {
            if(!dfs(n, visited, graph))
                return false;
        }
        
        visited[src] = 2;
        
        return true;
    }


    //210
    //BFS
    public int[] findOrder(int n, int[][] prerequisites) {
        int[] ans = new int[n];
        List<Integer>[] graph = new List[n];
        Queue<Integer> que = new LinkedList<>();
        int[] indeg = new int[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int arr[]: prerequisites){
            graph[arr[1]].add(arr[0]);
            indeg[arr[0]]++;
        }
        for(int i=0; i<n; i++){
            if(indeg[i]==0){
                que.add(i);
            }
        }
        int count=0;
        
        while(!que.isEmpty())
        {
            int curr = que.poll();
            for(int k: graph[curr]){
                
                indeg[k]-=1;
                if(indeg[k]==0)
                    que.add(k);   
            }
                ans[count++]=curr;
         }
        if(count!=n) return new int[0];
            
        
     return ans;
    }

    //DFS 
    public static boolean DFS_TopoisCycle(ArrayList<Integer>[] graph, int src, int[] vis, ArrayList<Integer> ans) {
        vis[src] = 0;
        boolean res = false;
        for (Integer e : graph[src]) {
            if (vis[e] == -1) {
                res = res || DFS_TopoisCycle(graph, e, vis, ans);
            } else if (vis[e] == 0)
                return true;
        }

        vis[src] = 1;
        ans.add(src);
        return res;
    }

    public static ArrayList<Integer> DFS_TopoisCycle(ArrayList<Integer>[] graph) {
        int N = graph.length;
        int[] vis = new int[N];
        Arrays.fill(vis, -1);
        ArrayList<Integer> ans = new ArrayList<>();

        boolean cycle = false;
        for (int i = 0; i < N; i++) {
            if (vis[i] == -1) {
                cycle = cycle || DFS_TopoisCycle(graph, i, vis, ans);
            }
        }

        if (cycle)
            ans.clear();

        return ans;
    }
    public int[] findOrder_02(int N, int[][] arr) {
        ArrayList<Integer>[] graph = new ArrayList[N];
        
        for(int i=0; i<N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] pre : arr) {
            graph[pre[0]].add(pre[1]);
        }
        ArrayList<Integer> ans = DFS_TopoisCycle(graph);
        int[] res = new int[ans.size()];
        int idx =0;
        for(int ele : ans)
            res[idx++] = ele;
        return res;
    }

    //329
    public int longestIncreasingPath(int[][] matrix) {
       int n = matrix.length;
       int m = matrix[0].length;
        
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        int[][] indeg = new int[n][m];
        LinkedList<Integer> que = new LinkedList<>();
        
        for(int i=0; i<n ;i++){
            for(int j=0; j<m ; j++){
                int count =0;
                for(int d=0; d<4; d++){
                    int r = i + dir[d][0];
                    int c = j + dir[d][1];
                    if(r>=0 && c>=0 && r<n && c<m){
                        if(matrix[i][j]>matrix[r][c]) count++;
                    }
                }
                indeg[i][j] = count;
                if(count == 0) que.addLast(i * m + j);
            }
        }
        
        int lev =0;
        while(que.size()>0){
            int size = que.size();
            for(int i=0; i<size; i++){
                int rval = que.removeFirst();
                
                int j = rval / m;
                int k = rval % m;
                for(int d=0; d<4; d++){
                    int r = j+ dir[d][0];
                    int c = k + dir[d][1];
                    if(r>=0 && c>=0 && r<n && c<m && matrix[r][c]>matrix[j][k]){
                        if(--indeg[r][c]==0){
                            que.addLast(r*m + c);
                        }
                    }
                }
            }
            lev++;
        }
        return lev;
    }
}
