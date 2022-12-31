package eu.kekx.loomsciencepaper;

import java.sql.SQLOutput;

public class StartVirtualThreads {

    public static void main(String[] args) throws InterruptedException {

        //tag::createPThread[]
        // Platform Thread
        var platformThread = Thread.ofPlatform().start(() -> {
            System.out.println("Platform: " + Thread.currentThread());
        });
        platformThread.join();
        //end::createPThread[]
        //tag::createVThread[]
        // Virtual Thread
        var virtualThread = Thread.startVirtualThread(() -> {
            System.out.println("Virtual: " + Thread.currentThread());
        });
        virtualThread.join();
        //end::createVThread[]
    }
}
