package PG10;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ImplementMinHeap {

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] arr=null;
    private static int index;
    private static ArrayList<Integer> list=null;

    public static void main(String[] args)throws IOException{
        int test = Integer.parseInt(br.readLine());
        arr = new int[test];
        list = new ArrayList<>();
        index=0;
        while (test-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            if(operation.equals("insert")){
//                arr[index++]=Integer.parseInt(st.nextToken());
                list.add(index++,Integer.parseInt(st.nextToken()));
                adjust();
            }
            else if(operation.equals("delMin")){
                if(index==0)
                    continue;
//                arr[0] = arr[--index];
                list.set(0,list.get(--index));
                list.set(index,0);
//                arr[index]=0;
                delete();
            }
            else {
                if(index==0)
                    bw.write("Empty\n");
                else
                    bw.write(list.get(0)+"\n");
//                    bw.write(arr[0]+"\n");
            }
        }
        bw.flush();
    }

    private static void delete(){
        int temp=0;
        while(2*temp+1<index){
            int child = 2*temp+1;
//            int source = arr[child];
            int source = list.get(child);

            if(2*temp+2<index && list.get(2*temp+2)<source){
                child=2*temp+2;
                source=list.get(child);
            }
//            if(2*temp+2<index && arr[2*temp+2]<source){
//                child=2*temp+2;
//                source=arr[child];
//            }
            if(source<list.get(temp)){
                swap(temp,child);
                temp=child;

            }
//            if(source<arr[temp]){
//                swap(temp,child);
//                temp=child;
//            }
            else
                break;
        }


    }

    private static void adjust(){
        int temp = index-1;
        while (temp!=0 && list.get(getParent(temp))>list.get(temp)){
            swap(temp,getParent(temp));
            temp = getParent(temp);
        }
//        while(temp!=0 && arr[getParent(temp)]>arr[temp]){
//            swap(temp,getParent(temp));
//            temp = getParent(temp);
//        }
    }

    private static void swap(int i, int j){
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
        int temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }

    private static int getParent(int index){
        if(index==0)
            return 0;
        return (index-1)/2;
    }


}
