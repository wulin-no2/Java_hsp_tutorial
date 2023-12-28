package qq.client.service;

import java.util.HashMap;

public class ClientConnectServerThreadManager {
    private static HashMap<String, ClientConnectServerThread> hm = new HashMap<>();
    // add thread:
    public static void addClientConnectServerThread(String userID, ClientConnectServerThread t){
        hm.put(userID,t);
    }
    // get thread:
    public static ClientConnectServerThread getClientConnectServerThread(String userID){
        return hm.get(userID);
    }

}
