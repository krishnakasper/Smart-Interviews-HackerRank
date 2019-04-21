package PG13;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class LongestPathInGraph {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static boolean[] visited;

    public static void main(String[] args)throws IOException {
        int test = Integer.parseInt(br.readLine());

        while (test-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            ArrayList[] list = new ArrayList[n+1];

            for (int i=1;i<=n;i++)
                list[i] = new ArrayList<Integer>();

            for (int i=1;i<=m;i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                list[u].add(v);
                list[v].add(u);
            }


            bw.write(BestOptimal(list,n,m)+"\n");

        }
        bw.flush();
    }

    private static int BestOptimal(ArrayList[] list,int n,int m){
        int node = BSTgetLongestNode(list,1);

        int max = BSF1(list,node);
        return Math.max(max,0);
    }

    private static int BSTgetLongestNode(ArrayList<Integer>[] list,int source){
        boolean[] visited = new boolean[list.length];
        Queue<Integer> queue = new LinkedList<>();
        ((LinkedList<Integer>) queue).add(source);
        int node=0;
        while (!queue.isEmpty()){
            int temp = ((LinkedList<Integer>) queue).pop();

            if(visited[temp])
                continue;
            visited[temp] = true;
            node = temp;
            for (int i:list[temp])
                ((LinkedList<Integer>) queue).add(i);
        }
        return node;
    }

    private static int Optimal(ArrayList[] list,int n,int m){
        int max = 0;
        for(int i=1;i<n+1;i++){
                int temp = BSF1(list,i);
                max = Math.max(max,temp);
        }
        return max;
    }

    private static int BSF1(ArrayList<Integer>[] list, int source){
        boolean[] visited = new boolean[list.length];
        Queue<Integer> queue = new LinkedList<>();
        ((LinkedList<Integer>) queue).add(source);
        ((LinkedList<Integer>) queue).add(0);
        int count=0;
        while (!queue.isEmpty()){
            int temp = ((LinkedList<Integer>) queue).pop();
            if(queue.isEmpty())
                break;
            if(temp==0 && !queue.isEmpty()) {
                ((LinkedList<Integer>) queue).add(0);
                count++;
                continue;
            }
            if(visited[temp])
                continue;
            visited[temp] = true;
            for (int i:list[temp])
                ((LinkedList<Integer>) queue).add(i);
        }
        return count-1;
    }

    private static int BruteForce(ArrayList[] list,int n,int m){
        int max = 0;
        for(int i=1;i<n+1;i++){
            for (int j=i;j<=n;j++){
                int temp = BSF(list,i,j);
                max = Math.max(max,temp);
            }
        }
        return max;
    }

    private static int BSF(ArrayList<Integer>[] list, int source, int des){
        boolean[] visited = new boolean[list.length];
        Queue<Integer> queue = new LinkedList<>();
        ((LinkedList<Integer>) queue).add(source);
        ((LinkedList<Integer>) queue).add(0);
        int count=0;

        while (!queue.isEmpty()){
            int temp = ((LinkedList<Integer>) queue).pop();
            if(queue.isEmpty())
                break;
            if(temp==0 && !queue.isEmpty()) {
                ((LinkedList<Integer>) queue).add(0);
                count++;
                continue;
            }
            if(visited[temp])
                continue;
            visited[temp] = true;
            if(temp == des)
                return count;
            for (int i:list[temp])
                ((LinkedList<Integer>) queue).add(i);
        }
        return count;
    }
}
