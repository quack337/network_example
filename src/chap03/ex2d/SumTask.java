package chap03.ex2d;

public class SumTask implements Runnable {
    int from, to;
    long result;

    public SumTask(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {
        long sum = 0;
        for (int i = from; i <= to; ++i)
            sum += i;
        result = sum;
        Main.printResult(this);
    }

    public long getResult() {
        return result;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }
}
