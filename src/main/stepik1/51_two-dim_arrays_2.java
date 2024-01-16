package stepik1;
/* Пользователь вводит количество строк и столбцов двумерного массива, а затем начальное значение генератора случайных чисел.
Создать массив целых чисел указанной размерности и инициализировать его случайными числами от -10 до 10. 
Массив вывести на консоль в виде таблицы, элементы которой отделяются знаками табуляции. Знак табуляции должен быть и  в конце каждой строки.
Вывести пустую строку после двумерного массива.
Для каждого столбца найти сумму положительных элементов и вывести на консоль, отделяя пробелами.

Sample Input:
4 5 89
Sample Output:
-3	-9	8	-6	2	
9	1	-4	-4	-5	
-10	5	-6	3	-3	
-2	7	-4	1	-4	

9 13 8 4 2 

 */
//put your code here
import java.util.Scanner;
import java.util.Random;

class Main51 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] array = new int[scan.nextInt()][scan.nextInt()];
        Random rand = new Random(scan.nextLong());
        
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = rand.nextInt(-10, 11);
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.print("\n");
        
        int sum = 0;
        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array [j][i] > 0) {
                    sum += array [j][i];
                }
            }
            System.out.print(sum + " ");
            sum = 0;
        }
    }
}
