package PG6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EnclosingSubstring {

    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int test = Integer.parseInt(st.nextToken());
        while (test-- > 0) {
            st = new StringTokenizer(bf.readLine());
            String a = st.nextToken();
            String b =  st.nextToken();
            System.out.println(Optimal(a,b));
        }
    }

    private static int Optimal(String a, String b){
        if(a.length()>b.length())
            return -1;
        if(!aPresentinb(a,b))
            return -1;

        int[] aArray = new int[26];
        for(char ch:a.toCharArray())
            aArray[ch-'a']++;

        int low =a.length();
        int high = b.length();
        while(low<high){
            int mid = low+(high-low)/2;
            if(check(a,b,mid, aArray))
                high=mid;
            else
                low=mid+1;
        }
        return low;
    }

    private static boolean check(String a, String b, int mid, int[] aArray){
        int[] bArray = new int[26];
        for(int i=0;i<=mid-1;i++){
            bArray[b.charAt(i)-(int)'a']++;
        }
        if(find(aArray,bArray))
            return true;
        for(int i=mid;i<b.length();i++){
            bArray[b.charAt(i-mid)-(int)'a']--;
            bArray[b.charAt(i)-(int)'a']++;
            if(find(aArray,bArray))
                return true;
        }
        return false;
    }

    private static boolean find(int[] a, int[] b){
        for(int i=0;i<26;i++){
            if(a[i]>b[i])
                return false;
        }
        return true;
    }

    private static boolean aPresentinb(String a, String b){
        int[] aArray = new int[26];
        int[] bArray = new int[26];
        for(char ch:a.toCharArray())
            aArray[ch-(int)'a']++;
        for(char ch: b.toCharArray())
            bArray[ch-(int)'a']++;
        for(int i=0;i<26;i++){
            if(aArray[i]>bArray[i])
                return false;
        }
        return true;
    }
}
