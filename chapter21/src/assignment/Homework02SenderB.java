package assignment;

import java.io.IOException;
import java.net.*;

public class Homework02SenderB {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        System.out.println("I've created the socket");

        // send question:
        byte[] bytes = "what are Big4 literatures in China??".getBytes();
        int byteLen = bytes.length;
        DatagramPacket datagramPacket = new DatagramPacket(bytes,0,byteLen,InetAddress.getLocalHost(),8888);
        datagramSocket.send(datagramPacket);
        System.out.println("I've sent the question");

        // receive reply:
        byte[] bytes1 = new byte[1024];
        DatagramPacket datagramPacket1 = new DatagramPacket(bytes1, bytes1.length);
        datagramSocket.receive(datagramPacket1);

        // unwrapped it;
        System.out.println("The answer is:");
        System.out.println(new String(datagramPacket1.getData(),0,datagramPacket1.getLength()));

        // exit;
        datagramSocket.close();


    }
}
