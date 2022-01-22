import java.util.*;
public class arrtrav{
    public static Scanner in=new Scanner(System.in);
    public static void main(String args[]){
        int i=in.nextInt(), j=in.nextInt();
        int[][] arr= new int[i+1][j+1];
        for(int x=1;x<=i;x++){
            for(int y=1;y<=j;y++){
                arr[x][y]=in.nextInt();
            }
        }
        for(int x=1;x<=j;x++){
            if(x%2==1){
            for(int y=1;y<=i;y++){
                System.out.println(arr[y][x]);
            }}
            else 
             for(int y=i;y>=1;y--)
                 System.out.println(arr[y][x]);
            
        }
    }
}