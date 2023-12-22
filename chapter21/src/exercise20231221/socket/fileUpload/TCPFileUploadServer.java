package exercise20231221.socket.fileUpload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFileUploadServer {
    public static void main(String[] args) throws IOException {
        // analyze:
        // 1) get socket from client.
        // 2) use InputStream get image.
        // 3) Output image into a file.
        // 4) sent a message via an OutputStream of socket.

        // get socket from client:
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        System.out.println("server is listening at 8888..");

        // get image:
        InputStream inputStream = socket.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        byte[] buff = new byte[1024];
        int readLen = 0;
        // store the image into what type of data?
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while ((readLen = bufferedInputStream.read(buff)) != -1){
            byteArrayOutputStream.write(buff,0,readLen);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        System.out.println("get image from client..");
        // store image into a file:
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("imageCopy.png"));
        bufferedOutputStream.write(byteArray);
        System.out.println("store image into the file..");

        // send a message to client:
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Got it!".getBytes());
        System.out.println("sent message to the client..");
        socket.shutdownOutput();

        // close all:
        outputStream.close();
        bufferedOutputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("server ends..");
    }
}
