package PG7;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class StockSpan {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        while (test-->0){
            int num = Integer.parseInt(br.readLine());
            Stack<Integer> stack = new Stack<>();
            int[] arr = new int[num];
            int[] brr = new int[num];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j=0;
            while (st.hasMoreTokens())
                arr[j++] = Integer.parseInt(st.nextToken());
            for(int i=0;i<num;i++){
                int count=1;
                while(!stack.empty() && arr[stack.peek()]<=arr[i]) {
                    stack.pop();
                    count++;
                }
                if(stack.empty())
                {
                    brr[i] = i+1;
                    stack.push(i);
                }
//                if(arr[stack.peek()]>=arr[i])
                else
                {
                    brr[i] = i-stack.peek();
                    stack.push(i);
                }
            }
            for(int i=0;i<num;i++){
                bw.write(brr[i]+" ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
