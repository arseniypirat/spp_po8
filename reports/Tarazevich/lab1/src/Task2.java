public class Task2 {
    public static void main(String[] args) {
        if (args.length == 3){
            double[][] arr = random(Double.parseDouble(args[0]),
                    Double.parseDouble(args[1]), Integer.parseInt(args[2]));
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    System.out.print(arr[i][j] + "  ");
                }
                System.out.println();
            }
        }
    }
    public static double[][] random(double a, double b, int size){
        double[][] arr = new double[size][size];
        for (int i = 0; i < size; i ++){
            for (int j = 0; j < size; j++){
                arr[i][j] = a + (Math.random() * (b - a));
            }
        }
        return arr;
    }
}
