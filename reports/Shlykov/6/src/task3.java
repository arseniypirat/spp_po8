interface ButtonFunction {
    void execute();
}

class DigitButtonFunction implements ButtonFunction {
    private int digit;

    public DigitButtonFunction(int digit) {
        this.digit = digit;
    }

    @Override
    public void execute() {
        System.out.println("Digit: " + digit);
    }
}

class ArithmeticButtonFunction implements ButtonFunction {
    private char operation;

    public ArithmeticButtonFunction(char operation) {
        this.operation = operation;
    }

    @Override
    public void execute() {
        System.out.println("Operation: " + operation);
    }
}

class CustomButtonFunction implements ButtonFunction {
    private String function;

    public CustomButtonFunction(String function) {
        this.function = function;
    }

    @Override
    public void execute() {
        System.out.println("Custom function: " + function);
    }
}

class Button {
    private ButtonFunction function;

    public Button(ButtonFunction function) {
        this.function = function;
    }

    public void press() {
        function.execute();
    }

    public void setFunction(ButtonFunction function) {
        this.function = function;
    }
}

public class task3 {
    public static void main(String[] args) {
        Button button1 = new Button(new DigitButtonFunction(1));
        Button button2 = new Button(new ArithmeticButtonFunction('+'));
        Button button3 = new Button(new CustomButtonFunction("sqrt"));

        button1.press();
        button2.press();
        button3.press();

        button3.setFunction(new DigitButtonFunction(3));
        button3.press();
    }
}
