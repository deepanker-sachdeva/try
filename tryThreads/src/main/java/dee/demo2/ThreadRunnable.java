package dee.demo2;

class Runner implements Runnable{
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println("hello "+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadRunnable {

    public static void main(String[] args){
        Thread t1=new Thread(new Runner());
        t1.start();//if call run method, it will run it in the main thread, start method calls the run method in its own new thread

        Thread t2=new Thread(new Runner());
        t2.start();





        //can use anonymous class if just want to run a single method in a thread, no need to create a full class
        Thread t3=new Thread(new Runnable() {
            public void run() {
                for (int i=0;i<10;i++){
                    System.out.println("hello "+i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t3.start();


        Thread t4=new Thread(new Runnable() {
            public void run() {
                Runner r=new Runner();
                r.run();
            }
        });
        t4.start();



    }





}




