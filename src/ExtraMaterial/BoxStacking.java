package ExtraMaterial;

import java.io.*;
import java.util.*;

public class BoxStacking {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)throws IOException{
        int n = Integer.parseInt(br.readLine());
        Dimensions[] arr = new Dimensions[n];
        int i=0;
        while (n-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            arr[i++] = new Dimensions(l,w,h);
        }
        Dimensions[] combinations = createCombinations(arr);
        Arrays.sort(combinations);
        int[] max = createMax(combinations);
        int[] index = new int[combinations.length];
        for (i=0;i<index.length;i++){
            index[i] = i;
        }

        for (i=1;i<index.length;i++){
            for (int j=0;j<i;j++){
                if(combinations[j].length>combinations[i].length && combinations[j].width>combinations[i].width && max[i]<max[j]+combinations[i].height){
                    max[i] = max[j]+combinations[i].height;
                    index[i] = j;
                }
            }
        }
        int ans = index[0];
        for (i=1;i<index.length;i++){
            ans = Math.max(ans,max[i]);
        }
        System.out.println(ans);
    }

    public static int[] createMax(Dimensions[] in){
        int[] max = new int[in.length];
        for (int i=0;i<in.length;i++){
            max[i] = in[i].height;
        }
        return max;
    }


    public static Dimensions[] createCombinations(Dimensions[] arr){
        int n = arr.length;
        Dimensions[] combinations = new Dimensions[3*n];
        int j=0;
        for (int i=0;i<n;i++){
            combinations[j++] = checkCreate(arr[i].height,arr[i].length,arr[i].width);
            combinations[j++] = checkCreate(arr[i].width,arr[i].length,arr[i].height);
            combinations[j++] = checkCreate(arr[i].length,arr[i].height,arr[i].width);
        }
        return combinations;
    }

    public static Dimensions checkCreate(int height,int side1,int side2){
        if(side1>=side2){
            return new Dimensions(side1,side2,height);
        }
        else
            return new Dimensions(side2,side1,height);
    }

    static class Dimensions implements Comparable<Dimensions>{
        int height;
        int width;
        int length;

        Dimensions(int length,int width,int height){
            this.height = height;
            this.width = width;
            this.length = length;
        }

        @Override
        public int compareTo(Dimensions o2) {
            if(this.length*this.width > o2.length*o2.width)
                return -1;
            else if(this.length*this.width < o2.length*o2.width)
                return 1;
            return 0;
        }
    }

    private static void permute(Integer[] arr,int index){
        if(index == arr.length){
            System.out.println(arr[0] +" "+ arr[1]+" "+arr[2]);
        }
        else{
            for (int i=index;i<arr.length;i++){
//              swap
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                permute(arr,index+1);
//              unswap
                temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
    }
}


