package PG7;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class CollectingMangoes {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        int count=1;
        while (test-- > 0) {
            int num = Integer.parseInt(br.readLine());
            bw.write("Case "+count+++":\n");
            Stack<Integer> stack = new Stack<>();
            Stack<Integer> maxStack = new Stack<>();
            while (num-->0){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                if(s.equals("A")){
                    int t=Integer.parseInt(st.nextToken());
                    stack.push(t);
                    if(maxStack.empty())
                        maxStack.push(t);
                    else if(maxStack.peek().intValue()<=t)
                        maxStack.push(t);
                }
                else if(s.equals("R")){
                    if(stack.empty())
                        continue;
                    int t = stack.pop();
//                    if(t==maxStack.peek())
//                        maxStack.pop();
                    if(maxStack.peek().equals(t))
                        maxStack.pop();
                }
                else {
                    if(maxStack.empty())
                        bw.write("Empty\n");
                    else
                        bw.write(maxStack.peek()+"\n");
                }
            }
        }
        bw.flush();
    }
}
