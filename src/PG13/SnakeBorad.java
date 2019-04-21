package PG13;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SnakeBorad {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args)throws IOException{
        int s = Integer.parseInt(br.readLine());
        HashMap<Integer,Integer> snakes = new HashMap<>();
        while (s-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            snakes.put(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        int l = Integer.parseInt(br.readLine());
        HashMap<Integer,Integer> ladders = new HashMap<>();
        while (l-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            ladders.put(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        bw.write(playBSF(snakes,ladders)+"\n");
        bw.flush();
    }


    public static int playBSF(HashMap<Integer,Integer> snakes,HashMap<Integer,Integer> ladders)throws IOException{
        int count=0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] visited = new boolean[10][10];
        ((LinkedList<Integer>) queue).add(1);
        ((LinkedList<Integer>) queue).add(0);
        while (!queue.isEmpty()){
            int N = queue.poll();
//            bw.write(N+"\n");
//            bw.flush();
            if(N==0 && !queue.isEmpty()){
                ((LinkedList<Integer>) queue).add(0);
                count++;
                continue;
            }
            if(N==0 && queue.isEmpty()){
                break;
            }
            if(N==100){
                return count;
            }
            if(N>100){
                continue;
            }
            int[] index = convertNToIndex(N);
            if(visited[index[0]][index[1]]){
                continue;
            }
            visited[index[0]][index[1]] = true;
            if(snakes.containsKey(N)){
                N = snakes.get(N);
            }
            if(ladders.containsKey(N)){
                N = ladders.get(N);
            }

            for (int i=1;i<7;i++){
                ((LinkedList<Integer>) queue).add(N+i);
            }

        }

        return -1;
    }

    public static int[] convertNToIndex(int N){
        N = N-1;
        int[] a = {N/10,N%10};
        return a;
    }

    public static int convertIndexToN(int i, int j){
        return (i*10)+j+1;
    }
}
