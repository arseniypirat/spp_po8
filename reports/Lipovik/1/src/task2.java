import java.util.Random;

public class task2 {
    public static void main(String[] args) {
        if(args.length>3){
            System.out.println("too many values!");
            return;
        }
        double a, b;
        int size;
        try{
            a = Double.parseDouble(args[0]);
            b = Double.parseDouble(args[1]);
            size = Integer.parseInt(args[2]);
        }
        catch (NumberFormatException e) {
            System.out.println("wrong value!");
            return;
        }
        if(a-b>0){
            System.out.println("first value is greater than second!");
            return;
        }
        double[][] resultArr=random(a, b, size);
        System.out.println("Result:");
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(resultArr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static double[][] random(double a, double b, int size){
        double[][] arr = new double[size][size];
        double diff = b - a;
        Random random = new Random();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                arr[i][j]=random.nextDouble(diff);
                arr[i][j]+=a;
            }
        }
        return arr;
    }
}
