/*
Описать класс Employee, предназначенный для хранения информации  о работниках организации.

Поля:
фамилия
пол
возраст
зарплата в копейках (целое число)
  
Методы:
boolean isPensioner() – возвращает true, если сотрудник пенсионного возраста (женщина старше 58 или мужчина старше 63). 
void changeSalary(double koef)  - изменяет зарплату работника, умножая ее на некоторый коэффициент
void show() - выводит данные о работнике в csv - формате (поля, отделенные точкой с запятой). Пример: 
 Ivanov; male;48;90000

В классе Main описать метод main(), в котором:
Создать объект класса Employee
Считать значения его полей с консоли. Все данные располагаются в одной строке через пробел
Если сотрудник является пенсионером, то уменьшить его зарплату на 10 процентов (умножить на коэффициент 0.9). Использовать методы isPensioner() и changeSalary()
Вывести данные о сотруднике в csv - формате с помощью метода show().
P.S. Напоминаю, что строки на равенство сравнивает метод equals()!!! 


Sample Input:
Ivanov male 65 100000
Sample Output:
Ivanov;male;65;90000
*/

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Employee person = new Employee();
        person.surname = scan.next();
        person.gender = scan.next();
        person.age = scan.nextInt();
        person.salary = scan.nextInt();
        if (person.isPensioner()) {
            person.changeSalary(0.9);
        }
        person.show();        
    }
}

class Employee {
    String surname;
    String gender;
    int age;
    int salary;
    
    boolean isPensioner() {
        if ("male".equals(gender) && age >= 63 || "female".equals(gender) && age >= 58) return true;
        else return false;
    }
    void changeSalary(double koef) {
        salary = (int) (salary * koef);
    }
    void show() {
        System.out.println(surname + ";" + gender + ";" + age + ";" + salary);
    }  
}
