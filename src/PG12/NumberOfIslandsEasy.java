package PG12;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NumberOfIslandsEasy {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] matrix;
    private static boolean[] visited;

    public static void main(String[] args)throws IOException {
        int test = Integer.parseInt(br.readLine());

        while (test-->0){
            int count=0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            matrix = new int[n][m];

            for (int i=0;i<n;i++){
                String s = br.readLine();
                for (int j=0;j<m;j++)
                    matrix[i][j] = (int)s.charAt(j)-48;
            }

            for (int i=0;i<n;i++){
                for (int j=0;j<m;j++){
                    if(matrix[i][j]==1){
                        count++;
                        DSF(i,j);
                    }
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

    private static void DSF(int n,int m){
        if(n<0 || m<0 ||n>=matrix.length || m>=matrix[0].length)
            return;
        if(matrix[n][m]==0)
            return;

        matrix[n][m] = 0;
        DSF(n-1,m);
        DSF(n-1,m-1);
        DSF(n-1,m+1);
        DSF(n+1,m);
        DSF(n+1,m+1);
        DSF(n+1,m-1);
        DSF(n,m+1);
        DSF(n,m-1);

    }
}
