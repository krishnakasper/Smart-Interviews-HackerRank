package ExtraMaterial;

import java.io.*;
import java.util.StringTokenizer;

public class SegmentTree {

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] segTree;

    public static void main(String[] args)throws IOException{
        int n =  Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i=0;
        while (st.hasMoreTokens())
            arr[i++] = Integer.parseInt(st.nextToken());
        int m;
        if(checkSetBits(n)){
            m = 2*n-1;
        }
        else {
            m = 2*getNearest2(n)-1;
        }

        segTree = new int[m];
        createSegTree(arr,0,n-1,0);
        bw.write(rangeQuery(segTree,1,2,0,n-1,0)+"\n");
        bw.flush();
    }

    private static int rangeQuery(int[] segTree,int qlow, int qhigh,int low,int high,int pos){
        if(qlow<=low && qhigh>=high)
            return segTree[pos];
        if(qhigh<low || qlow>high)
            return Integer.MAX_VALUE;
        int mid = (low+high)/2;
        return Math.min(rangeQuery(segTree,qlow,qhigh,low,mid,2*pos+1),rangeQuery(segTree,qlow,qhigh,mid+1,high,2*pos+2));
    }

    private static void createSegTree(int[] arr,int low,int high,int pos){
        if(low == high){
            segTree[pos] = arr[low];
            return;
        }
        int mid = (low+high)/2;
        createSegTree(arr,low,mid,2*pos+1);
        createSegTree(arr,mid+1,high,2*pos+2);
        segTree[pos] = Math.min(segTree[2*pos+1],segTree[2*pos+2]);
    }

    private static int getNearest2(int num){
        for (int i=31;i>=0;i--){
            if(((1<<i)&num)==1)
                return 1<<(i+1);
        }
        return 0;
    }

    private static boolean checkSetBits(int num){
        int count=0;
        for (int i=0;i<31;i++){
            if(((1<<i)&num)>=1)
                count++;
        }
        return count == 1;
    }
}
