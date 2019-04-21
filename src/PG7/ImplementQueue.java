package PG7;

import java.io.*;
import java.util.StringTokenizer;

public class ImplementQueue {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        int[] arr = new int[10000];
        int front=0;
        int rear =0;

        while(test-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            if(st.nextToken().equals("Enqueue")){
                arr[rear++] = Integer.parseInt(st.nextToken());
            }
            else
            {
                if(front==rear)
                    bw.write("Empty\n");
                else{
                    bw.write(arr[front++]+"\n");
                }
            }
        }
        bw.flush();
    }
}
