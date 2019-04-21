package PG8;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class VerticalOrderOfTree{
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int lowlevel = 0;
    static int highlevel = 0;
    static HashMap<Integer, ArrayList<Integer>> map=null;
    public static void main(String[] args)throws IOException {
        int test = Integer.parseInt(br.readLine());
        while (test-->0){
            map = new HashMap<>();
            int num = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Node root = null;
            while (st.hasMoreTokens()){
                root = insert(root ,Integer.parseInt(st.nextToken()));
            }
            checkTree(root,0);
            for(int i=lowlevel;i<=highlevel;i++){
                ArrayList<Integer> temp = map.get(i);
                for(int j=0;j<temp.size();j++){
                    bw.write(temp.get(j)+" ");
                }
                bw.write("\n");
            }
            bw.write("\n");
            lowlevel=0;
            highlevel=0;
        }

        bw.flush();
    }
    private static void checkTree(Node root, int i){
        if(root==null)
            return;
        if(i<lowlevel)
            lowlevel=i;
        if(i>highlevel)
            highlevel=i;
        checkTree(root.left, i-1);
        if(map.containsKey(i)) {
            ArrayList<Integer> temp = map.get(i);
            temp.add(root.data);
            map.put(i,temp);
        }
        else {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(root.data);
            map.put(i,temp);
        }

        checkTree(root.right,i+1);

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
