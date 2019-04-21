package PG10;

import java.io.*;
import java.util.*;

public class MaxPairSumOf2Arrays {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static PriorityQueue<Integer> max = null;
    private static PriorityQueue<Integer> min = null;

    public static void main(String[] args)throws IOException {
        int test = Integer.parseInt(br.readLine());
        while (test-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] arr1 = new int[num];
            int[] arr2 = new int[num];
            int i = 0;
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens())
                arr1[i++] = Integer.parseInt(st.nextToken());

            i = 0;
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens())
                arr2[i++] = Integer.parseInt(st.nextToken());

            printKMaxElementsBruteForce1(arr1,arr2,k);
            bw.write("\n");
        }
        bw.flush();
    }

    private static void printKMaxElementsBruteForce1(int[] arr1, int[] arr2, int k)throws IOException {
        // time complexity O(T*K*K*log(K)) S(K*K)
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int[] arr = new int[k*k];
        int m = 0;
        for(int i=arr1.length-k;i<arr1.length;i++){
            for(int j=arr2.length-k;j<arr2.length;j++){
                arr[m++] = arr1[i]+arr2[j];
            }
        }
        Arrays.sort(arr);

        for(int i=arr.length-1;i>=0&&k>0;i--,k--)
            bw.write(arr[i]+" ");
    }

    private static void printKMaxElementsBruteForce(int[] arr1, int[] arr2, int k)throws IOException{
        //time complexity O(T*N*N*Log(N)) S(N*N)
        int[] arr = new int[arr1.length*arr1.length];
        int m=0;
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr2.length;j++) {
                arr[m++] = arr1[i] + arr2[j];
            }
        }
        Arrays.sort(arr);
        for(int i=arr.length-1;i>=0 && k>0;i--,k--)
            bw.write(arr[i]+" ");

    }



}

