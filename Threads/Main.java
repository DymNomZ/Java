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

        try {
            c.join();
        } catch (InterruptedException e) {
        }
    }
}
