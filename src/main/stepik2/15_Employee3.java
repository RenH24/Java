package stepik2;
/*
В п.1.2 был создан, а в п.1.3 доработан класс Employee. Если Вы пропустили эти задачи, то создайте заново этот класс:
Поля: фамилия, пол, возраст, зарплата в копейках (целое число).

Методы:
boolean isPensioner() – возвращает true, если сотрудник пенсионного возраста (женщина старше 58 или мужчина старше 63). 
void changeSalary(double koef)  - изменяет зарплату работника, умножая ее на некоторый коэффициент
void show() - выводит данные о работнике в csv - формате (поля, отделенные точкой с запятой). Пример: Ivanov; male;48;90000

Создайте подкласс  Programmer - программист.
Дополнительные поля:
String status - может принимать значения: junior, middle, senior.
String specialization - может принимать значения: frontend, backend, fullstack, mobile.
Добавьте необходимые конструкторы, геттеры и сеттеры. Переопределите метод show так, чтобы в конце строки стоял статус программиста. Например:   Ivanov; male;48;90000;middle

Также создайте подкласс Accountant  - бухгалтер.
Дополнительное поле:
char gruppa - группа профстандарта (может принимать значения от A до E).
Добавьте необходимые конструкторы, геттеры и сеттеры. Переопределите метод show так, чтобы в конце строки стояла группа профстандарта. Например:   Ivanov; male;48;90000;B

В методе main() класса Main выполнить следующее:
Ввести количество элементов массива и создать массив ссылочных переменных типа Employee соответствующего размера.
Заполнить массив данными, считав их с консоли. Данные о сотруднике вводятся с новой строки. Первым числом идет тип сотрудника (1 - тип Employee, 2 - тип Programmer, 3 - тип Accountant). Затем указывается  фамилия, пол, возраст в годах, зарплата. Для программистов указывается в конце строки статус и специализация. А для бухгалтеров - группа профстандарта. Данные отделяются пробелами.   Напоминаю: у  Сканнера нет метода для чтения символа. Поэтому нужно группу профстандарта считывать как строку, а  потом передавать в конструктор нулевой символ этой строки: gruppa.charAt(0)
Выведите массив на консоль, каждый элемент с новой строки (используйте  метод show()).
Рассчитайте общий фонд заработной платы на месяц (сумму зарплат всех сотрудников) и выведите ее с новой строки.
Найдите сотрудника с самой большой зарплатой и выведите информацию о нем с новой строки методом show(). Если таких человек несколько, то выводим данные только первого из них (первый максимум).
Пропустите строку, а затем сформируйте команду программистов для frontend - разработки. Выведите список сотрудников на консоль. Также используйте метод show(). Если нужных сотрудников нет, то выведите "NO".

Sample Input:
7
1 Иванов male 34 150000
2 Петров male 28 260000 middle frontend
3 Кукушкина female 45 340000 B
2 Сидоров male 30 170000 junior mobile
1 Смирнов male 39 260000
2 Андреева female 25 180000 junior frontend
2 Коваленко male 36 210000 middle frontend
  
Sample Output:
Иванов;male;34;150000
Петров;male;28;260000;middle
Кукушкина;female;45;340000;B
Сидоров;male;30;170000;junior
Смирнов;male;39;260000
Андреева;female;25;180000;junior
Коваленко;male;36;210000;middle
1570000
Кукушкина;female;45;340000;B

Петров;male;28;260000;middle
Андреева;female;25;180000;junior
Коваленко;male;36;210000;middle
*/

import java.util.Scanner;

class Main15 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Employee3[] gruppa = new Employee3[n];
        
        //заполнение массива
        for(int i = 0; i < gruppa.length; i++) {
            int type = scan.nextInt();
            String surname = scan.next();
            String gender = scan.next();
            int age = scan.nextInt();
            int salary = scan.nextInt();
            switch (type) {
                case 1:
                    gruppa[i] = new Employee3(surname, gender, age, salary);
                    break;
                case 2:
                    gruppa[i] = new Programmer(surname, gender, age, salary, scan.next(), scan.next());
                    break;
                case 3:
                    String prof = scan.next();
                    char grup = prof.charAt(0);
                    gruppa[i] = new Accountant(surname, gender, age, salary, grup);
                    break;
            }
        }
        
        //вывод массива
        for (Employee3 worker: gruppa) {
            worker.show();
        }
        
        //рассчет и вывод общего фонда зарплат
        int fond = 0;
        for (Employee3 worker: gruppa) {
            fond += worker.getSalary();
        }
        System.out.println(fond);
                
        //поиск сотрудника с максимальной зарплатой
        int indMax = 0;
        for (int i = 0; i < gruppa.length; i++) {
            if (gruppa[i].getSalary() > gruppa[indMax].getSalary()) {
                indMax = i;
            }
        }
        gruppa[indMax].show();
        System.out.println();
        
        //формирование команды программистов
        boolean available = false;
        for(int i = 0; i < gruppa.length; i++) {
            if (gruppa[i] instanceof Programmer) {
                Programmer worker = (Programmer) gruppa[i];
                if ("frontend".equals(worker.getSpecialization())) {
                    available = true;
                    gruppa[i].show();
                }
            }
        }
        
        if (available == false) {
            System.out.println("NO");
        } 
    }
}

class Employee3 {
    private String surname;
    private String gender;
    private int age;
    private int salary;
    
    public Employee3() {
    }

    public Employee3(String surname, String gender, int age, int salary) {
        this.surname = surname;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
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
    
    public boolean isPensioner() {
        if ("male".equals(gender) && age >= 63 || "female".equals(gender) && age >= 58) return true;
        else return false;
    }
    
    public void changeSalary(double koef) {
        salary = (int) (salary * koef);
    }
    
    public void show() {
        System.out.println(surname + ";" + gender + ";" + age + ";" + salary);
    }
}

class Programmer extends Employee3 {
    private String status;
    private String specialization;

    public Programmer() {
    }

    public Programmer(String surname, String gender, int age, int salary, String status, String specialization) {
        super(surname, gender, age, salary);
        this.status = status;
        this.specialization = specialization;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public void show() {
        System.out.println(getSurname() + ";" + getGender() + ";" + getAge() + ";" + getSalary() + ";" + status);
    }
}


class Accountant extends Employee3 {
    private char gruppa;

    public Accountant() {
    }

    public Accountant(String surname, String gender, int age, int salary, char gruppa) {
        super(surname, gender, age, salary);
        this.gruppa = gruppa;
    }

    public char getGruppa() {
        return gruppa;
    }

    public void setGruppa(char gruppa) {
        this.gruppa = gruppa;
    }

    @Override
    public void show() {
        System.out.println(getSurname() + ";" + getGender() + ";" + getAge() + ";" + getSalary() + ";" + gruppa);
    }    
}