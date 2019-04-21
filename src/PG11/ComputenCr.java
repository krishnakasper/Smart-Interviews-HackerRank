package PG11;

import java.io.*;
import java.util.StringTokenizer;

public class ComputenCr {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int mod = (int)1e9+7;
    public static void main(String[] args)throws IOException {

        int[][] dp = calculateOptimal(2000,2000);
        int test = Integer.parseInt(br.readLine());

        while (test-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
//            bw.write(calculateBruteForce(n,r)+"\n");
            bw.write(dp[n][r]+"\n");
        }
        bw.flush();
    }

    private static int calculateBruteForce(int n, int r){
        int[][] dp = new int[n+1][r+1];
        for(int i=1;i<r+1;i++)
            dp[0][i]=0;
        for(int i=0;i<n+1;i++)
            dp[i][0]=1;

        for(int i=1;i<n+1;i++){
            for(int j=1;j<r+1;j++){
                dp[i][j] = (dp[i-1][j]+dp[i-1][j-1])%mod;
            }
        }

        return dp[n][r];
    }

    private static int[][] calculateOptimal(int n, int r){
        int[][] dp = new int[n+1][r+1];
        for(int i=1;i<r+1;i++)
            dp[0][i]=0;
        for(int i=0;i<n+1;i++)
            dp[i][0]=1;

        for(int i=1;i<n+1;i++){
            for(int j=1;j<r+1;j++){
                dp[i][j] = (dp[i-1][j]+dp[i-1][j-1])%mod;
            }
        }

        return dp;
    }
}
