package Lab1;
import java.util.Arrays;
import java.util.Scanner;


public class task2 {
    public static void main(String[] args){
        if(args.length == 0){
            System.out.println("Correct usage : java task2 <firstEl> <secondEl> <thirdEl> ...");
            return;
        }

        double[] arr = new double[args.length];
        for(int i=0;i< args.length;i++){
            arr[i]=Double.parseDouble(args[i]);
        }
        int startIndex,endIndex;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите начальный индекс: ");
        startIndex = scanner.nextInt();
        System.out.println("Введите конечный индекс: ");
        endIndex = scanner.nextInt();

        System.out.println("Старый массив: "+ Arrays.toString(arr));
        double[] newArr = subarray(arr,startIndex,endIndex);
        System.out.println("Новый  массив: "+ Arrays.toString(newArr));
    }
    public static double[] subarray(double[] array, int startIndex, int endIndex){
        if(endIndex>startIndex && endIndex<=array.length && startIndex>=0 ){
            double[] newArray = new double[endIndex-startIndex];
            int index=0;
            for(int i=startIndex;i<endIndex;i++){
                newArray[index++]=array[i];
            }
            return newArray;
        }
        return new double[0];
    }
}
