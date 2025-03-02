package Threads;

public class ABCThread implements Runnable {

    static int COUNT = 0;
    static int turn = 1;
    int change;
    char name;
    static final Object lock = new Object();

    public ABCThread(char name, int change){
        this.name = name;
        this.change = change;
    }

    @Override
    public void run(){

        while(COUNT < 10){

            synchronized(lock){

                while(turn != change){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                    }
                }

                // try {
                //     if(COUNT != 0 )lock.wait();
                // } catch (InterruptedException e) {
                // }

                //System.out.println("BEFORE " + COUNT + " from thread " + name);

                if(COUNT < 10) COUNT++;
                System.out.println(COUNT + " from thread " + name);

                turn = (change + 1) == 4 ? 1 : change + 1;

                lock.notifyAll();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

            }
        }

    }
}
