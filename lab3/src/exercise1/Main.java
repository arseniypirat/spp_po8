public class Main {
    public static void main(String[] args) {
        Triangle triangle1 = new Triangle(5, 5, 6);
        Triangle triangle2 = new Triangle(3, 4, 5);

        System.out.println("Triangle 1: " + triangle1);
        System.out.println("Perimeter: " + triangle1.determinePerimeter());
        System.out.println("Area: " + triangle1.determineArea());
        System.out.println("Exists: " + triangle1.isTriangleExists());
        System.out.println("Are triangles equal? " + triangle1.isIsoscelesTriangle());

        System.out.println("\nTriangle 2: " + triangle2);
        System.out.println("Perimeter: " + triangle2.determinePerimeter());
        System.out.println("Area: " + triangle2.determineArea());
        System.out.println("Exists: " + triangle2.isTriangleExists());
        System.out.println("Are triangles equal? " + triangle2.isIsoscelesTriangle());

        System.out.println("\nAre triangle1 and triangle2 equal?  " + triangle1.equals(triangle2));
    }
}
