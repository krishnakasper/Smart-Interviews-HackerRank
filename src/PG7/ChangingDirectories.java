package PG7;

import java.io.*;
import java.util.ListIterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class ChangingDirectories {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        while (test-->0){
            int num = Integer.parseInt(br.readLine());
            Stack<String> stack = new Stack<>();
            while(num-->0){
                String s = br.readLine();
                if(s.equals("pwd"))
                {
//                    Stack<String> temp = (Stack<String>)stack.clone();
                    String ans = "/";
                    ListIterator<String> list =  stack.listIterator();
                    while(list.hasNext())
                        ans+=list.next()+"/";
                    bw.write(ans+"\n");
                }
                else
                {
                    String temp = s.substring(3,s.length());
                    StringTokenizer st = new StringTokenizer(temp,"/");
                    if(temp.charAt(0)=='/'){
                        stack.clear();
                        while(st.hasMoreTokens())
                        {
                            String t = st.nextToken();
                            if(t.equals(".."))
                                stack.pop();
                            else
                                stack.push(t);
                        }

                    }
                    else
                    {
                        while(st.hasMoreTokens())
                        {
                            String t = st.nextToken();
                            if(t.equals(".."))
                                stack.pop();
                            else
                                stack.push(t);
                        }
                    }
                }
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
