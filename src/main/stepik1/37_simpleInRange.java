package stepik1;
/* Напишите статический метод simpleInRange(), который подсчитывает количество простых чисел в заданном диапазоне.
Если границы диапазона введены неверно (первое число больше второго), то в методе нужно их переставить местами.

Sample Input 1:
1 10
Sample Output 1:
4
  
Sample Input 2:
20 5
Sample Output 2:
6
*/
//put your code here
import java.util.Scanner;

class Main37 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int kol = simpleInRange(a, b);
        System.out.println(kol);
    }
    
    static int simpleInRange (int x, int y) {
        if (x > y) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        int c = 0;
        while (x <= y) {
            boolean prime = true;
            if (x <= 1) prime = false;
            for (int i = 2; i < x; i++) {
                if (x % i == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                c++;
            }
            x++;
        }
        return c;
    }
}
