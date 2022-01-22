import java.io.*;
import java.util.*;

public class removeprimes{

    public static void solution(ArrayList < Integer > al) {
        // write your code here
        ArrayList<Integer> ans = new ArrayList<>();
     
        for(int i=0;i<al.size();i++){
            boolean prime=true;
             int n=al.get(i);
            for(int j=2;j*j<=n;j++){
                if(n%j==0){
                 prime=false;
                 break;
                }
            }
            if(prime==false){
                ans.add(n);
            }
          //  System.out.println(ans);
        }
        System.out.println(ans);

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList < Integer > al = new ArrayList < > ();
        for (int i = 0; i < n; i++) {
            al.add(scn.nextInt());
        }
        solution(al);
       // System.out.println(al);
    }

}