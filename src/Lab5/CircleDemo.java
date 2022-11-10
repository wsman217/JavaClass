package Lab5;

public class CircleDemo {

    public static void main(String[] args) {
        Circle circle1 = new Circle(5);
        Circle circle2 = new Circle();
        Lab5.other.Circle circle3 = new Lab5.other.Circle(2, 5);

        circle1.printAll();
        circle1.calculateArea();
        circle1.calculateCircumference();

        System.out.println("Radius of circle2: " + circle2.getRadius());
        circle2.printAll();
        circle2.calculateArea();
        circle2.printArea();
        circle2.calculateCircumference();
        circle2.printAll();

        circle3.printAll();
        circle3.calculateArea();
        circle3.printArea();
        circle3.calculateCircumference();
        circle3.printAll();
    }
}
