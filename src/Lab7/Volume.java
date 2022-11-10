package Lab7;

public class Volume {

    private final double LENGTH;
    private final double WIDTH;
    private final double HEIGHT;
    private final double RADIUS;
    private final String SHAPE;
    private static final double PI;

    static {
        PI = 3.14;
    }

    public Volume() {
        this(0, "Unknown");
    }

    public Volume(double length, double width, double height, String shape) {
        this(length, width, height, 0, shape);
    }

    public Volume(double radius, String shape) {
        this(0, 0, 0, radius, shape);
    }

    public Volume(double height, double radius, String shape) {
        this(0, 0, height, radius, shape);
    }

    public Volume(double length, double width, double height, double radius, String shape) {
        this.LENGTH = length;
        this.WIDTH = width;
        this.HEIGHT = height;
        this.RADIUS = radius;
        this.SHAPE = shape;
    }

    public double compVolume(Equation equation) {
        return equation.calculateVolume(LENGTH, WIDTH, HEIGHT, RADIUS, PI);
    }

    public String getShape() {
        return SHAPE + ": ";
    }

    public static class Main {
        public static void main(String[] args) {
            Equation cuboidEq = (length, width, height, radius, pi) -> length * width * height;
            Equation sphereEq = (length, width, height, radius, pi) -> 4.0 / 3 * pi * radius * radius * radius;
            Equation cylinderEq = (length, width, height, radius, pi) -> pi * radius * radius * height;
            Equation coneEq = (length, width, height, radius, pi) -> 1.0 / 3 * pi * radius * radius * height;

            Volume emptyVolume = new Volume();
            Volume cubeVolume = new Volume(3, 3, 3, "Cube");
            Volume cuboidVolume = new Volume(3, 4, 5, "Cuboid");
            Volume sphere = new Volume(5, "Sphere");
            Volume cylinder = new Volume(4, 5, "Cylinder");
            Volume cone = new Volume(4, 5, "Cone");

            System.out.println(emptyVolume.getShape() + emptyVolume.compVolume(cuboidEq));
            System.out.println(cubeVolume.getShape() + cubeVolume.compVolume(cuboidEq));
            System.out.println(cuboidVolume.getShape() + cuboidVolume.compVolume(cuboidEq));
            System.out.println(sphere.getShape() + sphere.compVolume(sphereEq));
            System.out.println(cylinder.getShape() + cylinder.compVolume(cylinderEq));
            System.out.println(cone.getShape() + cone.compVolume(coneEq));
        }
    }

    public interface Equation {
        double calculateVolume(double length, double width, double height, double radius, double pi);
    }
}
