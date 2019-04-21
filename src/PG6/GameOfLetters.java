package PG6;

import java.io.*;

public class GameOfLetters {

    public static void main(String[] args)throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while(test-->0){
            String s = br.readLine();
            int[] arr = null;
            arr = createCountArray(s);
            int xor = doXOR(arr);
            if(xor==0)
                bw.write("Banta\n");
            else
                bw.write("Santa\n");
        }
        bw.flush();
    }

    private static int doXOR(int[] arr){
        int xor=0;
        for(int i=0,j=0;i<26;i++)
            xor = xor^arr[i];
        return xor;
    }

    private static int[] createCountArray(String s){
        int[] arr = new int[26];
        for(char ch:s.toCharArray()){
            arr[ch-'a']++;
        }
        return arr;
    }
}
