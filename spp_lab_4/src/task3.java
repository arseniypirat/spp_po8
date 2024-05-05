import java.util.ArrayList;
import java.util.List;

// Интерфейс Транспортное Средство
interface Vehicle {
    void move();
}

// Класс Автобус (реализация интерфейса Vehicle)
class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Автобус движется");
    }
}

// Класс Троллейбус (реализация интерфейса Vehicle)
class Trolleybus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Троллейбус движется");
    }
}

// Абстрактный класс Маршрут
abstract class Route {
    protected List<Vehicle> vehicles;
    protected int interval;
    protected List<Vehicle> reserveVehicles;

    public Route(int interval) {
        this.interval = interval;
        this.vehicles = new ArrayList<>();
        this.reserveVehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void addReserveVehicle(Vehicle vehicle) {
        reserveVehicles.add(vehicle);
    }

    public void startRoute() {
        System.out.println("Маршрут начал движение. Интервал: " + interval + " минут.");
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }

    public void breakdownHandler() {
        System.out.println("Поломка транспортного средства на маршруте!");
        if (!reserveVehicles.isEmpty()) {
            Vehicle reserveVehicle = reserveVehicles.remove(0);
            vehicles.add(reserveVehicle);
            System.out.println("Резервное транспортное средство вышло на маршрут.");
        } else {
            System.out.println("Резервных транспортных средств нет. Увеличиваем интервал движения.");
            interval *= 2;
        }
    }
}

// Конкретный класс Автобусный Маршрут (агрегация с классом Автобус)
class BusRoute extends Route {
    public BusRoute(int interval) {
        super(interval);
    }
}

// Конкретный класс Троллейбусный Маршрут (агрегация с классом Троллейбус)
class TrolleybusRoute extends Route {
    public TrolleybusRoute(int interval) {
        super(interval);
    }
}

class CityTransportSystem {
    public static void main(String[] args) {
        BusRoute busRoute = new BusRoute(10);
        busRoute.addVehicle(new Bus());
        busRoute.addVehicle(new Bus());
        busRoute.addReserveVehicle(new Bus());

        TrolleybusRoute trolleybusRoute = new TrolleybusRoute(15);
        trolleybusRoute.addVehicle(new Trolleybus());
        trolleybusRoute.addVehicle(new Trolleybus());
        trolleybusRoute.addReserveVehicle(new Trolleybus());

        busRoute.startRoute();
        busRoute.breakdownHandler();

        trolleybusRoute.startRoute();
        trolleybusRoute.breakdownHandler();
        trolleybusRoute.breakdownHandler();
    }
}
