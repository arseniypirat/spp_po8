package Lab3;

import java.io.*;
import java.time.Year;
import java.util.ArrayList;

class CarRent {
    private ArrayList<Car> cars;

    public CarRent(String filePath) {

        this.cars = new ArrayList<>();

        File file = new File(filePath);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            Car car = null;
            while ((line = reader.readLine()) != null) {
                String[] arg = line.split(":");

                if (arg.length == 2) {
                    String key = arg[0];
                    String value = arg[1];
                    switch (key) {
                        case "id":
                            car = new Car();
                            try{
                                car.setCarId(Integer.parseInt(value));
                            }
                            catch (NumberFormatException ex){
                                System.out.println("Ошибка преобразования строки в число: " + ex.getMessage());
                            }
                            break;
                        case "Brand":
                            car.setCarBrand(value);
                            break;
                        case "Model":
                            car.setCarModel(value);
                            break;
                        case "Year":
                            try{
                                car.setYear(Integer.parseInt(value));
                            }
                            catch (NumberFormatException ex){
                                System.out.println("Ошибка преобразования строки в число: " + ex.getMessage());
                            }
                            break;
                        case "Color":
                            car.setCarColor(value);
                            break;
                        case "Price":
                            try{
                                car.setCarPrice(Double.parseDouble(value));
                            }
                            catch (NumberFormatException ex){
                                System.out.println("Ошибка преобразования строки в число: " + ex.getMessage());
                            }
                            break;
                        case "RegNumber":
                            car.setRegNum(value);
                            break;
                        case "CarNumber":
                            car.setCarNumber(value);
                            break;
                        case "RenterFIO":
                            car.setRenterFIO(value);
                            break;
                        case "RenterPassportNumber":
                            car.setRenterPassportNumber(value);
                            cars.add(car);
                            break;
                        default:
                            System.out.println("Invalid data format: " + key);
                            break;
                    }
                }
            }
        }
        catch (IOException ex) {
            System.out.println("Файл не найден" + ex.getMessage());
        }
    }

    //Вывод списка всех автомобилей
    public void printAllCars() {
        System.out.println("Cars information: ");
        for (Car car : this.cars) {
            car.printCarInfo();
        }
    }

    //Вывод списка всех автомобилей заданной марки
    public void printCarsByBrand(String carBrand) {
        boolean isFind = false;
        for (Car car : this.cars) {
            if (car.getCarBrand().equalsIgnoreCase(carBrand)) {
                isFind = true;
                car.printCarInfo();
            }
        }
        if (!isFind) {
            System.out.println("Ничего не найдено.");
        }
    }

    //Вывод списка автомобилей заданной модели, которые эксплуатируются больше n лет;
    public void printOlderCarsByModel(String model, int years) {
        boolean isFind = false;
        int currentYear = Year.now().getValue();
        for (Car car : this.cars) {
            if (car.getCarModel().equalsIgnoreCase(model) && currentYear - car.getYear() > years) {
                isFind = true;
                car.printCarInfo();
            }
        }
        if (!isFind) {
            System.out.println("Ничего не найдено.");
        }
    }

    //Вывод списка всех автомобилей заданного года выпуска, цена которых больше указанной;
    public void printCarsByYearAndPrice(int year, double price) {
        int currentYear = Year.now().getValue();
        if(year>currentYear){
            System.out.println("Введите верные данные.");
            return;
        }

        for (Car car : this.cars) {
            if (car.getYear() == year && car.getCarPrice() > price) {
                car.printCarInfo();
            }
        }
    }

    //Вывод списка всех автомобилей, взятых на прокат
    public void printRentedCars() {
        boolean isFind = false;
        System.out.println("Автомобили взятые на прокат: ");
        for (Car car : this.cars) {
            if (!car.getRenterFullName().equals("-") && !car.getRenterPassportNumber().equals("-")) {
                System.out.println("id: " + car.getCarId() + "\nbrand: " + car.getCarBrand() + "\nmodel: " + car.getCarModel());
                isFind = true;
            }
        }
        if (!isFind) {
            System.out.println("Ничего не найдено.");
        }
    }

    //Вывод списка всех автомобилей,взятых на прокат с выводом личной информации об арендаторах.
    public void printRentedCarsWithRenterInfo() {
        boolean isFind = false;
        System.out.println("Автомобили взятые на прокат: ");
        for (Car car : this.cars) {
            if (!car.getRenterFullName().equals("-") && !car.getRenterPassportNumber().equals("-")) {
                System.out.println("id: " + car.getCarId() + "\nbrand: " + car.getCarBrand() + "\nmodel: " + car.getCarModel()
                + "\nRenter FullName: " + car.getRenterFullName() + "\nRenter passport number: " + car.getRenterPassportNumber() + "\n");
                isFind = true;
            }
        }
        if (!isFind) {
            System.out.println("Ничего не найдено.");
        }
    }
}