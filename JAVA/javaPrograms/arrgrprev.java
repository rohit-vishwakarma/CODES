import java.util.*;
public class arrgrprev{
public static Scanner in=new Scanner(System.in);
public static void main(String args[]){
    int n=in.nextInt(), k=in.nextInt();
    int[] arr=new int[n];
    for(int i=0;i<n;i++)
       arr[i]=in.nextInt();
    reverseInGroups(arr,n,k);
}
    public static void reverseInGroups(int[] arr, int n, int k) {
        // code here
       // int fi=0;
        int li=k-1;
        int ri=n-1;
        for(int i=0;i<=li;i++){
            int temp=arr[i];
            arr[i]=arr[li];
            arr[li]=temp;
            li--;
        }
        for(int i=k;i<=ri;i++){
            int temp=arr[i];
            arr[i]=arr[ri];
            arr[ri]=temp;
            ri--;
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
