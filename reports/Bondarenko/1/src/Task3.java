import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        for (String arg : args)
        {
            Scanner scanner = new Scanner(System.in);
            int shift = scanner.nextInt();
            System.out.println(shiftRight(arg, shift));
        }
    }

    public static String shiftRight(String srt, int shift) {
        if (srt == null || srt.isEmpty()) {
            return srt;
        }

        int length = srt.length();
        shift = (shift % length + length) % length;

        String shiftedSubstring = srt.substring(length - shift);
        String remainingSubstring = srt.substring(0, length - shift);

        return shiftedSubstring + remainingSubstring;
    }
}
