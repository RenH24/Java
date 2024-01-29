
/*
Создайте абстрактный класс Pet. Поля: кличка, возраст. Определите конструкторы, геттеры и сеттеры. 
Переопределите метод  toString() (должен выдавать все поля в csv-формате). Задайте абстрактный метод void getNoise();

Создать производный класс Dog с дополнительным полем: порода.  
Переопределите метод toString(). Переопределите метод getNoise(), чтобы он выводил на консоль “Гав-гав!”.

Создайте  также производный от Pet класс Cat с дополнительным полем: окрас. Переопределите методы toString() и getNoise(), чтобы последний выводил на консоль “Мяу-мяу!”.

В методе main() класса Main выполнить следующее:
Ввести размер массива и создать массив домашних животных.
Заполнить массив объектами, считав их данные с консоли. В начале каждой строки стоит тип объекта: 1 - собака, 2 - кот. Затем идут данные, которые отделяются пробелами: кличка и возраст.  Далее для собаки следует порода, а для кота - окрас.
Выведите список всех домашних животных в массиве. Для каждого животного должно быть выведено название класса, затем пробел и кличка, далее двоеточие и издаваемый звук. Например: Dog Мухтар:Гав-гав!
Выведите пустую строку.
Затем вывести список всех котов в массиве в csv-формате.

Sample Input:
5
1 Джек 3 сенбернар
2 Васька 2 рыжий
1 Мухтар 1 овчарка
1 Шарик 4 дворняга
2 Бакстер 3 белый
  
Sample Output:
Dog Джек:Гав-гав!
Cat Васька:Мяу-мяу!
Dog Мухтар:Гав-гав!
Dog Шарик:Гав-гав!
Cat Бакстер:Мяу-мяу!

Васька;2;рыжий
Бакстер;3;белый
*/

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Pet[] list = new Pet[n];

        //заполнение массива
        for(int i = 0; i < list.length; i++) {
            int type = scan.nextInt();
            String name = scan.next();
            int age = scan.nextInt();
            switch (type) {
                case 1:
                    String breed = scan.next();
                    list[i] = new Dog(name, age, breed);
                    break;
                case 2:
                    String color = scan.next();
                    list[i] = new Cat(name, age, color);
                    break;
            }
        }

        //вывод массива
        for (Pet pets: list) {
            System.out.print(pets.getClass().getSimpleName() + " " + pets.getName() + ":");
            pets.getNoise();
        }
            System.out.println();
        
        //список всех котов
        for (Pet pets: list) {
            if (pets instanceof Cat) {
                System.out.println(pets);
            }
        }
    }
}

abstract class Pet {
    private String name;
    private int age;

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Pet() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + ";" + age;
    }

    abstract void getNoise();
}

class Dog extends Pet {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    public Dog() {
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return getName() + ";" + getAge() + ";" + breed;
    }

    @Override
    public void getNoise() {
        System.out.println("Гав-гав!");
    }
}

class Cat extends Pet {
    private String color;

    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    public Cat() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return getName() + ";" + getAge() + ";" + color;
    }

    @Override
    public void getNoise() {
        System.out.println("Мяу-мяу!");
    }
}
