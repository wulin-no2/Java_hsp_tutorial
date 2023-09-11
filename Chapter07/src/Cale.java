public class Cale{
    double num1;
    double num2;
    public double add(){
        return num1 + num2;
    }
    public double minus(){
        return num1 - num2;
    }
    public double multiple(){
        return num1 * num2;
    }
    public double divide() {
        if (num2 == 0) {
            System.out.println("the divider shouldn't be 0. the result will be set as 0.");
            return 0;
        } else {
            return num1 / num2;
        }
    }
}
