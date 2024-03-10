public class SharedBuffer {
    private final int capacity;
    private final int[] buffer;
    private int count = 0;
    // private int putIndex = 0;
    // private int takeIndex = 0;

    public SharedBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.count = 0;
    }
    public synchronized void produce(int item) throws InterruptedException {
        while (count == capacity) {
            wait();
        }
        buffer[count] = item;
        System.out.println("produce: " + count);
        count++;
        notify();
        /*
        buffer[putIndex] = item;
        System.out.println("Produced: " + item + " in: " + putIndex);
        putIndex = (putIndex + 1) % capacity;
        count++;
        notifyAll();
         */

    }

    public synchronized int consume() throws InterruptedException {
        while (count == 0) {
            wait();
        }
        buffer[count - 1] = 0;
        System.out.println("consume: " + (count - 1));
        count--;
        notify();
        return count - 1;
        /*
        int item = buffer[takeIndex];
        System.out.println("Consumed: " + item + " from: " + takeIndex);
        takeIndex = (takeIndex + 1) % capacity;
        count--;
        notifyAll();
        return item;
         */
    }

}
