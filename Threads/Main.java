package Threads;

class Main {
    public static void main(String[] args) {
        
        Thread t1 = new Thread(new CounterThread(1));
        Thread t2 = new Thread(new CounterThread(2));

        // t1.start();
        // t2.start();

        Thread a = new Thread(new ABCThread('a', 1));
        Thread b = new Thread(new ABCThread('b', 2));
        Thread c = new Thread(new ABCThread('c', 3));

        a.start();
        b.start();
        c.start();

        // SingleSlotQueue queue = new SingleSlotQueue();

        // Thread sender = new Thread(() -> {
        //     for (int i = 1; i <= 3; i++) {
        //         String message = "Message " + i;
        //         queue.sendMessage(message);
        //         System.out.println("Sent: " + message);
        //         try {
        //             Thread.sleep(500); // Simulate some delay
        //         } catch (InterruptedException e) {
        //             Thread.currentThread().interrupt();
        //         }
        //     }
        // });

        // Thread receiver = new Thread(() -> {
        //     for (int i = 1; i <= 3; i++) {
        //         String message = queue.receiveMessage();
        //         System.out.println("Received: " + message);
        //         try {
        //             Thread.sleep(1000); // Simulate some delay
        //         } catch (InterruptedException e) {
        //             Thread.currentThread().interrupt();
        //         }
        //     }
        // });

        // sender.start();
        // receiver.start();
    }
}
