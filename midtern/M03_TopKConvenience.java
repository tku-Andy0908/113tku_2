import java.util.*;

public class M03_TopKConvenience {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),k=sc.nextInt();
        String[] name=new String[n];int[] qty=new int[n];
        for(int i=0;i<n;i++){name[i]=sc.next();qty[i]=sc.nextInt();}
        sc.close();

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);
        for(int i=0;i<n;i++){pq.add(new int[]{qty[i],i});if(pq.size()>k)pq.poll();}
        List<int[]> res=new ArrayList<>(pq);
        res.sort((a,b)->b[0]!=a[0]?b[0]-a[0]:a[1]-b[1]);
        for(int[]x:res) System.out.println(name[x[1]]+" "+x[0]);
    }
}
/*
 * Time Complexity: O(n log k)
 * 說明：每個元素插入堆 O(log k)，共 n 筆，總計 O(n log k)。
 */
