package PG10;

import java.io.*;

public class NumberOfDiceRollsGivenSum {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args)throws IOException {
        int test = Integer.parseInt(br.readLine());
        int[] arr = calculateSum();
        while (test-->0){
            int num = Integer.parseInt(br.readLine());
            bw.write(arr[num]+"\n");
        }
        bw.flush();
    }

    private static int[] calculateSum(){
        //time complexity O(T+N) space(N)
        int mod = (int)1e9+7;
        int[] arr = new int[100001];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = arr[0] + arr[1];
        arr[3] = arr[2] + arr[1] + arr[0];
        arr[4] = arr[3] + arr[2] + arr[1] + arr[0];
        arr[5] = arr[4] + arr[3] + arr[2] + arr[1] + arr[0];

        for (int i=6; i<arr.length;i++){
            long sum=0;
            for (int j=1;j<7;j++){
                sum = (sum+arr[i-j])%mod;
            }
            arr[i] = (int)(sum%mod);
        }
        return arr;
    }
}
