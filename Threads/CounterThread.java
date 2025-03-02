package Threads;

public class CounterThread implements Runnable {

    static int COUNT = 0;
    static Object lock = new Object();
    static int turn = 1;
    int num;

    public CounterThread(int num){
        this.num = num;
    }

    @Override
    public void run() {
        
        while(COUNT != 10000){

            synchronized (lock) {

                //if its not the thread's turn, wait
                while(num != turn){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        return;
                    }
                }

                COUNT++;
                System.out.println(COUNT + " from thread " + num);
                turn = (turn == 1) ? 2 : 1;

                //notify the other thread
                lock.notifyAll();
                
            }

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                return;
            }

            
        }
        
    }
}
