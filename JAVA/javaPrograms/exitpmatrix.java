import java.util.*;
public class exitpmatrix{
    public static Scanner in=new  Scanner(System.in);
    public static void main(String args[]){
        int n=in.nextInt(), m=in.nextInt();
        int[][] arr=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
               arr[i][j]=in.nextInt();
        }
        operation(n,m,arr);
    }
    public static void operation(int n,int m, int[][] arr){
        int i=0,j=0,d=0;
        while(true){
             d=(d+arr[i][j])%4;
            if(d==0){
                j++;//east
                if(j==m){
                   System.out.print(i+"\n"+(j-1));
                break;}
            }else if(d==1){
                i++;//south
                if(i==n){
                    System.out.print((i-1)+"\n"+j);
                    break;
                }
            }else if(d==2){
                j--;
                if(j==-1){
                    System.out.print(i+"\n"+(j+1));
                    break;
                }
            }else{
                i--;
                if(i==-1){
                    System.out.print((i+1)+"\n"+j);
                }
        }
        }
    }

}