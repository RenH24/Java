Выполните задачу с использованием цикла do-while.

Пользователь вводит целое число (контрольное число).
А затем вводится произвольное количество положительных целых чисел. 
Признаком конца ввода является любое отрицательное число.

Подсчитать во вводимой последовательности количество положительных делителей контрольного числа.

// put your code here
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int number = scan.nextInt();
        int divisors = 0;
        int x;
        do{
            x = scan.nextInt();
            if (number % x == 0 && x > 0){
                divisors++;
            }
        }while(x > 0);
        System.out.println(divisors);        
    }
}
