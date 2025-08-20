import java.util.*;

public class M02_YouBikeNextArrival {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(); sc.nextLine();
        String[] times=new String[n];
        int[] mins=new int[n];
        for(int i=0;i<n;i++){times[i]=sc.nextLine().trim();mins[i]=toMin(times[i]);}
        String q=sc.nextLine().trim(); sc.close();
        int target=toMin(q);

        int l=0,r=n-1,ans=-1;
        while(l<=r){
            int m=(l+r)/2;
            if(mins[m]>target){ans=m;r=m-1;}else l=m+1;
        }
        System.out.println(ans==-1?"No bike":times[ans]);
    }
    static int toMin(String s){String[]p=s.split(":");return Integer.parseInt(p[0])*60+Integer.parseInt(p[1]);}
}

