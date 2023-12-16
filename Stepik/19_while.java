Выполните задачу с использованием цикла while.
Нужно найти произведение всех целых чисел в диапазоне, указанном пользователем.
Пользователь вводит границы диапазона через пробел. При этом не всегда первое вводимое число меньше второго. 
Произведение чисел быстро растет, поэтому для него используйте переменную типа double.
Форматирование при выводе не используйте!

Sample Input 1:
3 7
Sample Output 1:
2520.0
   
Sample Input 2:
44 39
Sample Output 2:
5.08251744E9

// put your code here
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        scan.close();
        
        int left = 0;
        int right = 0;
        if (a > b){
            left = b;
            right = a;
        }else{
            left = a;
            right = b;
        }
        double res = 1;
        while (left <= right){
            res *= left;
            left++;
        }
        System.out.println(res);
    }
}
