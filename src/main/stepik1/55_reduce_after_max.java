package stepik1;
/* Напишите четыре статических метода  для работы с одномерным массивом целых чисел:
1) init()  - заполнение массива случайными числами от -3 до 5;
2) print() - вывод массива на консоль в строку, отделяя элементы пробелами;
3) findMax() - поиск индекса первого максимального элемента в одномерном массиве.
4) reduceAfterMax() - создает новый массив, удаляя все элементы после первого максимума.
В main() пользователь вводит количество элементов одномерного массива и начальное значение генератора случайных чисел. 
Выводится на консоль сформированный массив, и затем с новой строки  - сформированный массив с удаленной частью.

Sample Input:
10 99
Sample Output:
1 2 3 3 0 5 4 5 2 5 
1 2 3 3 0 5 
*/
//put your code here
import java.util.Scanner;
import java.util.Random;

class Main55 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] ar = new int[scan.nextInt()];
        long seed = scan.nextLong();
        init(ar, seed);
        print(ar);
        int[] b = reduceAfterMax(ar);
        print(b);
    }
    public static void init(int[] mas, long seed) {
        Random rand = new Random(seed);
        for(int i = 0; i < mas.length; i++) {
            mas[i] = rand.nextInt(-3, 6);
        }
    }
    public static void print(int[] mas) {
        for(int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
        System.out.println();
    }
    public static int findMax(int[] mas) {
        int imax = 0;
        for(int i = 0; i < mas.length; i++) {
            if (mas[i] > mas[imax]) {
                imax = i;
            }
        }
        return imax;
    }
    public static int[] reduceAfterMax(int[] mas) {
        int limit = findMax(mas);
        limit += 1;
        int[] result = new int[limit];
        for(int i = 0; i < limit; i++) {
            result[i] = mas[i];
        }
        return result;
    }         
}
