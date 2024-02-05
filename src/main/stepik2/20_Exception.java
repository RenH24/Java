package stepik2;
/*
В методе main() класса Main введите начальное значение генератора псевдослучайных чисел. 
Затем разыграйте случайное число от -10 до 10 (напоминаю, что для этого можно использовать класс Random). 
Создайте массив соответствующего размера и заполните его последовательными десятичными цифрами, начиная с нуля. Выведите массив на консоль, используя метод Arrays.toString().
Если разыгранное число отрицательное, то должно быть выведено сообщение "Неверный размер массива: " и полученное значение. 

Sample Input 1:
145
Sample Output 1:
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
  
Sample Input 2:
67
Sample Output 2:
Неверный размер массива: -6
*/

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Main20 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //генерация размера массива
        int gen = scan.nextInt();
        Random rand = new Random(gen);
        int n = rand.nextInt(-10, 11);

        //обработка исключений
        try {
            int[] mas = new int [n];
            for (int i = 0; i < mas.length; i++) {
                mas[i] = i;
            }
            System.out.println(Arrays.toString(mas));
        } catch (NegativeArraySizeException ex) {
            System.out.println("Неверный размер массива: " + n);
        }
    }
}