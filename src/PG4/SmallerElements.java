package PG4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SmallerElements {

    static int count=0;

    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int test = Integer.parseInt(st.nextToken());
        while(test-->0){
            st = new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[] arr = new int[num];
            st = new StringTokenizer(bf.readLine());
            int i=0;
            while(st.hasMoreTokens())
                arr[i++] = Integer.parseInt(st.nextToken());
//            count=0;
//            mergeSortBruteForce(arr,0,num-1);
//            System.out.println(count);
            count=0;
            mergeSortOptimal(arr,0,num-1);
            System.out.println(count);
        }
    }

    private static void mergeSortOptimal(int[] arr, int low, int high){
        if(low==high)
            return;
        int mid = low+(high-low)/2;
        mergeSortOptimal(arr,low,mid);
        mergeSortOptimal(arr,mid+1,high);
        mergeOptimal(arr, low, mid, high);
    }

    private static void mergeOptimal(int[] arr, int low, int mid, int high){
        int p1=low;
        int p2 = mid+1;

        while(p1<=mid && p2<=high){

            if(arr[p1]>arr[p2]){
                count+=mid-p1+1;
                p2++;

            }
            else
                p1++;
        }

        int[] temp = new int[high-low+1];
        int i=0;
        p1=low;
        p2 = mid+1;
        while(p1<=mid && p2<=high){
            if(arr[p1]<arr[p2])
                temp[i++] = arr[p1++];
            else
                temp[i++] = arr[p2++];
        }
        while(p1<=mid){
            temp[i++] = arr[p1++];
        }
        while(p2<=high ){
            temp[i++] = arr[p2++];
        }

        for(int k=0,j=low;j<=high && k<temp.length;k++,j++){
            arr[j] = temp[k];
        }
    }

    private static void mergeSortBruteForce(int[] arr, int low, int high){
        if(low==high)
            return;
        int mid = low+(high-low)/2;
        mergeSortBruteForce(arr,low,mid);
        mergeSortBruteForce(arr,mid+1,high);
        mergeBruteForce(arr, low, mid, high);
    }

    private static void mergeBruteForce(int[] arr, int low, int mid, int high){
        int[] temp = new int[high-low+1];
        int p1 = low;
        int p2 = mid+1;
        int i=0;


        for(i=low;i<=mid;i++){
            for(int j=mid+1;j<=high;j++){
                if(arr[i]>arr[j])
                    count++;
            }
        }
        i=0;
        p1=low;
        p2 = mid+1;
        while(p1<=mid && p2<=high){
            if(arr[p1]<arr[p2])
                temp[i++] = arr[p1++];
            else
                temp[i++] = arr[p2++];
        }
        while(p1<=mid){
            temp[i++] = arr[p1++];
        }
        while(p2<=high ){
            temp[i++] = arr[p2++];
        }

        for(int k=0,j=low;j<=high && k<temp.length;k++,j++){
            arr[j] = temp[k];
        }


    }
}
