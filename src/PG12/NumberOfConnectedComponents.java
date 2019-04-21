package PG12;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NumberOfConnectedComponents {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static boolean[] visited;

    public static void main(String[] args)throws IOException {
        int test = Integer.parseInt(br.readLine());

        while (test-->0){
            int count=0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            ArrayList[] list = new ArrayList[n+1];
            visited = new boolean[list.length];

            for (int i=1;i<=n;i++)
                list[i] = new ArrayList<Integer>();
            for (int i=1;i<=m;i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                list[u].add(v);
                list[v].add(u);
            }

            for (int i=1;i<=n;i++){
                if(!visited[i])
                {
                    count++;
                    BSF(list,i);
                }
            }
            bw.write(count+"\n");
        }
        bw.flush();
    }

    private static boolean BSF(ArrayList<Integer>[] list, int source){
        Queue<Integer> queue = new LinkedList<>();
        ((LinkedList<Integer>) queue).push(source);
        while (!queue.isEmpty()){
            int temp = ((LinkedList<Integer>) queue).pop();
            if(visited[temp])
                continue;
            visited[temp] = true;
            for (int i:list[temp])
                ((LinkedList<Integer>) queue).push(i);
        }
        return false;
    }

    private static boolean DSF(ArrayList<Integer>[] list,int source){
        if(visited[source])
            return false;
        visited[source]=true;

        ArrayList<Integer> temp = list[source];
        for (int i:temp) {
            if (DSF(list, i))
                return true;

        }
        return false;
    }
}
