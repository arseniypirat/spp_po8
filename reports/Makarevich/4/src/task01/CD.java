package task01;

import java.util.ArrayList;

public class CD {
    private ArrayList<Directory> directories;

    public CD() {
        directories = new ArrayList<>();
    }

    public void addDirectory(String name) {
        directories.add(new Directory(name));
    }

    public void addRecord(String directoryName, String recordName) {
        for (Directory directory : directories) {
            if (directory.getName().equals(directoryName)) {
                directory.addRecord(recordName);
                return;
            }
        }
        System.out.println("Directory not found: " + directoryName);
    }

    public void showContents() {
        for (Directory directory : directories) {
            System.out.println("Directory: " + directory.getName());
            directory.showRecords();
        }
    }

    private class Directory {
        private String name;
        private ArrayList<String> records;

        public Directory(String name) {
            this.name = name;
            records = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void addRecord(String recordName) {
            records.add(recordName);
        }

        public void showRecords() {
            for (String record : records) {
                System.out.println("  Record: " + record);
            }
        }
    }

    public static void main(String[] args) {
        CD cd = new CD();
        cd.addDirectory("Rock");
        cd.addRecord("Rock", "Stairway to Heaven");
        cd.addRecord("Rock", "Bohemian Rhapsody");

        cd.addDirectory("Pop");
        cd.addRecord("Pop", "Shape of You");
        cd.addRecord("Pop", "Billie Jean");

        cd.showContents();
    }
}
