package ExtraMaterial;

import java.io.*;

public class LongestPalindromicSubSequence {

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)throws IOException{
        String input = br.readLine();
        bw.write(Optimal(input)+"\n");
        bw.flush();
        bw.write(BruteForce(input)+"\n");
        bw.flush();
    }

    public static int Optimal(String input){
//        T.C O(N*N) S.C O(N*N)
        int N = input.length();
        int[][] dp = new int[N][N];
//      words with N 1
        for (int i=0;i<N;i++)
            dp[i][i] = 1;
        for (int i=0;i<N-1;i++){
            if (input.charAt(i)==input.charAt(i+1))
                dp[i][i+1] = 2;
            else
                dp[i][i+1] = 1;
        }
        for (int length=3;length<=N;length++){
            for (int i=0;i<N-length+1;i++){
                int j = i+length-1;
                if(input.charAt(i) == input.charAt(j)){
                    dp[i][j] = dp[i+1][j-1]+2;
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }
        return dp[0][N-1];
    }

    public static int BruteForce(String input){
//        T.C O(2^N)
        int count =  1;
        int length = input.length();
        long sequence = ((long)1)<<length;
        for (long i=1;i<sequence;i++){
            String temp = "";
            for (int j=0;j<length;j++){
                if(checkBit(i,j))
                    temp = temp + input.charAt(j);
            }
            if(checkPalindrome(temp))
                count = Math.max(count,temp.length());
        }
        return count;
    }

    private static boolean checkPalindrome(String input){
        int i=0;
        int j=input.length()-1;
        while (i<j){
            if(input.charAt(i)!=input.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    private static boolean checkBit(long number, int position){
        if(((number>>position)&1)%2==1)
            return true;
        return false;
    }
}
