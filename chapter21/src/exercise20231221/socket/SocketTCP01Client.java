package exercise20231221.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author wulin
 * client, sent"hello, server" to server.
 */
public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        // analyze:
        // 1) connect server(IP, port)
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("client socket return " + socket.getClass());
        // 2) after getting connected, get a socket
        // via socket.getOutputStream()
        OutputStream outputStream = socket.getOutputStream();
        // write date to stream.
        outputStream.write("hello, server".getBytes());
        // end tag
        socket.shutdownOutput();
        // get message from server:
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf))!= -1){
            System.out.println(new String(buf,0,readLen));
        }
        // close:
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
