package stepik2;
/*
Создать класс Car, представляющий автомобиль.
Поля:
марка,
фамилия владельца,
объем двигателя
год выпуска.
статическое поле: текущий год.
  
Статическое поле инициализировать в статическом блоке, используя следующий код:
Calendar cal = Calendar.getInstance(); //не забыть импортировать класс java.util.Calendar!
yearNow = cal.get(Calendar.YEAR);

Конструкторы:
без параметров;
с параметрами.

Методы:
геттеры/сеттеры для всех полей экземпляра;
геттер для статического поля;
int getLife( )– расчет возраста автомобиля в годах. 
toString( ) – переопределить метод toString() для вывода информации в формате:
Car{brand='volvo', owner='Иванов', volume=2.6, yearOfMade=2014}

В методе main() класса Main выполнить следующее (корректность вводимых данных гарантируется, можно ее не проверять):
Ввести размер массива автомобилей.
Создать массив из ссылок на класс Car нужного размера и заполнить его данными, считывая их с консоли. Данные при вводе отделяются пробелами.
Ввести номер  автомобиля (номер считается с 1) и объем  двигателя. Изменить данные об этом автомобиле в массиве, задав сеттером  этот новый объем двигателя.
Вывести массив на консоль с использованием метода toString( ).
Вывести пустую строку.
Найти самый новый автомобиль в массиве и распечатать его данные.

Sample Input:
3
volvo Иванов 2.4 2014
toyota Петров 1.9 2003
nissan Сидоров 3.2 2018
1 2.6
Sample Output:
Car{brand='volvo', owner='Иванов', volume=2.6, yearOfMade=2014}
Car{brand='toyota', owner='Петров', volume=1.9, yearOfMade=2003}
Car{brand='nissan', owner='Сидоров', volume=3.2, yearOfMade=2018}

Car{brand='nissan', owner='Сидоров', volume=3.2, yearOfMade=2018}
*/

import java.util.Scanner;
import java.util.Calendar;

class Main11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Car[] data = new Car[n];
        
        //заполнение массива
        for (int i = 0; i < data.length; i++) {
            data[i] = new Car(scan.next(), scan.next(), scan.nextDouble(), scan.nextInt());
        }
        
        //изменение объема двигателя
        int ind = scan.nextInt();
        double newVolume = scan.nextDouble();
        data[ind - 1].setVolume(newVolume);
        
        //вывод массива на консоль
        for (Car item: data) {
            System.out.println(item);
        }
        System.out.println();
        
        //поиск самого нового автомобиля
        int min = data[0].getLife();
        int idMin = 0;
        for (int i = 1; i < data.length; i++) {
            if(data[i].getLife() < min) {
                min = data[i].getLife();
                idMin = i;
            }
        }
        System.out.println(data[idMin]);
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
}