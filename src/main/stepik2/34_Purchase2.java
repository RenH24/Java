package stepik2;
/*
Усовершенствуйте Васину программу так, чтобы в списке покупок могли быть как обычные товары, так и товары со скидкой. 
При этом в каждой строке сначала вводится тип класса (1 - класс Purchase, 2 - класс DiscountPurchase), а затем уже идут необходимые поля.
Как в Вашей программе используется полиморфизм?

Sample Input:
1 Сахар 2300 3
2 Мука 1750 5 20
1 Кофе 8500 1
2 Конфеты 4500 2 30
end
Sample Output:
Total sum = 28700
*/

import java.util.ArrayList;
import java.util.Scanner;

class Main34 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Purchase4> list = new ArrayList<>();

        String buffer = scan.nextLine();
        while (!"end".equals(buffer)) {
            String[] data = buffer.split(" ");
            int type = Integer.parseInt(data[0]);
            if (type == 1) {
                list.add(new Purchase4(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3])));
            } else {
                list.add(new DiscountPurchase(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4])));
            }
            buffer = scan.nextLine();
        }

        System.out.println("Total sum = " + getTotalSum(list));
    }

    public static int getTotalSum(ArrayList<Purchase4> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).getCost();
        }
        return sum;
    }
}

class Purchase4 {
    private String name;
    private int price;
    private int number;

    public Purchase4(String name, int price, int number) {
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public Purchase4() {
    }

    int getCost() {
        return price * number;
    }
}

class DiscountPurchase extends Purchase4 {
    private int discount;

    public DiscountPurchase(String name, int price, int number, int discount) {
        super(name, price, number);
        this.discount = discount;
    }

    public DiscountPurchase() {
        this.discount = 0;
    }

    @Override
    int getCost() {
        return super.getCost() - super.getCost() * discount / 100;
    }
}
