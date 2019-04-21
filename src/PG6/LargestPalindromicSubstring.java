package PG6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LargestPalindromicSubstring {
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int test = Integer.parseInt(st.nextToken());
        while(test-->0){
            st = new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(st.nextToken());
            String s = bf.readLine();
            //System.out.println(bruteForce(s));
            System.out.println(optimal(s));
        }
    }

    private static int optimal(String s){
        int max=1;
        int temp=0;
        if(s.length()==1)
            return 1;
        for(int i=1;i<s.length();i++){
            int p1=i;
            int p2=i;
            temp=0;
            while(p1>=0 && s.charAt(p1)==s.charAt(i)){
                p1--;
            }
            while(p2<s.length() && s.charAt(p2)==s.charAt(i)){
                p2++;
            }
            temp = p2-p1-1;
            while(p1 >= 0 && p2 < s.length()) {
                if (s.charAt(p1) == s.charAt(p2)){
                    p1--;
                    p2++;
                }
                else {
                    if(p1<0 || p2>s.length())
                        temp = p2-p1-1;
                    else
                        temp = p2 - p1 -1;
                    break;
                }
            }
            temp = p2 - p1 -1;
            if(temp>max)
                max = temp;
        }
        return max;
    }

    private static int bruteForce(String s){
        int max =0;
        int temp=0;
        if(s.length()==1)
            return 1;
            for (int i = 1; i < s.length(); i++) {
                int p1 = i - 1;
                int p2 = i + 1;
                temp = 1;
                if(s.charAt(i)==s.charAt(p1) && p2<s.length() && s.charAt(i)==s.charAt(p2)){
//                    p2--;
                    temp=1;
                }
                else if(s.charAt(i) == s.charAt(p1)){
                    p2--;
                    temp=0;
                }
                while (p1 >= 0 && p2 < s.length()) {
                    if (s.charAt(p1--) == s.charAt(p2++))
                        temp+=2;
                    else
                        break;
                }
                if (temp > max)
                    max = temp;
            }

//        else{
//            for(int i=0;i<s.length()-1;i++){
//                int p1 = i;
//                int p2 = i+1;
//                temp=0;
//                while(p1>=0 && p2<s.length()){
//                    if(s.charAt(p1--) == s.charAt(p2++))
//                        temp++;
//                }
//                if(temp>max)
//                    max = temp;
//            }
//        }
        return max;
    }
}
