package ExtraMaterial;

import java.io.*;
import java.util.StringTokenizer;

public class RodCutting {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args)throws IOException{

        StringTokenizer  st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int i=0;
        int[] arr = new int[n];
        while (st.hasMoreTokens()){
            arr[i++] = Integer.parseInt(st.nextToken());
        }
        bw.write(Optimal(arr,length)+"\n");
        bw.flush();
        bw.write(BruteForce(arr,length)+"\n");
        bw.flush();
    }

    public static int BruteForce(int[] arr,int length){
//        time complexity O(2^N)
        int ans = 0;
        if(length == 0)
            return 0;
        if(length == 1)
            return arr[1];
        if(length < arr.length){
            for(int i=1;i<arr.length;i++){
                ans = Math.max(ans,Math.max(arr[length],length-i));
            }
        }
        for(int i=1;i<length;i++){
            ans = Math.max(ans,BruteForce(arr,length-i)+BruteForce(arr,i));
        }
        return ans;
    }

    public static int Optimal(int[] arr, int length)throws IOException{
//        time complexity O(N^2) Space complexity O(N^2)
        int[][] dp = new int[arr.length][length+1];
        for (int j=0;j<=length;j++){
            dp[0][j] = 0;
        }
        for (int i=1;i<arr.length;i++){
            for (int j=0;j<=length;j++){
                if(j>=i) {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-i]+arr[i]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        printRods(dp);
        return dp[arr.length-1][length];
    }

    public static void printRods(int[][] dp)throws IOException{
        int i = dp.length-1;
        int j = dp[0].length-1;
        while (dp[i][j]!=0){
            if(dp[i][j] == dp[i-1][j]){
                i--;
            }
            else{
                bw.write(i+" ");
                j = j-i;
            }
        }
        bw.write("\n");
        bw.flush();
    }
}
