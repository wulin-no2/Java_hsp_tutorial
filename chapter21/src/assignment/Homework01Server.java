package assignment;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Homework01Server {
    public static void main(String[] args) throws IOException {
        // analyze:
        // 1) new serverSocket to accept socket;
        // 2) use inputStream to get message from client;
        // 3) use outputStream to send message to client;
        // 4) use inputStream to get message from client;
        // 5) use outputStream to send message to client;
        // 6) close all;

        // create socket;
        ServerSocket serverSocket = new ServerSocket(8899);
        Socket socket = serverSocket.accept();
        System.out.println("waiting for client..");

        // get message from client. but how to make it a loop?
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println("client says: ");
            System.out.println(line);

//        System.out.println("end reading message1");
            // reply1;

            if (line.equals("name?")) {
                bufferedWriter.write("My name is Lina.");
            } else if (line.equals("hobby?")) {
                bufferedWriter.write("Coding ^_^");
            } else {
                bufferedWriter.write("What are you talking about?");
            }
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        System.out.println("sent reply1");

        // close all;
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();
    }
}
