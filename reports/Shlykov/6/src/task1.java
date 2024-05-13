abstract class Coffee {
    abstract String prepare();
}


class Espresso extends Coffee {
    String prepare() {
        return "Espresso is ready!";
    }
}

class Latte extends Coffee {
    String prepare() {
        return "Latte is ready!";
    }
}

class Cappuccino extends Coffee {
    String prepare() {
        return "Cappuccino is ready!";
    }
}

class Americano extends Coffee {
    String prepare() {
        return "Americano is ready!";
    }
}

class Mocha extends Coffee {
    String prepare() {
        return "Mocha is ready!";
    }
}

class CoffeeMachine {
    String makeCoffee(Coffee coffee) {
        return coffee.prepare();
    }
}
class CoffeeFactory {
    static Coffee createCoffee(String type) {
        switch (type) {
            case "Espresso":
                return new Espresso();
            case "Latte":
                return new Latte();
            case "Cappuccino":
                return new Cappuccino();
            case "Americano":
                return new Americano();
            case "Mocha":
                return new Mocha();
            default:
                throw new IllegalArgumentException("Unknown coffee type: " + type);
        }
    }
}

public class task1{
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        System.out.println(coffeeMachine.makeCoffee(CoffeeFactory.createCoffee("Espresso")));
        System.out.println(coffeeMachine.makeCoffee(CoffeeFactory.createCoffee("Latte")));
        System.out.println(coffeeMachine.makeCoffee(CoffeeFactory.createCoffee("Cappuccino")));
        System.out.println(coffeeMachine.makeCoffee(CoffeeFactory.createCoffee("Americano")));
        System.out.println(coffeeMachine.makeCoffee(CoffeeFactory.createCoffee("Mocha")));
    }
}
