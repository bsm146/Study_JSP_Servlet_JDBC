package test;

public class Test {

    public static void main(String[] args) {

        int answer = 0;
//        int[] number = {-2, 3, 0, 2, -5};
        int[] number = {-3, -2, -1, 0, 1, 2, 3};
        int numberLength = number.length;

        int a = 0;
        int b = 1;
        int c = 2;

        while (true) {

            if (number[a] + number[b] + number[c] == 0) {
                answer++;
                if (c != numberLength - 1) {
                    c++;
                    continue;
                } else {
                    if (b != numberLength - 2) {
                        b++;
                        c = b + 1;
                        continue;
                    } else {
                        if (a != numberLength - 3) {
                            a++;
                            b = a + 1;
                            c = a + 2;
                            continue;
                        } else {
                            break;
                        }
                    }
                }
            } else {
                if (c != numberLength - 1) {
                    c++;
                    continue;
                } else {
                    if (b != numberLength - 2) {
                        b++;
                        c = b + 1;
                        continue;
                    } else {
                        if (a != numberLength - 3) {
                            a++;
                            b = a + 1;
                            c = a + 2;
                            continue;
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
