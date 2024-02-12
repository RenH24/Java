
/*
Помните класс Stack, который Вы создавали в п 3.3? В этой задаче нужно его усовершенствовать: сделать так, чтобы он мог работать не только с символами, но и с объектами любого класса!!!
Отдельно добавьте класс Student с полями: фамилия, средний балл, возраст.
Добавьте необходимые методы на свое усмотрение (но не забудьте переопределить метод toString() так, чтобы все поля выводились через точку с запятой).
В методе main() класса Main пользователь  вводит информацию о нескольких студентах. Данные каждого объекта отделяются пробелами и вводятся с новой строки. Завершается ввод данных словом "Конец".
Нужно по мере ввода данных помещать объекты класса в стек. Гарантируется, что данных не будет больше 10 (т.е. размер стека при создании можно задать 10 или больше).  
А затем вывести содержимое стека от вершины ко дну (т.е. в порядке, обратном вводу)

Sample Input:
Иванов 7.9 22
Петрова 9.3 18
Курочкин 6.8 24
Конец
Sample Output:
Курочкин;6.8;24 Петрова;9.3;18 Иванов;7.9;22
*/

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack<Student> stack = new Stack<>(10);
        
        String buffer = scan.nextLine();
        while (!"Конец".equals(buffer)) {
            try {                
                String[] parts = buffer.split(" ");
                stack.push(new Student(parts[0], Double.parseDouble(parts[1]), Integer.parseInt(parts[2])));
            } catch (StackException ex) {
                System.out.println(ex.getMessage());
            }
            buffer = scan.nextLine();
        }
        stack.print();
    }
}

class Student {
    private String name;
    private double ball;
    private int age;

    public Student(String name, double ball, int age) {
        this.name = name;
        this.ball = ball;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + ";" + ball + ";" + age;
    }
}

class StackException extends Exception{
    public StackException() {
    }

    public StackException(String message) {
        super(message);
    }
}

class Stack <E> {
    E[] array;
    private int top;

    public Stack(int n) {
        array = (E[]) new Object[n];
        top = 0;
    }

    public void push(E c) throws StackException {
        if (top == array.length) throw new StackException("Стек заполнен!");
        array[top++] = c;
    }

    public E pop() throws StackException{
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
