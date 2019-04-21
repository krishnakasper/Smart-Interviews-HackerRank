package PG8;

import java.io.*;
import java.util.StringTokenizer;

public class BinaryTree {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args)throws IOException{
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-->0){
            int num = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Node root = null;
            while (st.hasMoreTokens()){
                root = insert(root ,Integer.parseInt(st.nextToken()));
            }
            preOrder(root);
//            System.out.println();
            bw.write("\n");
            inOrder(root);
//            System.out.println();
            bw.write("\n");
            postOrder(root);
            bw.write("\n");
            bw.write("\n");
//            System.out.println();
//            System.out.println();
        }
        bw.flush();
    }

    private static void preOrder(Node root)throws IOException{
        if(root==null)
            return;
//        System.out.print(root.data+" ");
        bw.write(root.data+" ");
        if(root.left!=null)
            preOrder(root.left);
        if(root.right!=null)
            preOrder(root.right);
    }

    private static void postOrder(Node root)throws IOException{
        if(root==null)
            return;
        if(root.left!=null)
            postOrder((root.left));
        if(root.right!=null)
            postOrder(root.right);
//        System.out.print(root.data+" ");
        bw.write(root.data+" ");
    }
    private static void inOrder(Node root)throws IOException{
        if(root==null)
            return;
        if(root.left!=null)
            inOrder(root.left);
//        System.out.print(root.data+" ");
        bw.write(root.data+" ");
        if(root.right!=null)
            inOrder(root.right);
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
