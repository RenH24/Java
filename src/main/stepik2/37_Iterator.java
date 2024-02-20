
/*
Как известно, цикл for-each по умолчанию позволяет перебрать массив только от начала  к концу...
Создайте класс ReverseArray, который инкапсулирует массив целых чисел (т.е. содержит массив в качестве своего поля). Элементы этого класса цикл for-each перебирает в обратном порядке!
В конструктор класса ReverseArray передается ссылка на массив из элементов типа int.
В методе main() класса Main реализован ввод элементов массива, а затем его вывод в цикле for-each. Этот код менять нельзя!

Sample Input:
6
5 12 -2 77 4 95
Sample Output:
95 4 77 -2 12 5 
*/

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = new int[scan.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = scan.nextInt();
        }
        ReverseArray reverse = new ReverseArray(array);
        for (Integer item : reverse) {
            System.out.print(item + " ");
        }
    }
}

class ReverseArray implements Iterable<Integer>, Iterator<Integer> {
    private int[] array;
    private int count;

    public ReverseArray(int[] array) {
        this.array = array;
    }

    @Override
    public Iterator<Integer> iterator() {
        count = array.length - 1;
        return this;
    }

    @Override
    public boolean hasNext() {
        return count >= 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) throw new NoSuchElementException();
        return array[count--];
    }
}
