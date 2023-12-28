package qq.client.service;

import qq.common.Message;
import qq.common.MessageType;
import qq.common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * used for user login and user sign up;
 */

public class ClientService {
    // user and socket can be used not only in one method.
    // so it's better to make them data members of the class.
    private User user = new User();
    private Socket socket;
    // Create a method to check if user exists. need to use User and then use socket to ask server.
    public boolean checkUser(String userID, String passwd) throws IOException, ClassNotFoundException {
        boolean b = false;
        user.setUserId(userID);
        user.setPasswd(passwd);
        // use a socket to send user and get a message in which is the boolean-verified result.
        socket = new Socket(InetAddress.getByName("127.0.0.1"),9999);

        // use ObjectStream to send and get;
        // send User:
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(user);

        // get Message:
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        Message o = (Message)objectInputStream.readObject();

        // return if the user exists;
        if (o.getMsgType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){
            b = true;
            // we need a thread to hold the socket here (new Thread class: ClientConnectServerThread):
            // this thread will keep connecting with server:
            ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
            clientConnectServerThread.start();

            // we'd better create a collection to manage threads;
            ClientConnectServerThreadManager.addClientConnectServerThread(userID,clientConnectServerThread);

        }else {
            // if check failed, close the socket.
            socket.close();

        }
        return b;

    }
}
