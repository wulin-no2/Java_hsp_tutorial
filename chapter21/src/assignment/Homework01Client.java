package assignment;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Homework01Client {
    public static void main(String[] args) throws IOException {
        // analyze:
        // 1) create socket to link server;
        // 2) get outputStream to send message 'name', need to use char stream;
        // 3) get inputStream to get message from server, need to use char stream;
        // 4) get outputStream to send message 'hobby', need to use char stream;
        // 5) get inputStream to get message from server, need to use char stream;
        // 6) close all;

        // create socket;
        Socket socket = new Socket(InetAddress.getLocalHost(), 8899);
        System.out.println("waiting for link..");
        // get output to send message;
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        bufferedWriter.write("name?");
        bufferedWriter.newLine();
        bufferedWriter.write("hobby?");
        bufferedWriter.newLine();
        bufferedWriter.write("what else can you reply?");
        // need newLine() instead of shutdown;
        bufferedWriter.newLine();
        // need refresh;
        bufferedWriter.flush();

        // get reply1 from server;
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        while ((line = bufferedReader.readLine()) != null){
            System.out.println("The server reply:");
            System.out.println(line);
        }

        // close all;
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
    }
}
