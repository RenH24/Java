
/*
В методе main() класса Main введите начальное значение генератора псевдослучайных чисел. 
Затем разыграйте случайное число от 1 до 10. Создайте массив целых чисел соответствующего размера и заполните его нулями.
Затем пользователь трижды вводит индекс в массиве и значение элемента. Нужно записать значение по заданному индексу в массив.
Поскольку пользователь не знает размер массива, он может указать неверный индекс. 
В этом случае в массив ничего не записывается, пользователю выводится сообщение: “Индекс не попал в массив”, а программа продолжает свою работу. 
В конце работы программы на консоль выводится содержимое массива с помощью метода Arrays.toString().

Sample Input:
145
4 8
9 2
2 11
  
Sample Output:
Индекс не попал в массив
[0, 0, 11, 0, 8, 0, 0]
*/

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int gen = scan.nextInt();
        Random rand = new Random(gen);
        int n = rand.nextInt(1, 11);
        int[] mas = new int[n];

        for (int i = 0; i <= 2; i++) {
            try {
                mas[scan.nextInt()] = scan.nextInt();
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Индекс не попал в массив");
            }
        }
        System.out.println(Arrays.toString(mas));
    }
}
