package Task1;

import java.util.*;
import java.lang.StringBuilder;

public class Notepad {
    Map<Date, Note> entries;

    public Notepad() {
        entries = new HashMap<>();
    }

    public void addEntry(Date date, String text) { if (!entries.containsKey(date)) {
        entries.put(date, new Note());
    }
        Note entry = entries.get(date); entry.addNote(text);
    }

    public ArrayList<String> getEntryByDate(Date date) { if (!entries.containsKey(date)) {
        return new ArrayList<String>();
    }
        return entries.get(date).getNote();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(); entries.forEach((date, entry) -> {
            builder.append(date); builder.append("\n");
            ArrayList<String> notes = entry.getNote();

            for (String note : notes) { builder.append(note); builder.append("\n");
            }
        });

        return builder.toString();
    }

    private class Note {
        private ArrayList<String> entry;

        public Note() {
            entry = new ArrayList<String>();
        }

        public void addNote(String text) { entry.add(text);
        }
        public ArrayList<String> getNote() { return entry;
        }
    }
}
