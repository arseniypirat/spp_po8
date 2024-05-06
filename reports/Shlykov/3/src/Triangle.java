public class Triangle {
    private double base;
    private double side;

    public Triangle(double base, double side) {
        this.base = base;
        this.side = side;
    }

    public double getBase() {
        return base;
    }

    public double getSide() {
        return side;
    }

    public double getPerimeter() {
        return 2 * side + base;
    }

    public double getArea() {
        double height = Math.sqrt(side * side - base * base / 4);
        return base * height / 2;
    }

    public boolean isValid() {
        return 2 * side > base;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Triangle triangle = (Triangle) obj;
        return Double.compare(triangle.base, base) == 0 &&
                Double.compare(triangle.side, side) == 0;
    }

    @Override
    public String toString() {
        return "IsoscelesTriangle{" +
                "base=" + base +
                ", side=" + side +
                '}';
    }
}

