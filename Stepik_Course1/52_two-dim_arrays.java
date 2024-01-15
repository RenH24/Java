Пользователь вводит количество строк и столбцов двумерного массива, а затем начальное значение генератора случайных чисел. 
Создать массив целых чисел указанной размерности и инициализировать его случайными числами от -10 до 10. 
Массив вывести на консоль в виде таблицы, элементы которой отделяются знаками табуляции. 
Знак табуляции должен быть и  в конце каждой строки.
В каждой строке найти первый отрицательный элемент и вывести индекс соответствующего столбца или слово "NO", если он отсутствует.

Sample Input:
4 3 100
Sample Output:
6	0	-6	
2	-9	-4	
7	7	3	
0	-9	-8	
2
1
NO
1

//put your code here
import java.util.Scanner;
import java.util.Random;

class Main {
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
        
        for (int i = 0; i < array.length; i++) {
            int ind = -1;
            for (int j = 0; j < array[i].length; j++) {
                if (array [i][j] < 0) {
                    ind = j;
                    System.out.println(ind);
                    break;
                } 
            }
            if (ind == -1) {
                System.out.println("NO");
            }
        }
    }
}
