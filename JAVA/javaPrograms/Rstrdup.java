import java.io.*;
import java.util.*;

public class Rstrdup {
public static Scanner in= new Scanner(System.in);
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        String s=in.nextLine();
        int n= in.nextInt();
        String p=s.substring(0,1);
        StringBuilder ans= dupli(s,1,p);
        dupli(s,1,p);
        System.out.print(ans);
    }
    public static StringBuilder dupli(String s,int i, String p){
        if(s.length()==i){
            StringBuilder base = new StringBuilder();
            base.append("");
            return base;
        }
        String c=s.substring(i,i+1);
        StringBuilder ans= new StringBuilder();
        dupli(s,i+1,c);
        ans.append(p);
        if(p==c){
            ans.append("*");
            System.out.print("hello");
        }
        
        return ans;
    }
}