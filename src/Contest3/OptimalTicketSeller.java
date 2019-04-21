package Contest3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class OptimalTicketSeller {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int mod = (int)1e9+7;

    public static void main(String[] args)throws IOException{
        int test = Integer.parseInt(br.readLine());
        while (test-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            int i=0;
            while (st.hasMoreTokens())
                arr[i++] = Integer.parseInt(st.nextToken());
//            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
//            for (i=0;i<n;i++){
//                maxHeap.add(arr[i]);
//            }
//            long max = 0;
//            for (i=0;i<k;i++){
//                int temp = maxHeap.poll();
//                max +=temp;
//                if(temp<=1)
//                    continue;
//                else maxHeap.add(temp-1);
//            }
//            bw.write(max+"\n");
            bw.write(Optimal(arr,n,k)+"\n");
        }
        bw.flush();
    }

    private static long Optimal(int[] arr,int n, int k){
        Arrays.sort(arr);
        int[] array = new int[n];
        for (int i=0;i<n;i++){
            array[n-i-1] = arr[i];
        }
        long sum=0;
        int prev = array[0];
        int len =1;
        for (int i=1;i<n;i++){
            int diff = prev-array[i];
            for (int j=0;j<diff;j++){
                int temp = Math.min(k,len);
                sum+=temp*prev;
                prev--;
                k = k-temp;
                if(k<1)
                    return sum;
            }
            len++;
        }
        while (k>0){
            int temp = Math.min(k,len);
            sum+=temp*prev;
            prev--;
            k = k-temp;

        }
        return sum;
    }
}
