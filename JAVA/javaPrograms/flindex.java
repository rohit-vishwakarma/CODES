import java.util.*;
public class flindex{
    public static Scanner in=new Scanner(System.in);
    public static void main(String args[]){
        int n=in.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
          arr[i]=in.nextInt();
         int d=in.nextInt();
         operation(n,arr,d);
    }
    public static void operation(int n, int[] arr, int d){
        int x=0,y=0;
        for(int i=0;i<n;i++){
            if(arr[i]==d){
                x=i;
                break;
            }
        }
        if(x==0){
            x=-1;y=-1;
            System.out.println(x+"\n"+y);
            
        }
        else{
        System.out.println(x);
        for(int i=x;i<n;i++){
            if(arr[i]!=d){
                y=i-1;
                break;
            }
        }
        System.out.println(y);}
    }
}