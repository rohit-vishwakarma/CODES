import java.util.*;
public class binarysearch{
    public static Scanner in=new Scanner(System.in);
    public static void main(String args[]){
        int n=in.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        int data=in.nextInt();
        operation(n,arr,data);
    }
    public static void operation(int n, int[] arr,int data){
        int si=0,ei=n-1;
        while(si<=ei){
            int mid=(si+ei)/2;
            if(arr[mid]==data){
                System.out.println(mid);
                break;
            }
            else if(data<arr[mid]){
                ei=mid-1;
            }else si=mid+1;
        }
        
    }
}