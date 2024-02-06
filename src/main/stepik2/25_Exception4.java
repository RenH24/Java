package stepik2;
/*
В методе main() класса Main введите размер массива, а затем создайте массив целых чисел нужного размера. 
В следующей строке указаны элементы массива через пробел. Нужно ввести их и заполнить массив. 
Затем с новой строки входных данных считывается индекс в массиве и выводится соответствующий элемент массива. 
После чего с новой строки выводится сам массив. Т.е. при корректных исходных данных тест будет выглядеть так:
Sample Input:
5
3 6 7 1 2
2
Sample Output:
Извлечено из массива: 7
[3, 6, 7, 1, 2]

Однако пользователь при вводе может совершать различные ошибки. И реагировать на них программа должна по-разному.

1) Если пользователь вводит неверно размер массива, то программа должна добиться от него корректного ввода. 
  Для этого она выводит сообщение "Введите положительный размер массива!" или "Размер массива должен быть целым числом!" (в зависимости от ошибки) и опять ожидает ввода этого числа. 
  До тех пор, пока оно не будет введено правильно!
2) Если пользователь неверно вводит элемент массива (например, вводит буквы или вещественное число), то этому элементу просто присваивается 0, а программа продолжает ввод дальше.
3) Если пользователь неверно вводит индекс (например, вводит буквы или неправильное целое число), то выводится на консоль "Неверный индекс!".
*/

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

class Main25 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //создание массива
        int[] mas = null;
        boolean repeate = true;
        while (repeate) {
            try {
                int n = scan.nextInt();
                mas = new int[n];
                repeate = false;
            } catch (InputMismatchException ex) {
                System.out.println("Размер массива должен быть целым числом!");
                scan.nextLine(); //очистка буфера
            } catch (NegativeArraySizeException ex) {
                System.out.println("Введите положительный размер массива!");
            }
        }
        //заполнение массива
        for (int i = 0; i < mas.length; i++) {
            try {
                mas[i] = scan.nextInt();
            } catch (InputMismatchException ex3) {
                mas[i] = 0;
                scan.next(); //очистка буфера
            }
        }
        //вывод элемента массива
        try {
            int index = scan.nextInt();
            System.out.println("Извлечено из массива: " + mas[index]);
        } catch (ArrayIndexOutOfBoundsException | InputMismatchException ex) {
            System.out.println("Неверный индекс!");
        }
        //печать массива
        System.out.println(Arrays.toString(mas));
    }
}
