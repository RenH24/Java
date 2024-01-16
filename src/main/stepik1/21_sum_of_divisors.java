package stepik1;
/* Выполните задачу с использованием цикла for.
Найти сумму делителей целого положительного числа. Например, вводится число 12. Сумма его делителей: 1+2+3+4+6+12=28. 

Sample Input:
12
Sample Output:
28
*/
// put your code here
import java.util.Scanner;

class Main21 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int number = scan.nextInt();
        int sum = 0;
        for (int i = 1; i <= number; i++){
            if (number % i == 0){
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
