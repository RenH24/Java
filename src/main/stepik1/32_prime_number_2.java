package stepik1;
/*Выведите все простые числа в заданном диапазоне (включая его границы).
Границы диапазона вводит пользователь через пробел (положительные целые числа). 
Границы диапазона в тестах корректны (не нужно проверять, что первая граница меньше или равна второй).
Если в заданном диапазоне нет простых чисел, то не должно быть выведено ничего (пустой результат).

 Sample Input 1:
1 12
Sample Output 1:
2 3 5 7 11
  
Sample Input 2:
20 22
Sample Output 2:


 */
//put your code here.0
import java.util.Scanner;
class Main32 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        while (a <= b){
            boolean prime = true;
            if (a == 1) prime = false;
            for (int i = 2; i < a; i++) {
                if (a % i == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                System.out.print(a + " ");
            }
            a++;
        }
    }
}
