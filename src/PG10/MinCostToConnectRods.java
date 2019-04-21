package PG10;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MinCostToConnectRods {

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)throws IOException {
        int test = Integer.parseInt(br.readLine());

        while (test-->0){
            int num = Integer.parseInt(br.readLine());
            int arr[] = new int[num];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i=0;
            while (st.hasMoreTokens())
                arr[i++] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            bw.write(optimal(arr)+"\n");

        }
        bw.flush();
    }

    private static long optimal(int[] arr){
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            heap.add(arr[i]);
        }
        long sum=0;
        while(heap.size()!=1){
            int a = heap.remove();
            int b = heap.remove();
            int temp = a+b;
            sum+=temp;
            heap.add(temp);
        }
        return sum;
    }

    private static long find(int[] arr){
        if(arr.length==1)
            return arr[0];
        for(int i=1;i<arr.length;i++){
            arr[i]=arr[i-1]+arr[i];
        }
        long sum = 0;
        for(int i=1;i<arr.length;i++)
            sum+=arr[i];
        return sum;
    }

    private static long findCost(int[] arr){
        long sum=0;
        if(arr.length==1)
            return arr[0];
        arr[1]=arr[0]+arr[1];
        for (int i=1;i<arr.length;i++){
            sum+=(arr[i]*(arr.length-i));
        }
        return sum;
    }
}
