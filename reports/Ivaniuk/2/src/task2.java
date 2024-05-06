package Lab2;

import java.io.*;

public class task2 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Correct Usage: task2 <lines> <filePath>");
            return;
        }
        int lines = Integer.parseInt(args[0]);
        String path = args[1];
        String[] result = head(lines,path);

        for (String str : result) {
            System.out.println(str);
        }
    }

    public static String[] head(int lines,String filePath){

        if(lines < 0 || filePath.isEmpty() || filePath == null){
            return new String[0];
        }

        String[] result = new String[lines];

        try (RandomAccessFile f = new RandomAccessFile(filePath, "r")) {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            for (int i = 0; i < lines; i++) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                result[i] = line;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }
}
