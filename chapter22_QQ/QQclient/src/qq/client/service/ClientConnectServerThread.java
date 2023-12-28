package qq.client.service;

import qq.common.Message;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientConnectServerThread extends Thread{
    // it needs to hold a socket;
    private Socket socket;
    private boolean loop = true;
    public ClientConnectServerThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run(){
        // we need this thread to keep connecting server, so use while here.
        while (loop) {
            // we use this thread to get message from server;
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                // if server doesn't send a message, thread will block here;
                Message m = (Message)objectInputStream.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    // to get socket easily:

    public Socket getSocket() {
        return socket;
    }
}
