package PG8;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ZigZagLevelOrder {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList[] list;
    public static void main(String[] args)throws IOException {

        int test = Integer.parseInt(br.readLine());
        while (test-->0){
            int num = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Node root = null;
            list = new ArrayList[num];
            for(int i=0;i<num;i++)
                list[i] = new ArrayList<>();

            while (st.hasMoreTokens()){
                root = insert(root ,Integer.parseInt(st.nextToken()),0);
            }

            printList();

            bw.write("\n");
        }
        bw.flush();
    }
    private static void printList()throws IOException{
        for(int i=0;i<list.length;i++){
            Collections.sort(list[i]);
            if(i%2==1) {
                for (int j = 0; j < list[i].size(); j++)
                    bw.write(list[i].get(j) + " ");
            }
            else{
                for(int j=list[i].size()-1;j>=0;j--)
                    bw.write(list[i].get(j) + " ");
            }
        }
    }

    private static Node insert(Node root, int k, int i){
        if(root==null){
            list[i].add(k);
            return new Node(k);

        }
        if(root.data>k)
            root.left = insert(root.left,k,i+1);
        else
            root.right = insert(root.right,k,i+1);
        return root;
    }

    static class Node{
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
