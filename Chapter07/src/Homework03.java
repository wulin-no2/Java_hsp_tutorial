public class Homework03 {
    public static void main(String[] args) {

        Book mybook = new Book();
        double newPrice = mybook.updatePrice("Gone with the wind", 20);
        System.out.println(newPrice);

    }
}
