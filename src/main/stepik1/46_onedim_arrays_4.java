package stepik1;
/* Массив из целых чисел заполнить случайными значениями от -5 до 15 (включая обе границы)
Пользователь вводит размер массива, а затем начальное значение генератора случайных чисел.
Вывести исходный массив на консоль в одной строке, разделяя элементы пробелами. Пробел должен быть в том числе и после последнего элемента массива.
Поменять местами первый максимальный и последний отрицательный элементы. Если отрицательных элементов нет в массиве, то он должен остаться без изменения.
C новой строки вывести измененный массив, отделяя элементы пробелами.

Sample Input:
10 77
Sample Output:
7 -5 -1 5 -3 8 2 -1 -3 -3 
7 -5 -1 5 -3 -3 2 -1 -3 8
*/
//put your code here
import java.util.Random;
import java.util.Scanner;

class Main46 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int gen = scan.nextInt();
        
        Random rand = new Random(gen);
        int[] a = new int[n];
        for (int i = 0; i <a.length; i++) {
            a[i] = rand.nextInt(-5, 16);
            System.out.print(a[i] + " ");
        }
        System.out.println();
        
        int ineg = -1;
        int imax = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[imax]) {
                imax = i;
            }
            if (a[i] < 0) {
                ineg = i;
            }
        }
        if (ineg != -1) {
            int tmp = a[ineg];
            a[ineg] = a[imax];
            a[imax] = tmp;
        }
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
