package stepik2;
/*
Разработать класс Purchase, описывающий покупку товара:
Поля: название товара; цена в копейках; кол-во единиц товара.
В классе Main создать массив покупок, данные вводятся с консоли. В первой строке вводится количество элементов массива. В последующих строках  - данные каждой покупки, разделенные пробелами.
Отсортировать  массив покупок по названию товара и вывести на консоль. Для каждого объекта выводятся: название товара, цена, количество, стоимость в копейках (отделенные пробелами). 
Затем отсортировать по стоимости покупки (стоимость=цена*количество) и после пустой строки снова вывести на консоль. Использовать метод sort() класса Arrays.

Sample Input:
3
Молоко 169 2
Сахар 269 1
Кофе 695 1
Sample Output:
Кофе 695 1 695
Молоко 169 2 338
Сахар 269 1 269

Сахар 269 1 269
Молоко 169 2 338
Кофе 695 1 695
*/

import java.util.Comparator;
import java.util.Scanner;
import static java.util.Arrays.sort;

class Main35 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //создание массива и ввод данных
        Purchase5[] list = new Purchase5[scan.nextInt()];

        for (int i = 0; i < list.length; i++) {
            list[i] = new Purchase5(scan.next(), scan.nextInt(), scan.nextInt());
        }
        //сортировка по названию и вывод на консоль
        sort(list, new Comparator<Purchase5>() {
            @Override
            public int compare(Purchase5 o1, Purchase5 o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        for (Purchase5 item: list) {
            System.out.println(item);
        }
        System.out.println();
        //сортировка по стоимости
        sort(list, new Comparator<Purchase5>() {
            @Override
            public int compare(Purchase5 o1, Purchase5 o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        for (Purchase5 item: list) {
            System.out.println(item);
        }
    }
}

class Purchase5 {
    private String name;
    private int price;
    private int number;

    public Purchase5(String name, int price, int number) {
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public int getValue() {
        return getPrice() * getNumber();
    }

    @Override
    public String toString() {
        return name + " " + price + " " + number + " " + getValue();
    }

    public String getName() {
        return name;
    }
    

    public int getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }
}
