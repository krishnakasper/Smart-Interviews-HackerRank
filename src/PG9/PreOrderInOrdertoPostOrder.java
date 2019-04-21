package PG9;

import java.io.*;
import java.util.StringTokenizer;

public class PreOrderInOrdertoPostOrder {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int k;

    public static void main(String[] args)throws IOException
    {
        int test = Integer.parseInt(br.readLine());
        while (test-->0)
        {
            int num = Integer.parseInt(br.readLine());
            int[] preorder = new int[num];
            int[] inorder = new int[num];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i=0;
            while(st.hasMoreTokens())
                preorder[i++]=Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            i=0;
            while (st.hasMoreTokens())
                inorder[i++]=Integer.parseInt(st.nextToken());
            BruteForce(preorder,inorder,num);
            Optimal(preorder,inorder,num);
        }
        bw.flush();
    }

    private static void Optimal(int[] preorder,int[] inorder,int num)throws IOException{
        k=0;
        printInPostOrder(preorder,inorder,0,num-1);
        bw.write("\n");
    }

    private static void printInPostOrder(int[] pre,int[] in,int low, int high)throws IOException{
        if(low>high)
            return;
        int index = search(in,pre[k++]);
        printInPostOrder(pre,in,low,index-1);
        printInPostOrder(pre,in,index+1,high);
        bw.write(in[index]+" ");
    }

    private static void BruteForce(int[] preorder,int[] inorder,int num)throws IOException{
        k=0;
        Node root = createTree(preorder,inorder,0,num-1);
        postOrder(root);
        bw.write("\n");
    }

    private static void postOrder(Node root)throws IOException{
        if(root==null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        bw.write(root.data+" ");
    }

    private static Node createTree(int[] preorder,int[] inorder,int low,int high){
        if(low>high)
            return null;
        int index = search(inorder,preorder[k++]);
        Node root = new Node(inorder[index]);
        root.left = createTree(preorder,inorder,low,index-1);
        root.right = createTree(preorder,inorder,index+1,high);
        return root;
    }

    private static int search(int[] inorder,int key){
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==key)
                return i;
        }
        return 0;
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
