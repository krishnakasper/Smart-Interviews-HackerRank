package PG11;

import java.io.*;

public class ArrangingDominos {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)throws IOException {
        int test = Integer.parseInt(br.readLine());
        int[] dp = calculateDP();
        while (test-->0){
            int num = Integer.parseInt(br.readLine());
            bw.write(dp[num]+"\n");
        }
        bw.flush();
    }

    private static int[] calculateDP(){
        int num = 1000001;
        int mod = (int)1e9+7;
        int[] dp = new int[num];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 5;
        for (int i=5;i<num;i++){
            dp[i] = (dp[i-1]+(int)(dp[i-2]+(((long)dp[i-5])*8)%mod)%mod)%mod;
        }
        return dp;
    }
}
