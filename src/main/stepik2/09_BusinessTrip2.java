
/*
Доработайте класс BusinessTrip, созданный в п.1.2:
Сделайте все поля приватными согласно принципу инкапсуляции. А методы сделайте публичными.
Добавьте в класс три разных конструктора, геттеры и сеттеры.
Создайте четвертый конструктор клонирования.
Переопределите методы класса Object:
equals() и hashCode() - равными считаются командировки, у которых равны общие расходы.
toString() - данные должны выводиться в csv - формате. Также выводятся и общие расходы. Например:
Шумский;4;28;128

В классе Main в методе main() напишите код, в котором нужно:
Считать с консоли размер массива. Если введено отрицательное число, то напечатать ERROR и закончить программу.
Создать массив командировок (типа BusinessTrip) нужного размера.
Заполнить массив данными, считав их с консоли, кроме последней командировки. Гарантируется корректность исходных данных в тестах, поэтому проверять их не нужно.
Последний объект в массиве создать с помощью конструктора клонирования, сделав его копией элемента массива с индексом 0. 
Очистить буфер ввода, например методом  scan.skip("\n");
Изменить фамилию в командировке с индексом 0, считав данные с консоли.
Вывести список всех командировок в csv-формате. Затем вывести пустую строку.
Ввести с консоли индекс командировки (корректность не проверяем). Вывести в csv - формате все командировки, которые считаются равными элементу массива с этим индексом (включая и сам этот элемент).

Sample Input:
4
Иванов 3 65
Петров 1 26
Сидоров 2 90
Сергеев
2
Sample Output:
Сергеев;3;65;140
Петров;1;26;51
Сидоров;2;90;140
Иванов;3;65;140

Сергеев;3;65;140
Сидоров;2;90;140
Иванов;3;65;140
*/

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        if (size < 0) {
            System.out.println("ERROR");
            return;
        }
        
        BusinessTrip[] list = new BusinessTrip[size];
        for(int i = 0; i < list.length - 1; i++) {
            list[i] = new BusinessTrip(scan.next(), scan.nextInt(), scan.nextInt());
        }
        
        list[list.length - 1] = new BusinessTrip(list[0]);
        scan.skip("\n");

        list[0].setName(scan.next());
        for(int i = 0; i < list.length; i++) {
            if(list[i] != null) {
                System.out.println(list[i]);
            }
        }
        System.out.println();
        
        int ind = scan.nextInt();
        for(int i = 0; i < list.length; i++) {
            if(list[i] != null) {
                if(list[i].equals(list[ind])) {
                    System.out.println(list[i]);
                }
            }
        }
    }
}

class BusinessTrip {
    static final int PER_DIEM = 25;
    private String name;
    private int days;
    private int transCosts;

    public BusinessTrip() {
    }

    public BusinessTrip(String name, int days) {
        this.name = name;
        this.days = days;
    }

    public BusinessTrip(String name, int days, int transCosts) {
        this.name = name;
        this.days = days;
        this.transCosts = transCosts;
    }

    public BusinessTrip(BusinessTrip businessTrip) {
        this.name = businessTrip.name;
        this.days = businessTrip.days;
        this.transCosts = businessTrip.transCosts;
    }

    public int getTotal() {
        return transCosts + (days * PER_DIEM);
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        BusinessTrip that = (BusinessTrip) obj;
        return this.getTotal() == that.getTotal();
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(getTotal());
    }

    @Override
    public String toString() {
        return name + ";" + days + ";" + transCosts + ";" + getTotal();
    }

    public void show() {
        System.out.println("Суточные = " + PER_DIEM);
        System.out.println("Фамилия Имя = " + name);
        System.out.println("Транспортные расходы = " + transCosts);
        System.out.println("Количество дней = " + days);
        System.out.println("Итого расходы = " + getTotal());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getTransCosts() {
        return transCosts;
    }

    public void setTransCosts(int transCosts) {
        this.transCosts = transCosts;
    }
}
