import java.util.*;

public class M04_TieredTaxSimple {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();long sum=0;
        for(int i=0;i<n;i++){long x=sc.nextLong();long tax=calc(x);System.out.println("Tax: "+tax);sum+=tax;}
        sc.close();
        System.out.println("Average: "+(sum/n));
    }
    static long calc(long x){
        long t=0;
        if(x<=120000) return Math.round(x*0.05);
        t+=Math.round(120000*0.05);
        if(x<=500000) return t+Math.round((x-120000)*0.12);
        t+=Math.round((500000-120000)*0.12);
        if(x<=1000000) return t+Math.round((x-500000)*0.20);
        t+=Math.round((1000000-500000)*0.20);
        return t+Math.round((x-1000000)*0.30);
    }
}
/*
 * Time Complexity: O(n)
 * 說明：每筆收入 O(1) 計算，n 筆輸入總共 O(n)。
 */

