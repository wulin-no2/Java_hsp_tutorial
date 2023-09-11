// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Homework01 {
    public static void main(String[] args) {
        /*
         Press Opt+Enter with your caret at the highlighted text to see how
         IntelliJ IDEA suggests fixing it.
        */
        double[] arr = {1,9};
        A01 a01 = new A01();
        Double result = a01.max(arr);
        if (result == null) {
            System.out.println("This array is null or { }.");
        } else {
            System.out.println("The max number of this array is " + result);
        }
    }
}
