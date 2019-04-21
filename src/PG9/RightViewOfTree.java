package PG9;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class RightViewOfTree {
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
            height=0;
            printLeftView(root);
        }
        bw.flush();
    }

    private static HashMap<Integer,Integer> map;
    private static void printLeftView(Node root)throws IOException{
        map = new HashMap<>();
        getHeight(root,0);
        createLeftViewMap(root,0);
        for(int i=0;i<height+1;i++){
            bw.write(map.get(i)+" ");
        }
        bw.write("\n");
    }

    private static void createLeftViewMap(Node root,int depth){
        if(root==null)
            return;
        if(!map.containsKey(depth))
            map.put(depth,root.data);
        createLeftViewMap(root.right,depth+1);
        createLeftViewMap(root.left,depth+1);
    }

    private static int height=0;
    private static void getHeight(Node root, int currHeight){
        if(root==null)
            return ;
        if(currHeight>height)
            height = currHeight;
        getHeight(root.left,currHeight+1);
        getHeight(root.right,currHeight+1);
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
