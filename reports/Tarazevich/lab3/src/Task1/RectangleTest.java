package Task1;
public class RectangleTest {
    public static void main(String[] args) throws Exception {
        Rectangle rect1 = new Rectangle();
        Rectangle rect2 = new Rectangle(1, 1);

        if (rect1.equals(rect2))
            System.out.println("Rectangles are equal");
        else
            System.out.println("Rectangles are not equal");

        if (rect1.isSquare())
            System.out.print(rect1 + " is square;" +
                    " its area = " + rect1.getArea() +
                    "; its perimeter = " + rect1.getPerimeter());
    }
}
