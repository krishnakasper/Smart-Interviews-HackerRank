package PG8;

import java.io.*;
import java.util.StringTokenizer;

public class DepthOfTreeNodes {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int height=0;
    static int[] arr;
    static int j;
    public static void main(String[] args)throws IOException{

        int test = Integer.parseInt(br.readLine());
        while (test-->0){
            int num = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Node root = null;
            j=0;
            arr= new int[num];
            while (st.hasMoreTokens()){
                root = insert(root ,Integer.parseInt(st.nextToken()),0);
            }
            int i=0;
            for (i=0;i<num;i++)
                bw.write(arr[i]+" ");
            bw.write("\n");
        }
        bw.flush();
    }


    private static Node insert(Node root, int k, int i){
        if(root==null){
            arr[j++]=i;
            return new Node(k);

        }
        if(root.data>k)
            root.left = insert(root.left,k,i+1);
        else
            root.right = insert(root.right,k,i+1);
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

