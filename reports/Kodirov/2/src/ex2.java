//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package lab2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class exercise2 {
    public exercise2() {
    }

    public static void main(String[] args) {
        try {
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            String resString = "Введите содержимое файла";
            System.out.print(resString + " a.txt: ");
            BufferedWriter writerA = new BufferedWriter(new FileWriter("a.txt"));

            String lineA;
            while((lineA = consoleReader.readLine()) != null && !lineA.isEmpty()) {
                writerA.write(lineA);
                writerA.newLine();
            }

            writerA.close();
            System.out.print(resString + " b.txt: ");
            BufferedWriter writerB = new BufferedWriter(new FileWriter("b.txt"));

            String lineB;
            while((lineB = consoleReader.readLine()) != null && !lineB.isEmpty()) {
                writerB.write(lineB);
                writerB.newLine();
            }

            writerB.close();
            consoleReader.close();
            BufferedWriter writerABC = new BufferedWriter(new FileWriter("abc.txt"));
            BufferedReader readerA = new BufferedReader(new FileReader("a.txt"));

            while((lineA = readerA.readLine()) != null) {
                writerABC.write(lineA);
                writerABC.newLine();
            }

            readerA.close();
            BufferedReader readerB = new BufferedReader(new FileReader("b.txt"));

            while((lineB = readerB.readLine()) != null) {
                writerABC.write(lineB);
                writerABC.newLine();
            }

            readerB.close();
            writerABC.close();
            System.out.print("Содержимое файлов a.txt и b.txt успешно объединено и сохранено в файле abc.txt.");
        } catch (IOException var9) {
            System.err.println("Ошибка при чтении или записи файлов: " + var9.getMessage());
            System.exit(1);
        }

    }
}
