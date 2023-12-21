package exercise20231221.socket;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wulin
 * @version 1.0
 */
public class SocketTCP03Server {
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
        // IO read, char stream:
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = bufferedReader.readLine();
        System.out.println(line);
        // sent message:
        OutputStream outputStream = socket.getOutputStream();
        // use char stream:
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello, client by[char stream server]");
        bufferedWriter.newLine();
        bufferedWriter.flush();
        // end tag no use:
        //socket.shutdownOutput();
        // close:
        bufferedReader.close();
        bufferedWriter.close();
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("server exits.");

    }
}
