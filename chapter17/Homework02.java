public class Homework02 {
    public static void main(String[] args) {
        WithDraw withDraw = new WithDraw();
        Thread user1 = new Thread(withDraw);
        Thread user2 = new Thread(withDraw);
        user1.start();
        user2.start();
    }
}
class WithDraw extends Thread{
    private static int sum = 10000;

    @Override
    public void run() {
        while (sum != 0) {
            synchronized (this){
                sum = sum - 1000;
                System.out.println(Thread.currentThread().getName() + " Withdraw 1000, remained " + sum);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("run out of money.");
    }
}
