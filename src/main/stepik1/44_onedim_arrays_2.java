package stepik1;
/* Массив из вещественных чисел типа double заполнить случайными значениями от 0 до 5 (не включая).
Пользователь вводит размер массива, а затем начальное значение генератора случайных чисел.
Вывести исходный массив на консоль в одной строке, разделяя элементы пробелами. 

Найти среднее арифметическое элементов массива и вывести его с новой строки. Заменить все элементы, большие среднего, его значением.

C новой строки вывести преобразованный массив. Элементы отделяются пробелами. 
Все вещественные числа при выводе округляются до двух знаков после десятичной точки.

Sample Input:
10 45
Sample Output:
3.63 4.35 1.50 3.77 1.29 3.07 2.09 4.80 4.70 3.77 
3.30
3.30 3.30 1.50 3.30 1.29 3.07 2.09 3.30 3.30 3.30
*/
//put your code here
import java.util.Random;
import java.util.Scanner;

class Main44 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int gen = scan.nextInt(); 
        
        double sum = 0;
        Random rand = new Random(gen);
        double[] a = new double[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextDouble(0, 5);
            System.out.printf("%.2f ", a[i]);
            sum += a[i];
        }
        
        System.out.printf("\n%.2f",sum/n);
        System.out.println();
        
        for (int i = 0; i < a.length; i++) {
           if(a[i]>sum/n){
               a[i]=sum/n;
           }
            System.out.printf("%.2f ",a[i]);
        }
    }
}
