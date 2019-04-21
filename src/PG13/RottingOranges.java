package PG13;

import java.io.*;
import java.util.*;

public class RottingOranges {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int mod = (int)1e9+7;
    private static int empty=0;
    private static int rotten = 2;
    private static int fresh = 1;
    private static int prime = 91;

    public static void main(String[] args)throws IOException{
        int test = Integer.parseInt(br.readLine());
        while (test-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = n;
            int[][] matrix = new int[n][m];
            for (int i=0;i<n;i++){
                String s = br.readLine();
                for (int j=0;j<m;j++)
                    matrix[i][j] = (int)s.charAt(j)-48;
            }
            int ans = Optimal(matrix,n,m);
            bw.write(ans+"\n");
        }
        bw.flush();
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

    private static int Optimal(int[][] matrix,int n,int m){
        Queue<Pair> queue = new LinkedList<Pair>();
        HashSet<Pair> set = new HashSet<>();
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if(matrix[i][j]==rotten){
                    ((LinkedList<Pair>) queue).add(new Pair(i,j));
                }
                if(matrix[i][j]==fresh){
                    set.add(new Pair(i,j));
                }
            }
        }

        int count=0;
        ((LinkedList<Pair>) queue).add(null);
        if(set.size()==0)
            return count;

        int[] xd = {-1,0,1,0};
        int[] yd = {0,-1,0,1};
        while (!queue.isEmpty() ){
            Pair temp = ((LinkedList<Pair>) queue).removeFirst();
            if(queue.isEmpty())
                break;
            if(temp==null && !queue.isEmpty()) {
                queue.add(null);
                count++;
                continue;
            }

            int i = temp.i;
            int j = temp.j;
            if(i==3 && j==1)
                empty=0;
            for (int k=0;k<4;k++){
                int x = i+xd[k];
                int y = j+yd[k];
                if(x<0 ||x>=n || y<0 ||y>=m)
                    continue;
                if(matrix[x][y]==fresh){
                    set.remove(new Pair(x,y));
                    matrix[x][y] = rotten;
                    queue.add(new Pair(x,y));
                }

            }

        }
        if(!set.isEmpty())
            return -1;
        else
            return count;
    }

    private static int calculate(int[][] matrix,int n,int m){
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();

        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if(matrix[i][j]==rotten){
                    ((LinkedList<Integer>) queue).add(calculateHashValue(i,j));
                }
                if(matrix[i][j]==fresh){
                    set.add(calculateHashValue(i,j));
                }
            }
        }
        int count=0;
        ((LinkedList<Integer>) queue).add(Integer.MIN_VALUE);
        if(set.size()==0)
            return count;

        int[] xd = {-1,0,1,0};
        int[] yd = {0,-1,0,1};
        while (!queue.isEmpty() ){
            int temp = ((LinkedList<Integer>) queue).removeFirst();
            if(queue.isEmpty())
                break;
            if(temp==Integer.MIN_VALUE && !queue.isEmpty()) {
                queue.add(Integer.MIN_VALUE);
                count++;
                continue;
            }
            int[] index = decodeHashValue(temp);
            int i = index[0];
            int j = index[1];
            if(i==3 && j==1)
                empty=0;
            for (int k=0;k<4;k++){
                int x = i+xd[k];
                int y = j+yd[k];
                if(x<0 ||x>=n || y<0 ||y>=m)
                    continue;
                if(matrix[x][y]==fresh){
                    set.remove(calculateHashValue(x,y));
                    matrix[x][y] = rotten;
                    queue.add(calculateHashValue(x,y));
                }

            }

        }
        if(!set.isEmpty())
            return -1;
        else
            return count;
    }

    private static int[] decodeHashValue(int hash){
        int[] index = new int[2];
        index[0] = hash/(prime*prime);
        index[1] = (hash-(prime*prime*index[0]))/prime;
        return index;
    }

    private static int calculateHashValue(int i,int j){
        return ((prime*prime*i)+(prime*j));
    }
}
