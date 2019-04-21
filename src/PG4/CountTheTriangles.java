package PG4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CountTheTriangles {
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
            while(st.hasMoreTokens()){
                arr[i++] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            System.out.println(countTrianglesBruteForce(arr));
            System.out.println(countTrianglesOptimal(arr));
        }
    }

    private static int countTrianglesOptimal(int[] arr){
        int count=0;
        int length = arr.length;

        for(int i=0;i<length-2;i++){
            int k = i+2;
            for(int j=i+1;j<=k;j++){
                while(k<length && arr[i]+arr[j]>arr[k])
                    k++;
                if(k>j)
                    count+= k-j-1;
            }

        }
        return count;
    }

    private static int binaryceil(int[] arr, int l,int key){
        int low = l;
        int high = arr.length-1;
        while(low<high){
            int mid = low+(high-low)/2;
            if(arr[mid] == key)
                return mid;
            else if(arr[mid]>key)
                high = mid;
            else
                low = mid+1;
        }
        return low;
    }

    private static int binaryfloor(int[] arr,int l, int key){
        int low = l;
        int high = arr.length-1;
        while(low<high){
            int mid = low+(high-low+1)/2;
            if(arr[mid] == key)
                return mid;
            else if(arr[mid]<key)
                low = mid;
            else
                high = mid-1;
        }
        return low;
    }

    private static int countTrianglesBruteForce(int[] arr){
        int count=0;
        int length = arr.length;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                for(int k=j+1;k<length;k++){
                    if(arr[i]+arr[j]>arr[k] && arr[i]+arr[k]>arr[j] && arr[j]+arr[k]>arr[i])
                        count++;
                }
            }
        }
        return count;
    }
}
