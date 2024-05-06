import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
class EquilateralTriangle
{
    // длина стороны
    private double sideLength;

    // Конструктор с начальной инициализацией
    public EquilateralTriangle(double sideLength) {
        this.sideLength = sideLength;
    }

    // Геттер для получения длины стороны
    public double getSideLength() {
        return sideLength;
    }
    // Сеттер для изменения длины стороны
    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    // Метод для определения площади треугольника
    public double calculateArea() {
        return (Math.sqrt(3) / 4) * sideLength * sideLength;
    }

    // Метод для определения периметра треугольника
    public double calculatePerimeter() {
        return 3 * sideLength;
    }

    // Логический метод для определения существования треугольника
    public boolean exists() {
        return sideLength > 0;
    }

    // Переопределение метода toString()
    @Override
    public String toString() {
        return "EquilateralTriangle{" +
                "sideLength=" + sideLength +
                '}';
    }

    // Переопределение метода equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquilateralTriangle that = (EquilateralTriangle) o;
        return Double.compare(that.sideLength, sideLength) == 0;
    }
}



class Car {
    private int id;
    public int getId() {
        return id;
    }
    private String brand;
    public String getBrand() {
        return brand;
    }
    private String model;
    public String getModel() {
        return model;
    }
    private int year;
    public int getYear() {
        return year;
    }
    private String color;
    public String getColor() {
        return color;
    }
    private double price;
    public double getPrice() {
        return price;
    }
    private String registrationNumber;
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    private String licensePlateNumber;
    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }
    private String renterName;
    public String getRenterName() {
        return renterName;
    }
    private String renterPassportNumber;
    public String getRenterPassportNumber() {
        return renterPassportNumber;
    }

    public Car(int id, String brand, String model, int year, String color, double price, String registrationNumber, String licensePlateNumber, String renterName, String renterPassportNumber) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
        this.licensePlateNumber = licensePlateNumber;
        this.renterName = renterName;
        this.renterPassportNumber = renterPassportNumber;
    }

    // Геттеры и сеттеры для всех полей
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nID: " + id +
                "\nБренд: " + brand +
                "\nМодель: " + model +
                "\nГод выпуска: " + year +
                "\nЦвет кузова: " + color +
                "\nЦена при покупке: " + price + " $" +
                "\nРегистрационный номер: " + registrationNumber +
                "\nИдентификационный номер (VIN): " + licensePlateNumber);

        if (renterName != null && renterPassportNumber != null) {
            stringBuilder.append("\nФИО лица-арендатора: " + renterName +
                    "\nНомер паспорта лица-арендатора: " + renterPassportNumber);
        }
        return stringBuilder.toString();
    }
}

