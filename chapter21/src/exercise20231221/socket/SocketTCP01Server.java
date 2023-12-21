package exercise20231221.socket;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.Provider;
/**
 * @author wulin
 * @version 1.0
 */
public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        // Analyze:
        // 1) 9999 waiting for connection.
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("server is waiting for connection at 9999 port:");
        // 2) if no connection, blocked and wait.
        // If there is a connection from client, there will be a socket return;
        // serverSocket can return several socket through accept() method;
        Socket socket = serverSocket.accept();
        System.out.println("server socket = " + socket.getClass());
        // 3) get content from socket.getInputStream()
        // from what client has written into the data stream;
        InputStream inputStream = socket.getInputStream();
        // IO read:
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf))!= -1){
            // show the content according to real length.
            System.out.println(new String(buf,0, readLen));
        }
        // close:
        inputStream.close();
        socket.close();
        serverSocket.close();

    }
}
