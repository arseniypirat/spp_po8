public class Task1 {
    public static void main(String[] args) {
        int sum = 0;
        int num;
        for (String elem : args){
            num = Integer.parseInt(elem);
            if (num < 0){
                sum += num * num;
            }
        }
        System.out.println(sum);
    }
}