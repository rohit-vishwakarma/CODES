import java.util.*;
public class substr{
    public static Scanner in= new Scanner(System.in);
    public static void main(String args[]){
        String str=in.nextLine();
        operation(str);
    }
    public static void operation(String str){
      /*  int x=0;
        for(int k=0;k<str.length();k++){
        for(int i=x;i<str.length();i++){
            for(int j=x;j<=i;j++){
             System.out.print(str.charAt(j));
            }
            System.out.println();
        }x++;*/
       // /* 
        for(int i=0;i<str.length();i++){
          for(int len=1; i+ len<= str.length() ;len++){
              System.out.println(str.substring(i,i+len));
          }
       // */
    }
    }
}