import java.util.*;

public class M08_BSTRangedSum {
    static class Node{int v;Node l,r;Node(int v){this.v=v;}}
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();int[] a=new int[n];for(int i=0;i<n;i++)a[i]=sc.nextInt();
        int L=sc.nextInt(),R=sc.nextInt();sc.close();
        if(n==0||a[0]==-1){System.out.println("Sum: 0");return;}
        Node root=new Node(a[0]);Queue<Node> q=new LinkedList<>();q.add(root);int i=1;
        while(!q.isEmpty()&&i<n){Node cur=q.poll();
            if(i<n&&a[i]!=-1){cur.l=new Node(a[i]);q.add(cur.l);}i++;
            if(i<n&&a[i]!=-1){cur.r=new Node(a[i]);q.add(cur.r);}i++;}
        System.out.println("Sum: "+dfs(root,L,R));
    }
    static int dfs(Node x,int L,int R){
        if(x==null)return 0;
        if(x.v<L)return dfs(x.r,L,R);
        if(x.v>R)return dfs(x.l,L,R);
        return x.v+dfs(x.l,L,R)+dfs(x.r,L,R);
    }
}
