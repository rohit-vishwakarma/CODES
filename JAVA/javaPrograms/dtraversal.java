import java.io.*;
import java.util.*;

public class dtraversal {
public static Scanner in=new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        // write your code here
        int n=in.nextInt();
        int[][] arr=new int[n][n];
        for(int i=0;i<n;i++)
        for(int j=0;j<n;j++){
            arr[i][j]=in.nextInt();
        }
        operation(arr);
    }
    public static void operation(int[][] arr){
        for(int gap=0;gap<arr[0].length;gap++){
            for(int i=0,j=gap;i<arr.length && j<arr[0].length; i++, j++){
                System.out.println(arr[i][j]);
            }
        }
    }

}