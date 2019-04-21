package PG12;

import java.io.*;

public class NonAdjacentSetBits {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int mod = (int)1e9+7;

    public static void main(String[] args)throws IOException {
        int test = Integer.parseInt(br.readLine());

        int[] dp = calculate1(1000001);
        while (test-->0){
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n]+"\n");
        }
        bw.flush();
    }

    private static int[] calculate1(int size){
        int[] dp = new int[size];
        int mod = (int)1e9+7;
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        dp[3] = 7;
        for(int i=4;i<size;i++){
            dp[i] = (dp[i-1]+(dp[i-1]-dp[i-4]))%mod;
        }
        return dp;
    }

    private static int[] calculate2(int size){
        int[] dp = new int[size];
        int mod = (int)1e9+7;
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        dp[3] = 7;
        for(int i=4;i<size;i++){
            dp[i] = (dp[i-1]+(dp[i-2]+(dp[i-3]-dp[i-4])%mod)%mod)%mod;
        }
        return dp;
    }

    private static int[] calculate(int size){
        int[] dp = new int[size];
        int mod = (int)1e9+7;
        dp[0] = 0;
        dp[1] = 2;
        int odd =1;
        int diff = 2;
        for(int i=2;i<size;i++){
            dp[i] = (dp[i-1]+diff)%mod;
            diff = (diff+odd)%mod;
            odd = (odd+2)%mod;
        }

        return dp;
    }
}
