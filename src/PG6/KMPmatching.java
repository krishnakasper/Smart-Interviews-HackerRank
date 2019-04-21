package PG6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KMPmatching {

    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int test = Integer.parseInt(st.nextToken());
        while(test-->0){
            st = new StringTokenizer(bf.readLine());
            String pattern = st.nextToken();
            String text = st.nextToken();
            System.out.println(findCount(pattern, text));
        }
    }

    private static int findCount(String pattern, String text){
        int count=0;
        int[] failureArray = failureFunction(pattern);
        int j=0;
        for(int i=0;i<text.length();i++){

            if(text.charAt(i)==pattern.charAt(j))
                j++;
            else{
                if(j>0) {
                    j = failureArray[j - 1];
                    i--;
                }
                else
                    j=0;
            }

            if(j==pattern.length()){
                count++;
                j=failureArray[j-1];
            }
        }
        return count;
    }

    private static int[] failureFunction(String pattern){
        int[] failureArray = new int[pattern.length()];
        failureArray[0] = 0;
        int i=1;
        int j=0;
        while(i<failureArray.length){
            if(pattern.charAt(i)==pattern.charAt(j)){
                failureArray[i] = j+1;
                i++;
                j++;
            }
            else{
                while(j>0){
                        j = failureArray[j - 1];
                        if (j == 0 && pattern.charAt(j) != pattern.charAt(i)) {
                            failureArray[i] = 0;
//                            i++;
                            break;
                        }
                        if (pattern.charAt(j) == pattern.charAt(i)) {
                            failureArray[i] = j + 1;
                            j++;
//                            i++;
                            break;
                        }

                }
                i++;
            }
        }

        return failureArray;
    }
}
