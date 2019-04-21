package PG11;

import java.io.*;
import java.util.StringTokenizer;

public class PathInMatrix {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int mod = (int)1e9+7;
    public static void main(String[] args)throws IOException {
        int test = Integer.parseInt(br.readLine());

        while (test-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[][] matrix = new int[n][m];
            while(b-->0){
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                matrix[r][c]=1;
            }

            bw.write(BruteForce(matrix,n-1,m-1)+"\n");
            bw.write(Optimal(matrix,n,m)+"\n");

        }
        bw.flush();
    }

    private static int Optimal(int[][] matrix,int n,int m){
        int[][] dp = new int[n][m];
        boolean flag=false;
        for(int i=0;i<n;i++){
            if(matrix[i][0]==1){
                flag=true;
            }
            dp[i][0] = (flag)?0:1;
        }

        flag=false;
        for (int j=0;j<m;j++){
            if(matrix[0][j]==1)
                flag=true;
            dp[0][j] = (flag)?0:1;
        }

        for (int i=1;i<n;i++){
            for (int j=1;j<m;j++){
                if(matrix[i][j]==1)
                    dp[i][j]=0;
                else
                    dp[i][j] = ((dp[i-1][j]+dp[i-1][j-1])%mod+dp[i][j-1])%mod;
            }
        }

        return dp[n-1][m-1];
    }

    private static int BruteForce(int[][] matrix,int n,int m){
        if(n==-1 || m==-1)
            return 0;
        if(matrix[n][m]==1)
            return 0;

        if(n==0 && m==0)
            return 1;

        return (((BruteForce(matrix,n-1,m)+BruteForce(matrix,n-1,m-1))%mod)+BruteForce(matrix,n,m-1))%mod;
    }
}
