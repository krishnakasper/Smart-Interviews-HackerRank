package PG9;

import java.io.*;
import java.util.LinkedList;

import java.util.Queue;
import java.util.StringTokenizer;

public class IsBST {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Queue<Node> queue=null;

    public static void main(String[] args)throws IOException{
        int test = Integer.parseInt(br.readLine());
        while (test-->0)
        {
            int num = Integer.parseInt(br.readLine());
            queue = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            Node root = new Node(Integer.parseInt(st.nextToken()));
            queue.add(root);
            queue.add(null);
            while (st.hasMoreTokens()){
                Node temp = queue.remove();
                if(queue.isEmpty() && temp==null)
                    break;
                if(temp==null && !queue.isEmpty()) {
                    queue.add(null);
                    continue;
                }
                Node left = new Node(Integer.parseInt(st.nextToken()));
                Node right=null;
                if(st.hasMoreTokens())
                    right = new Node(Integer.parseInt(st.nextToken()));
                temp.left=left;
                temp.right=right;
                queue.add(left);
                if(right!=null)
                    queue.add(right);

            }

            if(checkBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE))
                bw.write("True\n");
            else
                bw.write("False\n");
        }
        bw.flush();
    }

    private static boolean checkBST(Node root, int min, int max){
        if(root==null)
            return true;
        if(root.data<min || root.data>max )
            return false;
        return checkBST(root.left,min,root.data)&&checkBST(root.right,root.data,max);
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
