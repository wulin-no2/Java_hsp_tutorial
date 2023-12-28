package qq.client.view;

import org.junit.Test;
import qq.client.service.ClientService;
import qq.client.utils.Utility;

import java.io.IOException;

/**
 * Login menu
 */

public class LoginView {
    private boolean loop = true; // whether show the menu;
    private String key; // get what users enter;
    private ClientService clientService = new ClientService(); // used to verify login and signup;

    @Test
    public void showMainMenu() throws IOException, ClassNotFoundException {
        while (loop){
            System.out.println("========== welcome to the QQ system ==========");
            System.out.println("\t\t 1 login system");
            System.out.println("\t\t 9 exit system");
            System.out.println("Please choose 1 or 9:");
            key = Utility.readString(1);
            switch (key){
                case "1":
                    System.out.println("login..");
                    System.out.println("Please enter your ID:");
                    String userID = Utility.readString(20);
                    System.out.println("Please enter your password:");
                    String userPassword = Utility.readString(20);
                    // Verify if the user exists:
                    if (clientService.checkUser(userID,userPassword)){
                        loop = false;
                        System.out.println("login successful");
                        // call the homeView;
                        UserHomeView userHomeView = new UserHomeView();
                        userHomeView.setUserID(userID);
                        userHomeView.showMainMenu();
                    }else {
                        System.out.println("User not exists. Try again.");
                    }
                    break;
                case "9":
                    System.out.println("exiting..");
                    loop = false;
                    break;
                default:
                    continue;
            }

        }
    }


}
