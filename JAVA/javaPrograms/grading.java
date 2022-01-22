import java.util.Scanner;
public class grading{
    public static void main(String args[]){
        int marks;
        Scanner in=new Scanner(System.in);
        marks=in.nextInt();
        gradingsystem(marks);
    }
    public static void gradingsystem(int n){
        if(n>90)
        System.out.println("excellent");
        else if(n>80&&n<=90)
             System.out.println("good");
        else if(n>70&&n<=80)
              System.out.println("fair");
        else if(n>60&&n<=70)
              System.out.println("meets expectation");
        else 
              System.out.println("below par");
       
              
    }
    
}