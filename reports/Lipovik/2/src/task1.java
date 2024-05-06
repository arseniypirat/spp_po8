import java.io.*;
import java.util.Vector;

public class task1 {
    public static void main(String[] args) throws IOException {
        if(args.length>1){
            System.out.println("too many arguments!");
            return;
        }
        File file = new File(args[0]);
        if(!file.exists()){
            System.out.println("file not exist!");
            return;
        }
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        Vector uniqueWords = new Vector();
        Vector resultText = new Vector();
        String text="";
        while ((line = reader.readLine()) != null) {
            text +=line;
        }
        reader.close();
        String[] words = text.split(" ");
        for(String word:words){
            String[] tempWord = word.toLowerCase().split("[;:,.?!]");
            if(tempWord.length!=0 && !uniqueWords.contains(tempWord[0])){
                uniqueWords.add(tempWord[0]);
                resultText.add(word);
            }
            else if(tempWord.length>1){
                uniqueWords.add(tempWord[word.length()-1]);
                resultText.add(word);
            }
            else if(tempWord.length==0){
                resultText.add(word);
            }
        }
        for(Object str : resultText){
            System.out.print(str+" ");
        }
    }
}