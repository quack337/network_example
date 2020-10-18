package chap03.ex2b;

class SumTask implements Runnable {
    int from, to;

    public SumTask(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {
        long sum = 0;
        for (int i = from; i <= to; ++i)
            sum += i;
        System.out.print(from + " 부터 " + to + " 까지 합계는 ");
        System.out.println(sum);
    }
}

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int from = 1, to = 100000;
        SumTask sumTask = new SumTask(from, to);
        Thread thread = new Thread(sumTask);
        thread.start();
    }

}
