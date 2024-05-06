public class Main {
    public static void main(String[] args) {
        IsoscelesTriangle triangle1 = new IsoscelesTriangle(3, 7, 4);
        IsoscelesTriangle triangle2 = new IsoscelesTriangle(3, 4, 4);

        System.out.println("Треугольник 1: " + triangle1);
        System.out.println("Периметр треугольника 1: " + triangle1.determinePerimeter());
        System.out.println("Площадь треугольника 1: " + triangle1.determineArea());
        System.out.println("Существует ли треугольник 1? " + triangle1.isTriangleExists());
        System.out.println("Является ли треугольник 1 равнобедренным? " + triangle1.isIsoscelesTriangle());

        System.out.println("\nТреугольник 2: " + triangle2);
        System.out.println("Периметр треугольника 2: " + triangle2.determinePerimeter());
        System.out.println("Площадь треугольника 2: " + triangle2.determineArea());
        System.out.println("Существует ли треугольник 2? " + triangle2.isTriangleExists());
        System.out.println("Является ли треугольник 2 равнобедренным? " + triangle2.isIsoscelesTriangle());

        System.out.println("\nРавны ли треугольник 1 и треугольник 2? " + triangle1.equals(triangle2));
    }
}