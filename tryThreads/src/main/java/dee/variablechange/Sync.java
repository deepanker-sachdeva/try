package dee.variablechange;

public class Sync {
    private int count=0;

    public synchronized void inc(){//synchronized keyword takes the lock of the object (of the class)
        count++;
    }
    public static void main(String[] args){
        Sync sync=new Sync();
        sync.doWork();
    }

    private void doWork() {
        Thread t1=new Thread(new Runnable() {
            public void run() {
                for (int i=0;i<10000;i++){
                    inc();
                }
            }
        });


        Thread t2=new Thread(new Runnable() {
            public void run() {
                for (int i=0;i<10000;i++){
                    inc();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();//will wait until t1 completes
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);
    }
}
