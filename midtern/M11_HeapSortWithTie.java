import java.util.*;

public class M11_HeapSortWithTie {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();int[][] a=new int[n][2];
        for(int i=0;i<n;i++){a[i][0]=sc.nextInt();a[i][1]=i;}sc.close();
        PriorityQueue<int[]> pq=new PriorityQueue<>((x,y)->x[0]!=y[0]?y[0]-x[0]:x[1]-y[1]);
        for(int[]x:a)pq.add(x);
        int[] ans=new int[n];
        for(int i=n-1;i>=0;i--)ans[i]=pq.poll()[0];
        for(int i=0;i<n;i++){if(i>0)System.out.print(" ");System.out.print(ans[i]);}
        System.out.println();
    }
}
/*
 * Time Complexity: O(n log n)
 * 說明：所有元素進出堆各一次，單次 O(log n)，總計 O(n log n)。
 */
