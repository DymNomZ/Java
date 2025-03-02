package Threads;

public class SingleSlotQueue {

    private String message = null;
    private boolean messageAvailable = false;
    private final Object lock = new Object();

    public void sendMessage(String message) {
        synchronized (lock) {
            while (messageAvailable) {
                try {
                    lock.wait(); // Wait if a message is already present
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            this.message = message;
            messageAvailable = true;
            lock.notify(); // Notify the single receiver
        }
    }

    public String receiveMessage() {
        synchronized (lock) {
            while (!messageAvailable) {
                try {
                    lock.wait(); // Wait if no message is available
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return null;
                }
            }
            String receivedMessage = this.message;
            messageAvailable = false;
            lock.notify(); // Notify the sender (if it's waiting)
            return receivedMessage;
        }
    }
}
