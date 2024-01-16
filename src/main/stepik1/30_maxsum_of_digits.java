package stepik1;
/* Пользователь вводит два целых числа (границы отрезка числовой оси).
Границы могут быть введены некорректно (первое число больше второго). 
В этом случае нужно границы переставить местами. Т.е. перебор должен быть всегда от меньшего к большему.
Найти в данном отрезке первое число с максимальной суммой цифр. Для отрицательного числа при расчете суммы цифр знак не учитывается. Например, сумма цифр -324 равна 9.

Sample Input 1:
15 22
Sample Output 1:
19
  
Sample Input 2:
-16 5
Sample Output 2:
-9
*/
//put your code here
import java.util.Scanner;

class Main30 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        int sumMax = 0;
        int numberMax = 0;
        while (a <= b) {
            int sum = 0;
            int tmp = Math.abs(a);
            while (tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            if (sum > sumMax) {
                sumMax = sum;
                numberMax = a;
            }
            a++;
        }
        System.out.println(numberMax);
    }
}
