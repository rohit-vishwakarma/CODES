package RecursionLU;

import java.util.*;
public class basic {
    public static Scanner in = new Scanner(System.in);

    public static void printAllPath(int[][] maze, int sr, int sc, int er, int ec, int[][] dir, String[] dirS, String ans, ArrayList<String> allpaths){
        if(sr==er && sc==ec){
            System.out.println(ans);
            allpaths.add(ans);
            return;
        }
        maze[sr][sc]=1;
        int n = maze.length;
        int m = maze[0].length;
        for(int d =0; d<dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if(r>=0 && c>=0 && r<n && c<m && maze[r][c]==0){
                printAllPath(maze,r,c,er,ec,dir,dirS,ans+dirS[d],allpaths);
            }
        }
        maze[sr][sc]=0;
    }

    public static int countAllPath(int[][] maze, int sr, int sc, int er, int ec, int[][] dir, String[] dirS, String ans){
        if(sr==er && sc==ec){
            // System.out.println(ans);
            return 1;
        }
        maze[sr][sc]=1;
        int n = maze.length;
        int m = maze[0].length;
        int count=0;
        for(int d =0; d<dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if(r>=0 && c>=0 && r<n && c<m && maze[r][c]==0){
               count+= countAllPath(maze,r,c,er,ec,dir,dirS,ans+dirS[d]);
            }
        }
        maze[sr][sc]=0;
        return count;
    }
    public static void AllPathLengths(int[][] maze, int sr, int sc, int er, int ec, int[][] dir, String[] dirS, String ans,ArrayList<Integer> max){
        if(sr==er && sc==ec){
            // System.out.println(ans);
            // return 1;
            max.add(ans.length());
        }
        maze[sr][sc]=1;
        int n = maze.length;
        int m = maze[0].length;
        // int count=0;
        for(int d =0; d<dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if(r>=0 && c>=0 && r<n && c<m && maze[r][c]==0){
                AllPathLengths(maze,r,c,er,ec,dir,dirS,ans+dirS[d],max);
            }
        }
        maze[sr][sc]=0;
        // return count;
    }

    public static void printPath(){
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++)
        for(int j =0; j<m; j++)
          arr[i][j]=in.nextInt();
        int[][] dir = {{-1,0}, {-1,1}, {0,1}, {1,1}, {1,0},{1,-1}, {0,-1}, {-1,-1}};
        String[] dirS ={"t","e", "r", "s", "d", "w", "l", "n"};
        ArrayList<String> allpaths = new ArrayList<>();
        printAllPath(arr, 0, 0, n-1, m-1, dir, dirS, "", allpaths);
        System.out.println( countAllPath(arr, 0, 0, n-1, m-1, dir, dirS, ""));
        ArrayList<Integer> alllength = new ArrayList<>();
        AllPathLengths(arr, 0, 0, n-1, m-1, dir, dirS, "", alllength);
        Collections.sort(alllength);
        int max =  alllength.get(alllength.size()-1);
        int min = alllength.get(0);
        System.out.println("Longest Paths:");
        for(int i=0; i<allpaths.size();i++){
            if(allpaths.get(i).length()==max){
                System.out.println(allpaths.get(i));
            }
        }
        System.out.println("Shortest Paths:");
        for(int i=0; i<allpaths.size();i++){
            if(allpaths.get(i).length()==min){
                System.out.println(allpaths.get(i));
            }
        }
    }

    public static void main(String[] args){
        printPath();
    }
}
