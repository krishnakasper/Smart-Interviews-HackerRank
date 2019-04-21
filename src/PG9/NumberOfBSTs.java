package PG9;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class NumberOfBSTs {

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Queue<Node> queue=null;
    private static int count;

    public static void main(String[] args)throws IOException {
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
            count=0;
            setMinMax(root);
            checkBST1(root);
//            BruteForce(root);
            bw.write(count+"\n");
        }
        bw.flush();
    }

    private static void BruteForce(Node root){
        if(root==null)
            return;
        BruteForce(root.left);
        BruteForce(root.right);
        if(isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE))
            count++;
    }

    private static boolean isBST(Node root, int min, int max){
        if(root==null)
            return true;
        if(root.data<min || root.data>max )
            return false;
        return isBST(root.left,min,root.data)&&isBST(root.right,root.data,max);
    }

    private static void check(Node root){
        if(root==null)
            return;

        int max = getMax(root.left);
        int min = getMin(root.right);
        if(max<=root.data && min>=root.data)
            count++;
        check(root.left);
        check(root.right);
    }

    private static void setMinMax(Node root){
        if(root==null)
            return;
        setMinMax(root.left);
        setMinMax(root.right);
        if(root.left==null)
            root.max=root.data;
        else
            root.max=Math.max(root.left.min,root.left.max);
        if(root.right==null)
            root.min=root.data;
        else
            root.min = Math.max(root.right.max,root.right.min);
    }

    private static int getMin(Node root){
        if(root==null)
            return Integer.MAX_VALUE;
        while(root.left!=null)
            root=root.left;
        return root.data;
    }

    private static int getMax(Node root){
        if(root==null)
            return Integer.MIN_VALUE;
        while(root.right!=null)
            root = root.right;
        return root.data;
    }

    private static boolean checkBST1(Node root){
        if(root==null)
            return true;

        boolean temp1 = checkBST1(root.left);
        boolean temp2 = checkBST1(root.right);
        if(temp1 &&temp2&&(root.max<=root.data)&&(root.min>=root.data)){
            count++;
            return true;
        }
        return false;
    }

    private static boolean checkBST(Node root, int min, int max){
        if(root==null)
            return true;
        if(root.left==null && root.right==null && root.data>min && root.data<max)
            return true;

        if(root.data<min || root.data>max )
            return false;
        if(root.left!=null && root.right==null)
        {
            boolean temp1 = checkBST(root.left,min,root.data);
            if(temp1)
                count++;
            return temp1;
        }
        if(root.left==null && root.right!=null)
        {
            boolean temp2 = checkBST(root.right,root.data,max);
            if(temp2)
                count++;
            return temp2;
        }

        boolean temp1 = checkBST(root.left,min,root.data);
        if(temp1)
            count++;
        boolean temp2 = checkBST(root.right,root.data,max);
        if(temp2)
            count++;
        return temp1&&temp2;
    }


    private static class Node{
        private int data;
        private int max;
        private int min;
        private Node left;
        private Node right;

        Node(int k){
            data = k;
            left=null;
            right=null;
            max=0;
            min=0;
        }
    }
}
