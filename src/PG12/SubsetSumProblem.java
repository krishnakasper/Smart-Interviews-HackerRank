package PG12;

import java.io.*;
import java.util.StringTokenizer;

public class SubsetSumProblem {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int mod = (int)1e9+7;

    public static void main(String[] args)throws IOException {
        int test = Integer.parseInt(br.readLine());
        while (test-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            int i=0;
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()){
                arr[i++] = Integer.parseInt(st.nextToken());
            }
            bw.write((Optimal(arr,s))?"YES\n":"NO\n");
        }
        bw.flush();
    }

    private static boolean Optimal(int[] arr,int k){
        boolean[][] dp = new boolean[arr.length+1][k+1];
        dp[0][0] = true;

        for(int i=1;i<=k;i++)
            dp[0][i] = false;

        for(int i=0;i<arr.length;i++) {
            if(arr[i]<=k)
                dp[1][arr[i]] = true;
        }

        for(int i=0;i<=arr.length;i++)
            dp[i][0] = true;

        for(int i=1;i<=arr.length;i++){
            for(int j=1;j<=k;j++){
                if(j-arr[i-1]>=0)
                    dp[i][j] = dp[i-1][j]||dp[i-1][j-arr[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[arr.length][k];
    }
}
