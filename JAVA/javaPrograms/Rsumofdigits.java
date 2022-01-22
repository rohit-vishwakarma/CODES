import java.io.*;
import java.util.*;

public class Rsumofdigits {
public static Scanner in= new Scanner(System.in);
public static void main(String[] args) {
    // Write your code here
   String str=in.nextLine();
   int sum=0;
//   int x= (int)(str.charAt(0));
//   System.out.println(x-48);
   System.out.println(operation(str,0,sum));
}
public static int operation(String str,int idx,int sum){
    if(idx==str.length()) return sum;
//   if(str.length()>idx) return sum+str.charAt(idx);
    int n=(int)(str.charAt(idx));
    n=n-48;
    sum+=n;
    return operation(str,idx+1,sum);
}
}