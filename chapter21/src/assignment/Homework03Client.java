package assignment;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Homework03Client {
    public static void main(String[] args) throws IOException {
        // analyze:
        // link to server;
        // enter a song name;
        // if the name is"QueenAvenueEast", server return the song;
        // if not, return a default song "Ground";
        // after receiving the song, save it. Use ByteArray transform inputStream to bytes[];

        // Create a socket, link to server which address can be retrieved from InetAddress;
        Socket socket = new Socket(InetAddress.getLocalHost(),6666);
        System.out.println("Client socket is created..");

        // enter a song name;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a song name:");
        String name = scanner.nextLine();

        // send the name to server;
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(name.getBytes());
        System.out.println("sent name successfully.");

        // get the song from server, use a buffer;
        InputStream inputStream = socket.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int songLen = 0;
        while ((songLen = bufferedInputStream.read(bytes)) != -1){
            byteArrayOutputStream.write(bytes,0,songLen);
        }
        byte[] songByte = byteArrayOutputStream.toByteArray();

        //output to the file;
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("outSong.mp3"));
        bufferedOutputStream.write(songByte);
        System.out.println("downloaded successfully.");

        // close all;
        bufferedOutputStream.close();
        byteArrayOutputStream.close();
        bufferedInputStream.close();
        outputStream.close();
        socket.close();
    }
}
