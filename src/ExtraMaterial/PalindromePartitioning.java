package ExtraMaterial;

import java.io.*;

public class PalindromePartitioning {

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)throws IOException {
        int test = Integer.parseInt(br.readLine());
        while (test-->0) {
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();
            bw.write(Optimal1(input) + "\n");
            bw.write(Optimal2(input) + "\n");
        }
        bw.flush();
    }

    public static int Optimal1(String input){
//        time complexity O(N^3) space complexity O(N^2)
        int n = input.length();
        int[][] dp = new int[n][n];
//      for all substrings with length 1
        for (int i=0;i<n;i++){
            dp[i][i] = 0;
        }
//      for all substring with length 2
        for(int i=0;i<n-1;i++){
            if(input.charAt(i)==input.charAt(i+1))
                dp[i][i+1] = 0;
            else
                dp[i][i+1] = 1;
        }
//      for all sub strings with length greater than 2
        for(int currlength=3;currlength<=n;currlength++){
            for (int i=0;i<n-currlength+1;i++){
                int j = i+currlength-1;
                if(input.charAt(i)==input.charAt(j) && dp[i+1][j-1]==0) //if substring is a palindrome
                    dp[i][j] = 0;
                else
                {
                    int ans = Integer.MAX_VALUE;
                    for (int k=0;k<j;k++){
                        ans = Math.min(ans,dp[i][k]+dp[k+1][j]+1);
                    }
                    dp[i][j] = ans;
                }
            }
        }
//        answer
        return dp[0][n-1];
    }

    public static int Optimal2(String input){
//        time complexity O(N^2) space complexity O(N^2)
        int n = input.length();
        boolean[][] P = new boolean[n][n];
        int[] dp = new int[n];

        for (int i=0;i<n;i++){
            P[i][i] = true;
        }

//        for all substring with length 2
        for(int i=0;i<n-1;i++){
            if(input.charAt(i)==input.charAt(i+1))
                P[i][i+1] = true;
            else
                P[i][i+1] = false;
        }

//      for all sub strings with length greater than 2
        for(int currlength=3;currlength<=n;currlength++) {
            for (int i = 0; i < n - currlength + 1; i++) {
                int j = i + currlength - 1;
                if (input.charAt(i) == input.charAt(j) && P[i + 1][j - 1] == true) //if substring is a palindrome
                    P[i][j] = true;
                else {
                    P[i][j] = false;
                }
            }
        }

        for (int i=0;i<n;i++){
            if(P[0][i]==true)
                dp[i] = 0;
            else{
                int ans = Integer.MAX_VALUE;
                for (int j=0;j<i;j++){
                    if(P[j+1][i])
                        ans = Math.min(ans,dp[j]+1);
                }
                dp[i] = ans;
            }
        }
//        answer
        return dp[n-1];
    }
}
