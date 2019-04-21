package PG11;

import java.io.*;
import java.util.StringTokenizer;

public class CollectApples {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int mod = (int)1e9+7;
    public static void main(String[] args)throws IOException {

        int test = Integer.parseInt(br.readLine());

        while (test-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] matrix = new int[n][m];
            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                int j=0;
                while (st.hasMoreTokens())
                    matrix[i][j++] = Integer.parseInt(st.nextToken());
            }

//            bw.write(BruteForce(matrix,n-1,m-1)+"\n");
            bw.write(Optimal(matrix)+"\n");
        }
        bw.flush();
    }

    private static int BruteForce(int[][] matrix,int n, int m){

        if(n==-1){
            return 0;
        }
        if(m==-1){
            return 0;
        }
        int top = BruteForce(matrix,n,m-1);
        int left = BruteForce(matrix,n-1,m);
        return Math.max(top,left)+matrix[n][m];
    }

    private static int Optimal(int[][] matrix){
        int[][] dp = new int[matrix.length][matrix[0].length];

        dp[0][0] = matrix[0][0];
        for(int j=1;j<matrix[0].length;j++)
            dp[0][j] = dp[0][j-1]+matrix[0][j];

        for(int i=1;i<matrix.length;i++)
            dp[i][0] = dp[i-1][0]+matrix[i][0];

        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+matrix[i][j];
            }
        }

        return dp[matrix.length-1][matrix[0].length-1];
    }
}
