import java.util.*;
public class arrdemo{
    public static Scanner in=new Scanner(System.in);
    public static void main(String args[]){
        int i=in.nextInt(), j=in.nextInt();
        int[][] arr= new int[i][j];
        for(int x=0;x<i;x++){
            for(int y=0;y<j;y++){
                arr[x][y]=in.nextInt();
            }
        }
        for(int x=0;x<i;x++){
            for(int y=0;y<j;y++){
                System.out.print(arr[x][y]+" ");
            }
            System.out.println();
        }
    }
}