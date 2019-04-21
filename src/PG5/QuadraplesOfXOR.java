package PG5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class QuadraplesOfXOR {
    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int test = Integer.parseInt(st.nextToken());
        while(test-->0){
            st = new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[] a = new int[num];
            int[] b = new int[num];
            int[] c = new int[num];
            int[] d = new int[num];
            st = new StringTokenizer(bf.readLine());
            int i=0;
            while(st.hasMoreTokens()){
                a[i++] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(bf.readLine());
            i=0;
            while(st.hasMoreTokens()){
                b[i++] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(bf.readLine());
            i=0;
            while(st.hasMoreTokens()){
                c[i++] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(bf.readLine());
            i=0;
            while(st.hasMoreTokens()){
                d[i++] = Integer.parseInt(st.nextToken());
            }

            int[] aXORb = XORarray(a,b);
            int[] cXORd = XORarray(c,d);
            int[] countarr = countArray(cXORd);
//            for(int j:aXORb)
//                System.out.print(j+" ");
////            System.out.println(countXOR(a,b,c,d));
//            System.out.println();
//            for(int j:cXORd)
//                System.out.print(j+" ");
            System.out.println(findCount(aXORb,cXORd));
            System.out.println(find(aXORb,countarr));
        }
    }

    private static int find(int[] arr, int[] countarr){
        int count = 0;
        for(int i:arr){
            count+=countarr[i];
        }
        return count;
    }

    private static int[] countArray(int[] arr){
        int[] count = new int[1000];
        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;
        }
        return count;
    }

    private static int findCount(int[] ab, int[] cd){
        int count=0;
        for(int i:ab){
            int h = binaryceil(cd,i);
            int l = binaryfloor(cd,i);
            if(cd[h]==i && cd[l]==i)
                count+=h-l+1;
        }
        return count;
    }

    private static int binaryceil(int[] arr, int key){
        int low = 0;
        int high = arr.length-1;
        while(low<high){
            int mid = low+(high-low+1)/2;
            if(arr[mid]==key)
                low = mid;
            else if(arr[mid]<key)
                low = mid+1;
            else
                high = mid-1;
        }
        return low;
    }

    private static int binaryfloor(int[] arr, int key){
        int low = 0;
        int high = arr.length-1;
        while(low<high){
            int mid = low+(high-low)/2;
            if(arr[mid]==key)
                high = mid;
            else if(arr[mid]>key)
                high = mid-1;
            else
                low = mid+1;
        }
        return low;
    }

    public static int[] XORarray(int[] a, int[] b){
        String s = "";
        int[] arr = new int[a.length*a.length];
        int k=0;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                arr[k++] = a[i]^b[j];
            }
        }
        Arrays.sort(arr);
        return arr;
    }

    public static int countXOR(int[] a, int[] b, int[] c, int[] d){
        int count=0;
        int length = a.length;
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                for(int k=0;k<length;k++){
                    for(int l=0;l<length;l++){
                        if((a[i]^b[j]^c[k]^d[l])==0)
                            count++;
                    }
                }
            }
        }
        return count;
    }

}
