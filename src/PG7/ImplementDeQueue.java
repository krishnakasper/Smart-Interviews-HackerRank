package PG7;

import java.io.*;
import java.util.StringTokenizer;

public class ImplementDeQueue {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        int[] arr = new int[20001];

        int top1=10000;
        int top2=10001;

        while(test-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            if(operation.equals("push_back"))
            {
                arr[top2++] = Integer.parseInt(st.nextToken());
            }
            else if(operation.equals("pop_back"))
            {
                if(top2-top1==1)
                    bw.write("Empty\n");

                else{
                    bw.write(arr[--top2]+"\n");
                }
            }
            else if(operation.equals("push_front"))
            {
                arr[top1--] = Integer.parseInt(st.nextToken());
            }
            else
            {
                if(top2-top1==1)
                    bw.write("Empty\n");

                else{
                    bw.write(arr[++top1]+"\n");
                }
            }
        }
        bw.flush();
    }
}
