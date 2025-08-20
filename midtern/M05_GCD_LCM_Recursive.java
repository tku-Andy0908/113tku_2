import java.util.*;

public class M05_GCD_LCM_Recursive {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        long a=sc.nextLong(),b=sc.nextLong();sc.close();
        long g=gcd(a,b),l=(a/g)*b;
        System.out.println("GCD: "+g);
        System.out.println("LCM: "+l);
    }
    static long gcd(long a,long b){return b==0?a:gcd(b,a%b);}
}
/*
 * Time Complexity: O(log(min(a,b)))
 * 說明：歐幾里得演算法遞迴，每步取餘數，複雜度為對數。
 */
