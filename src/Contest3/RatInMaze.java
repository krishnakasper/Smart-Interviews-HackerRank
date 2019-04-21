package Contest3;

import java.io.*;
import java.util.*;

public class RatInMaze {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int mod = (int)1e9+7;

    static private int i=0;

    public static void main(String[] args)throws IOException{
        int test = Integer.parseInt(br.readLine());
        while (test-->0){
            StringTokenizer  st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Pair source = new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            Pair destination = new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

            int[][] matrix = new int[n][m];

            while (b-->0){
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                matrix[i][j] = -1;
            }
            int ans = calulate(matrix,source,destination,n,m);
            bw.write(ans+"\n");
        }
        bw.flush();
    }

    private static int[] dx = {0,-1,-1,-1,0,1,1,1};
    private static int[] dy = {-1,-1,0,1,1,1,0,-1};

//    private static boolean

    private static int calulate(int[][] matrix,Pair source, Pair destination, int n, int m){
        int count=1;
        boolean[][] visited = new boolean[n][m];
        Queue<Pair> queue = new LinkedList<>();
        ((LinkedList<Pair>) queue).add(source);
        ((LinkedList<Pair>) queue).add(null);
        visited[source.i][source.j] = true;

        Pair end = null;
        HashMap<Pair,Pair> map = new HashMap<>();

        while (!queue.isEmpty()){
            Pair temp = ((LinkedList<Pair>) queue).pop();
            if(queue.isEmpty())
                break;
            if(temp==null && !queue.isEmpty()){
                ((LinkedList<Pair>) queue).add(null);
                count++;
                continue;
            }
            if(visited[temp.i][temp.j])
                continue;
            else
                visited[temp.i][temp.j] = true;

            if(temp.i == destination.i && temp.j == destination.j)
            {
                end = destination;
                break;
            }

            for (int i=0;i<8;i++){
                ((LinkedList<Pair>) queue).add(new Pair(temp.i+dx[i],temp.j+dy[i]));
            }

        }
        if(end==null)
            return -1;
        return 0;
    }

    static class Pair{
        public int i,j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return i == pair.i &&
                    j == pair.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }
}
