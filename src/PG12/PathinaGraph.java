package PG12;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PathinaGraph {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args)throws IOException {
        int test = Integer.parseInt(br.readLine());
        int count=1;
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

            int q = Integer.parseInt(br.readLine());
            bw.write("Test Case #"+count+++"\n");
            while (q-->0){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
//                bw.write(BSF(list,s,d)?"Yes\n":"No\n");
                bw.write(DSF(list,s,d,new boolean[list.length])?"Yes\n":"No\n");
            }

        }
        bw.flush();
    }

    private static boolean BSF(ArrayList<Integer>[] list, int source, int des){
        boolean[] visited = new boolean[list.length];
        Queue<Integer> queue = new LinkedList<>();
        ((LinkedList<Integer>) queue).push(source);
        while (!queue.isEmpty()){
            int temp = ((LinkedList<Integer>) queue).pop();
            if(visited[temp])
                continue;
            visited[temp] = true;
            if(temp == des)
                return true;
            for (int i:list[temp])
                ((LinkedList<Integer>) queue).push(i);
        }
        return false;
    }

    private static boolean DSF(ArrayList<Integer>[] list,int source,int des, boolean[] visited){
        if(visited[source])
            return false;
        visited[source]=true;
        if(source==des)
            return true;

        ArrayList<Integer> temp = list[source];
        for (int i:temp) {
            if (DSF(list, i, des, visited))
                return true;

        }
        return false;
    }
}
