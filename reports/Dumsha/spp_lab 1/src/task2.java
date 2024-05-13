import java.util.Scanner;

class ArrayFlattener {
    public static double[] flatten(double[][] array) {
        int size = 0;
        for (double[] subArray : array) {
            size += subArray.length;
        }

        double[] flatArray = new double[size];
        int index = 0;
        for (double[] subArray : array) {
            for (double element : subArray) {
                flatArray[index++] = element;
            }
        }

        return flatArray;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество строк в двумерном массиве: ");
        int rows = scanner.nextInt();

        double[][] array = new double[rows][];
        for (int i = 0; i < rows; i++) {
            System.out.print("Введите количество элементов в строке " + (i + 1) + ": ");
            int cols = scanner.nextInt();
            array[i] = new double[cols];

            System.out.print("Введите элементы строки " + (i + 1) + ": ");
            for (int j = 0; j < cols; j++) {
                array[i][j] = scanner.nextDouble();
            }
        }

        double[] flatArray = flatten(array);
        System.out.print("Одномерный массив: ");
        for (double element : flatArray) {
            System.out.print(element + " ");
        }
    }
}
