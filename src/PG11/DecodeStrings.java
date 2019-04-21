package PG11;

import java.io.*;
import java.util.StringTokenizer;

public class DecodeStrings {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int mod = (int)1e9+7;
    public static void main(String[] args)throws IOException {
        int test = Integer.parseInt(br.readLine());

        while (test-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String s = br.readLine();
//            bw.write(BruteForce(s,n)+"\n");
            bw.write(Optimal(s,n)+"\n");
        }
        bw.flush();
    }

    private static int Optimal(String s,int n){
        int[] dp1 = new int[n+1];
        dp1[0] = 1;
        dp1[1] = 1;
        for (int i=2;i<=n;i++){
            dp1[i]=0;
            if(!s.substring(i-2,i-1).equals("0"))
                dp1[i] = dp1[i-1]%mod;
            if(s.substring(i-2,i-1).equals("1") || s.substring(i-2,i-1).equals("2") && Integer.parseInt(s.substring(i-1,i))<7){
                dp1[i]=(dp1[i]+dp1[i-2])%mod;
            }
        }
        return dp1[n];
    }

    private static int BruteForce(String s, int n){
        if(n==0 || n==1)
            return 1;
        int ans = BruteForce(s,n-1);
        String temp = s.substring(n-2,n);
        if(temp.substring(0,1).equals("0"))
            return ans;
        int num = Integer.parseInt(temp);
        if(num<26)
            ans+=BruteForce(s,n-2);

        return ans%mod;
    }
}
