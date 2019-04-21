package PG7;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class ReverseSentence {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        while (test-->0){
            String s = br.readLine();
            s = reverse(s);
            bw.write(s+"\n");
        }
        bw.flush();
    }

    private static String reverse(String input){
        Stack<String> st = new Stack<>();
        StringTokenizer t = new StringTokenizer(input);
        while (t.hasMoreTokens()){
            st.push(t.nextToken());
        }
        String output="";
        while(!st.empty()){
            output=output+st.pop()+" ";
        }
        return output;
    }

}
