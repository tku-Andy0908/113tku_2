import java.util.*;

public class M06_PalindromeClean {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();sc.close();
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()) if(Character.isLetter(c)) sb.append(Character.toLowerCase(c));
        String t=sb.toString();
        int l=0,r=t.length()-1;boolean ok=true;
        while(l<r) if(t.charAt(l++)!=t.charAt(r--)){ok=false;break;}
        System.out.println(ok?"Yes":"No");
    }
}

