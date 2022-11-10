package Lab5.other;

public class Circle {

    private double radius;
    private static final double PI = 3.14;
    private double area;
    private double circumference;
    private double diameter;

    public Circle() {
        this(0);
    }

    public Circle(double radius) {
        this.radius = radius;
        this.area = calculateArea();
        this.circumference = calculateCircumference();
        this.diameter = 2 * radius;
    }

    public Circle(double radius, double area) {
        this.radius = radius;
        this.area = area;
        this.circumference = calculateCircumference();
        this.diameter = 2 * radius;
    }

    public double calculateArea() {
        return PI * radius *radius;
    }

    public double calculatePerimeter() {
        return PI * 2 * radius;
    }

    public double calculateCircumference() {
        return 2 * PI * radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return area;
    }

    public double getCircumference() {
        return circumference;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        this.area = calculateArea();
        this.circumference = calculateCircumference();
        this.diameter = 2 * radius;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setCircumference(double circumference) {
        this.circumference = circumference;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public void printRadius() {
        System.out.println("Radius: " + this.radius);
    }

    public void printArea() {
        System.out.println("Area: " + this.area);
    }

    public void printCircumference() {
        System.out.println("Circumference: " + this.circumference);
    }

    public void printDiameter() {
        System.out.println("Diameter: ");
    }

    public void printAll() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", area=" + area +
                ", circumference=" + circumference +
                ", diameter=" + diameter +
                ", perimeter=" + this.calculatePerimeter() +
                '}';
    }
}
