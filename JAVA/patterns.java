import java.util.*;
public class patterns{

    public static void pattern_01(int rows){
        int nst =1;
        for(int r =1; r<=rows; r++){
            printStar(nst);
            System.out.println();
            nst++;
        }
    }

    public static void pattern_02(int rows){
        int nst = rows;
        for(int r =1; r<= rows; r++){
            printStar(nst);
            System.out.println();
            nst--;
        }
    }
    public static void pattern_03(int rows){
        int nsp = rows -1, nst = 1;
        for(int r =1; r<= rows; r++){
            printSpace(nsp);
            printStar(nst);
            System.out.println();
            nsp--;
            nst++;
        }
    }

    public static void pattern_04(int rows){
        int nsp = 0, nst = rows;
        for(int r =1; r<= rows; r++){
            printSpace(nsp);
            printStar(nst);
            nsp++;
            nst--;
            System.out.println();
        }
    }

    public static void pattern_05(int rows){
        int nsp = rows/2, nst = 1;
        for(int r =1; r<= rows; r++){
            printSpace(nsp);
            printStar(nst);
            System.out.println();
            if(r<=rows/2){
                nsp -=1;
                nst +=2;
            }else{
                nsp +=1;
                nst -=2;
            }
        }
    }

    public static void pattern_06(int rows){
        int nst = rows/2+1, nsp =1;
        for(int r =1; r<= rows; r++){
            printStar(nst);
            printSpace(nsp);
            printStar(nst);
            System.out.println();
            if(r <= rows/2){
                nsp +=2;
                 nst -=1;
            }else{
                nst +=1;
                nsp -=2;
            }
        }
    }

    public static void pattern_07(int rows){
        int nsp = 0;
        for(int r =1; r<= rows; r++){
            printSpace(nsp);
            printStar(1);
            System.out.println();
            nsp++;

        }
    }

