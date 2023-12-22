package exercise20231221.socket.fileUpload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TCPFileUploadClient {
    public static void main(String[] args) throws IOException {
        // analyze:
        // 1) create an inputStream to get image from a file;
        // 2) create a socketOutputStream to send the image to server;
        // 3) create a socketInputStream to get the message from server;

        // create a socket to send the image;
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        OutputStream outputStream = socket.getOutputStream();
        System.out.println("socket is output..");

        // get image from a file;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("image.png"));
        byte[] buff = new byte[1024];
        int readLen = 0;
        // use ByteArrayInputStream to store the image;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while ((readLen = bufferedInputStream.read(buff)) != -1){
            byteArrayOutputStream.write(buff,0,readLen);
        }
        // get image to byteArray:
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        System.out.println("get image from the file..");

        // output to server;
        // use a buffer;
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        bufferedOutputStream.write(byteArray);
        socket.shutdownOutput();
        System.out.println("output to the server..");

        // get the message from server;
        InputStream inputStream = socket.getInputStream();
        byte[] buff1 = new byte[1024];
        int readLen1 = 0;
        while ((readLen1 = inputStream.read(buff1))!= -1){
            System.out.println(new String(buff1,0,readLen1));
        }
        System.out.println("get message from server..");

        // close all;
        byteArrayOutputStream.close();
        bufferedOutputStream.close();
        inputStream.close();
        outputStream.close();
        socket.close();
        System.out.println("client ends..");

    }
}
