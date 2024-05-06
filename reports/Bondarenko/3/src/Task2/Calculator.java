import java.util.Stack;
import java.util.Map;
import java.util.HashMap;
public class Calculator {
    private Stack<Double> stack;
    private Map<String, Double> defineParameters;

    public Calculator() {
        stack = new Stack<>();
        defineParameters = new HashMap<>();
    }

    public void performCommand(String command) {
        String[] params = command.split("\\s+");
        String operation = params[0];

        try {
            switch (operation) {
                case "#":
                    break;
                case "POP":
                    if (stack.isEmpty()) {
                        throw new OperationExecutionException("Стек пуст!");
                    }
                    stack.pop();
                    break;
                case "PUSH":
                    try {
                        stack.push(Double.parseDouble(params[1]));
                    }
                    catch (Exception e) {
                        throw new CommandParseException("Ошибка извлечения значения!");
                    }
                    break;
                case "+":
                    if (stack.size() < 2) {
                        throw new OperationExecutionException("Недостаточно операндов в стеке!");
                    }
                    Double a = stack.pop();
                    Double b = stack.pop();
                    stack.push(a + b);
                    break;
                case "-":
                    if (stack.size() < 2) {
                        throw new OperationExecutionException("Недостаточно операндов в стеке!");
                    }
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a - b);
                    break;
                case "*":
                    if (stack.size() < 2) {
                        throw new OperationExecutionException("Недостаточно операндов в стеке!");
                    }
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(a * b);
                    break;
                case "/":
                    if (stack.size() < 2) {
                        throw new OperationExecutionException("Недостаточно операндов в стеке!");
                    }
                    a = stack.pop();
                    b = stack.pop();

                    if (b == 0) {
                        stack.push(b);
                        stack.push(a); // сохранить извлеченные операнды в стеке
                        throw new OperationExecutionException("Деление на 0!");
                    }
                    stack.push(a / b);
                    break;
                case "SQRT":
                    if (stack.isEmpty()) {
                        throw new OperationExecutionException("Стек пуст!");
                    }
                    a = stack.pop();

                    if (a < 0) {
                        stack.push(a); // сохранить извлеченные операнды в стеке
                        throw new OperationExecutionException("Извлечение корня из отрицательного числа!");
                    }
                    stack.push(Math.sqrt(a));
                    break;
                case "PRINT":
                    if (stack.isEmpty()) {
                        throw new OperationExecutionException("Стек пуст!");
                    }
                    System.out.println(stack.peek());
                    break;
                case "DEFINE":
                    defineParameters.put(params[1], Double.parseDouble(params[2]));
                    break;
                default:
                    throw new CommandParseException("Неизвестная операция:" + operation + "!");
            }
        } catch (CalculatorException e) {
            System.out.println("Ошибка:" + e);
        }
    }
}
