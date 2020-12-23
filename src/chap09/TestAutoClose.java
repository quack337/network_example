package chap09;

public class TestAutoClose {

    static class MyAutoCloseable implements AutoCloseable {

        @Override
        public void close() {
            System.out.println("closed");
        }
    }

    public static void main(String[] args) {
        MyAutoCloseable a1 = new MyAutoCloseable();
        try (MyAutoCloseable a2 = a1) {
        }
    }

}
