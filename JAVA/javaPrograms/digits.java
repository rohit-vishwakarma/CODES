import java.util.*;
public class digits{
    public static Scanner in=new Scanner(System.in);
    public static void main(String args[]){
     int n=in.nextInt();
     int r=in.nextInt();
     operation(n,r);
    }
    public static void operation(int n,int r){
        int x= n;
        int c=0,y;
        while(x!=0){
            x=x/10;
            c++;
        } System.out.println(c);
        
        int len=c;
        r%=len;
        if(r<0) r=(r+len)%len;
        int mul=1,div=1;
        for(int i=1;i<=len;i++){
            if(i<r) div*=10;
            else mul *=10;
        } 
        int A=n%div;
        int B=n/div;
        
    System.out.println(A*mul +B);
    }
    
}

