package chap06;

public class KeepAlive1 {

    public static void main(String[] args) {
        // keep.alive 속성은 설정되어 있지 않다. 디폴트 값은 true 이다.
        System.out.println(System.getProperty("keep.alive"));

        // keep.alive 속성을 false로 설정할 수도 있지만, 그렇게 할 이유가 없다.
        System.setProperty("keep.alive", "false");
        System.out.println(System.getProperty("keep.alive"));
    }

}
