package Contest3;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class LongestSubarrayWithSum0 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args)throws IOException{
        int test = Integer.parseInt(br.readLine());
        while (test-->0){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i=0;
            while (st.hasMoreTokens())
                arr[i++] = Integer.parseInt(st.nextToken());
            int ans = calculate(arr);
            bw.write(ans+"\n");
        }
        bw.flush();
    }

    private static int calculate(int[] arr){
        int[] pre = new int[arr.length+1];
        pre[0] = 0;
        for (int i=1;i<=arr.length;i++)
            pre[i] = pre[i-1]+arr[i-1];

        int max=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<=arr.length;i++){
            if(map.containsKey(pre[i])){
                int index = map.get(pre[i]);
                int temp = i-index;
                max = Math.max(max,temp);
            }
            else
                map.put(pre[i],i);
        }
        return max;
    }
}
