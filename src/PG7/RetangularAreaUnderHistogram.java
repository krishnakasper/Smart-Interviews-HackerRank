package PG7;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class RetangularAreaUnderHistogram {
    public static void main(String[] args)throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-->0){
            int num = Integer.parseInt(br.readLine());
            int arr[] = new int[num];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i=0;
            while (st.hasMoreTokens())
                arr[i++] = Integer.parseInt(st.nextToken());
            bw.write(findMaxArea(arr)+"\n");
        }
        bw.flush();
    }

    private static int findMaxArea(int[] arr){
        int area = 0;
        int[] p1 = findMinLeft(arr);
        int[] p2 = findMinRight(arr);
        for(int i=0;i<arr.length;i++){
            int temp;
            temp = (p2[i]-p1[i]+1)*arr[i];
            area = Math.max(area,temp);
        }
        return area;
    }

    private static int[] findMinLeft(int[] arr){
        int[] brr = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<arr.length;i++){
            while (!stack.empty() && arr[stack.peek()]>=arr[i])
                stack.pop();

            if(stack.empty()){
                stack.push(i);
                brr[i]=-1;
            }
            else
            {
                brr[i] = stack.peek()+1;
                stack.push(i);
            }
            if(brr[i]==-1)
                brr[i]=0;
        }
        return brr;
    }

    private static int[] findMinRight(int[] arr){
        int[]  brr = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=arr.length-1;i>-1;i--){
            while (!stack.empty() && arr[stack.peek()]>=arr[i])
                stack.pop();
            if(stack.empty()){
                stack.push(i);
                brr[i] = arr.length-1;
            }
            else{
                brr[i] = stack.peek()-1;
                stack.push(i);
            }

        }
        return brr;
    }

    private static int[] findMinfromLeft(int[] arr){
        int[] brr = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<arr.length;i++){
            while (!stack.empty() && arr[stack.peek()]>arr[i])
                stack.pop();

            if(stack.empty()){
                stack.push(i);
                brr[i]=i;
            }
            else
            {
                brr[i] = stack.peek();
                stack.push(i);
            }
        }
        return brr;
    }

    private static int[] findMinfromRight(int[] arr){
        int[]  brr = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=arr.length-1;i>-1;i--){
            while (!stack.empty() && arr[stack.peek()]>arr[i])
                stack.pop();
            if(stack.empty()){
                stack.push(i);
                brr[i] = i;
            }
            else{
                brr[i] = stack.peek();
                stack.push(i);
            }

        }
        return brr;
    }
}
