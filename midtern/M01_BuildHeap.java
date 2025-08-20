import java.util.*;

public class M01_BuildHeap {
    static String type;
    static int[] heap;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        type = sc.next();
        int n = sc.nextInt();
        heap = new int[n];
        for (int i = 0; i < n; i++) heap[i] = sc.nextInt();
        sc.close();

        for (int i = n/2-1; i >= 0; i--) heapify(i,n);

        for (int i = 0; i < n; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(heap[i]);
        }
        System.out.println();
    }

    static void heapify(int i,int n){
        int best=i,l=2*i+1,r=2*i+2;
        if(type.equals("max")){
            if(l<n && heap[l]>heap[best]) best=l;
            if(r<n && heap[r]>heap[best]) best=r;
        }else{
            if(l<n && heap[l]<heap[best]) best=l;
            if(r<n && heap[r]<heap[best]) best=r;
        }
        if(best!=i){int t=heap[i];heap[i]=heap[best];heap[best]=t;heapify(best,n);}
    }
}
/*
 * Time Complexity: O(n)
 * 說明：自底向上建堆，每個節點最多下沉 log n，但總成本 ≤ 2n。
 */
