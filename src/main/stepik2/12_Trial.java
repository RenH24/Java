
/*
Рассмотрим процесс развития проекта по организации учета вступительных экзаменов на тренинг по программированию.

Начальный проект
Кандидаты проходят испытание, включающее в себя два теста, которые оцениваются целым числом в диапазоне от 0 до 100 включительно. 
Считается, что испытание пройдено, если  результат каждого теста не менее заранее заданного числа. 

Создается класс Trial:
Статическое поле: проходной балл.
Поля экземпляра: Фамилия, балл 1, балл 2.
Конструкторы: без параметров, с тремя параметрами, с одним параметром (фамилией). Если баллы не заданы, то они равны 0.
Методы:
геттеры и сеттеры для всех полей,  
boolean isPassed()  - выдает true, если испытание пройдено.
toString() - данные об испытании представляются в csv-формате.
  
Модернизация проекта
Добавляется новый вид испытания – упрощенное (LightTrial). Сумма баллов по обоим испытаниям должна быть не меньше проходного балла. 

Новая модернизация
Добавляется еще один вид испытания – усиленное (StrongTrial). Как и в основном варианте,  результат  каждого теста должен быть не менее проходного балла, но учитывается время прохождения теста. 
Имеется статическая переменная: лимит времени и поле экземпляра: время прохождения теста (время в минутах - целое число). 

В методе main() класса Main нужно выполнить следующее:
Ввести проходной балл и лимит времени для StrongTrial. Задать их в классах.
Ввести количество элементов массива и создать массив ссылочных  переменных класса Trial.
Ввести данные об испытаниях, каждое испытание с новой строки. Вводится тип испытания ( 1- Trial, 2 - LightTrial, 3 - StrongTrial), затем фамилия, баллы за каждый тест и время прохождения теста (для типа 3). Данные в строке отделяются пробелами.
Вывести массив на консоль (по одному элементу в строке, каждый элемент в csv - формате).
Вывести пустую строку.
Вывести список поступивших на тренинг (прошедших испытания).

Sample Input:
75
60
5
2 Иванов 50 60
1 Петров 70 80
3 Сидоров 80 78 55
3 Кириллов 90 90 67
1 Иволгин 90 60
  
Sample Output:
Иванов;50;60
Петров;70;80
Сидоров;80;78;55
Кириллов;90;90;67
Иволгин;90;60

Иванов;50;60
Сидоров;80;78;55
*/

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Trial.setScore(scan.nextInt());
        StrongTrial.setTimeLimit(scan.nextInt());

        int n = scan.nextInt();
        Trial[] data = new Trial[n];
        
        //заполнение массива
        for(int i = 0; i < data.length; i++) {
            int type = scan.nextInt();
            String name = scan.next();
            int point1 = scan.nextInt();
            int point2 = scan.nextInt();
            switch (type) {
                case 1:
                    data[i] = new Trial(name, point1, point2);
                    break;
                case 2:
                    data[i] = new LightTrial(name, point1, point2);
                    break;
                case 3:
                    data[i] = new StrongTrial(name, point1, point2, scan.nextInt());
                    break;
                default:
                    data[i] = null;
            }
        }
        
        //вывод массива на консоль и вывод пустой строки
        for (Trial item: data) {
            System.out.println(item);
        }
        System.out.println();
        
        //вывод списка поступивших
        for (Trial item: data) {
            if (item.isPassed()) {
                System.out.println(item);
            }
        }
        
    }
}

class Trial {
    static private int score;
    private String name;
    private int point1;
    private int point2;

    public Trial() {
    }

    public Trial(String name, int point1, int point2) {
        this.name = name;
        this.point1 = point1;
        this.point2 = point2;
    }

    public Trial(String name) {
        this.name = name;
    }

    public boolean isPassed() {
        if (point1 >= score && point2 >= score) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return name + ";" + point1 + ";" + point2;
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        Trial.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint1() {
        return point1;
    }

    public void setPoint1(int point1) {
        this.point1 = point1;
    }

    public int getPoint2() {
        return point2;
    }

    public void setPoint2(int point2) {
        this.point2 = point2;
    }
}

class LightTrial extends Trial {
    public LightTrial() {
    }

    public LightTrial(String name, int point1, int point2) {
        super(name, point1, point2);
    }

    public LightTrial(String name) {
        super(name);
    }

    @Override
    public boolean isPassed() {
        if ((getPoint1() + getPoint2()) >= getScore()) {
            return true;
        } else {
            return false;
        }
    }
}

class StrongTrial extends Trial {
    static private int timeLimit;
    private int timePass;

    public StrongTrial() {
    }

    public StrongTrial(int timePass) {
        this.timePass = timePass;
    }

    public StrongTrial(String name, int point1, int point2, int timePass) {
        super(name, point1, point2);
        this.timePass = timePass;
    }

    public StrongTrial(String name, int timePass) {
        super(name);
        this.timePass = timePass;
    }

    public static int getTimeLimit() {
        return timeLimit;
    }

    public static void setTimeLimit(int timeLimit) {
        StrongTrial.timeLimit = timeLimit;
    }

    public int getTimePass() {
        return timePass;
    }

    public void setTimePass(int timePass) {
        this.timePass = timePass;
    }

    @Override
    public boolean isPassed() {
        if (getPoint1() >= getScore() && getPoint2() >= getScore() && getTimePass() <= getTimeLimit()) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public String toString() {
        return getName() + ";" + getPoint1() + ";" + getPoint2() + ";" + getTimePass();
    }
}
