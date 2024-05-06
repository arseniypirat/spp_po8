package Lab3;

import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        final String FILE_PATH = "C:/Users/proro/OneDrive/Рабочий стол/CarInfo.txt";

        CarRent carRentalSystem = new CarRent(FILE_PATH);

        while(true){
            int choice;
            System.out.println("(1) Вывод списка всех автомобилей.");
            System.out.println("(2) Вывод списка всех автомобилей заданной марки.");
            System.out.println("(3) Вывод списка автомобилей заданной модели, которые эксплуатируются больше n лет.");
            System.out.println("(4) Вывод списка всех автомобилей заданного года выпуска, цена которых больше указанной.");
            System.out.println("(5) Вывод списка всех автомобилей, взятых на прокат.");
            System.out.println("(6) Вывод списка всех автомобилей,взятых на прокат с выводом личной информации об арендаторах.");
            System.out.println("(7) Выход.");

            System.out.println("Выберите пункт меню: ");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    carRentalSystem.printAllCars();
                    break;
                case 2:
                    System.out.println("Введите марку автомобиля: ");
                    scanner.nextLine();
                    String brand = scanner.nextLine();
                    carRentalSystem.printCarsByBrand(brand);
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("Введите модель автомобиля: ");
                    String model = scanner.nextLine();
                    System.out.println("Введите количество лет эксплуатации: ");
                    int  years = scanner.nextInt();

                    carRentalSystem.printOlderCarsByModel(model,years); 
                    break;
                case 4:
                    System.out.println("Введите год автомобиля: ");
                    int year = scanner.nextInt();
                    System.out.println("Введите цену: ");
                    double price = scanner.nextDouble();
                    carRentalSystem.printCarsByYearAndPrice(year,price);
                    break;
                case 5:
                    carRentalSystem.printRentedCars();
                    break;
                case 6:
                    carRentalSystem.printRentedCarsWithRenterInfo();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Неверный пункт меню");
                    break;
            }
        }
    }
}






