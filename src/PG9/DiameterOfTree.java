package PG9;

import java.io.*;
import java.util.StringTokenizer;

public class DiameterOfTree {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int ans;
    public static void main(String[] args)throws IOException{
        int test = Integer.parseInt(br.readLine());
        while(test-->0){
            int num = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Node root = null;
            while(st.hasMoreTokens()){
                root = insert(root, Integer.parseInt(st.nextToken()));
            }
            ans=0;
            numberOfNodes(root);
            bw.write(ans+"\n");

        }
        bw.flush();
    }

    private static int numberOfNodes(Node root){
        if(root==null)
            return 0;
        int l = numberOfNodes(root.left);
        int r = numberOfNodes(root.right);
        ans = Math.max(ans,l+r+1);
        return Math.max(l,r)+1;
    }

    private static Node insert(Node root, int n){
        if(root==null)
            return new Node(n);
        if(n<root.data){
            root.left=insert(root.left,n);
        }
        else
            root.right=insert(root.right,n);
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