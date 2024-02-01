public class Consumer extends Thread {
    private final SharedBuffer sharedBuffer;
    public Consumer(SharedBuffer sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    }
    @Override
    public void run() {
        try {
            while (true){
                sharedBuffer.consume();
                Thread.sleep(Math.round(Math.random()) * 500); // Simulate time taken to consume an item
            }
        } catch (InterruptedException e) {
            System.out.println("Consumer interrupted");
        }
        // System.out.println("Consumer finished.");
    }
}
