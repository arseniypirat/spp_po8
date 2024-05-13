package Task1;
public class Rectangle {
    private double length;
    private double width;

	public static boolean isValid(double length, double width){
		return (length > 0 && width > 0);
	} 

	public boolean isValid(){
		return (length > 0 && width > 0);
    } 
    
    public Rectangle(){
        this.length = 1;
        this.width = 1;
    }

    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width >= 0)
            this.width = width;
    }

    public void setLength(double length) {
        if (length >= 0)
            this.length = length;
    }

    public double getArea() {
        return length * width;
    }

    public double getPerimeter() {
        return 2 * (length + width);
    }

    public boolean isSquare() {
        return length == width;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Rectangle rect = (Rectangle) obj;
        return Double.compare(rect.length, length) == 0 && Double.compare(rect.width, width) == 0;
    }

    @Override
    public String toString() {
        return "rectangle(" +
                "length = " + length +
                ", width = " + width + ")";
    }
}
