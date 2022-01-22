import java.util.*;
public class arrsum{
    public static Scanner in= new Scanner(System.in);
    public static void main(String args[]){
        int n1=in.nextInt();
        int[] a1=new int[n1];
        for(int i=0;i<n1;i++){
            a1[i]=in.nextInt();
        }
        int n2=in.nextInt();
        int[] a2=new int[n2];
        for(int i=0;i<n2;i++){
            a2[i]=in.nextInt();
        }
        operation(n1,n2,a1,a2);
          
    }
    public static void operation(int n1, int n2, int[] a1, int[] a2){
        int x,y=0,d=0;
            x=n1;
            if(n2>n1)
                x=n2;
        int a=x-1;
        int[] res= new int[x];
        System.out.println("Output:\n");
        n1-=1;n2-=1;
        while(a>=0){
            d=y;
            if(n1>=0)
                d+=a1[n1];
            if(n2>=0)
                d+=a2[n2];
            y=d/10;
            d=d%10;
            res[a]=d;
            a--;n1--;n2--;

        }
        for(int i=0;i<x;i++){
            System.out.println(res[i]);
        }
    }
}