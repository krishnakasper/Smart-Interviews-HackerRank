package PG11;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class TheKnapsackProblem {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int mod = (int)1e9+7;
    public static void main(String[] args)throws IOException {
        int test = Integer.parseInt(br.readLine());

        while (test-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int[] value = new int[n];
            int[] weight = new int[n];
            int i=0;
            Stack<Integer> trmp = new Stack<>();

            while (n-->0){
                st = new StringTokenizer(br.readLine());
                weight[i] = Integer.parseInt(st.nextToken());
                value[i++] = Integer.parseInt(st.nextToken());
            }


            bw.write(Optimal(s,weight,value)+"\n");
        }
        bw.flush();
    }

    private static int Optimal(int k,int[] weight,int[] value){
        int[][] dp = new int[weight.length+1][k+1];

        for (int i=0;i<=k;i++)
            dp[0][i] = 0;

        for (int i=1;i<=weight.length;i++){
            for (int j=0;j<=k;j++){
                if(j-weight[i-1]>=0)
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+value[i-1]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[weight.length][k];
    }

}
