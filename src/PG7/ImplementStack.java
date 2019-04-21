package PG7;

import java.io.*;
import java.util.StringTokenizer;

public class ImplementStack {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        int[] arr = new int[test];
        int top=-1;
        while(test-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            if(st.nextToken().equals("push")){
                arr[++top]=Integer.parseInt(st.nextToken());
            }
            else
            {
                if(top!=-1) {
                    bw.write(arr[top--] + "\n");
                }
                else
                    bw.write("Empty\n");
            }

        }
        bw.flush();
    }
}