    public static void pattern_07Diagnoal(int rows){
        for(int r =1; r<= rows; r++){
            for(int c =1; c<=rows ; c++){
                if(r==c){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

    public static void pattern_08(int rows){
        int nsp = rows-1;
        for(int r =1; r<= rows; r++){
            printSpace(nsp);
            printStar(1);
            nsp--;
            System.out.println();
        }
    }

    public static void pattern_08Diagonal(int rows){
        for(int r =1; r<= rows; r++){
            for(int c =1; c<= rows; c++){
                if(r+c== rows+1){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

    public static void pattern_09(int rows){
        int nspO = 0, nspI = rows -2;
        for(int r =1; r<= rows; r++){
            printSpace(nspO);
            printStar(1);
            printSpace(nspI);
            if(r != rows/2 +1)
            printStar(1);
            System.out.println();
            if(r <= rows/2){
                nspO +=1;
                nspI -=2;
            }else{
                nspO -=1;
                nspI +=2;
            }
        }
    }

    public static void pattern_09Diagonal(int rows){
        for(int r =1; r<=rows; r++){
            for(int c=1; c<=rows; c++){
                if( r==c || r+c == rows+1){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

    public static void pattern_10(int rows){
        int nspO = rows /2, nspI = -1;
        for(int r =1; r<= rows; r++){
            printSpace(nspO);
            printStar(1);
            printSpace(nspI);
            if(r !=1 && r!=rows)
             printStar(1);
            System.out.println();
            if(r <= rows/2){
                nspO -=1;
                nspI +=2;
            }else{
                nspO +=1;
                nspI -=2;
            }
        }
    }

    public static void pattern_14(int x){
        for(int r=1; r<=10; r++){
            int val = x * r;
            System.out.println(x + " * " + r +" = " + val);
        }
    }
    
    public static void pattern_16(int rows){
        int nsp = 2*rows -3, nst=1;
        for(int r =1; r<=rows; r++){
            printStar(nst);
            printSpace(nsp);
            if(r == rows){
                nst -=1;
            }
            printStar(nst);
            System.out.println();
            nst++;
            nsp -=2;
        }
    }

    public static void pattern_17(int rows){
        int nsp = rows/2, nst =1;
        for(int r =1; r<= rows; r++){
            if(r == rows/2+1){
                printStar(nsp);
            }else{
                printSpace(nsp);
            }
            printStar(nst);
            System.out.println();
            if(r<=rows/2){
                nst +=1;
            }else{
                nst -=1;
            }

        }
    }

    public static void pattern_15(int rows){
        int n = rows, nsp = n/2, nst = 1;
        for(int r =1; r<= rows ; r++){
            printSpace(nsp);
            System.out.println();
        }
    }

    
    public static void pattern_19(int rows){
        int n = rows;
        for(int r =1; r<=n; r++){
            for(int c =1 ; c<=n ; c++){
                if(r == 1){
                    if(c <= n/2+1 || c == n){
                        System.out.print("*\t");
                    }else{
                        System.out.print("\t");
                    }
                }else if( r<= n/2){
                    if( c== n/2 +1 || c ==n){
                        System.out.print("*\t");
                    }else{
                        System.out.print("\t");
                    }
                }else if(r == n/2 +1){
                        System.out.print("*\t");
                }else if(r < n){
                        if(c == 1 || c == n/2 +1){
                            System.out.print("*\t");
                        }else{
                            System.out.print("\t");
                        }
                } else{
                    if(c >= n/2+1 || c==1){
                        System.out.print("*\t");
                    }else{
                        System.out.print("\t");
                    }
                }
            }
            System.out.println();
        }
    }

    public static void pattern_19S(int rows){
        int n = rows;
        for(int r = 1; r<= n ;r++){
            for(int c =1 ; c<=n ; c++){
                if((r==1 && (c<=n/2 || c==n)) || (r<=n/2 && (c == n/2+1 || c==n)) || (r == n/2+1) || ((r>n/2+1 && r<n) && (c == n/2+1 || c==1)) || (r==n && (c == 1 || c>=n/2+1))){
                        System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

    public static void pattern_20(int rows){
        int n = rows;
        for(int r =1; r<= n; r++){
            for(int c = 1 ; c<=n ; c++){
                if((r<=n/2 && (c ==1 || c==n)) || (r>n/2 && (c ==1 || c==n || r == c || r+c == n+1))){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }


    public static void pattern_21(int rows){
        int col = 3, n =rows;
        for(int r = 1; r<=n; r++){
            for(int c =1; c<=col; c++){
                if(r%2 == 1){
                    if(c%2 == 1){
                        System.out.print("*\t");
                    }else{
                        System.out.print("\t");
                    }
                }else{
                    if(c%2 == 0){
                        System.out.print("*\t");
                    }else{
                        System.out.print("\t");
                    }
                }
            }
            System.out.println();
        }
    }

    

    public static void pattern_22(int rows){
        int n = 2*rows - 1;
        for(int r = 0 ; r< n; r++){
            int val = rows;
            for(int c = 0; c< n; c++){
                System.out.print(val+"\t");
                    if(c<r)
                        val -= 1;
                     if(c >= n - r - 1)
                        val += 1;                
            }
            System.out.println();
        }
    }

    public static void pattern_23(int rows){
        int n = rows;
        for(int r = 1; r<=n; r++){
            for(int c =1 ; c<= n ; c++){
                if(r==1 || r==n || c==1 || c==n || r==c || r+c == n+1){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

    public static void pattern_24(int rows){
        int n = 2*rows -1;
        for(int r =1 ; r<=n ; r++){
            for(int c=1; c<=n; c++){

            }
        }
    }

    public static void pattern_25(int n){
        for(int r = 1; r<=n; r++){
            for(int c = 1; c<=r ; c++){
                if(c == 1 || c==r){
                    System.out.print(r+"\t");
                }else{
                    System.out.print("*\t");
                }
            }
            System.out.println();
        }
    }

    public static void pattern_26(int n){
        int nsp = 0, count1 = 1, count2 = (n*n) + 1, nst = n;
        for(int r=1; r<=n; r++){
            printSpace(nsp);
            for(int c=1; c<=nst; c++){
                System.out.print(count1+"\t");
                count1++;
            }
            for(int c=1; c<=nst; c++){
                System.out.print(count2 +"\t");
                count2++;
            }
            count2-=2*nst - 1;
            nst--;
            nsp++;
            
            System.out.println();
        }

    }

    public static void pattern_27(int n ){
        int nspO = n-1, nspI =  n-2;
        for(int r =1 ; r<=n; r++){
            printSpace(nspO);
            if(r==1 || r==n){
                printStar(n);
            }else{
                System.out.print("*\t");
                printSpace(nspI);
                System.out.print("*\t");
            }

            System.out.println();
            nspO--;
        }
    }

    public static void pattern_28(int rows){
        int n = 2*rows - 1, nspO = rows -1, nspI = -1, nst = 1;
        for(int r =1; r<= n; r++){
            
            printSpace(nspO);
            printStar(nst);
            printSpace(nspI);
            if(r!=1 && r!=n){
                printStar(nst);
            }
            if(r<n/2){
                if(r != rows/2){
                nspO -=1;
                nspI +=2;
                nst = 1;
                }
                
            }else if(r == rows/2 +2){
                    nspO -=2;
                    nspI +=4;
                    nst = 2;
                    // System.out.println(nst);
                }else if(r> n/2 +1){
                 if(r != (n%rows)/2){
                nspO +=1;
                nspI -=2;
                nst = 1;
                }else if(r == (n%rows)/2 +1){
                    nspO +=2;
                    nspI -=2;
                    nst = 2;
                }
            }
            System.out.println();
        }
    }

    public static void pattern_29(int n){
        int stId = (n%2 == 0)? (n/2)-1 : n/2;
        for(int r=0 ; r<n; r++){
            for(int c=0; c<n ;c++){
                if(r == n/2){
                    printStar(1);
                }else if(c == stId){
                    printStar(1);
                }else{
                    printSpace(1);
                }
            }
            if(r<n/2){
                stId++;
            }else if(r>=n/2){
                stId--;
            }
            System.out.println();
            
        }
    }

    public static void pattern_30(int rows){
        int nst = pattern_30A(rows);
        pattern_30B(nst);
    }

    public static int pattern_30A(int rows){
        int nspI = rows%2==0? rows -1 : rows;
        int nspO = nspI /2;
        int nst = rows;
        while(nspO >= 0){
            printSpace(nspO);
            printStar(nst);
            printSpace(nspI);
            printStar(nst);
            nst += 2;
            nspO -=1;
            nspI -=2;
            System.out.println();
        }
        return nst;
    }

    public static void pattern_30B(int rows){
        int nst = 2*rows - 3, nsp = 0;
        while(nst >=0){
            printSpace(nsp);
            printStar(nst);
            nsp++;
            nst -=2;
            System.out.println();
        }
    }

    public static void pattern_31(int n){
        int val = 1, mul = 2;
        for(int r = 1; r<=n ; r++){
            for(int c = 1; c<=n; c++){
                if(r ==1 || r==n || c==1 || c==n){
                    System.out.print(val+" ");
                }else{
                    System.out.print("* ");
                }
                val++;
            }
            if(n%2 == 1){
                if(r<=n/2){
                    val = mul * n + 1;
                    mul +=2;
                }else{
                    if(r == n/2+1) mul -=3;
                    val = mul *n+1;
                    mul -=2;
                }
            }else{
                if(r<n/2){
                    val = mul * n +1;
                    mul +=2;
                }else{
                    if(r == n/2) mul -=1;
                    val = mul*n+1;
                    mul -=2;
                }
            }
            System.out.println();
        }
    }

    public static void pattern_32(int n){
        char val = 'A';
        for(int r =1; r<=n; r++){
            for(int c = 1; c<=r ; c++){
                if(c==1 || c==r){
                    System.out.print(val +"\t");
                }else{
                    System.out.print("*\t");
                }
            }
            val = (char)(val +1);
            System.out.println();
        }
    }    

    public static void printNumber(int col, int val){
        for(int i=1; i <= col; i++){
            System.out.print(val +"\t");
        }
    }

    public static void printSpace( int nsp){
        for(int csp = 1; csp <= nsp; csp++){
            System.out.print("\t");
        }
    }
    public static void printStar( int nst){
        for(int cst = 1; cst<= nst; cst++){
            System.out.print("*\t");
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = 7;
        pattern_01(n);
        System.out.println("P1");  
        System.out.println();

        pattern_02(n);
        System.out.println("P2");
        System.out.println();

        pattern_03(n);
        System.out.println("P3");
        System.out.println();

        pattern_04(n);
        System.out.println("P4");
        System.out.println();
        pattern_05(n);
        System.out.println("P5");
        System.out.println();

        pattern_06(n);
        System.out.println("P6");
        System.out.println();

        pattern_07(n);
        System.out.println("P7");
        System.out.println();

        pattern_07Diagnoal(n);
        System.out.println("P7 Diagonal");
        System.out.println();

        pattern_08(n);
        System.out.println("P8");
        System.out.println();

        pattern_08Diagonal(n);
        System.out.println("P8 Diagonal");
        System.out.println();

        pattern_09(n);
        System.out.println("P9");
        System.out.println();

        pattern_09Diagonal(n);
        System.out.println("P9 Diagonal");
        System.out.println();

        pattern_10(n);
        System.out.println("P10");
        System.out.println();

        pattern_14(n);
        System.out.println("P14");
        System.out.println();

        pattern_16(n);
        System.out.println("P16");
        System.out.println();
        
        pattern_17(n);
        System.out.println("P17");
        System.out.println();

        pattern_19(n);
        System.out.println("P19");
        System.out.println();

        pattern_19S(n + 2);
        System.out.println("P19 Single if else");
        System.out.println();

        pattern_20(n+14);
        System.out.println("P20 -> St. Sabastiyan Garden (Goa) mai ek bade se dabloo ke niche 10 crore rupee");
        System.out.println();

        pattern_21(n);
        System.out.println("P21");
        System.out.println();

        pattern_22(n+1);
        System.out.println("P22");
        System.out.println();

        pattern_23(n + 2);
        System.out.println("P23");
        System.out.println();

        pattern_24(n+1);
        System.out.println("P24");
        System.out.println();

        pattern_25(n);
        System.out.println("P25");
        System.out.println();

        pattern_26(n);
        System.out.println("P26");
        System.out.println();

        pattern_27(n);
        System.out.println("P27");
        System.out.println();

        pattern_28(n);
        System.out.println("P28");
        System.out.println();

        pattern_29(n+2);
        System.out.println("P29");
        System.out.println();

        pattern_30(3);
        System.out.println("P30");
        System.out.println();

        pattern_31(n);
        System.out.println("P31");
        System.out.println();

        pattern_32(n);
        System.out.println("P32");
        System.out.println();
    }
}