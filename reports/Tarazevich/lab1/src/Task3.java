public class Task3 {
    public static void main(String[] args) {
        if (args.length == 1){
            System.out.println(swapStringCase(args[0]));
        }
    }
    public static String swapStringCase(String str){
        if (str == null){
            return null;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            if (Character.isUpperCase(str.charAt(i))){
                result.append(Character.toLowerCase(str.charAt(i)));
            }
            else if (Character.isLowerCase(str.charAt(i))){
                result.append(Character.toUpperCase(str.charAt(i)));
            }
            else {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }
}
