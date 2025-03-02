package Threads;

public class ABCThread implements Runnable {

    static int COUNT = 0;
    static int turn = 1;
    int change;
    char name;
    static Object lock = new Object();

    public ABCThread(char name, int change){
        this.name = name;
        this.change = change;
    }

    @Override
    public void run(){

        while(COUNT != 10){

            synchronized(Locks.a_lock){

                while(turn != change){
                    try {
                        Locks.a_lock.wait();
                    } catch (InterruptedException e) {
                    }
                }

                COUNT++;
                System.out.println(COUNT + " from thread " + name);

                turn = (change + 1) == 4 ? 1 : change + 1;

                Locks.a_lock.notifyAll();

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }

            }
        }

        return;
    }
}
