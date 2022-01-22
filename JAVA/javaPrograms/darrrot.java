import java.util.*;
public class darrrot{
    public static Scanner in=new Scanner(System.in);
    public static void main(String args[]){
        int n=in.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        int r=in.nextInt();
         operation(arr, r);
         display(arr);
    }
    public static void operation(int[] arr, int r){
        r=r%arr.length;
        if(r<0){
            r=r+arr.length;
        }
       rotate(arr, 0, r-1);
       rotate(arr, r, arr.length-1);
       rotate(arr,0, arr.length-1);
    }
   public static void rotate(int[] arr, int li, int ri){
       while(li<ri){
           int temp=arr[li];
           arr[li]=arr[ri];
           arr[ri]=temp;
           li++;ri--;
       }
   }
   public static void display(int[] arr){
       for(int i=0;i<arr.length;i++){
           System.out.print(arr[i]+" ");
       }
   }
}