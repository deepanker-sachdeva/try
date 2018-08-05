package dee.variablechange;

import java.util.Scanner;

class Processor extends Thread{
    private volatile boolean running=true;//threads may cache a copy of the var, assuming no one else will change them, if they themselves aren't , so better to use volatile keyword

    @Override//can run code infinitely, till call this shutdown method
    public void run() {
        while (running){
            System.out.println("hi");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown(){
        running=false;
    }
}
public class Volatil {
    public static void main(String[] args){
        Processor p1=new Processor();
        p1.start();

        System.out.println("Press enter to stop");
        Scanner scanner=new Scanner(System.in);
        scanner.nextLine();
        p1.shutdown();
    }
}
