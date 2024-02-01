public class Producer extends Thread {
    private final SharedBuffer sharedBuffer;

    public Producer(SharedBuffer sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    }
    @Override
    public void run() {
        try {
            while (true){
                sharedBuffer.produce(1);
                Thread.sleep(Math.round(Math.random()) * 500); // Simulate time taken to produce an item
            }
        } catch (InterruptedException e) {
            System.out.println("Producer interrupted");
        }
        // System.out.println("Producer finished.");
    }
}
