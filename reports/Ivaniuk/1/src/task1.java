package Lab1;

import java.util.Arrays;

public class task1 {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Correct usage : java task1 <start> <end> <step>");
            return;
        }
        int start = Integer.parseInt(args[0]);
        int end = Integer.parseInt(args[1]);
        int step = Integer.parseInt(args[2]);

        int[] sequence = rep(start,end,step);
        System.out.println("Результат: "+ Arrays.toString(sequence));
    }

    public static int[] rep(int start,int end,int step){
        if(start < end ){
            int size = (end - start) / step + 1;
            int[] arr = new int[size];
            int index = 0;
            while(start<=end) {
                arr[index]=start;
                start+=step;
                index++;
            }
            return arr;
        }
        else{
            return new int[0];
        }
    }
}
