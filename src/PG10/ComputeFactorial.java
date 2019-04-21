package PG10;

import java.io.*;

public class ComputeFactorial {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args)throws IOException {
        int test = Integer.parseInt(br.readLine());
        long[] arr = new long[1000001];
        long temp=0;
        arr[0]=1;
        arr[1]=1;
        int mod = (int)1e9+7;
        for(int i=2;i<arr.length;i++){
            arr[i] = ((i*arr[i-1])%mod);
        }
        while (test-->0){
            int num = Integer.parseInt(br.readLine());
            bw.write(arr[num]+"\n");
        }
        bw.flush();
    }

}
