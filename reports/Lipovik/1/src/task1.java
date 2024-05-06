public class task1 {
    public static void main(String[] args) {
        int[] sequence = new int[args.length];
        for(int i=0;i< args.length;i++){
            try{
                sequence[i]=Integer.parseInt(args[i]);
            }
            catch (NumberFormatException e) {
                System.out.println("wrong value!");
                return;
            }
        }
        for(int i=1;i<args.length;i++){
            if(!(sequence[0]==sequence[i])){
                System.out.println("elements of sequence are not equal");
                return;
            }
        }
        System.out.println("elements of sequence are equal");
    }
}