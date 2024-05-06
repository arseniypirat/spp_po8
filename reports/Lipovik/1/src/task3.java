public class task3 {
    public static void main(String[] args) {
        String str= "";
        for (String arg : args) {
            str += arg + " ";
        }
        System.out.println(swapStringCase(str));
    }

    public static String swapStringCase(String str){
        String resultStr = "";
        for(int j=0;j<str.length();j++){
            String temp = String.valueOf(str.charAt(j));
            if(temp.toUpperCase().equals(temp)){
                resultStr+=temp.toLowerCase();
            }
            else{
                resultStr+=temp.toUpperCase();
            }
        }
        return resultStr;
    }
}
