package stepik2;
/*
Описать класс Commodity, описывающий товар.
Поля:
название товара;
цена в копейках.
Методы (все публичные)
void setPrice(int price) - изменяет цену товара, задавая этому полю значение price
void show() - выводит на консоль значения всех полей по одному в строке в формате name: value. Пример:
Наименование товара: сахар
Цена товара: 260
  
Описать класс Purchase, описывающий покупку товара.
Поля:
товар (поле класса Commodity)
количество единиц товара (целое)
Методы:
int getCost() - вычисляет стоимость покупки в копейках (цена * количество). Этот метод должен быть приватным.
void show() - выводит на консоль значения всех полей по одному в строке в формате name: value. Этот метод публичный. Пример:
Наименование товара: сахар
Цена товара: 260
Количество: 5
Стоимость покупки: 1300

В классе Main описать метод main(), в котором:
Создать объект класса Commodity
Считать значения его полей с консоли. При этом в первой строке располагается название товара, а во второй - цена в копейках.
Создать объект класса Purchase. В качестве товара присвоить ранее созданный объект класса Commodity, а количество считать из следующей строки консоли.
Вывести информацию о покупке, используя метод show().
Считать новую цену товара с консоли. Изменить цену товара в созданном объекте класса Commоdity.
Вывести пустую строку на консоль.
Вновь вывести информацию о покупке, используя метод show().

Sample Input:
Сахар
260
5
290
Sample Output:
Наименование товара: Сахар
Цена товара: 260
Количество: 5
Стоимость покупки: 1300

Наименование товара: Сахар
Цена товара: 290
Количество: 5
Стоимость покупки: 1450
*/

import java.util.Scanner;

class Main4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Commodity commodity = new Commodity();
        commodity.name = scan.nextLine();
        commodity.price = scan.nextInt();
        
        Purchase purchase = new Purchase();
        purchase.commodity = commodity;
        purchase.numbers = scan.nextInt();
        purchase.show();
        
        int newPrice = scan.nextInt();
        commodity.setPrice(newPrice);
        System.out.println();
        purchase.show();
    }
}

class Commodity {
    String name;
    int price;
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    public void show() {
        System.out.println("Наименование товара: " + name);
        System.out.println("Цена товара: " + price);
    }
}

class Purchase {
    Commodity commodity;
    int numbers;
    
    private int getCost() {
        return commodity.price * numbers;
    }
    
    public void show() {
        commodity.show();
        System.out.println("Количество: " + numbers);
        System.out.println("Стоимость покупки: " + getCost());
    }
}
