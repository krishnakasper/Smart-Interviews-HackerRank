package PG12;

import java.io.*;
import java.util.StringTokenizer;

public class LargestSubMatrixSum {

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

            for (int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                for (int j=0;j<m;j++){
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] sum = calculateSum(matrix,n,m);

//            int max = findMax(sum,n,m);

//            bw.write(max+"\n");
            bw.write(Optimal(matrix,n,m)+"\n");

        }
        bw.flush();
    }

    private static int Optimal(int[][] matrix,int n, int m){
        int[][] dp = new int[n][m];

        for (int i=0;i<m;i++)
            dp[0][i] = matrix[0][i];

        for(int i=1;i<n;i++){
            for (int j=0;j<m;j++){
                dp[i][j] = dp[i-1][j]+matrix[i][j];
            }
        }

        int ans=Integer.MIN_VALUE;
        for(int j=0;j<m;j++)
            ans = Math.max(ans,dp[0][j]);

        for (int i=1;i<n;i++){
            for (int k=i;k<n;k++){
                int s=0;
                for (int j=0;j<m;j++){
                    s = s+(dp[k][j]-dp[i-1][j]);

                    ans = Math.max(ans,s);
                    if(s<0)
                        s=0;
                }
            }
        }
        return ans;
    }

    private static int min = Integer.MAX_VALUE;

    private static int findMax(int[][] sum,int n,int m){
        int max = Integer.MIN_VALUE;

        for (int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                max = Math.max(max,sum[i][j]);
            for(int k=0;k<=i;k++){
                    for (int l=0;l<=j;l++) {
                        int total = sum[i][j] + sum[k][l] - sum[k][j] - sum[i][l] ;
                        max = Math.max(max,total);
                    }
                }
            }
        }

        if(max==0)
            return min;

        return max;
    }

    private static int[][] calculateSum(int[][] matrix,int n,int m){
        int[][] sum = new int[n+1][m+1];
        sum[1][1] = matrix[0][0];
        min = Integer.MIN_VALUE;
        for(int i=0;i<=n;i++)
            sum[i][0]=0;
        for(int j=0;j<=m;j++)
            sum[0][j] = 0;

        for (int i=2;i<=n;i++) {
            sum[i][1] = sum[i - 1][1] + matrix[i - 1][0];
            min = Math.max(min,matrix[i-1][0]);
        }

        for(int j=2;j<=m;j++) {
            sum[1][j] = sum[1][j - 1] + matrix[0][j - 1];
            min = Math.max(min,matrix[0][j-1]);
        }

        for(int i=2;i<=n;i++){
            for (int j=2;j<=m;j++){
                sum[i][j] = sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+matrix[i-1][j-1];
                min = Math.max(min,matrix[i-1][j-1]);
            }
        }

        return sum;
    }

}
