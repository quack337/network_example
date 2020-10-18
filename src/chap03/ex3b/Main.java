package chap03.ex3b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        OnSumFinishListener listener = new OnSumFinishListener() {
@Override
public synchronized void onSumFinish(SumTask task) {
    System.out.print(task.getFrom() + " 부터 " + task.getTo() + " 까지 합계는 ");
    System.out.println(task.getResult());
}
        };

        ExecutorService service = Executors.newFixedThreadPool(4);
        int from = 1;
        for (int to = 10; to <= 1000000; to += 10) {
            SumTask sumTask = new SumTask(from, to);
            sumTask.setOnSumFinishListener(listener);
            service.submit(sumTask);
        }
        service.shutdown();
    }

}
