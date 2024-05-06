package Lab1;

public class task3 {
    public static void main(String[] args) {
        if(args.length!=2){
            System.out.println("Correct usage : java task3 <string> <shift>");
            return;
        }
        String str = args[0];
        int shift = Integer.parseInt(args[1]);
        System.out.println("Полученная строка : " + str);
        System.out.println("Новая строка : " + shiftRight(str, shift));
    }

    public static String shiftRight(String str, int shift) {
        if (str == null || str.isEmpty()) {
            return null;
        }

        char[] newStr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            int newIndex = (i + shift + str.length()) % str.length();
            newStr[newIndex] = str.charAt(i);
        }
        return new String(newStr);
    }
}
