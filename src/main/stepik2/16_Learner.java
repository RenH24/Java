
/*
Создайте абстрактный класс Learner (Учащийся) и производные классы Schoolboy (Школьник) и Student (Студент). 
Класс Learner должен содержать поля «Фамилия» и «Оценка 1», «Оценка 2», метод для подсчета среднего балла и абстрактный метод «каникулы», который возвращает общую продолжительность каникул в году.
Класс Schoolboy имеет дополнительно поля «школа» и «класс». 
Класс Student имеет дополнительные поля «ВУЗ», «группа»  и статическое поле «базовый размер стипендии», а также метод для расчета стипендии в зависимости от среднего балла. 

В каждом классе должен быть переопределен метод toString(), который возвращает строку из значений полей в csv - формате (поля отделяются точкой с запятой).
Продолжительность каникул задайте 124 дня для школьников и 74 дня для студентов!

В методе main() класса Main выполнить следующее:
Ввести базовый размер стипендии и задать его в классе Student.
Ввести размер массива и создать массив учащихся.
Заполнить массив учащихся объектами, считав их данные с консоли. Данные каждого учащегося вводятся с новой строки, вначале которого стоит тип объекта: 1 - школьник, 2 - студент. 
Затем идут данные, которые отделяются пробелами: фамилия, оценка 1, оценка 2. Далее для школьника следует название школы и название класса, а для студента - название ВУЗа и группы.
Выведите список всех учащихся и продолжительность каникул каждого ( см. пример вывода в тесте).
С новой строки выведите средний балл успеваемости для всех учащихся в массиве (дробная часть этого значения должна иметь один знак).
Выведите список студентов, и с новой строки - сумму всех стипендий студентов. Если в массиве нет студентов, то нужно напечатать "NO", и больше ничего не выводить.

Sample Input:
110
5
1 Семенов 8 7 СШ21 8А
1 Коваленко 6 8 СШ10 9Б
2 Некрасов 9 8 ГГУ М21
2 Покровский 9 10 БТЭУ G21
2 Смирнова 7 5 ГГУ М11
  
Sample Output:
Семенов;8;7;СШ21;8А каникулы: 124
Коваленко;6;8;СШ10;9Б каникулы: 124
Некрасов;9;8;ГГУ;М21 каникулы: 74
Покровский;9;10;БТЭУ;G21 каникулы: 74
Смирнова;7;5;ГГУ;М11 каникулы: 74
7.7
Некрасов;9;8;ГГУ;М21
Покровский;9;10;БТЭУ;G21
Смирнова;7;5;ГГУ;М11
462
*/

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Student.setBaseScholarship(scan.nextInt());

        //создание и заполнение массива
        int n = scan.nextInt();
        Learner[] gruppa = new Learner[n];
        for(int i = 0; i < gruppa.length; i++) {
            int type = scan.nextInt();
            String name = scan.next();
            int gradeOne = scan.nextInt();
            int gradeTwo = scan.nextInt();
            switch (type) {
                case 1:
                    gruppa[i] = new Schoolboy(name, gradeOne, gradeTwo, scan.next(), scan.next());
                    break;
                case 2:
                    gruppa[i] = new Student(name, gradeOne, gradeTwo, scan.next(), scan.next());
                    break;
            }
        }
        
        //вывод массива
        for (Learner person: gruppa) {
            System.out.println(person + " каникулы: " + person.vacation());
        }
        
        //средний балл успеваемости для всех учащихся
        double summMark = 0.0;
        for (Learner person: gruppa) {
            summMark += person.averageGrade();
        }
        System.out.printf("%.1f", summMark/n);
        System.out.println();
        
        //вывод списка студентов и суммы степендий
        boolean students = false;
        int summScholarship = 0;
        for (int i = 0; i < gruppa.length; i++) {
            if (gruppa[i] instanceof Student) {
                Student person = (Student) gruppa[i];
                students = true;
                summScholarship += person.calculateScholarship();
                System.out.println(person);
            }
        }

        if (students) {
            System.out.println(summScholarship);
        } else {            
            System.out.println("NO");
        }
    }
}

abstract class Learner {
    private String name;
    private int gradeOne;
    private int gradeTwo;

    public Learner(String name, int gradeOne, int gradeTwo) {
        this.name = name;
        this.gradeOne = gradeOne;
        this.gradeTwo = gradeTwo;
    }

    public Learner() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGradeOne() {
        return gradeOne;
    }

    public void setGradeOne(int gradeOne) {
        this.gradeOne = gradeOne;
    }

    public int getGradeTwo() {
        return gradeTwo;
    }

    public void setGradeTwo(int gradeTwo) {
        this.gradeTwo = gradeTwo;
    }

    public double averageGrade() {
        return (gradeOne + gradeTwo) / 2.;
    }

    abstract int vacation();
}

class Schoolboy extends Learner {
    private String school;
    private String numberClass;

    public Schoolboy(String name, int gradeOne, int gradeTwo, String school, String numberClass) {
        super(name, gradeOne, gradeTwo);
        this.school = school;
        this.numberClass = numberClass;
    }

    public Schoolboy() {
    }

    @Override
    int vacation() {
        return 124;
    }

    @Override
    public String toString() {
        return getName() + ";" + getGradeOne() + ";" + getGradeTwo() + ";" + school + ";" + numberClass;
    }
}

class Student extends Learner {
    private String university;
    private String numberGrupp;
    private static int baseScholarship;

    public Student(String name, int gradeOne, int gradeTwo, String university, String numberGrupp) {
        super(name, gradeOne, gradeTwo);
        this.university = university;
        this.numberGrupp = numberGrupp;
    }

    public Student() {
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getNumberGrupp() {
        return numberGrupp;
    }

    public void setNumberGrupp(String numberGrupp) {
        this.numberGrupp = numberGrupp;
    }

    public static int getBaseScholarship() {
        return baseScholarship;
    }

    public static void setBaseScholarship(int baseScholarship) {
        Student.baseScholarship = baseScholarship;
    }

    public int calculateScholarship(){
        if (averageGrade() >= 9) {
            return (int) (baseScholarship * 1.6);
        } else if (averageGrade() >= 8) {
            return (int) (baseScholarship * 1.4);
        } else if (averageGrade() >= 6) {
            return (int) (baseScholarship * 1.2);
        } else if (averageGrade() >= 5) {
            return baseScholarship;
        } else {
            return 0;
        }
    }

    @Override
    int vacation() {
        return 74;
    }

    @Override
    public String toString() {
        return getName() + ";" + getGradeOne() + ";" + getGradeTwo() + ";" + university + ";" + numberGrupp;
    }
}
