package PG10;

import java.io.*;
import java.util.StringTokenizer;

public class MaximumXOR {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args)throws IOException {
        int test = Integer.parseInt(br.readLine());
        while (test-->0){
            int num = Integer.parseInt(br.readLine());
            int[] arr = new int[num];
            int i=0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens())
                arr[i++] = Integer.parseInt(st.nextToken());
            Node root = new Node();
            for (i=0;i<num;i++){
                insert(root,arr[i]);
            }
            int max = 0;
            for(i=0;i<num;i++){
                max = Math.max(max,findMax(root,arr[i]));
            }
//            BruteForce(arr);
            bw.write(max+"\n");
        }
        bw.flush();
    }

    private static int findMax(Node root, int a){
        int ans = 0;
        for(int i=20;i>=0;i--){
            int b = (a>>i)&1;
            if(root.arr[1-b]!=null){
                ans+=(1<<i);
                root = root.arr[1-b];
            }
            else
                root = root.arr[b];
        }
        return ans;
    }

    private static void insert(Node root,int num){
        //consider 20 bits since value of num cannot be grater than 10^6
        for(int i=20;i>=0;i--){
            if(root.arr[checkBit(num,i)]==null){
                root.arr[checkBit(num,i)] = new Node();
            }
            root = root.arr[checkBit(num,i)];
        }
    }

    private static int checkBit(int num, int position){
        return (num&(1<<position))>0?1:0;
    }

    private static void BruteForce(int[] arr)throws IOException{
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                ans = Math.max(ans,arr[i]^arr[j]);
            }
        }
        bw.write(ans+"\n");
    }

    static class Node{
        private Node[] arr = null;
        Node(){
            arr = new Node[2];
        }
    }
}
