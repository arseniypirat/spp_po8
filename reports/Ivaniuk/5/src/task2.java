package Lab5;

public class task2 {
    public static void main(String[] args){
        Route route = new Route("Брест", "Москва", 1100);

        Cargocarrier[] cargocarriers = new Cargocarrier[]{
                new Airplane("Boeing 747", route, 800, 5, 20, 1.5),
                new Train("Грузовой поезд", route, 120, 3, 30, 1),
                new Car("Грузовик", route, 100, 2, 10, 1.2)
        };




        double airplanePrice = cargocarriers[0].calculateTransportationPrice(route.getDistance());
        double airplaneTime = cargocarriers[0].calculateTransportationTime(route.getDistance());

        double trainPrice =cargocarriers[1].calculateTransportationPrice(route.getDistance());
        double trainTime = cargocarriers[1].calculateTransportationTime(route.getDistance());

        double carPrice = cargocarriers[2].calculateTransportationPrice(route.getDistance());
        double carTime = cargocarriers[2].calculateTransportationTime(route.getDistance());


        System.out.println("Маршрут: " + route.getStartCity() + " - " + route.getEndCity() + ", расстояние: " + route.getDistance() + " km;");

        System.out.println("Транспорт: Самолет (Boeing 747)");
        System.out.println("Стоимость: $" + String.format("%.2f", airplanePrice));
        System.out.println("Время доставки: " + String.format("%.2f", airplaneTime) + " часов");

        System.out.println();

        System.out.println("Транспорт: Поезд (Грузовой поезд)");
        System.out.println("Стоимость: $" + String.format("%.2f", trainPrice));
        System.out.println("Время доставки: " + String.format("%.2f", trainTime) + " часов");

        System.out.println();

        System.out.println("Транспорт: Автомобиль (Грузовик)");
        System.out.println("Стоимость: $" + String.format("%.2f", carPrice));
        System.out.println("Время доставки: " + String.format("%.2f", carTime) + " часов");
    }
}
class Route {
    private String firstCity;
    private String secondCity;
    private double distance; // Расстояние между городами в км

    public Route(String startCity, String endCity, double distance) {
        this.firstCity = startCity;
        this.secondCity = endCity;
        this.distance = distance;
    }

    public String getStartCity() {
        return firstCity;
    }

    public String getEndCity() {
        return secondCity;
    }

    public double getDistance() {
        return distance;
    }

    public void setFirstCity(String firstCity) {
        this.firstCity = firstCity;
    }

    public void setSecondCity(String secondCity) {
        this.secondCity = secondCity;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}

abstract class Cargocarrier{
    protected String name;
    protected Route route;
    protected double avgSpeed;
    protected double ratePerKm;
    protected double fuelConsumption; // Потребление топлива в литрах на 100 км
    protected double fuelPrice; // Цена топлива за литр

    public abstract double calculateTransportationTime(double distance);
    public abstract double calculateTransportationPrice(double distance);

    public Cargocarrier(String name, Route route, double avgSpeed, double ratePerKm, double fuelConsumption, double fuelPrice) {
        this.name = name;
        this.route = route;
        this.avgSpeed = avgSpeed;
        this.ratePerKm = ratePerKm;
        this.fuelConsumption = fuelConsumption;
        this.fuelPrice = fuelPrice;
    }

    public String getName() {
        return name;
    }

    public Route getRoute() {
        return route;
    }

    public double getAvgSpeed() {
        return avgSpeed;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getFuelPrice() {
        return fuelPrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public void setAvgSpeed(double avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    public void setRatePerKm(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setFuelPrice(double fuelPrice) {
        this.fuelPrice = fuelPrice;
    }
}

class Airplane extends Cargocarrier{
    private double additionalFees;

    public Airplane(String name, Route route, double avgSpeed, double ratePerKm, double fuelConsumption, double fuelPrice) {
        super(name, route, avgSpeed, ratePerKm, fuelConsumption, fuelPrice);
        this.additionalFees = 0.8;
    }

    @Override
    public double calculateTransportationTime(double distance) {
        return distance / super.avgSpeed;
    }

    @Override
    public double calculateTransportationPrice(double distance) {
        double fuelNeeded = (super.fuelConsumption / 100) * distance;
        double totalFuelPrice = fuelNeeded * super.fuelPrice;
        double transportPrice = distance * super.ratePerKm;
        return (totalFuelPrice + transportPrice) * additionalFees;
    }
}

class Train extends Cargocarrier{

    public Train(String name, Route route, double avgSpeed, double ratePerKm, double fuelConsumption, double fuelPrice) {
        super(name, route, avgSpeed, ratePerKm, fuelConsumption, fuelPrice);
    }

    @Override
    public double calculateTransportationTime(double distance) {
        return distance / super.avgSpeed;
    }

    @Override
    public double calculateTransportationPrice(double distance) {
        double fuelNeeded = (super.fuelConsumption / 100) * distance;
        double totalPrice = fuelNeeded * super.fuelPrice;
        double transportPrice = distance * super.ratePerKm;
        return totalPrice + transportPrice;
    }
}

class Car extends Cargocarrier{
    private double profitMargin; // Наценка за перевозку

    public Car(String name, Route route, double avgSpeed, double ratePerKm, double fuelConsumption, double fuelPrice) {
        super(name, route, avgSpeed, ratePerKm, fuelConsumption, fuelPrice);
        this.profitMargin = 0.4;
    }

    public void setProfitMargin(double profitMargin) {
        this.profitMargin = profitMargin;
    }

    public double getProfitMargin() {
        return profitMargin;
    }

    @Override
    public double calculateTransportationTime(double distance) {
        return distance / super.avgSpeed;
    }

    @Override
    public double calculateTransportationPrice(double distance) {
        double fuelNeeded = (super.fuelConsumption / 100) * distance;
        double totalPrice = fuelNeeded * super.fuelPrice;
        double transportPrice = distance * super.ratePerKm;
        return (totalPrice + transportPrice) * profitMargin; 
    }
}
