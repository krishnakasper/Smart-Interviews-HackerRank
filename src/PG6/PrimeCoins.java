package PG6;

import java.io.*;

public class PrimeCoins {

    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(bf.readLine());
        while(test-->0){
            int num = Integer.parseInt(bf.readLine());
            if(num%6==0)
                bw.write("Banta\n");
            else
                bw.write("Santa\n");
        }
        bw.flush();
    }
}
