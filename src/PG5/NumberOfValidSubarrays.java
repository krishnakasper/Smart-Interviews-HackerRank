package PG5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class NumberOfValidSubarrays {
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int test = Integer.parseInt(st.nextToken());
        while (test-- > 0) {
            st = new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[] arr = new int[num];
            st = new StringTokenizer(bf.readLine());
            int i=0;
            while(st.hasMoreTokens())
                arr[i++] = Integer.parseInt(st.nextToken());
            int sum=0;
            int count=0;
            HashMap<Integer,Integer> map = new HashMap<>();
            for(i=0;i<arr.length;i++){
                if(arr[i]==0)
                    arr[i]=-1;
                sum+=arr[i];
                if(sum==0)
                    count++;
                if(map.containsKey(sum)){
                    count+=map.get(sum);
                }
                if(!map.containsKey(sum)){
                    map.put(sum,1);
                }
                else
                    map.put(sum,map.get(sum)+1);
            }
            System.out.println(count);
        }
    }
}

