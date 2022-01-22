import java.util.*;
public sample3{
    public static Scanner in= new Scanner(System.in);
    public static void main(String args[]){
        primefactor();
       
    }
    public static void primefac(int n,ArrayList<Integer> ans){
       // ArrayList<Integer> arr = new ArrayList<>();
        for(int i=2;i*i<=n;i++){
            if(isPrime(i)) ans.add(i);
        }
    }
    public static boolean isPrime(int n){
        for(int i=2;i*i<=n;i++){
            if(n%i==0) return false;
        }
    return true;
    }
    public static void primeFactor(){
        ArrayList<Integer> list = new ArrayList<>();
        primefac(500,list);
        System.out.println(list);
    }
}