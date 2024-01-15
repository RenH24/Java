Пользователь вводит размер массива и начальное значение генератора случайных чисел. 
Создать массив  чисел типа double заданного размера и заполнить его случайными числами от 0 до 2. 
Распечатать исходный массив, используя метод toString() - в квадратных скобках, элементы через запятую.
С новой строки вывести на консоль сумму максимального и минимального элементов массива.

Sample Input:
5 25
Sample Output:
[1.4631897195641836, 0.10745131965527377, 1.2906709676610488, 0.14895347726291952, 0.012141832026828503]
1.4753315515910121

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int gen = scan.nextInt();
        
        Random rand = new Random(gen);
        double[] a = new double[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextDouble(0, 2);
        }
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println(a[0] + a[n-1]);
    }    
}
