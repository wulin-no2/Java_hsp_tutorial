package exercise20231221.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author wulin
 * client, sent"hello, server" to server.
 */
public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {
        // analyze:
        // 1) connect server(IP, port)
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("client socket return " + socket.getClass());
        // 2) after getting connected, get a socket
        // via socket.getOutputStream()
        OutputStream outputStream = socket.getOutputStream();
        // write date to stream.
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello,server by[char stream client]");
        // insert newLine() means the content ends.
        bufferedWriter.newLine();
        // refresh the char stream, then it can be written.
        bufferedWriter.flush();
        // we don't need end tag here, because we have newLine()
        //socket.shutdownOutput();
        // get message from server:
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = bufferedReader.readLine();
        System.out.println(line);

        // close:
        bufferedReader.close();
        bufferedWriter.close();
        inputStream.close();
        outputStream.close();
        socket.close();
        System.out.println("client exits.");
    }
}
