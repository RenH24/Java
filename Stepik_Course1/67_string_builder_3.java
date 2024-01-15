Напишите метод primer(), который принимает два целых числа и возвращает строку, представляющую собой пример на сложение (см. тест). 
Используйте для формирования результата StringBuilder!

Sample Input:
8 11
Sample Output:
8 + 11 = 19

//put your code here
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        String str = primer(a, b);
        System.out.println(str);
    }
    public static String primer(int a, int b) {
        int result = a + b;
        StringBuilder sb = new StringBuilder();
        sb.append(a).append(" + ").append(b).append(" = ").append(result);
        String s = sb.toString();
        return s;
    }
}
