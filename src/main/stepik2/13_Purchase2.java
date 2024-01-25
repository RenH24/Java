
/*
В п.1.2 были созданы, а в п.1.4 были доработаны классы Commodity и Purchase

Commodity представляет товар.
Поля (приватные): название товара, цена в копейках.
Конструкторы: без параметров, с двумя параметрами.
Методы (все публичные):
геттеры и сеттеры для всех полей.
переопределенный метод toString(), который представляет объект как строку в csv - формате (значения полей отделяются точкой с запятой).  Например: Молоко;211
  
Purchase  описывает покупку.
Поля (приватные): товар (поле класса Commodity), количество единиц товара (целое).
Конструкторы: без параметров, с двумя параметрами, с одним параметром (товаром).
Методы (все публичные):
геттеры и сеттеры для всех полей.
int getCost() - вычисляет стоимость покупки в копейках (цена * количество).
Переопределенный метод toString(),  который представляет объект как строку в csv - формате (название товара, цена, количество). Последним элементом выводится стоимость покупки. Например: Молоко;211;2;422

Доработайте класс Purchase: переопределите методы equals() и hashCode(): две покупки считаются равными, если совпадают товары (название и цена). 
Подсказка: сначала переопределите эти методы в классе Commodity. Можно воспользоваться кодом, который генерирует Idea.

Разработать подкласс FixDiscountPurchase  для покупки товара с фиксированной скидкой от цены.  
В этом классе имеется дополнительное статическое поле  discount типа double (размер скидки в долях). Добавьте соответствующие конструкторы,  геттеры и сеттеры для этого поля. Переопределите:
метод getCost( ) -  стоимость покупки со скидкой. Учтите, что размер скидки округляется в меньшую сторону. Например, если скидка 0.1 (т.е. 10%)  для покупки стоимостью 422, то скидка 42 копейки. 
Стоимость товара тогда 422 - 42 = 380 копеек.
метод  toString( ): строка формируется из  названия товара, цены, количества, скидки и стоимости покупки. Например: Молоко;211;2;0.1;380

Разработать второй подкласс от Purchase с названием FlowDiscountPurchase. в котором скидка предоставляется в случае, если количество единиц товара не меньше некоторого заданного объема. 
Дополнительные статические поля: discount (размер скидки), minAmount (заданный объем товара, с которого начинает действовать скидка).
Добавьте конструкторы, геттеры и сеттеры для статических полей. Переопределить нужные методы:
метод getCost( ) -  стоимость покупки.
метод  toString( ): строка формируется из  названия товара, цены, количества, процента скидки, порога действия скидки  и стоимости покупки. Например: Молоко;211;2;0.1;2;380

В методе main() класса Main выполнить следующее:
Ввести количество элементов массива и создать массив ссылочных переменных типа Purchase соответствующего размера.
Затем ввести размер скидки в долях и задать соответствующее поле  для классов FixDiscountPurchase и FlowDiscountPurchase (одинаковые значение скидки для обоих классов). 
Также ввести минимальный объем покупки для получения скидки и задать его для класса FlowDiscountPurchase.
Ввести данные для каждого элемента массива. Данные о каждой покупке вводятся с новой строки и отделяются пробелами: номер класса, название товара, цена, количество. 
Номер класса может быть 1, 2 или 3: ( 1 - класс Purchase; 2 - класс FixDiscountPurchase; 3 - класс FlowDiscountPurchase). Название товара в тестах состоит из одного слова, поэтому можно его вводить методом сканнера next().
Вывести исходный массив покупок на консоль, используя метод toString().
Найти покупку с максимальной стоимостью и вывести индекс этой покупки в массиве на консоль с новой строки. 
Если покупок с такой стоимостью несколько, то выводится индекс первой их них (первый максимум).
Определить, являются ли все покупки равными. Вывести с новой строки "YES", если это так, и "NO", если нет. 
P.S. При создании кода equals() с помощью мастера Идеи  (Alt+Insert) поставьте флажок "Accept subclusses as parametr to equals() method", 
тогда в равными будут считаться не только объекты родительского класса, в которых совпадают товары, но и все наследники Purchase.

Sample Input:
6
0.1
3
1 Сахар 395 5
3 Сахар 395 5
1 Молоко 211 2
2 Молоко 211 2
3 Молоко 211 2
2 Сахар 395 5

Sample Output:
Сахар;395;5;1975
Сахар;395;5;0.1;3;1778
Молоко;211;2;422
Молоко;211;2;0.1;380
Молоко;211;2;0.1;3;422
Сахар;395;5;0.1;1778
0
NO
*/

