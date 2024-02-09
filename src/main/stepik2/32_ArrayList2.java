package stepik2;
/*
Создайте класс Student подобно тому, как это было сделано в модуле 1.
Поля: Фамилия студента; Средний балл; Возраст.
Методы: Конструкторы; Геттеры и сеттеры для всех полей; Переопределите метод toString() так, чтобы он возвращал строку, состоящую из значений полей, разделенных точкой с запятой.
Пользователь вводит данные студентов, разделенные пробелами (каждого студента с новой строки). 
Сформируйте два списка: один для студентов моложе 18 лет, а другой - для совершеннолетних студентов.

Выведите списки студентов на консоль используя метод toString(), переопределенный для коллекций. Если список пуст, то выведите сообщение "Пустой список".

Sample Input:
Иванов 7.8 22
Петров 6.4 17
Андреева 8.1 13
Солнцев 4.5 23
Чумаченко 9.3 15
end
Sample Output:
[Петров;6.4;17, Андреева;8.1;13, Чумаченко;9.3;15]
[Иванов;7.8;22, Солнцев;4.5;23]
*/

import java.util.ArrayList;
import java.util.Scanner;

class Main32 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Student2> young = new ArrayList<>();
        ArrayList<Student2> legal = new ArrayList<>();

        
        while (true) {
            String buffer = scan.nextLine();
            if ("end".equals(buffer)) break;
            
            String[] parts = buffer.split(" ");
            double ball = Double.parseDouble(parts[1]);
            int age = Integer.parseInt(parts[2]);

            Student2 person = new Student2(parts[0], ball, age );
            
            if (age < 18) {
                young.add(person);
            } else {
                legal.add(person);
            }
        }

        if (young.isEmpty()) {
            System.out.println("Пустой список");
        } else {
            System.out.println(young.toString());
        }

        if (legal.isEmpty()) {
            System.out.println("Пустой список");
        } else {
            System.out.println(legal.toString());
        }        
    }
}

class Student2{
    private String name;
    private double ball;
    private int age;

    public Student2(String name, double ball, int age) {
        this.name = name;
        this.ball = ball;
        this.age = age;
    }

    public Student2() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBall() {
        return ball;
    }

    public void setBall(double ball) {
        this.ball = ball;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + ";" + ball + ";" + age;
    }
}
