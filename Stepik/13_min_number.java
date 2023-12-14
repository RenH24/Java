Найти минимальное из пяти целых чисел, введенных пользователем.

Sample Input:
3 -2 5 0 1
Sample Output:
-2

// put your code here
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int d = scan.nextInt();
        int e = scan.nextInt();
        int min = a;
        if (b < min){
            min = b;
        }
        if (c < min){
            min = c;
        }
        if (d < min){
            min = d;
        }
        if (e < min){
            min = e;
        }
        System.out.println(min);
    }
}
