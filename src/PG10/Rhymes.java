package PG10;


import java.io.*;

public class Rhymes {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args)throws IOException {
        int num = Integer.parseInt(br.readLine());
        Node root = new Node();
        while (num-->0){
            String s = br.readLine();
            add(root,s,s.length());
        }

        int queries = Integer.parseInt(br.readLine());
        while (queries-->0){
        String s = br.readLine();

            maxSuffix(root,s);
        }
        bw.flush();

    }


    private static boolean  maxSuffix(Node root,String s)throws IOException{
        if(root==null )
            return false;
        if(s.length()==0){
            bw.write(root.max+"\n");
            return true;
        }

        String temp = s.substring(0,s.length()-1);
        boolean check = maxSuffix(root.arr[s.charAt(s.length()-1)-'a'],temp);
        if(!check){
            bw.write(root.max+"\n");
            return true;
        }
        return true;

    }



    private static void add(Node root, String s,int length){
        if(root==null)
            return;
        if(s.length()==0){
            return;
            }
        if(s.length()!=length)
            root.max = Math.max(root.max,length);
        if(s.length()!=0 && root.arr[s.charAt(s.length()-1)-'a'] == null){
            root.arr[s.charAt(s.length()-1)-'a'] = new Node();
        }
        root = root.arr[s.charAt(s.length()-1)-'a'];
        root.max = Math.max(root.max,length);
        add(root,s.substring(0,s.length()-1),length);
    }

    static class Node{
        private Node[] arr = null;
        private int max;

        Node(){
            arr = new Node[26];
            max=0;
        }
    }
}
