package Lab3;

import java.util.Scanner;

public class task1 {

    public static void main(String[] args){
        double sideLength = 30.0;
        EquilateralTriangle triangle1 = new EquilateralTriangle();
        if(triangle1.isEquilateralTriangleExist()){
            System.out.println("Периметр <triangle1>: " + triangle1.calculatePerimeter());
            System.out.println("Площадь <triangle1>: " + triangle1.calculateArea());
            System.out.println(triangle1.toString());
        }
        else{
            System.out.println("Треугольник <triangle1> со сторонами " + triangle1.getSideLength() +" см не существует");
        }

        EquilateralTriangle triangle2 = new EquilateralTriangle(20.00);
        if(triangle2.isEquilateralTriangleExist()){
            System.out.println("\nПериметр <triangle2>: " + triangle2.calculatePerimeter());
            System.out.println("Периметр <triangle2>: " + triangle2.calculateArea());
            System.out.println(triangle2);
        }
        else{
            System.out.println("Треугольник <triangle2> со стронами " + triangle2.getSideLength() +" см не существует");
        }

        EquilateralTriangle triangle3 = new EquilateralTriangle(22.00);

        if(triangle2.equals(triangle3)){
            System.out.printf("\nТреугольники <triangle2> и <triangle3> со сторонами %.2f см и %.2f см равны.",triangle2.getSideLength(),triangle3.getSideLength());
        }
        else{
            System.out.printf("\nТреугольники <triangle2> и <triangle3> со сторонами %.2f см и %.2f см не равны.",triangle2.getSideLength(),triangle3.getSideLength());
        }
    }
}

 class EquilateralTriangle{
    private double sidesLength;

    public EquilateralTriangle(){
        this.sidesLength=0.0;
    }

    public EquilateralTriangle(double sideLength){
        this.sidesLength=sideLength;
    }

    public void setSideLength(double sideLength){
        this.sidesLength=sideLength;
    }

    public double getSideLength(){
        return this.sidesLength;
    }

    public double calculatePerimeter(){
        return this.sidesLength*3;
    }

    public double calculateArea(){
        return (Math.pow(this.sidesLength,2)*Math.sqrt(3))/4;
    }

    public boolean isEquilateralTriangleExist(){
        return this.sidesLength>0;
    }

    @Override
    public String toString() {
        return "Равностронний треугольник со сторонами {"+
                this.sidesLength + "} см.";
    }

    @Override
    public boolean equals(Object otherObject){
        if(this == null){
           return false;
        } else if(this == otherObject){
            return true;
        } else {
            EquilateralTriangle otherEquilateralTriangle = (EquilateralTriangle) otherObject;
            return this.getSideLength() == otherEquilateralTriangle.getSideLength();
        }
    }
}
