package PG5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RabinKarpmatching {
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int test = Integer.parseInt(st.nextToken());
        while (test-->0){
            st = new StringTokenizer(bf.readLine());
            String pattern = st.nextToken();
            String text = st.nextToken();
            System.out.println(findcount(pattern,text));
        }
    }

    private static int findcount(String pattern, String text){
        int count=0;
        int m = pattern.length();
        int n = text.length();
        if(m>n)
            return 0;
        long[] powArray1 = findpow1(m);
        long[] powArray2 = findpow2(m);
        long HB1 = 0;
        long HB2 = 0;

        for(int i=0;i<m;i++){
            HB1 = (HB1+pattern.charAt(i)*powArray1[m-i-1])%1000000007;
        }

        for(int i=0;i<m;i++){
            HB2 = (HB2+pattern.charAt(i)*powArray2[m-i-1])%1000000007;
        }

        long HA1 = 0;
        long HA2 = 0;
        for(int i=0;i<m;i++){
            HA1 = (HA1+text.charAt(i)*powArray1[m-i-1])%1000000007;
        }

        for(int i=0;i<m;i++){
            HA2 = (HA2+text.charAt(i)*powArray2[m-i-1])%1000000007;
        }
        if(HA1==HB1 && HA2==HB2)
            count++;
        for(int i=m;i<text.length();i++){
            HA1 = (((HA1-text.charAt(i-m)*powArray1[m-1]+text.charAt(i))*powArray1[0])%1000000007+1000000007)%1000000007;
            HA2 = (((HA2-text.charAt(i-m)*powArray2[m-1]+text.charAt(i))*powArray2[0])%1000000007+1000000007)%1000000007;
            if(HA1==HB1 && HA2==HB2)
                count++;
        }
        return count;
    }

    private static long[] findpow1(int length){
        long[] arr = new long[length];
        int p = 97;
        arr[0] = p;
        for(int i= 1; i<length;i++){
            arr[i] = (arr[i-1]*p)%1000000007;
        }
        return arr;
    }

    private static long[] findpow2(int length){
        long[] arr = new long[length];
        int p = 89;
        arr[0] = p;
        for(int i= 1; i<length;i++){
            arr[i] = (arr[i-1]*p)%1000000007;
        }
        return arr;
    }
}
