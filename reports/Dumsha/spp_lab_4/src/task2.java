import java.util.ArrayList;
import java.util.List;

class Planet {
    private String name;
    private List<Continent> continents;

    public Planet(String name) {
        this.name = name;
        this.continents = new ArrayList<>();
    }

    public void addContinent(Continent continent) {
        continents.add(continent);
    }

    public void removeContinent(Continent continent) {
        continents.remove(continent);
    }

    public List<Continent> getContinents() {
        return continents;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Planet earth = new Planet("Земля");

        Continent asia = new Continent("Азия", 44579000);
        Continent africa = new Continent("Африка", 30370000);
        Continent northAmerica = new Continent("Северная Америка", 24709000);

        earth.addContinent(asia);
        earth.addContinent(africa);
        earth.addContinent(northAmerica);

        System.out.println("Планета: " + earth.getName());
        System.out.println("Материки:");

        for (Continent continent : earth.getContinents()) {
            System.out.println("- " + continent.getName() + ", площадь: " + continent.getArea() + " кв. км");
        }
    }
}

class Continent {
    private String name;
    private double area;

    public Continent(String name, double area) {
        this.name = name;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }
}
