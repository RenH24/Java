
/*
Разработать класс Range (диапазон) c двумя полями:
int start - начало диапазона;
int end - конец диапазона.
Сделать этот класс итерируемым, т.е. обеспечить возможность перебора в цикле for-each всех целых чисел от start до end.
В методе main() класса Main создать объект класса Range. Границы диапазона для этого объекта ввести с консоли. Предположить, что пользователь вводит границы корректно ( первая граница меньше второй).
Пользуясь циклом for-each, вывести на консоль все целые числа из данного диапазона, отделяя их пробелами.

Sample Input:
5 10
Sample Output:
5 6 7 8 9 10
*/

import java.util.Iterator;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Range range = new Range(scan.nextInt(), scan.nextInt());
        
        for (Integer number: range) {
            System.out.print(number + " ");
        }
    }
}

class Range implements Iterable<Integer>, Iterator<Integer> {
    private int start;
    private int end;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Iterator<Integer> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return start <= end;
    }

    @Override
    public Integer next() {
        return start++;
    }
}
