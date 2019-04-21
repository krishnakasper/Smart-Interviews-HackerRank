package ExtraMaterial;

import java.io.*;

public class LongestCommonSubString {

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)throws IOException {
        String input1 = br.readLine();
        String input2 = br.readLine();
        bw.write(Optimal(input1,input2)+"\n");
        bw.flush();

    }
    public static int Optimal(String input1,String input2){
        int n = input1.length();
        int m = input2.length();
        int ans = 0;
        int[][] dp = new int[n+1][m+1];
        for (int i=0;i<=n;i++){
            for (int j=0;j<=m;j++){
                if(i==0 || j==0)
                    dp[i][j] = 0;
                else {
                    if(input1.charAt(i-1)==input2.charAt(j-1)){
                        dp[i][j] = 1+dp[i-1][j-1];
                        ans = Math.max(ans,dp[i][j]);
                    }
                    else{
                        dp[i][j] = 0;
                    }
                }
            }
        }
        return ans;
    }
}