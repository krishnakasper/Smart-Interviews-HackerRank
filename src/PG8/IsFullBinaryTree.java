package PG8;

import java.io.*;
import java.util.StringTokenizer;

public class IsFullBinaryTree{
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean flag = true;
    public static void main(String[] args)throws IOException {
        int test = Integer.parseInt(br.readLine());
        while (test-->0){
            int num = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Node root = null;
            while (st.hasMoreTokens()){
                root = insert(root ,Integer.parseInt(st.nextToken()));
            }
            checkBinaryTree(root);
            if(!flag)
                bw.write("False\n");
            else
                bw.write("True\n");
            flag=true;
        }

        bw.flush();
    }

    private static void checkBinaryTree(Node root){
        if(!flag)
            return;
        if(root==null)
            return;
        if((root.left!=null)^(root.right!=null))
            flag=false;
        else {
            checkBinaryTree(root.left);
            checkBinaryTree(root.right);
        }
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
