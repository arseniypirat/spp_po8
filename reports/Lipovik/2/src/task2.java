import java.io.*;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) throws IOException {
        int linesNum=-1;
        int bytesNum = -1;
        String prefix = "x";
        String fileNameSequence = "abcdefghijklmnopqrstuvwxyz";
        String fileName = "";
        for(int i=0;i<args.length;i++){
            if(args[i].contains("-b=") || args[i].contains("--bytes=")){
                String[] temp = args[i].split("=")[1].split("[0-9]");
                String size = temp[temp.length-1];
                if(size.equals("b")){
                    bytesNum = Integer.parseInt(args[i].split("=")[1].split("b")[0]);
                }
                else if(size.equals("k")){
                    bytesNum = Integer.parseInt(args[i].split("=")[1].split("k")[0])*1000;

                }
                else if(size.equals("m")){
                    bytesNum = Integer.parseInt(args[i].split("=")[1].split("m")[0])*1000000;
                }
            }
            else if(args[i].contains("-l=") || args[i].contains("--lines=")){
                linesNum=Integer.parseInt(args[i].split("=")[1]);
            }
            else if(args[i].contains("-d")||args[i].contains("--numericsuffixes")){
                fileNameSequence="";
            }
            else if(new File(args[i]).exists()){
                fileName=args[i];
            }
            else{
                prefix=args[i];
            }
        }
        if(bytesNum==-1 && linesNum==-1){
            linesNum=10;
        }
        if(fileName.isEmpty()){
            String line="";
            String text="";
            Scanner scanner=new Scanner(System.in);
            while(!line.equals("#")){
                text+=line;
                if(!text.isEmpty()){
                    text+="\n";
                }
                line= scanner.nextLine();
            }
            fileName=prefix+".txt";
            FileWriter writer = new FileWriter(fileName, false);
            writer.write(text);
            writer.flush();
        }

        String text="";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        if(bytesNum==-1){
            String line;
            int counter=linesNum;
            int fileCounter=0;
            while(counter==linesNum){
                counter=0;
                while ( counter<linesNum && (line = reader.readLine()) != null) {
                    text +=line+"\n";
                    counter++;
                }
                if(text.equals("")){
                    break;
                }
                FileWriter writer = new FileWriter(createFileName(prefix,fileNameSequence,fileCounter), false);
                writer.write(text);
                writer.flush();
                fileCounter++;
                text="";
            }
        }
        else if(linesNum!=10){
            int c;
            int counter=bytesNum;
            int fileCounter=0;
            while(counter==bytesNum){
                counter=0;
                while ( counter<bytesNum && (c = reader.read()) != -1) {
                    text += ((char)c);
                    counter++;
                }
                if(text.equals("")){
                    break;
                }
                FileWriter writer = new FileWriter(createFileName(prefix,fileNameSequence,fileCounter), false);
                writer.write(text);
                writer.flush();
                fileCounter++;
                text="";
            }
        }
        else{
            System.out.println("wrong command!");
        }
    }

    public static String createFileName(String prefix, String fileNameSequence, int fileCounter){
        String fileName=prefix;
        if(fileNameSequence.isEmpty()){
            fileName+=Integer.toString(fileCounter);
        }
        else{
            int i=0;
            int j=1;
            while(!(Math.pow(fileNameSequence.length(),i)-1<=fileCounter && Math.pow(fileNameSequence.length(),j)-1>=fileCounter)){
                i++;
                j++;
            }
            String fileIndex="";
            fileIndex += fileNameSequence.charAt(fileCounter % fileNameSequence.length());
            for(int index=1;index<j;index++){
                fileIndex += fileNameSequence.charAt((int)(fileCounter/Math.pow(fileNameSequence.length(), index)-1));
            }
            fileIndex = new StringBuilder(fileIndex).reverse().toString();
            fileName+=fileIndex;
        }
        return fileName+".txt";
    }
}
