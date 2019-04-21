package PG9;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class NodesAtDistanceK {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Node> list=null;
    static int ans;

    public static void main(String[] args)throws IOException{
        int test = Integer.parseInt(br.readLine());
        while(test-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            Node root = null;
            while(st.hasMoreTokens()){
                root = insert(root, Integer.parseInt(st.nextToken()));
            }

            ans=0;
            //bw.write(optimal1(root,s,k)+"\n");
            optimal2(root,s,k);
            bw.write(ans+"\n");

        }
        bw.flush();
    }

    private static int optimal2(Node root,int source,int distance){
        //time complexity O(N) Space complexity O(1)
        if(root==null)
            return 0;
        if(root.data==source){
            ans+=count(root,distance);
            return 1;
        }
        int l = optimal2(root.left,source,distance);
        if(l==distance){
            ans++;
            return l+1;
        }
        if(l!=0){
            ans+=count(root.right,distance-l-1);
            return l+1;
        }
        int r = optimal2(root.right,source,distance);
        if(r==distance){
            ans++;
            return r+1;
        }
        if(r!=0) {
            ans += count(root.left, distance - r-1);
            return r + 1;
        }
        return 0;

    }

    private static int optimal1(Node root,int source,int distance){
        //time complexity O(N+N) Space complexity O(N)
        list = new ArrayList<>();
        getPath(root,source);
        int ans = count(list.get(0),distance);
        for(int i=1;i<list.size();i++){
            Node temp = list.get(i);
            if(i==distance){
                ans++;
                break;
            }
            if(temp.left==list.get(i-1)){
                ans+=count(temp.right,distance-i-1);
            }
            else{
                ans+= count(temp.left,distance-i-1);
            }

        }
        return ans;
    }

    private static int count(Node root,int distance){
        if(root==null)
            return 0;
        if(distance==0)
            return 1;
        return count(root.left,distance-1)+count(root.right,distance-1);
    }

    private static void getPath(Node root, int source){
        if(root==null)
            return;
        if(root.data==source)
        {
            list.add(root);
            return;
        }
        if(list.size()==0)
        {
            getPath(root.left,source);
        }
        if(list.size()!=0){
            list.add(root);
            return;
        }
        if(list.size()==0)
            getPath(root.right,source);
        if(list.size()!=0){
            list.add(root);
            return;
        }

    }



    private static Node insert(Node root, int n){
        if(root==null)
            return new Node(n);
        if(n<root.data){
            root.left=insert(root.left,n);
        }
        else
            root.right=insert(root.right,n);
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

