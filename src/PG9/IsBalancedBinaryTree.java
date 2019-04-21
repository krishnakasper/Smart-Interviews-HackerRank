package PG9;

import java.io.*;
import java.util.StringTokenizer;

public class IsBalancedBinaryTree {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean check;

    public static void main(String[] args)throws IOException {
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            int num = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Node root = null;
            while (st.hasMoreTokens()) {
                root = insert(root, Integer.parseInt(st.nextToken()));
            }
            check=true;
            isBalancedTree(root);
            if(check)
                bw.write("Yes\n");
            else
                bw.write("No\n");
        }
        bw.flush();
    }

    private static int isBalancedTree(Node root){
        if(root==null)
            return 0;
        int l = isBalancedTree(root.left);
        int r = isBalancedTree(root.right);
        if(Math.abs(l-r)>1)
            check=false;
        return Math.max(l,r)+1;
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
