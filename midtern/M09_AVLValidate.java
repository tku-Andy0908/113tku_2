import java.util.*;

public class M09_AVLValidate {
    static class Node{int v;Node l,r;Node(int v){this.v=v;}}
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();int[] a=new int[n];for(int i=0;i<n;i++)a[i]=sc.nextInt();sc.close();
        if(n==0||a[0]==-1){System.out.println("Valid");return;}
        Node root=new Node(a[0]);Queue<Node> q=new LinkedList<>();q.add(root);int i=1;
        while(!q.isEmpty()&&i<n){Node cur=q.poll();
            if(i<n&&a[i]!=-1){cur.l=new Node(a[i]);q.add(cur.l);}i++;
            if(i<n&&a[i]!=-1){cur.r=new Node(a[i]);q.add(cur.r);}i++;}
        if(!isBST(root,Long.MIN_VALUE,Long.MAX_VALUE))System.out.println("Invalid BST");
        else if(height(root)==-1)System.out.println("Invalid AVL");
        else System.out.println("Valid");
    }
    static boolean isBST(Node x,long mn,long mx){
        if(x==null)return true;
        if(x.v<=mn||x.v>=mx)return false;
        return isBST(x.l,mn,x.v)&&isBST(x.r,x.v,mx);
    }
    static int height(Node x){
        if(x==null)return 0;
        int lh=height(x.l);if(lh==-1)return-1;
        int rh=height(x.r);if(rh==-1)return-1;
        if(Math.abs(lh-rh)>1)return-1;
        return Math.max(lh,rh)+1;
    }
}
/*
 * Time Complexity: O(n)
 * 說明：建樹 O(n)，檢查 BST O(n)，檢查 AVL 高度 O(n)，總計 O(n)。
 */
