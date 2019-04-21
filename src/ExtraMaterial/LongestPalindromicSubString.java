package ExtraMaterial;

import java.io.*;

public class LongestPalindromicSubString {

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static long[] FH,BH;
    private static int mod = 1000000007;
    private static long[] pow;

    public static void main(String[] args)throws IOException {
        String input = br.readLine();
        String temp = "|";
        int j = 0;
        for (int i=0;i<2*input.length();i++){
            if(i%2==0){
                temp = temp+ input.charAt(j++);
            }
            else
                temp = temp +"|";
        }
        calculateHash(temp);
        bw.write((RollingHash(temp))+"\n");
//        bw.write(BinarySearch(temp)+"\n");
        bw.flush();

    }

    public static int BinarySearch(String input){
        int ans = 2;
        int low = 2;
        int high = input.length();
        int n = input.length();
        while (low<high){
            int mid = low+(high-low+1)/2;
            if(palindromPresent(mid)){
                low = mid;
            }
            else
            {
                high = mid-1;
            }
        }
        return low;
    }

    public static boolean palindromPresent(int size){
        int n = FH.length;
        for (int i=0;i<FH.length-size+1;i++){
            int j = i+size-1;
            if(checkPalindrome(i,j)){
                return true;
            }
        }
        return false;
    }

    public static boolean checkPalindrome(int i, int j){
        long h1,h2;
        int n = FH.length;
        if(i<=0)
            h1 = FH[j]%mod;
        else
            h1 = (FH[j] - FH[i-1]+mod)%mod;
        if(j>=n-1)
            h2 = BH[i]%mod;
        else
            h2 = (BH[i] - BH[j+1]+mod)%mod;

        int y = n-j-1;
        int x = i;
        int d = Math.abs(y-x);
        if(x>y)
            h2 = (h2*pow[d-1])%mod;
        else if(y>x)
            h1 = (h1*pow[d-1])%mod;
        if(h1==h2)
            return true;
        return false;
    }

    public static void calculateHash(String input){
        int N = input.length();
        FH = new long[N];
        BH = new long[N];
        int prime = 89;
        pow = new long[N];
        pow[0] = prime;
        for (int i=1;i<N;i++)
            pow[i] = (pow[i-1]*89)%mod;

        FH[0] = pow[0]*(input.charAt(0));
        for (int i=1;i<N;i++){
            FH[i] = (FH[i-1] + (pow[i]*(input.charAt(i)))%mod)%mod;
        }

        BH[N-1] = pow[0]*(input.charAt(N-1));
        for (int i = N-2;i>=0;i--){
            BH[i] = (BH[i+1] + (pow[N-i-1]*(input.charAt(i)))%mod)%mod;
        }
    }

    public static int RollingHash(String input){
        int N = input.length();
        int ans = 1;
        for (int i=1;i<N;i++){
            int low = 0;
            int high = Math.min(i,N-i-1);
            while (low<=high){
                int mid = low+(high-low)/2;
                if(valid(i-mid,i+mid) == 1) {
                    ans = Math.max(ans, 2 * mid + 1);
                    low = mid+1;
                }
                else
                    high = mid-1;
            }
            ans = Math.max(ans,2*low+1);
        }

        return ans;
    }

    public static int valid(int i,int j){
        long h1;
        if(i<=0)
            h1 = FH[j]%mod;
        else
            h1 = ((FH[j] - FH[i-1])+mod)%mod;

        long h2;
        if(j>=FH.length-1)
            h2 = BH[i]%mod;
        else
            h2 = (BH[i] - BH[j+1]+mod)%mod;

        int y = FH.length-j;
        int d = Math.abs(i-y);
        if(i>y)
            h2 = (h2*pow[d+1])%mod;
        else if(i<y)
            h1 = (h1*pow[d+1])%mod;
        if(h1==h2)
            return 1;
        return 0;
    }
}
