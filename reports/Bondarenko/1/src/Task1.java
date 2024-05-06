public class Task1 {
    public static void main(String[] args) {
        int[] array = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            try {
                array[i] = Integer.parseInt(args[i]);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка преобразования в число: " + args[i]);
                return;
            }
        }

        boolean isEqual = true;
        for (int elem : array) {
            if (elem != array[0]) {
                isEqual = false;
                break;
            }
        }

        if (isEqual) {
            System.out.println("Равны");
        }
        else {
            System.out.println("Не равны");
        }
    }
}
