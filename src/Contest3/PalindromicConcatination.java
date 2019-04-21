package Contest3;

import java.io.*;
import java.util.StringTokenizer;

public class PalindromicConcatination {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args)throws IOException{
        int test = Integer.parseInt(br.readLine());
        while (test-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            boolean ans = calculate(a,b);
            bw.write((ans)?"Yes\n":"No\n");
        }
        bw.flush();
    }

    private static boolean calculate(String a, String b){
        int[] arrayA = new int[26];
        int[] arrayB = new int[26];
        for (char ch:a.toCharArray()){
            arrayA[(int)ch-97]++;
        }

        for (char ch:b.toCharArray())
            arrayB[(int)ch-97]++;

        for (int i=0;i<26;i++){
            if(arrayA[i]>0 && arrayB[i]>0)
                return true;
        }
        return false;
    }

}
