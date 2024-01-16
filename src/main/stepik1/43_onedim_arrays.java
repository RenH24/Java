package stepik1;
/* Массив из целых чисел заполнить случайными значениями от -5 до 5 (включая обе границы).
Пользователь вводит размер массива, а затем начальное значение генератора случайных чисел.
Вывести исходный массив на консоль в одной строке, разделяя элементы пробелами. 
Пробел должен быть в том числе и после последнего элемента массива.
Найти сумму положительных элементов массива и произведение отрицательных элементов. 
Произведение быстро растет, поэтому оно должно иметь тип double.
C новой строки вывести результаты программы через пробел (сначала сумму, а потом произведение).

Sample Input:
10 7
Sample Output:
-3 5 5 -3 1 -1 0 2 5 5 
23 -9.0
*/
//put your code here
import java.util.Random;
import java.util.Scanner;

class Main43 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int gen = scan.nextInt();

        Random rand = new Random(gen);
        int[] a = new int[n];
        for (int i = 0; i <a.length; i++) {
            a[i] = rand.nextInt(-5, 6);
            System.out.print(a[i] + " ");
        }
        
        int sum = 0;
        double prod = 1;
        for (int elem: a) {
            if(elem >= 0) {
            sum += elem;
            }
            if(elem < 0) {
                prod *= elem;
            }
        }
        System.out.println("\n" + sum + " " + prod);
    }
}
