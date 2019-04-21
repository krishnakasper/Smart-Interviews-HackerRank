package PG3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Interleavings {
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int test = Integer.parseInt(st.nextToken());
        int i=1;
        while (test-- > 0) {
            st = new StringTokenizer(bf.readLine());
            String a = st.nextToken();
            String b= st.nextToken();
//            System.out.println(count(a.length(),b.length()));
            print(a,b);
            Collections.sort(arr);
            Iterator<String> itr = arr.iterator();

            System.out.println("Case #"+i++);
            while(itr.hasNext())
                System.out.println(itr.next());
        }
    }

    private static int count(int a, int b){
        if(a<0 || b<0)
            return 0;
        if(a==1 && b==0)
            return 1;
        else if (a==0 && b==1)
            return 1;

        return count(a-1,b)+count(a,b-1);
    }
    static ArrayList<String> arr = null;
    private static void print(String a, String b){
        int i=0;
        String temp="";
        arr = new ArrayList<>();
        for(int j=0;j<a.length()+b.length();j++)
            temp=temp+" ";
        recursive(a,b,temp,a.length(),b.length(),i);

    }

    private static void recursive(String a, String b, String temp,int m, int n, int i){
        if(m==0 && n==0)
            arr.add(temp);
//            System.out.println(temp);
        else{
            if(m!=0){
                temp=temp.substring(0,i)+a.charAt(0)+temp.substring(i+1,temp.length());
                recursive(a.substring(1),b,temp,m-1,n,i+1);
            }
            if(n!=0){
                temp=temp.substring(0,i)+b.charAt(0)+temp.substring(i+1,temp.length());;
                recursive(a,b.substring(1),temp,m,n-1,i+1);
            }

        }
    }
}
