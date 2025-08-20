import java.util.*;

public class M12_MergeKTimeTables {
    static class Item{int v,l,p;Item(int v,int l,int p){this.v=v;this.l=l;this.p=p;}}
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int K=sc.nextInt();List<List<Integer>> L=new ArrayList<>();
        for(int i=0;i<K;i++){int m=sc.nextInt();List<Integer> tmp=new ArrayList<>();
            for(int j=0;j<m;j++)tmp.add(sc.nextInt());L.add(tmp);}
        sc.close();
        PriorityQueue<Item> pq=new PriorityQueue<>((a,b)->a.v-b.v);
        for(int i=0;i<K;i++)if(!L.get(i).isEmpty())pq.add(new Item(L.get(i).get(0),i,0));
        List<Integer> res=new ArrayList<>();
        while(!pq.isEmpty()){
            Item cur=pq.poll();res.add(cur.v);
            if(cur.p+1<L.get(cur.l).size())pq.add(new Item(L.get(cur.l).get(cur.p+1),cur.l,cur.p+1));
        }
        for(int i=0;i<res.size();i++){if(i>0)System.out.print(" ");System.out.print(res.get(i));}
        System.out.println();
    }
}

