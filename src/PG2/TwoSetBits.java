package PG2;

import java.io.*;
import java.util.StringTokenizer;

public class TwoSetBits {

    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int test = Integer.parseInt(st.nextToken());

        while(test-->0){
            st = new StringTokenizer(bf.readLine());
            long num = Long.parseLong(st.nextToken());
            bw.write(findnumBruteForce(num)+"\n");
            bw.write(findOptimal(num)+"\n");

        }
        bw.flush();
    }


    private static long findnumBruteForce(long num){
        long temp=0;
        long i=0;
        for(i=1;temp+i<num;i++){
            temp+=i;
        }
        long com = num-temp;
        long result =1;
        for(long j=i;j>0;j--){
            if(j==com){
                result = (result<<1|(long)1)%1000000007;
            }
            else
                result = (result<<1)%1000000007;
        }
        return result;
    }

    private static long findOptimal(long num){
        long t = 1-(-4*2*num);
        double sqrt = Math.sqrt(t);
        long i = (long)Math.ceil((-1+sqrt)/2);
        long temp = (i*(i-1))/2;
        long i2 = num-temp;
        return (power(2,i)+power(2,i2-1))%1000000007;
    }



    public static long power(int x,long y){
        if(y==0)
            return 1;
        long temp = power(x,y/2)%1000000007;
        if(y%2==0)
            return (temp*temp)%1000000007;
        else
            return ((x*temp)%1000000007*temp)%1000000007;
    }
}
