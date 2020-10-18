package chap03.ex3c;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(4);
        List<Future<Long>> futures = new ArrayList<Future<Long>>();
        int from = 1;
        for (int to = 10; to <= 1000000; to += 10) {
            SumTask sumTask = new SumTask(from, to);
            Future<Long> future = service.submit(sumTask);
            futures.add(future);
        }
        service.shutdown();
        for (Future<Long> future : futures)
            System.out.println(future.get());
    }

}
