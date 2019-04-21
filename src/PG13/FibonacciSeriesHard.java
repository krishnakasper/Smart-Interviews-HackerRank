package PG13;

import java.io.*;

import java.util.HashMap;

public class FibonacciSeriesHard {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int mod = 1000000007;
    private static HashMap<Long,Long> map = null;

    public static void main(String[] args)throws IOException {
        int test = Integer.parseInt(br.readLine());

        while (test-->0){
            long n = Long.parseLong(br.readLine());
            map = new HashMap<>();
            bw.write(Optimal(n+1)+"\n");
        }
        bw.flush();
    }

    private static long Optimal(long n){
            double phi = (1 + Math.sqrt(5)) / 2;
            return (long) Math.round(power(phi, n)
                    / Math.sqrt(5));
    }

    public static double power(double x,long y){
        if(y==0)
            return 1;
        double temp = power(x,y/2)%1000000007;
        if(y%2==0)
            return (temp*temp)%1000000007;
        else
            return ((x*temp)%1000000007*temp)%1000000007;
    }

    private static long calculate(long n){
        if(n==0)
            return 0;
        if(n==1 || n==2)
            return 1;
        if(map.containsKey(n))
            return map.get(n);

        long k ;

        if((n&1)==1) {
            k = (n + 1) / 2;
            long temp = (((calculate(k)*calculate(k))%mod)+(calculate(k-1)*calculate(k-1))%mod)%mod;
            map.put(n,temp);
            return temp;
        }

        else {
            k = n/2;
            long temp = ((((2*calculate(k-1))%mod+calculate(k))%mod)*calculate(k))%mod;
            map.put(n,temp);
            return temp;
        }

    }
}
