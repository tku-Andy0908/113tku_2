import java.util.*;

public class M07_BinaryTreeLeftView {
    static class Node{int v;Node l,r;Node(int v){this.v=v;}}
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();int[] a=new int[n];for(int i=0;i<n;i++)a[i]=sc.nextInt();sc.close();
        if(n==0||a[0]==-1){System.out.println("LeftView:");return;}
        Node root=new Node(a[0]);Queue<Node> q=new LinkedList<>();q.add(root);int i=1;
        while(!q.isEmpty()&&i<n){
            Node cur=q.poll();
            if(i<n&&a[i]!=-1){cur.l=new Node(a[i]);q.add(cur.l);}i++;
            if(i<n&&a[i]!=-1){cur.r=new Node(a[i]);q.add(cur.r);}i++;
        }
        q.add(root);System.out.print("LeftView:");
        while(!q.isEmpty()){int sz=q.size();for(int j=0;j<sz;j++){Node cur=q.poll();
            if(j==0)System.out.print(" "+cur.v);
            if(cur.l!=null)q.add(cur.l);if(cur.r!=null)q.add(cur.r);}
        }
        System.out.println();
    }
}

