public class Test {

    public static void main(String[] args) {

        add(5, 3);
        add2(10, 5);

        StringBuffer word = new StringBuffer();
        word.append("hello");

        System.out.println(word.equals("hello"));
        System.out.println(word.toString().equals("hello"));

    }

    public static void add(int a, int b) {

        System.out.println(a + b);
        add2(a, b);
    }

    public static void add2(int a, int b) {

        System.out.println(a - b);
    }
}
