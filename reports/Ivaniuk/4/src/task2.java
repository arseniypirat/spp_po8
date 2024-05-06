package Lab4.task2;

public class task2 {
    public static void main(String[] args){
        Motherboard motherboard = new Motherboard("ASUS ROG Strix Z490-E Gaming", "LGA1200", "Intel Z490", 128);
        Drive drive = new Drive("Samsung 970 EVO Plus", Drive.DriveType.SSD, 500);
        RAM ram = new RAM("Corsair Vengeance LPX", RAM.MemoryType.DDR4, 32, 3200);

        Computer myComputer = new Computer();
        myComputer.setMotherboard(motherboard);
        myComputer.setDrive(drive);
        myComputer.setRam(ram);

        System.out.println(myComputer);
    }
}

class Computer{
    private Motherboard motherboard;
    private Drive drive;
    private RAM ram;

    public Computer(){
    }
    public Computer(Motherboard motherboard,Drive drive,RAM ram){
        this.motherboard = motherboard;
        this.drive = drive;
        this.setRam(ram);
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }
    public void setMotherboard(Motherboard motherboard){
        this.motherboard = motherboard;
    }
    public void setRam(RAM ram){
        if(ram.capacity <= this.motherboard.getMaxRAM()){
            this.ram = ram;
        }
        else{
            System.out.println("Материнская плата " + this.motherboard.getTitle() + "поддерживает максимальный объем оперативной памяти " + this.motherboard.getMaxRAM());
        }
    }

    @Override
    public String toString() {
        return "Computer specs:" + this.motherboard + this.drive + this.ram;
    }
}

class Motherboard{
    private String title;
    private String socket;
    private  String chipset;
    private int maxRAM;

    public Motherboard(String title,String socket,String chipset,int maxRAM){
        this.title = title;
        this.socket = socket;
        this.chipset = chipset;
        this.maxRAM = maxRAM;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public void setMaxRAM(int maxRAM) {
        this.maxRAM = maxRAM;
    }

    public String getTitle() {
        return title;
    }

    public String getSocket() {
        return socket;
    }

    public String getChipset() {
        return chipset;
    }

    public int getMaxRAM() {
        return maxRAM;
    }

    @Override
    public String toString() {
        return "\nMorherboard specs: name = " + this.title + ", socket = " + this.socket + ", chipset = " +
            this.chipset + ", max RAM capacity = " + this.maxRAM + " GB;";
    }
}

class Drive{
    public enum DriveType{
        SSD,
        HDD
    }
    String name;
    DriveType type;
    int capacity;

    public Drive(String name,DriveType type, int memory){
        this.name = name;
        this.type = type;
        this.capacity = memory;
    }

    public DriveType getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setType(DriveType type) {
        this.type = type;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\nDrive specs: name = " + this.name + ", type = " + type + ", capacity = " + capacity + " GB;";
    }
}

class RAM{
    public enum MemoryType{
        DDR2,
        DDR3,
        DDR4,
        DDR5
    }
    String name;
    MemoryType type;
    int capacity;
    int speed;

    public RAM(String title, MemoryType type, int capacity, int speed) {
        this.name = title;
        this.type = type;
        this.capacity = capacity;
        this.speed = speed;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "\nRAM specs: name = " + name + ", capacity = " + capacity + " GB, RAM type = " +type+ ", speed = " + speed + " MHz;";
    }
}