class CarRentalSystem {
    private List<Car> cars;
    public CarRentalSystem() {
        this.cars = new ArrayList<>();
    }
    public void addCar(Car car) {
        cars.add(car);
    }
    public List<Car> getAllCars() {
        return cars;
    }
    public List<Car> getCarsByBrand(String brand) {
        List<Car> carsByBrand = new ArrayList<>();
        for (Car car : cars) {
            if (car.getBrand().equals(brand)) {
                carsByBrand.add(car);
            }
        }
        return carsByBrand;
    }
    public List<Car> getCarsByModelAndYearsUsedMoreThan( int years) {
        List<Car> carsByModelAndYearsUsedMoreThan = new ArrayList<>();
        for (Car car : cars) {
            if (2024 - car.getYear() > years) {
                carsByModelAndYearsUsedMoreThan.add(car);
            }
        }
        return carsByModelAndYearsUsedMoreThan;
    }
    public List<Car> getCarsByYearAndPriceGreaterThan(int year, double price) {
        List<Car> carsByYearAndPriceGreaterThan = new ArrayList<>();
        for (Car car : cars) {
            if (car.getYear() == year && car.getPrice() > price) {
                carsByYearAndPriceGreaterThan.add(car);
            }
        }
        return carsByYearAndPriceGreaterThan;
    }
    public List<Car> getRentedCars() {
        List<Car> rentedCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getRenterName() != null && car.getRenterPassportNumber() != null) {
                Car rentedCar = new Car(
                        car.getId(),
                        car.getBrand(),
                        car.getModel(),
                        car.getYear(),
                        car.getColor(),
                        car.getPrice(),
                        car.getLicensePlateNumber(),
                        car.getRegistrationNumber(),
                        null,
                        null
                );
                rentedCars.add(rentedCar);
            }
        }
        return rentedCars;
    }
    public List<Car> getRentedCarsWithRenterInfo() {
        List<Car> rentedCarsWithRenterInfo = new ArrayList<>();
        for (Car car : cars) {
            if (car.getRenterName() != null && car.getRenterPassportNumber() != null) {
                rentedCarsWithRenterInfo.add(car);
            }
        }
        return rentedCarsWithRenterInfo;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int choice = 0;
        String input = "";

        while (choice != 3)
        {
            while (true) {

                System.out.println("1. Задание 1\n2. Задание 2\n3. Выход\n");
                System.out.print("Выберите необходимое:  ");
                input = in.nextLine();

                // Проверка, что введено только одно целое число
                if (input.matches("^\\d+$")) {
                    choice = Integer.parseInt(input);
                    if (choice >= 1 && choice <= 3) {
                        break; // Выбор корректен, выходим из цикла
                    }
                }
                System.out.println("Неверный ввод! Введите только одно число от 1 до 3.\n");
            }

            switch (choice)
            {
                case 1:
                    System.out.print("\n==================================================================\n");
                    // Создание объекта равностороннего треугольника с длиной стороны 7
                    EquilateralTriangle triangle1 = new EquilateralTriangle(7);

                    // Вызов методов для расчета площади и периметра треугольника
                    double area = triangle1.calculateArea();
                    double perimeter = triangle1.calculatePerimeter();

                    // Проверка существования треугольника
                    boolean exists = triangle1.exists();

                    // Вывод результатов
                    System.out.println("Площадь треугольника: " + area);
                    System.out.println("Периметр треугольника: " + perimeter);
                    System.out.println("Треугольник существует: " + exists);

                    // Создание второго объекта равностороннего треугольника с длиной стороны 5
                    EquilateralTriangle triangle2 = new EquilateralTriangle(5);

                    // Проверка равенства двух объектов
                    boolean isEqual = triangle1.equals(triangle2);
                    System.out.println("Два треугольника равны: " + isEqual);
                    System.out.print("==================================================================\n\n");
                    break;

                case 2:
                    System.out.println("\n==================================================================");
                    CarRentalSystem carRentalSystem = new CarRentalSystem();

                    try (FileReader reader = new FileReader("cars.json")) {
                        Gson gson = new Gson();
                        Type carListType = new TypeToken<List<Car>>() {}.getType();
                        List<Car> cars = gson.fromJson(reader, carListType);

                        for (Car car : cars) {
                            carRentalSystem.addCar(car);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    // Вывод всех автомобилей
                    System.out.println("Все автомобили: ");
                    List<Car> allCars = carRentalSystem.getAllCars();
                    for (Car car : allCars) {
                        System.out.println(car);
                    }
                    System.out.println("------------------------------------------------------------------");

                    // Вывод автомобилей заданной марки
                    List<String> brands = new ArrayList<>();
                    brands.add("Ford");
                    brands.add("Peugeot");
                    String brandString = String.join(", ", brands);
                    System.out.println("Автомобили заданных марок: " + brandString);
                    for (String brand : brands) {
                        List<Car> carsByBrand = carRentalSystem.getCarsByBrand(brand);
                        for (Car car : carsByBrand) {
                            System.out.println(car);
                        }
                    }
                    System.out.println("------------------------------------------------------------------");

                    // Вывод автомобилей заданной модели, которые эксплуатируются больше n лет
                    System.out.println("Автомобили, которые эксплуатируются больше 5 лет: ");
                    List<Car> carsByModelAndYearsUsedMoreThan = carRentalSystem.getCarsByModelAndYearsUsedMoreThan( 5);
                    for (Car car : carsByModelAndYearsUsedMoreThan) {
                        System.out.println(car);
                    }
                    System.out.println("------------------------------------------------------------------");

                    // Вывод автомобилей заданного года выпуска, цена которых больше указанной
                    int year = 2004;
                    double price = 5800;
                    System.out.println("Автомобили заданного года выпуска, цена которых больше указанной: \nгод - " + year + ", цена - от " + price + "$");
                    List<Car> carsByYearAndPriceGreaterThan = carRentalSystem.getCarsByYearAndPriceGreaterThan(year, price);
                    for (Car car : carsByYearAndPriceGreaterThan) {
                        System.out.println(car);
                    }
                    System.out.println("------------------------------------------------------------------");

                    // Вывод автомобилей, взятых на прокат
                    System.out.println("Автомобили, взятые на прокат: ");
                    List<Car> rentedCars = carRentalSystem.getRentedCars();
                    for (Car car : rentedCars) {
                        System.out.println(car);
                    }
                    System.out.println("------------------------------------------------------------------");

                    // Вывод автомобилей, взятых на прокат с выводом личной информации об арендаторах
                    System.out.println("Автомобили, взятые на прокат с личной информацией об арендаторах: ");
                    List<Car> rentedCarsWithRenterInfo = carRentalSystem.getRentedCarsWithRenterInfo();
                    for (Car car : rentedCarsWithRenterInfo) {
                        System.out.println(car);
                    }
                    System.out.println("==================================================================\n");
                    break;

                case 3:
                    System.out.println("Завершение работы...");
                    break;

                default:
                    System.out.println("Неверное значение!\n");
            }
        }
    }
}
