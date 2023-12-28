package assignment;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Homework03Server {
    public static void main(String[] args) throws IOException {
        // analyze:
        // link to client;
        // get a name from client;
        // get the song from file to stream, then to byteArray;
        // if the name is "QueenAvenueEast", return the song;
        // if not, return default song "Ground";

        // Create a serverSocket and wait at port 6666. link to client;
        ServerSocket serverSocket = new ServerSocket(6666);
        Socket socket = serverSocket.accept();
        System.out.println("server socket is waiting..");

        // get a name from client;
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int byteLen = inputStream.read(bytes);
        String name = new String(bytes, 0, byteLen);
        System.out.println(name);

        // see if the song name can be found, then send the song;
        String songName = " ";
        if(name.equals("Queen Avenue East")){
            songName = name + ".mp3";
        }else {
            songName = "Ground.mp3";
        }

        // read the song to byteArray (inputStream to byteArray);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(songName));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] songBuff = new byte[1024];
        int songLen = 0;
        while ((songLen = bufferedInputStream.read(songBuff)) != -1){
            byteArrayOutputStream.write(songBuff,0,songLen);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();

        // send the song to client, use a buffer;
        OutputStream outputStream = socket.getOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        bufferedOutputStream.write(byteArray);
        socket.shutdownOutput();
        System.out.println("sent the song successfully.");

        // close all;
        outputStream.close();
        byteArrayOutputStream.close();
        bufferedInputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
