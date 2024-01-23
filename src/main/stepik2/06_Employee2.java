
/*
Доработайте класс Employee, созданный в п.1.2:
Сделайте все поля приватными согласно принципу инкапсуляции;
Добавьте в класс конструкторы, геттеры и сеттеры.

В классе Main опишите метод main(), в котором нужно:
Считать с консоли размер массива. Если введено отрицательное число, то вывести "ERROR" и закончить программу.
Создать массив сотрудников заданного размера;
Заполнить массив данными, считав их с консоли. В каждой строке указывается через пробел: фамилия, пол, возраст и зарплата в копейках.
Для всех пенсионеров задать одинаковую зарплату 90000 копеек.
Вывести данные о всех сотрудниках в csv - формате, используя метод show(). Информация о каждом сотруднике выводится с новой строки.

Sample Input:
3
Сидоров male 67 78000
Петрова female 45 120000
Семенов male 36 140000
  
Sample Output:
Сидоров;male;67;90000
Петрова;female;45;120000
Семенов;male;36;140000
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
        
        Employee[] list = new Employee[size];
        for(int i = 0; i < list.length; i++) {
            list[i] = new Employee(scan.next(), scan.next(), scan.nextInt(), scan.nextInt());
            if(list[i].isPensioner()) {
                list[i].setSalary(90000);
            }
        }
        
        for(int i = 0; i < list.length; i++) {
            if(list[i] != null) {
                list[i].show();
            }
        }        
    }
}

class Employee {
    private String surname;
    private String gender;
    private int age;
    private int salary;

    public Employee() {
    }

    public Employee(String surname, String gender, int age, int salary) {
        this.surname = surname;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
    }
    
    boolean isPensioner() {
        if ("male".equals(gender) && age >= 63 || "female".equals(gender) && age >= 58) return true;
        else return false;
    }
    
    void show() {
        System.out.println(surname + ";" + gender + ";" + age + ";" + salary);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
