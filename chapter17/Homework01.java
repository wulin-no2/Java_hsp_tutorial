import java.util.Scanner;

public class Homework01 {
    public static void main(String[] args) {
        T1 t = new T1();
        Thread t1 = new Thread(t);
        t1.start();
        T2 t0 = new T2(t);
        Thread t2 = new Thread(t0);
        t2.start();
    }
}
class T1 implements Runnable{
    private boolean loop = true;
    public void setLoop(boolean loop) {
        this.loop = loop;
    }
    @Override
    public void run() {
        while (loop){
            System.out.println(Thread.currentThread().getName() + " - " + Math.round(Math.random()*100));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class T2 implements Runnable{
    private T1 t1;
    private Scanner scanner = new Scanner(System.in);

    public T2(T1 t1) {
        this.t1 = t1;
    }
    @Override
    public void run() {
        while (true) {
            System.out.println("Please enter q to stop it: ");
            if (scanner.next().toUpperCase().charAt(0) == 'Q') {
                t1.setLoop(false);
                break;
            }
        }
    }
}
