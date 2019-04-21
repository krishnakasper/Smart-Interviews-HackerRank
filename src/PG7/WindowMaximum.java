package PG7;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class WindowMaximum {

    public static void main(String[] args)throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[num];
            int i=0;
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens())
                arr[i++] = Integer.parseInt(st.nextToken());
            int sum = findSumOptimal(arr,num,k);
            bw.write(sum+"\n");
        }
        bw.flush();
    }

    private static int findSum(int[] arr, int num, int k){
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int i;
        for(i=0;i<k;i++){
            if(map.containsKey(arr[i]))
                map.put(arr[i],map.get(arr[i])+1);
            else
                map.put(arr[i],1);
        }
        int sum = map.lastKey();
        for(i=k;i<num;i++){
            int count= map.get(arr[i-k]);
            if(count==1)
                map.remove(arr[i-k]);
            else
                map.put(arr[i-k],--count);
            if(map.containsKey(arr[i]))
                map.put(arr[i],map.get(arr[i])+1);
            else
                map.put(arr[i],1);

            sum+=map.lastKey();
        }
        return sum;
    }

    private static int findSumOptimal(int[] arr, int num, int k){
//        Deque<Integer> dq = new ArrayDeque<>();
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int sum=0;
        for(int i=0;i<k;i++){
            if(dq.size()==0){
                dq.addLast(i);
                continue;
            }
            while (dq.size()!=0 && arr[dq.peekLast()]<arr[i])
                dq.pollLast();
            dq.addLast(i);
        }
        sum+=arr[dq.peekFirst()];
        for(int i=k;i<num;i++){
            if(dq.size()==0){
                dq.addLast(i);
                continue;
            }
            while (dq.size()!=0 && arr[dq.peekLast()]<arr[i])
                dq.pollLast();
            dq.addLast(i);
            if(dq.peekFirst()==i-k)
                dq.pollFirst();
            sum+=arr[dq.peekFirst()];
        }
        return sum;
    }
}
