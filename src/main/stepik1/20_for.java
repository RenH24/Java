package stepik1;
/* Выполните задачу с использованием цикла for.
Найти минимальное число в последовательности целых чисел.
Пользователь вводит количество целых чисел, а затем сами числа через пробел. 

Sample Input:
6
2 8 -1 4 0 9
Sample Output:
-1
*/
// put your code here
import java.util.Scanner;

class Main20 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int numb = scan.nextInt();
        int min = scan.nextInt();
        for(int i = 1; i < numb; i++){
            int k = scan.nextInt();
            if (k < min){
                min = k;
            }
        }
        System.out.println(min);
    }
}
