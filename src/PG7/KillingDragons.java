package PG7;

import java.io.*;
import java.util.StringTokenizer;

public class KillingDragons {

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)throws IOException{
        int test = Integer.parseInt(br.readLine());
        while (test-->0){
            int num = Integer.parseInt(br.readLine());
            int[] dragon = new int[num];
            int[] vessel = new int[num];
            int i=0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens())
                dragon[i++] = Integer.parseInt(st.nextToken());
            i=0;
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens())
                vessel[i++] = Integer.parseInt(st.nextToken());
            int totaldragon = totalSum(dragon);
            int totalvessel = totalSum(vessel);
            if(totaldragon>totalvessel){
                bw.write("-1\n");
            }
            else
            {
                int currVessel = 0;
                int currDragon = 0;
                int position = 0;

                for(i=0;i<dragon.length;i++){
                    currDragon+=dragon[i];
                    currVessel+=vessel[i];
                    if(currDragon>currVessel){
                        currDragon=0;
                        currVessel=0;
                        position=i+1;
                    }
                }
                if(currDragon>currVessel)
                    bw.write("-1\n");
                else
                    bw.write((position+1)+"\n");
            }
        }
        bw.flush();
    }

    private static int totalSum(int[] arr)
    {
        int total=0;
        for(int i=0;i<arr.length;i++)
            total+=arr[i];
        return total;
    }
}
