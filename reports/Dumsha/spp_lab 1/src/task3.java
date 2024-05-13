class StringUtils {
    public static String stripWhitespaces(String str) {
        if (str == null || str.trim().isEmpty()) {
            return null;
        }
        return str.trim();
    }

    public static void main(String[] args) {
        System.out.println("stripWhitespaces(null) = " + stripWhitespaces(null));
        System.out.println("stripWhitespaces(\"\") = " + stripWhitespaces(""));
        System.out.println("stripWhitespaces(\" \") = " + stripWhitespaces(" "));
        System.out.println("stripWhitespaces(\" abc \") = " + stripWhitespaces(" abc "));
        System.out.println("stripWhitespaces(\" abc \") = " + stripWhitespaces(" abc "));
        System.out.println("stripWhitespaces(\" abc \") = " + stripWhitespaces(" abc "));
        System.out.println("stripWhitespaces(\" ab c \") = " + stripWhitespaces(" ab c "));
    }
}
