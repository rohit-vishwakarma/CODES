import java.io.*;
import java.util.*;

public class saddle {
public static Scanner in =new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        // write your code here
        int n=in.nextInt();
        int[][] arr=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=in.nextInt();
            }
        }
        operation(arr);
    }
    public static void operation(int[][] arr){
        int n=arr.length;
        int m=arr[0].length;
        for(int r=0;r<n;r++){
            int c=0;
            int minEle=(int)1e8;
            
            for(int j=0;j<m;j++){
                if(arr[r][j]<minEle){
                    minEle=arr[r][j];
                    c=j;
                }
            }
            boolean isSaddle = true;
            
            for(int i=0;i<n;i++){
                if(arr[i][c]>minEle){
                    isSaddle= false;
                    break;
                }
            }
            if(isSaddle){
                System.out.println(minEle);
                return;
            }
        }
        System.out.println("Invalid input");
    }

}