package PG11;

import java.io.*;

public class BinaryStringWithNoAdjacent1s {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] DP0,DP1;
    public static void main(String[] args)throws IOException {
        int test = Integer.parseInt(br.readLine());
        int mod = (int)1e9+7;
        calculateDP();
        while (test-->0){
            int num = Integer.parseInt(br.readLine());
            bw.write(((DP0[num]+DP1[num])%mod)+"\n");
        }
        bw.flush();
    }

    public static void calculateDP(){
        int num = 100000;
        int mod = (int)1e9+7;
        DP0 = new int[num+1];
        DP1 = new int[num+1];
        DP1[1] = 1;
        DP0[1] = 1;
        for (int i=2;i<num+1;i++){
            DP1[i] = DP0[i-1];
            DP0[i] = (DP0[i-1]+DP1[i-1])%mod;
        }
    }
}
