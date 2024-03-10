public class Driver {
    public static void main(String[] args) {
        SharedBuffer sharedBuffer = new SharedBuffer(5);
        Producer producer = new Producer(sharedBuffer);
        Consumer consumer = new Consumer(sharedBuffer);
        Thread.currentThread().setName("Lina's main Thread");
        producer.start();
        consumer.start();
        try {
            Thread.sleep(5000);
//            producer.join();
//            consumer.join();
        }catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted.");
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " and all the child threads finished.");
        System.exit(0); // Forcefully terminates the JVM
    }
}
