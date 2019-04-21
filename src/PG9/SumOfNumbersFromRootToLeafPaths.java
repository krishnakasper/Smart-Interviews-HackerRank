package PG9;

import java.io.*;
import java.util.StringTokenizer;

public class SumOfNumbersFromRootToLeafPaths {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)throws IOException {
        int test = Integer.parseInt(br.readLine());
        while (test-->0){
            int num = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Node root = null;
            while (st.hasMoreTokens()){
                root = insert(root ,Integer.parseInt(st.nextToken()));
            }

            bw.write(getSum(root,0)+"\n");
        }

        bw.flush();
    }

    private static int mod = (int)1e9+7;

    private static long getSum(Node root, long currSum){
        if(root==null)
            return 0;
        long tempSum = ((((long)Math.pow(10,(root.data+"").length())*currSum)%mod+root.data)%mod);
        if(root.left!=null || root.right!=null)
            return ((getSum(root.left,tempSum)%mod)+(getSum(root.right,tempSum)%mod))%mod;
        else
            return tempSum;
    }

    private static Node insert(Node root, int k){
        if(root==null){
            return new Node(k);
        }
        if(root.data>k)
            root.left = insert(root.left,k);
        else
            root.right = insert(root.right,k);
        return root;
    }

    private static class Node{
        private int data;
        private Node left;
        private Node right;

        Node(int k){
            data = k;
            left=null;
            right=null;
        }
    }
}
