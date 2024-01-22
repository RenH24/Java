package stepik2;
/*
Создайте класс Abiturient с полями: фамилия, имя и три оценки по разным предметам. 
Определите метод average(), который подсчитает средний балл абитуриента, а также метод print(), который выведет информацию об абитуриенте в формате:
Иванов Андрей математика = 9 физика = 9 язык = 7 средний балл = 8.3

Sample Input:
Иванов Андрей 9 9 7
Sample Output:
8.3
Иванов Андрей математика = 9 физика = 9 язык = 7 средний балл = 8.3
*/

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Abiturient person = new Abiturient();
        person.surname = scan.next();
        person.name = scan.next();
        person.math = scan.nextInt();
        person.physics = scan.nextInt();
        person.lang = scan.nextInt();
        System.out.printf("%.1f\n", person.average());
        person.print();
    }
}

class Abiturient {
    String surname;
    String name;
    int math;
    int physics;
    int lang;
    
    double average() {
        return ((math + physics + lang) / 3.);
    }
    
    void print() {
        System.out.printf("%s %s математика = %d физика = %d язык = %d средний балл = %.1f\n", surname, name, math, physics, lang,  average());
    }
}
