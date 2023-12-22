Пользователь вводит границы диапазона целых чисел. 
Границы диапазона в тестах корректны (не нужно проверять, что первая граница меньше или равна второй).
Нужно найти сумму наименьших делителей всех чисел в этом диапазоне (рассматриваются делители, начиная с 2).

Например, для диапазона 8 ...11: 
наименьший делитель 8 равен 2
наименьший делитель 9 равен 3
наименьший делитель 10 равен 2
наименьший делитель 11 равен 11

Сумма  2+3+2+11=18

Sample Input:
8 11
Sample Output:
18

//put your code here
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int div = 0;
        
        while (a <= b) {
            BLOCK:
            for (int i = 2; i <= a; i++) {
                if (a % i == 0) {
                    div += i;
                    break BLOCK;
                }
            }
            a++;
        }
        System.out.println(div);
    }
}
