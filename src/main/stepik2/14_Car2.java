
/*
В п.1.5 мы создали класс Car (автомобиль). Если Вы пропустили этот пункт, то создайте класс Car заново:
Поля:
марка, фамилия владельца, объем двигателя, год выпуска.

Cтатическое поле: текущий год.  
Статическое поле инициализировать в статическом блоке, используя следующий код:
Calendar cal = Calendar.getInstance(); //не забыть импортировать класс java.util.Calendar!
yearNow = cal.get(Calendar.YEAR);

Конструкторы: без параметров; с параметрами.

Методы: геттеры/сеттеры для всех полей экземпляра; геттер для статического поля;
int getLife( )– расчет возраста автомобиля в годах. 
toString( ) – переопределить метод toString() для вывода информации в формате: Car{brand='volvo', owner='Иванов', volume=2.6, yearOfMade=2014

Создайте также подкласс для класса Car, который представляет собой грузовой автомобиль (Truck).
Дополнительное поле: грузоподъемность в тоннах (вещественное число).
Дополнительный метод: boolean ifCanCarry(double weight) - возвращает true, если грузовик может перевести груз указанного веса.
Добавьте конструкторы, геттер и сеттер для нового поля, переопределите метод toString() так, чтобы он возвращал строку вида:
Truck{brand='fiat', owner='Иванов', volume=3.4, yearOfMade=2014, capacity=1.0}

В методе main() класса Main выполнить следующее:
Ввести количество элементов массива и создать массив ссылочных переменных типа Car соответствующего размера.
Заполнить массив данными, считав их с консоли. Данные о машине вводятся с новой строки. Первым числом идет тип автомобиля (1 - тип Car, 2 - тип Truck). Затем указывается марка, фамилия владельца, объем двигателя, год выпуска. Для грузовиков указывается в конце строки грузоподъемность. Данные отделяются пробелами.
Выведите массив на консоль, каждый элемент с новой строки (используйте переопределенный метод toString()).
Выведите пустую строку
Введите вес груза в отдельную переменную, и выведите список всех грузовиков, которые могут перевезти этот вес, и при этом имеют возраст не старше 6 лет. Если подходящих автомобилей нет, выведите "NO".

Sample Input:
7
1 volvo Иванов 2.4 2014
2 fiat Андреев 4.2 2020 1.0
1 toyota Петров 1.9 2003
2 citroen Смирнов 4.2 2010 0.99
1 nissan Cидоров 3.2 2018
2 УАЗ-3909 Коваленко 3.2 2018 0.925
2 ВИС-2347 Ермоленко 2.6 2022 0.49
0.5
  
Sample Output:
Car{brand='volvo', owner='Иванов', volume=2.4, yearOfMade=2014}
Truck{brand='fiat', owner='Андреев', volume=4.2, yearOfMade=2020, capacity=1.0}
Car{brand='toyota', owner='Петров', volume=1.9, yearOfMade=2003}
Truck{brand='citroen', owner='Смирнов', volume=4.2, yearOfMade=2010, capacity=0.99}
Car{brand='nissan', owner='Cидоров', volume=3.2, yearOfMade=2018}
Truck{brand='УАЗ-3909', owner='Коваленко', volume=3.2, yearOfMade=2018, capacity=0.925}
Truck{brand='ВИС-2347', owner='Ермоленко', volume=2.6, yearOfMade=2022, capacity=0.49}
*/

import java.util.Scanner;
import java.util.Calendar;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Car[] data = new Car[n];

        //заполнение массива
        for(int i = 0; i < data.length; i++) {
            int type = scan.nextInt();
            String brand = scan.next();
            String owner = scan.next();
            double volume = scan.nextDouble();
            int yearOfMade = scan.nextInt();
            switch (type) {
                case 1:
                    data[i] = new Car(brand, owner, volume, yearOfMade);
                    break;
                case 2:
                    data[i] = new Truck(brand, owner, volume, yearOfMade, scan.nextDouble());
                    break;
            }
        }

        //вывод массива на консоль
        for (Car item: data) {
            System.out.println(item);
        }
        System.out.println();

        //ввод веса и поиск подходящего грузовика
        double weight = scan.nextDouble();
        boolean available = false;
        for(int i = 0; i < data.length; i++) {
            if (data[i] instanceof Truck) {
                Truck item = (Truck) data[i];
                if (item.ifCanCarry(weight) && item.getLife() <= 6) {
                    available = true;
                    System.out.println(item);
                }
            }
        }

        if (available == false) {
            System.out.println("NO");
        } 
    }
}

class Car {
    private String brand;
    private String owner;
    private double volume;
    private int yearOfMade;
    static private int yearNow;

    static {
        Calendar cal = Calendar.getInstance();
        yearNow = cal.get(Calendar.YEAR);
    }

    public Car() {
    }

    public Car(String brand, String owner, double volume, int yearOfMade) {
        this.brand = brand;
        this.owner = owner;
        this.volume = volume;
        this.yearOfMade = yearOfMade;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public int getYearOfMade() {
        return yearOfMade;
    }

    public void setYearOfMade(int yearOfMade) {
        this.yearOfMade = yearOfMade;
    }

    public static int getYearNow() {
        return yearNow;
    }

    public int getLife() {
        return yearNow - yearOfMade;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", owner='" + owner + '\'' +
                ", volume=" + volume +
                ", yearOfMade=" + yearOfMade +
                '}';
    }
}

class Truck extends Car {
    private double capacity;

    public Truck() {
    }

    public Truck(String brand, String owner, double volume, int yearOfMade, double capacity) {
        super(brand, owner, volume, yearOfMade);
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "brand='" + getBrand() + '\'' +
                ", owner='" + getOwner() + '\'' +
                ", volume=" + getVolume() +
                ", yearOfMade=" + getYearOfMade() +
                ", capacity=" + capacity +
                '}';
    }

    public boolean ifCanCarry(double weight) {
        if (capacity >= weight) {
            return true;
        } else {
            return false;
        }
    }
}

Truck{brand='fiat', owner='Андреев', volume=4.2, yearOfMade=2020, capacity=1.0}
Truck{brand='УАЗ-3909', owner='Коваленко', volume=3.2, yearOfMade=2018, capacity=0.925}
