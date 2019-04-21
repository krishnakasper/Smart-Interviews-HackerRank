package PG6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SubsequenceSum {
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int test = Integer.parseInt(st.nextToken());
        while (test-- > 0) {
            st = new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[] arr = new int[num];
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int i=0;
            st = new StringTokenizer(bf.readLine());
            while(st.hasMoreTokens()){
                arr[i++] = Integer.parseInt(st.nextToken());
            }
//            System.out.println(findBruteForce(arr,a,b));
//            System.out.println(findOptimal(arr,a,b));
            System.out.println(findOptimal1(arr,a,b));
        }
    }

    private static int findOptimal(int[] arr, int a, int b){
        int mid = arr.length/2;
        int[] com1 = findCombinations(arr,0, mid);
        int[] com2 = findCombinations(arr,mid+1,arr.length-1);
        int count=0;

        Arrays.sort(com2);
        for(int i=0;i<com1.length;i++){
            int lower = a-com1[i];
            int tlower = lower;
            int higher = b-com1[i];
            int thigher = higher;
            int low;
            int high;
            while(true){
                low = binaryfloor(com2,lower);
                if(lower>thigher)
                {
                    lower = Integer.MAX_VALUE;
                    break;
                }
                if(low>=0 && com2[low]==lower)
                    break;
                else
                    lower++;
            }
            while(true){
                high = binaryceil(com2,higher);
                if(higher<tlower){
                    higher = Integer.MAX_VALUE;
                    break;
                }
                if(high<com2.length && com2[high]==higher)
                    break;
                else
                    higher--;
            }

            if(lower == Integer.MAX_VALUE && higher == Integer.MAX_VALUE){
                continue;
            }
            else if(lower == Integer.MAX_VALUE){
                int temp1 = binaryceil(com2,higher);
                int temp2 = binaryfloor(com2,high);
                count+=temp1-temp2+1;
            }
            else if(higher == Integer.MAX_VALUE){
                int temp1 = binaryceil(com2,lower);
                int temp2 = binaryfloor(com2,lower);
                count+=temp1-temp2+1;
            }
            else
                count+=high-low+1;
        }
        return count;
    }

    private static int findOptimal1(int[] arr, int a, int b){
        int mid = arr.length/2;
        int[] com1 = findCombinations(arr,0, mid);
        int[] com2 = findCombinations(arr,mid+1,arr.length-1);
        int count=0;

        Arrays.sort(com2);
        for(int i=0;i<com1.length;i++){
            int lower = a-com1[i];
            int tlower = lower;
            int higher = b-com1[i];
            int thigher = higher;
            int low;
            int high;

            low = binaryfloor(com2,lower);
            if(low<0)
                low=0;
            else if(com2[low] >= lower){
                low = low;
            }
            else
                low=low+1;

            high = binaryceil(com2,higher);
            if(high>=com2.length)
                high = com2.length-1;
            else if(com2[high]<=higher)
                high=high;
            else
                high = high-1;
            if(low<=high){
                count+=high-low+1;
            }

        }
        return count;
    }

    private static int[] findCombinations(int[] arr,int i, int j){
        int length = j-i+1;
        int[] com = new int[(1<<length)];
        for(int k=0;k<(1<<length);k++){
            int sum=0;
            for(int m=0;m<length;m++){
                if(checkBit(k,m))
                    sum+=arr[i+m];
            }
            com[k] = sum;
        }
        return com;
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


    private static int findBruteForce(int[] arr,int a, int b){
        int length = arr.length;
        int count=0;
        for(int i=0;i<(1<<length);i++){
            int sum=0;
            for(int j=0;j<length;j++){
                if(checkBit(i,j))
                    sum+=arr[j];
            }
            if(sum>=a && sum<=b)
                count++;
        }

        return count;
    }

    private static boolean checkBit(int i, int j){
        if(((1<<j)&i)>0)
            return true;
        return false;
    }
}
