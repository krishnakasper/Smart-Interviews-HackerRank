package PG8;

import java.io.*;
import java.util.*;

public class IsCompleteBinaryTree {

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

            if(checkBinaryTreeOptimal(root))
                bw.write("Yes\n");
            else
                bw.write("No\n");
        }

        bw.flush();
    }

    private static boolean checkBinaryTreeOptimal(Node root){

        int h = getHeight(root);
        int numberOfNodes = getNumberOfNodes(root);
        if(pow(h)>numberOfNodes)
            return false;

        return checkTreeStructure(root);

    }

    private static java.util.Queue<Node> queue=null;

    private static int pow(int height){
        int mod = 1000000007;
        int temp=1;
        while(height-->0){
            temp=(temp<<1)%mod;
        }
        return temp;
    }

    private static boolean checkTreeStructure(Node root){
        queue = new LinkedList<>();
        ((LinkedList<Node>) queue).addLast(root);
        ((LinkedList<Node>) queue).addLast(null);
        boolean check=true;
        while(!queue.isEmpty()){

            Node temp = ((LinkedList<Node>) queue).removeFirst();
            if(temp==null && !queue.isEmpty()) {
                ((LinkedList<Node>) queue).addLast(null);
                check=true;
                continue;
            }
            if(temp==null && queue.isEmpty())
                break;
            if(!check && (temp.left!=null || temp.right!=null))
                return false;
            if(temp.left==null || temp.right==null)
                check=false;
            if(temp.left==null && temp.right!=null)
                return false;
            if(temp.left!=null)
                ((LinkedList<Node>) queue).addLast(temp.left);
            if(temp.right!=null)
                ((LinkedList<Node>) queue).addLast(temp.right);

        }
        return true;
    }

    private static boolean checkStructure(Node root){
        if(root==null)
            return true;
        if(root.right!=null && root.left==null)
            return false;
        return checkStructure(root.left)&&checkStructure(root.right);
    }

    private static int getNumberOfNodes(Node root){
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;
        return getNumberOfNodes(root.left)+getNumberOfNodes(root.right)+1;
    }

    private static int getHeight(Node root){
        if(root==null)
            return -1;
        int l = getHeight(root.left);
        int r = getHeight(root.right);
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
