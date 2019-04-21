package PG6;

import java.io.*;


public class LargestPalindromicSubstringHard {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args)throws IOException{
        int test = Integer.parseInt(br.readLine());
        while (test-->0){
            int num = Integer.parseInt(br.readLine());
            String input = br.readLine();
            String output = getLongestPalindrome(input);
            int max = output.length();
            bw.write(max+"\n");
        }
        bw.flush();
    }

    public static String getLongestPalindrome(String str)

    {

        /** preprocess string **/

        char[] s = preProcess(str).toCharArray();

        int N = s.length;

        int[] p = new int[N + 1];

        int id = 0, mx = 0;

        for (int i = 1; i < N - 1; i++)

        {

            p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 0;

            while (s[i + 1 + p[i]] == s[i - 1 - p[i]])

                p[i]++;

            if (i + p[i] > mx)

            {

                mx = i + p[i];

                id = i;

            }

        }

        /** length of largest palindrome **/

        int maxLen = 0;

        /** position of center of largest palindrome **/

        int centerIndex = 0;

        for (int i = 1; i < N - 1; i++)

        {

            if (p[i] > maxLen)

            {

                maxLen = p[i];

                centerIndex = i;

            }

        }

        /** starting index of palindrome **/

        int pos = (centerIndex - 1 - maxLen)/2;

        return str.substring(pos , pos + maxLen);

    }

    public static String preProcess(String str)

    {

        int len = str.length();

        if (len == 0)

            return "^$";

        String s = "^";

        for (int i = 0; i < len; i++)

            s += "#" + str.charAt(i);

        s += "#$";

        return s;

    }

    private static int findLargestPalindromicSubstring(String input){
        int[] L = new int[input.length()];
        L[0]=0;
        L[1]=1;
        int center=1;
        int centerRight=L[center]+center;
        int centerLeft=center-L[center];
        int currRight;
        int currLeft;
        int diff;
        int expand;

        for(int i=2;i<L.length;i++){
            currRight=i;
            expand=0;
            currLeft = 2*center-currRight;
            diff = centerRight-currRight;
            if(diff>0){
                if(L[currLeft]<diff){
                    L[currRight] = L[currLeft]/2;
                }
                else if(L[currLeft]==diff && centerRight==L.length){
                    L[currRight] = L[currLeft]/2;
                }
                else if(L[currLeft]==diff && centerRight<L.length){
                    expand=1;
                    L[currRight] = L[currLeft]/2;
                }
                else{
                    expand=1;
                    L[currRight] = diff;
                }

            }
            else {
                L[i]=0;
                expand=1;
            }
            if(expand==1){
                center = currRight;
                int p1=center-(L[center]/2)-1;
                int p2 = center+(L[center]/2)+1;
                while(p1>-1 && p2<input.length() && (p2%2==0 ||input.charAt(p1)==input.charAt(p2))){
                    p1--;
                    p2++;
                }
                L[center] = (p2-p1-1);


            }



            if (i + (L[i]/2) > centerRight)
            {
                center = i;
                centerRight = i + (L[i]/2);
            }

        }

        return findMax(L)/2;
    }

    private static int findMax(int[] arr){
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max)
                max=arr[i];
        }
        return max;
    }
}
