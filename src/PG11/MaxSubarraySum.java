package PG11;

import java.io.*;
import java.util.StringTokenizer;

public class MaxSubarraySum {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)throws IOException {
        int test = Integer.parseInt(br.readLine());
        while (test-->0){
            int num = Integer.parseInt(br.readLine());
            int[] arr = new int[num];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i=0;
            while (st.hasMoreTokens())
                arr[i++] = Integer.parseInt(st.nextToken());

            calculate(arr);
        }
        bw.flush();
    }

    private static void calculate(int[] arr)throws IOException{
        int[] dp = new int[arr.length];
        int[] start = new int[arr.length];

        dp[0] = arr[0];
        start[0] = 1;
        int s=0;
        for (int i=1;i<arr.length;i++){
            if(dp[i-1]<0){
                dp[i] = arr[i];
                s=i;
            }
            else
                dp[i] = dp[i-1]+arr[i];

            start[i]=s;
        }

        int max=0;
        int maxi=0;
        for (int i=0;i<arr.length;i++){
            if(dp[i]>max){
                max=dp[i];
                maxi=i;
            }
        }
        bw.write(max+" "+start[maxi]+" "+maxi+"\n");
    }
}
