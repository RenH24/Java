
/*
Напишите программу, которая позволяет сравнить двух собак по размеру ошейника.
В классе Dog будут поля: кличка и порода, ошейник. Ошейник (Collar) - это вложенный приватный класс в классе Dog. Т.е. мы не моделируем магазин ошейников, а моделируем собак!
В классе Collar два поля: цвет и размер ошейника (размер - это обхват шеи, вещественное число). Добавьте конструктор и геттер для размера.
В классе Dog конструктор должен принимать все характеристики собаки: кличку, породу, цвет ошейника, размер ошейника.
Также в классе Dog должен быть метод compareTo(Dog two), который возвращает положительное число, 
если больше ошейник у собаки, от имени которой он вызывается, отрицательное - если больше ошейник у собаки-параметра метода. И возвращает ноль, если собаки одинакового размера. 
В классе Main введите данные двух собак, которые отделяются пробелами. 
Сравните размер ошейников и выведите сообщения "Первая собака больше", "Вторая собака больше" или "Собаки одинакового размера" в зависимости от ситуации.

Sample Input:
Жучка болонка красный 40
Мухтар овчарка черный 70.5
Sample Output:
Вторая собака больше
*/

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Dog one = new Dog(scan.next(), scan.next(), scan.next(), scan.nextDouble());
        Dog two = new Dog(scan.next(), scan.next(), scan.next(), scan.nextDouble());

        if (one.compareTo(two) > 0) {
            System.out.println("Первая собака больше");
        } else if (one.compareTo(two) < 0) {
            System.out.println("Вторая собака больше");
        } else {
            System.out.println("Собаки одинакового размера");
        }
    }
}

class Dog {
    private String name;
    private String breed;
    private Collar collar;

    public Dog(String name, String breed, String color, double size) {
        this.name = name;
        this.breed = breed;
        this.collar = new Collar(color, size);
    }

    public int compareTo(Dog two) {
        return (int) (collar.getSize() - two.collar.getSize());
    }

    private class Collar {
        private String color;
        private double size;

        public Collar(String color, double size) {
            this.color = color;
            this.size = size;
        }

        public double getSize() {
            return size;
        }
    }
}
