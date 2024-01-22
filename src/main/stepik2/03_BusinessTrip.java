package stepik2;
/*
Описать класс BusinessTrip, хранящий информацию о командировочных расходах работников. Учтите, что денежные средства нужно хранить в целых переменных!

Поля:
суточные в рублях (константа) - присвоить значение 25;
ФИ работника;
транспортные расходы в  рублях;
количество дней.

Методы:
 getTotal( ) – расчёт общей величины расходов (=транспортные + кол-во дней * суточные);
 show( ) – вывод всех полей на консоль по одному в строке в формате name=value. Пример:
Суточные = 25
Фамилия Имя = Борисов Андрей
Транспортные расходы = 80
Количество дней = 3
Итого расходы = 155

В классе Main описать метод main(), в котором:
Создать объект класса BusinessTrip
Считать значения его полей с консоли. При этом в первой строке располагаются фамилия и имя, а во второй - количество дней и транспортные расходы через пробел.
Вывести данные о командировке методом show().

Sample Input:
Борисов Андрей
3 80
Sample Output:
Суточные = 25
Фамилия Имя = Борисов Андрей
Транспортные расходы = 80
Количество дней = 3
Итого расходы = 155
*/

import java.util.Scanner;

class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BusinessTrip trip1 = new BusinessTrip();
        trip1.name = scan.nextLine();
        trip1.days = scan.nextInt();
        trip1.transCosts = scan.nextInt();
        trip1.show();
    }
}

class BusinessTrip {
    static final int PER_DIEM = 25;
    String name;
    int days;
    int transCosts;
    
    int getTotal() {
        return (transCosts + (days * PER_DIEM));
    }
    
    void show() {
        System.out.println("Суточные = " + PER_DIEM);
        System.out.println("Фамилия Имя = " + name);
        System.out.println("Транспортные расходы = " + transCosts);
        System.out.println("Количество дней = " + days);
        System.out.println("Итого расходы = " + getTotal());
    }
}
