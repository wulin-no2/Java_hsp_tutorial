public class Homework06 {
    public static void main(String[] args) {
        Cale cale = new Cale();
        Cale cale1 = new Cale();
        cale.num1 = 1;
        cale.num2 = 2;
        System.out.println(cale.add() +" " + cale.minus() +" " + cale.multiple() +" " + cale.divide());

        cale1.num1 = 10;
        cale1.num2 = 4;
        System.out.println(cale1.add() +" " + cale1.minus()+" "  + cale1.multiple()+" "  + cale1.divide());

    }
}
