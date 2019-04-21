package PG11;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MaximumCircularSubarraySum {
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
//            bw.write(calculate(arr)+"\n");
            BruteForce(arr);

        }
        bw.flush();
    }


    private static void BruteForce(int[] arr)throws IOException{

        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<arr.length;i++){
            list.add(arr[i]);
        }


        int[] ans = new int[arr.length];
        for (int j=0;j<arr.length;j++) {

            list.add(list.get(0));
            list.remove(0);
            int[] a = new int[arr.length];
            for(int i=0;i<a.length;i++)
                a[i] = list.get(i);
            int an = maxsum(a);
            if(an<0)
            {
                bw.write(an+"\n");
                return;
            }
            ans[j] = an;
        }

        int max = 0;
        for(int i=0;i<arr.length;i++)
            max = Math.max(max,ans[i]);


        bw.write(max+"\n");
    }

    private static int calculate(int[] arr)throws IOException{
        int maxpsum = maxsum(arr);
        if(maxpsum>=0){
            int sum = 0;
            for(int i=0;i<arr.length;i++) {
                sum += arr[i];
                arr[i] = -arr[i];
            }
            int maxnsum = maxsum(arr);

            sum = sum+maxnsum;

            if(sum>maxpsum)
                return sum;
        }
        return maxpsum;
    }

    private static int maxsum(int[] arr){
        int[] dp = new int[arr.length];
        int max=arr[0];
        dp[0]=arr[0];

        for(int i=1;i<arr.length;i++){
            dp[i] = Math.max(dp[i-1],0)+arr[i];
            if(dp[i]>max)
                max=dp[i];
        }

        return max;
    }
}
