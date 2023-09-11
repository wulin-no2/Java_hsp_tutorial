public class Homework05 {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.radius = 1;
        double a = circle.periCircle();
        double b = circle.areaCircle(1);
        System.out.println("the perimeter is: " + a + " the area is: " + b);
    }
}
