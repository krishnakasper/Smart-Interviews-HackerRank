package PG3;

import java.io.*;
import java.util.StringTokenizer;

public class FallingFootballs {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] position=null;

    public static void main(String[] args)throws IOException{
        int test=Integer.parseInt(br.readLine());
        int count=1;
        while (test-->0){
            int num = Integer.parseInt(br.readLine());
            int[] arr = new int[num];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i=0;
            while (st.hasMoreTokens())
                arr[i++] = Integer.parseInt(st.nextToken());

            bw.write("Case "+count+++":\n");
            findFinalPosition(arr);
        }
        bw.flush();
    }

    private static void findFinalPosition(int[] arr)throws IOException{
        position = new int[5][41];
        for(int i=0;i<arr.length;i++){
            dropball(arr[i]+10,4);
        }
        printFootballs();
        return;
    }

    private static void printFootballs()throws IOException{
        int left = findStart();
        int right = findEnd();
        int height = findheight();
        String s="";
        for(int i=height;i>=0;i--){
            for(int j=left;j<=right;j++){
                if(position[i][j]==0)
                    s+=".";
                else
                    s+="O";
            }
            s+="\n";
        }
        bw.write(s);
    }

    private static int findheight(){
        for (int i=position.length-1;i>=0;i--){
            for(int j=0;j<position[i].length;j++){
                if(position[i][j]==1)
                    return i;
            }
        }
        return 0;
    }

    private static int findEnd(){
        for (int i=40;i>=0;i--){
            if(position[0][i]==1)
                return i;
        }
        return 0;
    }

    private static int findStart(){
        for(int i=0;i<position[0].length;i++){
            if(position[0][i]==1)
                return i;
        }
        return 40;
    }

    private static void dropball(int index,int height){
        if(height==0){
            position[height][index]=1;
            return;
        }
        if(position[height-1][index]==0){
            dropball(index,height-1);
        }
        else{
            if(position[height-1][index-1]!=0 && position[height-1][index+1]!=0){
                position[height][index]=1;
                return;
            }
            else if(position[height-1][index-1]==0 && position[height-1][index+1]==0){
                dropball(index+1,height-1);
//                position[height-1][index+1]=1;
                return;
            }
            else if(position[height-1][index-1]!=0 && position[height-1][index+1]==0){
                dropball(index+1,height-1);
//                position[height-1][index+1]=1;
                return;
            }
            else{
                dropball(index-1,height-1);
//                position[height-1][index-1]=1;
                return;
            }
        }
    }
}
