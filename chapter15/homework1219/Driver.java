package homework1219;

public class Driver {
    public static void main(String[] args) {
        DAO<User> userDAO = new DAO<User>();
        userDAO.save("123",new User(123,30,"Tom"));
        userDAO.save("124",new User(124,22,"Jerry"));
        userDAO.get("123");
        userDAO.update("124",new User(125,18,"Cam"));
        userDAO.list();
        userDAO.delete("124");
        System.out.println(userDAO);
    }



}
