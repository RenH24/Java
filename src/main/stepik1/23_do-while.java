package stepik1;
/* Выполните задачу с использованием цикла do-while.
Пользователь вводит произвольное целое число (оно может быть отрицательным). 
Найдите количество цифр в числе и сумму цифр.
Выведите через пробел сначала количество, а потом сумму цифр.

Sample Input 1:
4579
Sample Output 1:
4 25
  
Sample Input 2:
0
Sample Output 2:
1 0
*/
//put your code here
import java.util.Scanner;

class Main23 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int number = scan.nextInt();
        int kol = 0;
        int sum = 0;
        if (number < 0) {number = -number;}
        do{
            int x = number % 10;
            kol++;
            sum += x;
            number /= 10;
        }while (number != 0);
        System.out.println(kol + " " + sum);
    }
}
