public class Homework02 {
    public static void main(String[] args) {
        A02 a02 = new A02();
        String[] testArr = {"jerry","tom","bing"};
        int index = a02.find("1",testArr);
        System.out.println("The index of the string in testArr is: " + index);
    }
}
