package PG10;

import java.io.*;
import java.util.StringTokenizer;

public class ActivitySelection {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args)throws IOException {
        int test = Integer.parseInt(br.readLine());

        while (test-->0){
            int num = Integer.parseInt(br.readLine());
            int[] start = new int[num];
            int[] finish = new int[num];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i=0;
            while (st.hasMoreTokens())
                start[i++] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            i = 0;
            while (st.hasMoreTokens())
                finish[i++] = Integer.parseInt(st.nextToken());

            BruteForce(start,finish);
        }
        bw.flush();
    }

    private static void BruteForce(int[] start, int[] finish){
        int[] time = new int[86400];
        for(int i=0;i<start.length;i++){
            for(int j = start[i];j<=finish[i];j++){
                time[j]++;
            }
        }
        int a=0;
    }
}
