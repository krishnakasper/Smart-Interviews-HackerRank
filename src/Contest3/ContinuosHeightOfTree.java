package Contest3;

import java.io.*;
import java.util.StringTokenizer;

public class ContinuosHeightOfTree {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int max = 0;

    public static void main(String[] args)throws IOException{
        int test = Integer.parseInt(br.readLine());
        while (test-->0){
            int n = Integer.parseInt(br.readLine());
            max=0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            Node root = null;
            while (st.hasMoreTokens()){
                root = insert(root ,Integer.parseInt(st.nextToken()),0);
                bw.write(max+" ");
            }
            bw.write("\n");
        }
        bw.flush();
    }

    private static Node insert(Node root, int k, int height){
        if(root==null){
            max = Math.max(max,height);
            return new Node(k);
        }
        if(root.data>k)
            root.left = insert(root.left,k,height+1);
        else
            root.right = insert(root.right,k,height+1);
        return root;
    }

    private static class Node{
        private int data;
        private Node left;
        private Node right;
        private int height;

        Node(int k){
            data = k;
            left=null;
            right=null;
        }
    }
}
