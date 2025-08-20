import java.util.*;

public class M10_RBPropertiesCheck {
    static class Node{int v;char c;Node l,r;Node(int v,char c){this.v=v;this.c=c;}}
    static String msg="";
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();int[] v=new int[n];char[] c=new char[n];
        for(int i=0;i<n;i++){v[i]=sc.nextInt();c[i]=sc.next().charAt(0);}sc.close();
        Node root=build(v,c,0,n);
        if(root==null||root.c!='B'){System.out.println("RootNotBlack");return;}
        if(check(root)==-1)System.out.println(msg);else System.out.println("RB Valid");
    }
    static Node build(int[] v,char[] c,int i,int n){
        if(i>=n||v[i]==-1)return null;
        Node x=new Node(v[i],c[i]);
        x.l=build(v,c,2*i+1,n);x.r=build(v,c,2*i+2,n);return x;
    }
    static int check(Node x){
        if(x==null)return 1;
        if(x.c=='R'){
            if((x.l!=null&&x.l.c=='R')||(x.r!=null&&x.r.c=='R')){msg="RedRedViolation";return -1;}
        }
        int lh=check(x.l),rh=check(x.r);
        if(lh==-1||rh==-1)return -1;
        if(lh!=rh){msg="BlackHeightMismatch";return -1;}
        return lh+(x.c=='B'?1:0);
    }
}
