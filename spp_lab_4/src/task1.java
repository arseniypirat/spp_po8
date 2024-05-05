import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Notepad {
    private Map<LocalDate, List<Entry>> entries;

    public Notepad() {
        entries = new HashMap<>();
    }

    public void addEntry(LocalDate date, String text) {
        List<Entry> entriesForDate = entries.computeIfAbsent(date, k -> new ArrayList<>());
        entriesForDate.add(new Entry(text));
    }

    public List<Entry> getEntries(LocalDate date) {
        return entries.getOrDefault(date, new ArrayList<>());
    }

    public static void main(String[] args) {
        Notepad notepad = new Notepad();

        LocalDate today = LocalDate.now();
        notepad.addEntry(today, "Купить продукты");
        notepad.addEntry(today, "Позвонить другу");

        LocalDate tomorrow = today.plusDays(1);
        notepad.addEntry(tomorrow, "Встретиться с коллегой");

        System.out.println("Записи на сегодня:");
        for (Entry entry : notepad.getEntries(today)) {
            System.out.println(entry.getText());
        }

        System.out.println("\nЗаписи на завтра:");
        for (Entry entry : notepad.getEntries(tomorrow)) {
            System.out.println(entry.getText());
        }
    }

    private static class Entry {
        private final String text;

        public Entry(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
}
