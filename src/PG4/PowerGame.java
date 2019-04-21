package PG4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PowerGame {

    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int test = Integer.parseInt(st.nextToken());
        while (test-- > 0) {
            st = new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[] a=new int[num];
            int[] b=new int[num];
            st = new StringTokenizer(bf.readLine());
            int i=0;
            while(st.hasMoreTokens())
                a[i++] = Integer.parseInt(st.nextToken());
            i=0;
            st = new StringTokenizer(bf.readLine());
            while(st.hasMoreTokens())
                b[i++] = Integer.parseInt(st.nextToken());
            System.out.println(findWinOfAOptimal(a,b));
        }
    }

    private static int findWinOfAOptimal(int[] a, int[] b){
        int count=0;
        int p1=0;
        int p2=0;
        Arrays.sort(a);
        Arrays.sort(b);
        while (p1<a.length && p2<b.length){
            if(a[p1]>b[p2]){
                count++;
                p1++;
                p2++;
            }
            else
                p1++;
        }

        return count;
    }

    private static int findWinOfA(int[] a, int[] b){
        int count=0;
        int p1=0;
        int p2=0;
        int temp=0;
        while(p1<a.length && p2<b.length){
            if(a[p1]>b[p2])
            {
                p1++;
                p2++;
                count++;
                temp=p1;
            }
            else{
                p1++;
            }
            if(p1==a.length && p2!=b.length){
                p1=temp;
                p2++;
            }

        }

        return count;
    }
}
