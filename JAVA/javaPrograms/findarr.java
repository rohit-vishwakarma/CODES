import java.util.*;
public class findarr{
    public static Scanner in=new Scanner(System.in);
    public static void main(String args[]){
        int n=in.nextInt();
        operation(n);
    
    }
    public static void operation(int n){
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        int x=in.nextInt();
        int c=-1;
        for(int i=0;i<n;i++){
            if(x==arr[i]){
                System.out.print(i);
                c++;
            }
            
        }
        if(c==-1){
           
            System.out.print(c);

        }
    }
}