package Contest3;

import java.io.*;
import java.util.StringTokenizer;

public class PartitionStrings {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int mod = (int)1e9+7;

    public static void main(String[] args)throws IOException{
        int test = Integer.parseInt(br.readLine());
        while (test-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            String num = br.readLine();
            int backSteps = (k+"").length()-1;
            int size = num.length();
            int[] dp = new int[size+1];
            dp[0] = 1;
            dp[1] = 1;
            num = num.substring(0,size);
            int ans=1;
            int i=0;
            for (i=2;i<=size;i++){
                ans = dp[i-1];
                for (int j=1;j<=backSteps;j++){
                    if(i-j-1<0)
                        break;
                    int temp = Integer.parseInt(num.substring(i-j-1,i));
                    if(temp<=k)
                        ans=(ans+dp[i-j-1])%mod;
                }
                dp[i] = ans;
            }

            bw.write(dp[size]+"\n");
        }
        bw.flush();
    }
}
