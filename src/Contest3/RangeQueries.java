package Contest3;

import java.io.*;
import java.util.StringTokenizer;

public class RangeQueries {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args)throws IOException{
        int test = Integer.parseInt(br.readLine());
        while (test-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            int i=0;
            while (st.hasMoreTokens())
                arr[i++] = Integer.parseInt(st.nextToken());

            int[] count = new int[k+1];

            for (i=0;i<n;i++)
                count[arr[i]]++;

            int[] dp = new int[k+2];

            dp[0]=0;
            for (i=1;i<dp.length;i++){
                dp[i] = dp[i-1]+count[i-1];
            }

            int queries = Integer.parseInt(br.readLine());
            while (queries-->0){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int ans = dp[b+1]-dp[a];
                bw.write(ans+"\n");
            }

        }
        bw.flush();
    }

}
