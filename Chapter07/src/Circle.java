public class Circle {
    double radius;
    static double PAI = Math.PI;
    public double periCircle(){
        return 2 * PAI * radius;
    }
    public double areaCircle(int i){
        this.radius = i;
        return PAI * i * i;
    }
}
