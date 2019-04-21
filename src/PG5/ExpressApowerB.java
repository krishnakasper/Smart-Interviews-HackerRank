package PG5;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ExpressApowerB {
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int test = Integer.parseInt(st.nextToken());
        Set<Long> map = findallpow(10000000);
        while (test-- > 0) {

            int num = Integer.parseInt(bf.readLine());

            if (map.contains((long) num))
                bw.write("Yes\n");

            else
                bw.write("No\n");
            bw.flush();
        }
    }

    private static boolean findpowBruteForce(int num){
        boolean flag=false;
            for(int i=2;i*i<=num;i++){
                int temp = num;
                int count=0;
                while(temp%i==0 && temp>1){
                    temp=temp/i;
                    count++;
                }
                if(temp==1 && count>1)
                    flag=true;
            }
            return flag;
    }

    private static Set<Long> findallpow(int num){
        Set<Long> map = new HashSet<Long>();
        int sqrt = (int)Math.sqrt(num);
        for(int i=2;i<=sqrt;i++){
            long temp=0;
            int j=2;
            while(temp<=num){
                temp = (long)Math.pow(i,j++);
                if(temp>num)
                    break;
                map.add(temp);
            }
        }
        return map;
    }

    private static boolean findpowOptimal(int num){
        for(int i=2;i<=Math.sqrt(num);i++){
            double val = Math.log(num)/Math.log(i);
            System.out.println("val "+val);
            if(val-(int)val<0.000001)
                return true;
        }
        return false;
    }

}
