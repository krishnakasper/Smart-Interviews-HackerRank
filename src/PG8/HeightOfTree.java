package PG8;

import java.io.*;
import java.util.StringTokenizer;

public class HeightOfTree {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int height=0;
    public static void main(String[] args)throws IOException{

        int test = Integer.parseInt(br.readLine());
        while (test-->0){
            int num = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Node root = null;
            while (st.hasMoreTokens()){
                root = insert(root ,Integer.parseInt(st.nextToken()));
            }
            findHeight(root,0);
            bw.write(height+"\n");
            height=0;
        }
        bw.flush();
    }

    private static void findHeight(Node root,int i){
        if(root==null){
            if(i>height)
                height=i-1;
            return;
        }
        findHeight(root.left,i+1);
        findHeight(root.right,i+1);
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

