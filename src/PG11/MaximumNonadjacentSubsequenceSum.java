package PG11;

import java.io.*;
import java.util.StringTokenizer;

public class MaximumNonadjacentSubsequenceSum {
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
//            calculate(arr);
            bw.write(FindMaxSum(arr,arr.length)+"\n");

        }
        bw.flush();
    }

    static int FindMaxSum(int arr[], int n)
    {
        int incl = arr[0];
        int excl = 0;
        int excl_new;
        int i;

        for (i = 1; i < n; i++)
        {
            /* current max excluding i */
            excl_new = (incl > excl) ? incl : excl;

            /* current max including i */
            incl = excl + arr[i];
            excl = excl_new;
        }

        /* return max of incl and excl */
        int temp = ((incl > excl) ? incl : excl);
        if(temp==0)
        {
            temp=Integer.MIN_VALUE;
            for(i=0;i<n;i++){
                if(temp<arr[i])
                    temp=arr[i];
            }
        }
        return temp;
    }

    private static void calculate(int[] arr)throws IOException{
        int[] dp = new int[arr.length];
        if(arr.length==1){
            bw.write(arr[0]+"\n");
            return;
        }
        dp[0]=arr[0];
        dp[1]=arr[1];
        int max= arr[0];
        for(int i=2;i<arr.length;i++){
            dp[i] = max+arr[i];
            max = Math.max(max,dp[i-1]);
        }

        max=Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++)
            max = Math.max(max,dp[i]);

        if(max<=0){
            max=Integer.MIN_VALUE;
            for (int i=0;i<arr.length;i++)
                max= Math.max(max,arr[i]);
        }


        bw.write(max+"\n");
    }
}
