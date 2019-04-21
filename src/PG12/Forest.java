package PG12;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Forest {
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

            bw.write((Optimal(list,n,m))?"Yes\n":"No\n");

        }
        bw.flush();
    }


    private static boolean Optimal(ArrayList<Integer>[] list,int n,int m){
        visited = new boolean[list.length];
        int count=0;
        for (int i=1;i<=n;i++){
            if(!visited[i])
            {
                count++;
                BSF(list,i);
            }
        }

        if(m==n-count)
            return true;
        return false;
    }

    private static boolean BruteForce(ArrayList<Integer>[] list,int n,int m){
        visited = new boolean[n+1];
        int nodes = 0;
        int edges = 0;
        boolean[] local = new boolean[n+1];
        for(int i=1;i<=n;i++){
            if(visited[i])
                continue;
            BSF(list,i);
            nodes = getDifference(visited,local);
            edges = getEdges(visited,local,list);


            for (int j=0;j<=n;j++)
                local[j] = visited[j]||local[j];

            if(nodes==1)
                continue;
            if(nodes-1!=edges){
                return false;
            }
        }
        return true;
    }

    private static int getEdges(boolean[] visited,boolean[] temp,ArrayList<Integer>[] list){
        int count=0;
        for (int i=0;i<temp.length;i++)
        {
            if(visited[i]!=temp[i])
                count+=list[i].size();
        }
        return count/2;
    }

    private static int getDifference(boolean[] visited,boolean[] temp){
        int count=0;
        for (int i=0;i<temp.length;i++)
        {
            if(visited[i]!=temp[i])
                count++;
        }
        return count;
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
