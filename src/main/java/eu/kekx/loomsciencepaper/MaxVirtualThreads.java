package eu.kekx.loomsciencepaper;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.IntStream;

public class MaxVirtualThreads {


    public static void main(String[] args) throws InterruptedException {

        //tag::maxThreads[]
        var threads =
                IntStream.range(0,1_000_000)
                        .mapToObj(index ->
                                Thread.ofVirtual()
                                        .name("virtual-", index)
                                        .unstarted(() -> {
                                            try {
                                                Thread.sleep(2_000);
                                            }
                                            catch (InterruptedException e) {
                                                throw new RuntimeException(e);
                                            }
                                        }))
                        .toList();
        //end::maxThreads[]
        Instant begin = Instant.now();
        threads.forEach(Thread::start);
        for (Thread thread : threads) {
            thread.join();
        }
        Instant end = Instant.now();
        System.out.println("Duration = "  + Duration.between(begin, end));
    }
}
