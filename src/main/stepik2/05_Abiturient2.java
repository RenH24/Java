package stepik2;
/*
Доработайте класс Abiturient, созданный в п.1.2:
Сделайте все поля приватными согласно принципу инкапсуляции;
Добавьте в класс три разных конструктора, геттеры и сеттеры.
Должен заработать код, представленный в классе Main. Этот код менять нельзя!

Sample Input:
Семенов 70 60 57
  
Sample Output:
Семенов : 0.0
Петров : 80.0
Алексиевич : 62.3
*/

import java.util.Scanner;

class Main5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Abiturient2[] list = new Abiturient2[3];
        list[0] = new Abiturient2();
        list[1] = new Abiturient2("Петров", "Андрей", 90, 70, 80);
        list[2] = new Abiturient2("Алексиевич", "Анна");
        list[0].setSurname(scan.next());
        list[2].setPhysics(scan.nextInt());
        list[2].setMath(scan.nextInt());
        list[2].setLang(scan.nextInt());
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                System.out.printf("%s : %.1f\n", list[i].getSurname(), list[i].average());
            }
        }
    }
}

class Abiturient2 {
    private String surname;
    private String name;
    private int math;
    private int physics;
    private int lang;

    public Abiturient2() {
    }
    
    public Abiturient2(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }
    
    public Abiturient2(String surname, String name, int math, int physics, int lang) {
        this.surname = surname;
        this.name = name;
        this.math = math;
        this.physics = physics;
        this.lang = lang;
    }

    double average() {
        return (math + physics + lang) / 3.;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getPhysics() {
        return physics;
    }

    public void setPhysics(int physics) {
        this.physics = physics;
    }

    public int getLang() {
        return lang;
    }

    public void setLang(int lang) {
        this.lang = lang;
    }
}
