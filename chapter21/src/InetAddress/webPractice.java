package InetAddress;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class webPractice {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        InetAddress byName = InetAddress.getByName("wulindembp.wireless.l3.nuigalway.ie");
        System.out.println(byName);

        InetAddress byName1 = InetAddress.getByName("www.google.com");
        System.out.println(byName1);

    }
}
