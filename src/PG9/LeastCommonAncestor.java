package PG9;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LeastCommonAncestor {

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<Integer> list1,list2;

    public static void main(String[] args)throws IOException {
        int test = Integer.parseInt(br.readLine());
        while (test-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int queries = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            Node root = null;
            while (st.hasMoreTokens()){
                root = insert(root ,Integer.parseInt(st.nextToken()));
            }

            while(queries-->0){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                solve(root,u,v);
            }
            bw.write("\n");
        }
        bw.flush();
    }


    private static void solve(Node root,int u, int v)throws IOException
    {
        list1 = new ArrayList<>();
        createList(root,u);
        list2 = list1;
        list1 = new ArrayList<>();
        createList(root,v);
        int i=0;
        int temp=Integer.MIN_VALUE;
        while( i<list1.size() && i<list2.size()&&list1.get(i).equals(list2.get(i))){
            temp = list1.get(i++);
        }
        if(temp==Integer.MIN_VALUE)
            bw.write(root.data+" ");
        else
            bw.write(temp+" ");
    }

    private static void createListReverse(Node root, int key){
        if(root==null)
            return;
        if(root.data==key)
        {
            list1.add(root.data);

        }
        else if(root.data<key)
        {
            createList(root.right,key);
            list1.add(root.data);
        }
        else
        {
            createList(root.left,key);
            list1.add(root.data);
        }
    }

    private static void createList(Node root, int key){
        if(root==null)
            return;
        if(root.data==key)
        {
            list1.add(root.data);

        }
        else if(root.data<key)
        {
            list1.add(root.data);
            createList(root.right,key);
        }
        else
        {
            list1.add(root.data);
            createList(root.left,key);
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

