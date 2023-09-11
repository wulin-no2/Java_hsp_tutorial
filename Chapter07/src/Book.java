public class Book {
    public double updatePrice(String name, double oldPrice){
        double newPrice;
        if(oldPrice > 150){
            newPrice = 150;
        } else if (oldPrice > 100) {
            newPrice = 100;
        }
        else {
            newPrice = oldPrice;
        }
        return newPrice;
    }
}
