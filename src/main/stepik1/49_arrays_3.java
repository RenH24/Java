package stepik1;
/* Пользователь вводит размер массива и начальное значение генератора случайных чисел.
Создать массив  целых чисел заданного размера и заполнить его случайными числами от 10 до 20 (включительно). 
Распечатать исходный массив, используя метод toString() - в квадратных скобках, элементы через запятую.
Затем вводятся два индекса (индексы в тестах корректные). Отсортировать по возрастанию часть массива между двумя этими индексами (включая оба).
С новой строки вывести преобразованный массив на консоль методом toString().

Sample Input:
10 85
1 4
Sample Output:
[20, 14, 10, 19, 18, 18, 20, 20, 16, 11]
[20, 10, 14, 18, 19, 18, 20, 20, 16, 11]
*/
//put your code here
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

class Main49 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] mas = new int[scan.nextInt()];
        Random rand = new Random(scan.nextInt());
        for (int i = 0; i < mas.length; i++) {
            mas[i] = rand.nextInt(10, 21);
        }
        System.out.println(Arrays.toString(mas));
        
        int a = scan.nextInt();
        int b = scan.nextInt();
        Arrays.sort(mas, a, b + 1);
        System.out.println(Arrays.toString(mas));
    }    
}
