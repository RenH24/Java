
/*
Доработайте  класс Commodity, созданный в п.1.2:
Сделайте все поля приватными согласно принципу инкапсуляции. А методы сделайте публичными.
Добавьте в класс два разных конструктора, а также геттеры и сеттеры для всех полей.
Переопределите метод toString() так, чтобы данные выводились в csv - формате.

Также доработайте класс Purchase:
Сделайте все поля приватными, а методы публичными (в том числе метод getCost()).
Добавьте в класс два разных конструктора, геттеры и сеттеры  для всех полей.
Переопределите метод toString() так, чтобы данные выводились в csv - формате (название, цена, количество). Последним элементом выводится стоимость покупки. Например:
Сахар;260;5;1300

В классе Main в методе main() напишите код, в котором нужно:
Считать с консоли размер массива. Если введено отрицательное число, то напечатать ERROR и закончить программу.
Создать массив покупок (типа Purchase) нужного размера.
Заполнить массив данными, считав их с консоли. Гарантируется корректность исходных данных в тестах, поэтому проверять их не нужно.
Определить максимальную стоимость покупки. Вывести все покупки с данной стоимостью в csv - формате.

Sample Input:
4
Сахар 260 4
Сыр 1040 1
Мука 450 1
Масло 520 2

Sample Output:
Сахар;260;4;1040
Сыр;1040;1;1040
Масло;520;2;1040
*/

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if (n < 0) {
            System.out.println("ERROR");
            return;
        }
        Purchase[] list = new Purchase[n];
        
        for(int i = 0; i < list.length; i++) {
            list[i] = new Purchase(new Commodity(scan.next(), scan.nextInt()), scan.nextInt());
        }
        
        int max = list[0].getCost();
        for(int i = 0; i < list.length; i++) {
            if(list[i].getCost() > max) {
                max = list[i].getCost();
            }
        }
        for(Purchase item: list) {
            if(item.getCost() == max) {
                System.out.println(item);
            }
        }
    }
}

class Commodity {
    private String name;
    private int price;

    public Commodity() {
    }

    public Commodity(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void show() {
        System.out.println("Наименование товара: " + name);
        System.out.println("Цена товара: " + price);
    }

    @Override
    public String toString() {
        return name + ";" + price + ";";
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }
}

class Purchase {
    private Commodity commodity;
    private int numbers;

    public Purchase() {
    }

    public Purchase(Commodity commodity, int numbers) {
        this.commodity = commodity;
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return commodity.getName() + ";" + commodity.getPrice() + ";" + numbers + ";" + getCost();
    }

    public int getCost() {
        return commodity.getPrice() * numbers;
    }

    public void show() {
        commodity.show();
        System.out.println("Количество: " + numbers);
        System.out.println("Стоимость покупки: " + getCost());
    }
}
