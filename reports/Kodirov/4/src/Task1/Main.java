package Task1;

import java.util.Date; public class Main {
    public static void main(String[] args) throws InterruptedException {
        Notepad notepad = new Notepad(); notepad.addEntry(new Date(), "Запись 1 Дата 1");
        notepad.addEntry(new Date(), "Запись 2 Дата 1"); Thread.sleep(2000);
        notepad.addEntry(new Date(), "Запись 1 Дата 2");
        System.out.println(notepad);
    }
}
