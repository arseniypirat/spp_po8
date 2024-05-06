public class Main {
    public static void main(String[] args) {
        StarType type = StarType.G_TYPE;
        StarSystem solarSystem = new StarSystem(new Star("Sun", type));

        Planet mercury = new Planet("Mercury", 0.39);
        Planet venus = new Planet("Venus", 0.72);
        Planet earth = new Planet("Earth", 1);
        Planet mars = new Planet("Mars", 1.52);

        solarSystem.addPlanet(mercury);
        solarSystem.addPlanet(venus);
        solarSystem.addPlanet(earth);
        solarSystem.addPlanet(mars);

        solarSystem.displayStarInfo();
        solarSystem.displayPlanetsInfo();
    }
}