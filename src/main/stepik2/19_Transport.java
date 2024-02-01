
/*
1. Опишите интерфейс Transport с методами:
boolean canCarry(double weight); //проверяет, может ли объект перевезти заданный груз
void  add(double weight); //добавить груз
double getTotalWeight(); //возвращает общий груз
2. Создайте классы Lorry (грузовик) и Ship (корабль), реализующие интерфейс Transport. Метод toString() этих классов должен отражать название  класса, грузоподъемность транспорта и вес нагруженного в данный момент.
3. В методе main() класса Main выполните следующее:
Введите размер массива и создайте массив транспортных средств.
Заполните массив объектами, считав их данные с консоли. В начале каждой строки стоит тип объекта: 1 - грузовик, 2 - корабль. Затем идет грузоподъемность транспортного средства. Все данные отделяются пробелами.
Введите вес груза.
Для каждого транспортного средства проверьте,  может ли оно перевезти этот груз. Если да – нагрузите его.
Распечатайте содержимое массива, используя метод toString() так, как это показано в примере теста.

Sample Input:
3
1 5
2 356
2 145
62.5
  
Sample Output:
Lorry{maxWeight=5.0, totalWeight=0.0}
Ship{maxWeight=356.0, totalWeight=62.5}
Ship{maxWeight=145.0, totalWeight=62.5}
*/

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Transport[] list = new Transport[scan.nextInt()];

        //заполнение массива
        for(int i = 0; i < list.length; i++) {
            int type = scan.nextInt();
            switch (type) {
                case 1:
                    list[i] = new Lorry(scan.nextDouble());
                    break;
                case 2:
                    list[i] = new Ship(scan.nextDouble());
                    break;
            }
        }

        //оценка возможности перевезти груз
        double weight = scan.nextDouble();
        for (Transport item: list) {
            if (item.canCarry(weight)) {
                item.add(weight);
            }
            System.out.println(item);
        }       
    }
}

interface Transport {
    boolean canCarry(double weight);
    
    void  add(double weight);
    
    double getTotalWeight();
}

class Lorry implements Transport {
    private double maxWeight;
    private double totalWeight = 0;

    public Lorry(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public boolean canCarry(double weight) {
        if (maxWeight >= weight + totalWeight) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void add(double weight) {
        totalWeight += weight;
    }

    @Override
    public double getTotalWeight() {
        return totalWeight;
    }

    @Override
    public String toString() {
        return "Lorry{" +
                "maxWeight=" + maxWeight +
                ", totalWeight=" + totalWeight +
                '}';
    }
}

class Ship implements Transport {
    private double maxWeight;
    private double totalWeight = 0;

    public Ship(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public boolean canCarry(double weight) {
        if (maxWeight >= weight + totalWeight) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void add(double weight) {
        totalWeight += weight;
    }

    @Override
    public double getTotalWeight() {
        return totalWeight;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "maxWeight=" + maxWeight +
                ", totalWeight=" + totalWeight +
                '}';
    }
}
