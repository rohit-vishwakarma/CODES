import java.io.*;
import java.util.*;

public class arrdiff{
public static Scanner in=new Scanner(System.in);
public static void main(String[] args) throws Exception {
    // write your code here
    int n=in.nextInt();
    int[] a1=new int[n];
    for(int i=0;i<n;i++)
      a1[i]=in.nextInt();
    int m=in.nextInt();
    int[] a2= new int[m];
    for(int i=0;i<m;i++)
      a2[i]=in.nextInt();
    int[] d=new int[m];
    int c=0;
    n--;m--;
    int k=m;
    while(k>=0){
        int x=0;
       
        int v = n>=0?a1[n]:0;
        if(a2[m]+c>=v){
            x=a2[m]+c-v;
            c=0;
        }else{
            x=a2[m]+c+10-v;
            c=-1;
        }
        d[k]=x;
        n--;m--;k--;
    }
    int idx=0;
    while(idx<d.length){
        if(d[idx]==0){
            idx++;
        }else
          break;
    }
    while(idx<d.length){
        System.out.println(d[idx]);
        idx++;
    }
 }
 

}