import java.util.Scanner;
import java.util.Objects;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Purchase[] data = new Purchase[n];
        
        double discount = scan.nextDouble();
        FixDiscountPurchase.setDiscount(discount);
        FlowDiscountPurchase.setDiscount(discount);
        
        int minAmount = scan.nextInt();
        FlowDiscountPurchase.setMinAmount(minAmount);
        
        //заполнение массива
        for(int i = 0; i < data.length; i++) {
            int type = scan.nextInt();
            String name = scan.next();
            int price = scan.nextInt();
            int numbers = scan.nextInt();
            switch (type) {
                case 1:
                    data[i] = new Purchase(new Commodity(name, price), numbers);
                    break;
                case 2:
                    data[i] = new FixDiscountPurchase(new Commodity(name, price), numbers);
                    break;
                case 3:
                    data[i] = new FlowDiscountPurchase(new Commodity(name, price), numbers);
                    break;
                default:
                    data[i] = null;
            }
        }
        
        //вывод массива на консоль и поиск покупки с максимальной стоимостью
        int indMax = 0;
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
            if (data[i].getCost() > data[indMax].getCost()) {
                indMax = i;
            }
        }
        System.out.println(indMax);
        
        //сравнение покупок
        boolean different = false;
        for (int i = 1; i < data.length; i++) {
            if (!data[i].equals(data[0])) {
                different = true;
                break;
            }
        }
        
        if (different) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
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

    @Override
    public String toString() {
        return name + ";" + price + ";";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Commodity commodity)) return false;
        return price == commodity.price && Objects.equals(name, commodity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
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

    public int getCost() {
        return commodity.getPrice() * numbers;
    }

    @Override
    public String toString() {
        return commodity.getName() + ";" + commodity.getPrice() + ";" + numbers + ";" + getCost();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase purchase)) return false;
        return Objects.equals(commodity, purchase.commodity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commodity);
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }
}

class FixDiscountPurchase extends Purchase {
    static private double discount;

    public FixDiscountPurchase() {
    }

    public FixDiscountPurchase(Commodity commodity, int numbers) {
        super(commodity, numbers);
    }

    public static double getDiscount() {
        return discount;
    }

    public static void setDiscount(double discount) {
        FixDiscountPurchase.discount = discount;
    }

    @Override
    public int getCost() {
        return (super.getCost() - (int) (super.getCost() * discount));
    }

    @Override
    public String toString() {
        return getCommodity().getName() + ";" + getCommodity().getPrice() + ";" + getNumbers() + ";" + getDiscount() + ";" + getCost();
    }
}

class FlowDiscountPurchase extends Purchase {
    static private double discount;
    static private int minAmount;

    public FlowDiscountPurchase() {
    }

    public FlowDiscountPurchase(Commodity commodity, int numbers) {
        super(commodity, numbers);
    }

    @Override
    public int getCost() {
        if (getNumbers() >= minAmount) {
            return (super.getCost() - (int) (super.getCost() * discount));
        }
            return super.getCost();
    }

    @Override
    public String toString() {
        return getCommodity().getName() + ";" + getCommodity().getPrice() + ";" + getNumbers() + ";" + getDiscount() + ";" + getMinAmount() + ";" + getCost();
    }

    public static double getDiscount() {
        return discount;
    }

    public static void setDiscount(double discount) {
        FlowDiscountPurchase.discount = discount;
    }

    public static int getMinAmount() {
        return minAmount;
    }

    public static void setMinAmount(int minAmount) {
        FlowDiscountPurchase.minAmount = minAmount;
    }
}
