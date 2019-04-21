package PG6;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PrimeFear {
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] check = checkPrimes(1000000);
        int[] arr = checkFearPrimes(check);
        int[] prefix = doPrefixSum(arr);
        int test = Integer.parseInt(st.nextToken());
        while (test-- > 0) {
            st = new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(st.nextToken());
//            System.out.println(prefix[num]);
            bw.write(prefix[num]+"\n");
        }
        bw.flush();
    }

    private static int[] doPrefixSum(int[] arr){
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            prefix[i]=prefix[i-1]+arr[i];
        }
        return prefix;
    }

    private static int[] checkFearPrimes(boolean[] check){
        int[] arr = new int[1000001];
        for(int i=0;i<arr.length;i++){
            if(!check[i])
            {
                arr[i] = 0;
                continue;
            }
            if(containsZero(i)){
                arr[i] = 0;
                continue;
            }
            if(!allPrime(i,check))
            {
                arr[i] = 0;
                continue;
            }
            arr[i]=1;
        }
        return arr;
    }

    private static boolean allPrime(int num, boolean[] check){
        String s = num+"";
        for(int i=1;i<s.length();i++){
            String temp = s.substring(i,s.length());
            int tnum = Integer.parseInt(temp);
            if(!check[tnum])
                return false;
        }
        return true;
    }

    private static boolean allPrimes(int num, boolean[] check){
        num=num/10;
        while(num!=0){
            if(!check[num])
                return false;
            num=num/10;

        }
        return true;
    }

    private static boolean containsZero(int num){
        String s = num+"";
        for(char ch:s.toCharArray()){
            if(ch=='0')
                return true;
        }
        return false;
    }


    private static boolean[] checkPrimes(int num){
        boolean[] check = new boolean[num+1];
        Arrays.fill(check, true);
        check[0]=false;
        check[1]=false;
        int sqrt = (int)Math.sqrt(num);
        for(int i=2;i<=sqrt;i++){
            if(!check[i])
                continue;
            for(int j=i*i;j<=num;j+=i){
                check[j]=false;
            }
        }
        return check;
    }

    private static int findCount(int num){
        boolean[] check = new boolean[num+1];
        Arrays.fill(check,true);
        int count=0;
        check[0] = false;
        check[1] = false;
        int sqrt = (int)Math.sqrt(num);
        for(int i=2;i<=sqrt;i++){
            if(!check[i])
                continue;
            int temp = i;
            int z = temp;
            boolean flag=false;
            while(z!=0)
            {
                z=z/10;
                if(z!=0 && z%10==0)
                    flag=true;
            }
            while(temp!=0 && !flag){
                int t=1;
                while(temp/t!=0)
                    t=t*10;
                t=t/10;
                temp=temp%t;
                //temp=temp/10;
                if(temp==0)
                    count++;
                if(!check[temp])
                    break;
            }
            for(int j=i*i;j<=num;j=j+i){
                check[j] = false;
            }
        }
        for(int i=sqrt+1;i<=num;i++){

            if(!check[i])
                continue;
            if(i==4632647)
            {
                int j=0;
            }
            int temp = i;
            int z = temp;
            boolean flag=false;
            while(z!=0)
            {
                z=z/10;
                if(z!=0 && z%10==0)
                    flag=true;
            }
            while(temp!=0){
                int t=1;
                while(temp/t!=0)
                    t=t*10;
                t=t/10;
                temp=temp%t;

                //temp=temp/10;
                if(temp==0)
                    count++;
                if(!check[temp])
                    break;

            }
        }

        return count;
    }
}

