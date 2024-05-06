class Star {
    private String name;
    private StarType type;

    public Star(String name, StarType type) {
        this.name = name;
        this.type = type;
    }

    public void displayInfo() {
        System.out.println("Star name: " + name);
        System.out.println("Star type: " + type);
    }
}