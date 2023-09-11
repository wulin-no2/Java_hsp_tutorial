public class Homework07 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.color = "red";
        dog.name = "bob";
        dog.age = 4;
        dog.show();
        dog.name = "jerry";
        dog.show();

        Dog dog1 = new Dog();
        dog1.color = "green";
        dog1.show();
    }
}
