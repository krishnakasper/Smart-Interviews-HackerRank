package Contest3;

import java.io.*;
import java.util.StringTokenizer;

public class MatrixFlips {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int mod = (int)1e9+7;

    public static void main(String[] args)throws IOException{
        int test = Integer.parseInt(br.readLine());
        while (test-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] arr = new int[n * m];
            int size = n * m;
            int i = 0;
            for (int j = 0; j < n; j++) {
                String num = br.readLine();
                for (int k=0;k<m;k++)
                    arr[i++] = (int)num.charAt(k)-48;
            }
            int[] dp = new int[size];
            if (arr[0] == 0)
                dp[0] = 1;
            for (i = 1; i < size; i++) {
                if ((arr[i - 1] != arr[i]) && arr[i] == 0) {
                    dp[i] = dp[i - 1] + 2;
                }
//               else if ((arr[i - 1] != arr[i]) && arr[i] == 1)
//                    dp[i] = dp[i - 1];
                else
                    dp[i] = dp[i-1];
            }
            bw.write(dp[size-1]+"\n");
        }
        bw.flush();
    }
}
