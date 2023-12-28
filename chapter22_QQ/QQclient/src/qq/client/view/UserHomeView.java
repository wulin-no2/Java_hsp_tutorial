package qq.client.view;

import qq.client.utils.Utility;

public class UserHomeView {
    private boolean loop = true; // whether show the menu;
    private String key; // get what users enter;
    private String userID;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void showMainMenu(){
        while (loop){
            System.out.println("========== HomePage User (" + userID + ") ==========");
            System.out.println("\t\t 1 show online friends list");
            System.out.println("\t\t 2 send group message");
            System.out.println("\t\t 3 send private message");
            System.out.println("\t\t 4 send file");
            System.out.println("\t\t 9 exit system");
            System.out.println("Please enter your choice:");
            key = Utility.readString(1);
            switch (key){
                case "1":
                    System.out.println("This is your online friends:");
                    // call online friends view;
                    //loop = false;
                    break;
                case "2":
                    System.out.println("This is group message function:");
                    // call group message function;
                    //loop = false;
                    break;
                case "3":
                    System.out.println("This is private message function:");
                    // call private message function;
                    //loop = false;
                    break;
                case "4":
                    System.out.println("This is file sending function:");
                    // call file sending function;
                    //loop = false;
                    break;
                case "9":
                    System.out.println("Exiting System..");
                    loop = false;
                    break;
                default:
                    continue;
            }
        }


    }
}
