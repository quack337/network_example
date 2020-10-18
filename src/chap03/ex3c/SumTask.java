package chap03.ex3c;

import java.util.concurrent.Callable;

public class SumTask implements Callable<Long> {
    int from, to;
    long result;

    public SumTask(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Long call() throws Exception {
        long sum = 0;
        for (int i = from; i <= to; ++i)
            sum += i;
        result = sum;
        return result;
    }

}
