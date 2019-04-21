package PG10;


import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class AnyTimeMedian {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static PriorityQueue<Integer> max = null;
    private static PriorityQueue<Integer> min = null;

    public static void main(String[] args)throws IOException{
        int test = Integer.parseInt(br.readLine());
        while (test-->0){
            int num = Integer.parseInt(br.readLine());
            int[] arr = new int[num];
            int i = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens())
                arr[i++] = Integer.parseInt(st.nextToken());
            max = new PriorityQueue<>(Collections.reverseOrder());
            min = new PriorityQueue<>();
            printMedian(arr);
            bw.write("\n");
        }
        bw.flush();
    }

    private static void printMedian(int[] arr)throws IOException{
        max.add(arr[0]);
        int median = arr[0];
        bw.write(median+" ");
        for(int i =1;i<arr.length;i++){
            median = max.peek();
            if(arr[i]<median)
                max.add(arr[i]);
            else
                min.add(arr[i]);
            if(max.size()-min.size()>1){
                int temp = max.peek();
                max.poll();
                min.add(temp);
            }
            else if(max.size()-min.size()<0){
                int temp = min.peek();
                min.poll();
                max.add(temp);
            }
            bw.write(max.peek()+" ");
        }
    }
}
