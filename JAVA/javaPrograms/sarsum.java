import java.util.*;
public class sarsum{
    public static Scanner in=new Scanner(System.in);
    public static void main(String args[]){
        int n=in.nextInt(), s=in.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
           arr[i]=in.nextInt();
        subarray(arr,n,s);
    }
    public static void subarray(int[] arr, int n, int s){
        
        int x=0;
        int sum=0;
        for(int i=x;i<n;i++){
            sum+=arr[i];
            //System.out.println("sum= "+sum);
            if(sum==s){
                System.out.println((x+1)+"<--->"+(i+1));
                break;
            }
            
           if(sum>s){
                x+=1;
                i=x-1;
                sum=0;
            }
          //  System.out.println("i=  "+i);
        } 
       
       
    }
}