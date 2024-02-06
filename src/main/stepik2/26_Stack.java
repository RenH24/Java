
/*
Создайте класс Stack, который реализует динамическую структуру типа LIFO (last in – first out) для символов типа char. Библиотечным классом пользоваться нельзя! 
Логика функционирования стека должна быть реализована на основе обычного одномерного массива. Размер этого массива передается при создании стека в конструктор. Методы класса:
void push(char c) – занести символ в вершину стека;
char pop() – извлечь символ из вершины стека;
void print() – распечатать содержимое стека, начиная от вершины;
void clear() - очистка стека (стек становится пустым)
Использовать исключительные ситуации для обработки проблем использования стека (например, попытка извлечь символ из пустого стека либо добавление символа  в стек, который полностью заполнен).
В методе main() класса Main демонстрируется работа стека:
1) Пользователь вводит размер буфера стека. Предположить, что ввод всегда будет корректным.
2) В цикле вводится с консоли выбор пользователя ( 1 - добавление в стек, 2 - удаление из стека, 3 - печать стека, 4 - очистка стека, 5 - выход из программы). 
Если нужно добавить символ в стек, то затем пользователь вводит этот символ.  Этот код нужно дополнить обработкой исключительных ситуаций.
Предполагается, что если произошла ошибка, связанная с работой стека, то цикл продолжается далее после вывода соответствующего сообщения. 
Если же пользователь некорректно вводит данные (например, вместо номера варианта вводит букву), то выводится сообщение "Некорректный ввод данных" и программа завершается с кодом 0.

Sample Input:
4
1 t 1 w 1 k 1 q 1 h 3 5
Sample Output:
Стек заполнен!
q k w t 
*/

import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Stack stack = new Stack(scan.nextInt());
        int choice;
        char sim;
        try {
            while (true) {
                try {
                    choice = scan.nextInt();
                    switch (choice) {
                        case 1:
                            sim = scan.next().charAt(0);
                            stack.push(sim);
                            break;
                        case 2:
                            sim = stack.pop();
                            System.out.println("Извлечено: " + sim);
                            break;
                        case 3:
                            stack.print();
                            break;
                        case 4:
                            stack.clear();
                            break;
                        default:
                            return;
                    }
                } catch (StackException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (InputMismatchException ex) {
            System.out.println("Некорректный ввод данных");
        }
    }
}

class StackException extends Exception{
    public StackException() {
    }

    public StackException(String message) {
        super(message);
    }
}

class Stack {
    private char[] array;
    private int top;

    public Stack(int n) {
        array = new char[n];
        top = 0;
    }

    public void push(char c) throws StackException {
        if (top == array.length) throw new StackException("Стек заполнен!");
        array[top++] = c;
    }

    public char pop() throws StackException{
        if (top == 0) throw new StackException("Попытка извлечь из пустого стека!");
        return array[--top];
    }

    public void print() {
        if (top == 0) {
            System.out.print("Стек пуст");
            return;
        }
        int index = top - 1;
        while (index >= 0) {
            System.out.print(array[index--] + " ");
        }
        System.out.println();
    }

    public void clear() {
        top = 0;
    }
}
