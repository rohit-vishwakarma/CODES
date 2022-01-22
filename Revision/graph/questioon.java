import java.util.LinkedList;
import java.util.Arrays;
public class questioon {
    public boolean isBipartite(int[][] graph, int src, int[] vis) {
        // -1 -> undefine, 0 -> red, 1 -> green.

        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);
        int color = 0;

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                int rvtx = que.removeFirst();
                if (vis[rvtx] != -1) {
                    if (vis[rvtx] != color) // conflict
                        return false;

                    continue;
                }

                vis[rvtx] = color;
                for (int v : graph[rvtx]) {
                    if (vis[v] == -1) {
                        que.addLast(v);
                    }
                }
            }

            color = (color + 1) % 2;
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int N = graph.length;
        int[] vis = new int[N];
        Arrays.fill(vis, -1);

        for (int i = 0; i < N; i++) {
            if (vis[i] == -1 && !isBipartite(graph, i, vis))
                return false;
        }

        return true;
    }

    //130 leetcode
    public void surroundedRegions(char[][] board) {
        int n= board.length;
        int m = board[0].length;
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int i=0; i< n; i++){
            for(int j =0; j<m ; j++){
                if((i==0 || j==0 || i==n-1 || j==m-1) && board[i][j] == 'O'){
                    surroundedDFS(board, i, j, dir);
                }
            }
        }
        for(int i =0; i<n; i++){
            for(int j=0; j<m ; j++){
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void surroundedDFS(char[][] grid, int i, int j , int[][] dir){
        grid[i][j] = '#';
        for(int d=0; d<4 ; d++){
            int r = i + dir[d][0];
            int c = j+ dir[d][1];
            
            if(r>=0 && c>=0 && r< grid.length && c<grid[0].length && grid[r][c] == 'O'){
                surroundedDFS(grid, r,c ,dir);
            }
        }
    }

    //1905

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length; 
        int m = grid1[0].length;
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        int count =0;
        for(int i =0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid2[i][j] == 1){
                    count += dfs(grid1, grid2, i, j, dir) ? 1:0;
                }
            }
        }
        return count;
    }
    
    public boolean dfs(int[][] grid1, int[][] grid2, int i, int j , int[][] dir){
        grid2[i][j] = 0;
        boolean res = true;
        for(int d=0; d<4; d++){
            int r= i + dir[d][0];
            int c = j+ dir[d][1];
            
            if(r>=0 && c>=0 && r< grid1.length && c< grid1[0].length && grid2[r][c] == 1){
                res = dfs(grid1, grid2, r,c, dir) && res;
            }
        }
        return res && grid1[i][j] == 1;
    }

    //BFS 994 rooting oranges

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dir = {{1,0}, {0,1},{-1,0}, {0,-1}};
       LinkedList<Integer> que = new LinkedList<>();
        int fresh =0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m ;j++){
                if(grid[i][j] == 1)fresh++;
                else if(grid[i][j] == 2){
                    que.addLast(i*m +j);
                    grid[i][j] = 2; // marking visited 
                }
            }
        }
        if(fresh == 0 ) return 0;
        int time =0;
        while(que.size()!=0){
            int sz = que.size();
            while(sz-->0){
                int rm = que.removeFirst();
                int i = rm / m , j = rm % m;
                for(int d =0 ; d<4 ; d++){
                    int r= i + dir[d][0];
                    int c = j+ dir[d][1];
                    
                    if(r>= 0 && c>=0 && r< n && c<m && grid[r][c] == 1){
                        if(--fresh == 0){
                            return time+1;
                        }
                        grid[r][c] = 2; // marked visited
                        que.addLast(r*m +c);
                    }
                }
               
            }
             time++;
        }
        return -1;
    }

    //shortest path in a binary matrix 1091

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid.length == 0 || grid[0].length ==0) return 0;
        int n = grid.length, m = grid[0].length;       
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1) return -1;
        
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,1},{1,-1},{-1,-1}};
        LinkedList<Integer> que = new LinkedList<>();
        int Spath =1;
        que.addLast(0);
        grid[0][0] = 1;
        while(que.size()!=0){
            int sz = que.size();
            while(sz-->0){
                int rm = que.removeFirst();
                int i = rm / m, j = rm% m;
                if(i ==n-1 && j == m-1) return Spath ;
                for(int d =0 ;d<dir.length; d++){
                    int r = i+ dir[d][0];
                    int c = j+ dir[d][1];
                    
                    if(r>=0 && c>=0 && r<n && c<m && grid[r][c] == 0){
                        grid[r][c] = 1;
                        que.addLast(r*m+c);
                    }
                }
            }
            Spath++;
        }
        return -1;
    }
    
}
