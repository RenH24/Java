
/*
Создайте класс-исключение HeavyLuggageException. Предусмотрите конструктор без параметров, в котором вызывается конструктор суперкласса со строковым аргументом “Превышение веса багажа”.
Создайте класс Luggage (багаж). В этом классе  создайте:
приватную финализированную переменную класса maxWeight (максимальный вес) типа double.
конструктор с одним параметром для инициализации переменной maxWeight.
метод void checkLuggage (double weight); В этом методе  сначала выводится на консоль сообщение “Взвесим багаж”. 
Затем анализируется параметр. Если он больше maxWeight, то выбрасывается исключение HeavyLuggageException. В конце метода выводится на консоль “Допустимый вес багажа”. Метод checkLuggage() исключений не обрабатывает.
В классе Main создайте метод main().  В нем создайте объект класса Luggage с максимальным весом багажа для тарифа Эконом Standart, равным 10 кг. 
Введите вес багажа  с консоли. Выведите на консоль “Надо пройти регистрацию на рейс”. 
Далее вызовите метод checkLuggage() c параметром, который ввел пользователь. 
Если выполнение метода прошло успешно, выведите на консоль “Доплата за вес не нужна”. 
Если нет – то выведите “Превышение веса багажа”, используя подходящий метод. 
Затем выведите “Нужно оплатить превышение веса по тарифу” В любом случае (как при удачном, так и при неудачном завершении метода checkLuggage()) выведите на консоль “Регистрация пройдена”.


Sample Input 1:
15.5
Sample Output 1:
Надо пройти регистрацию на рейс
Взвесим багаж
Превышение веса багажа
Нужно оплатить превышение веса по тарифу
Регистрация пройдена
  
Sample Input 2:
9.3
Sample Output 2:
Надо пройти регистрацию на рейс
Взвесим багаж
Допустимый вес багажа
Доплата за вес не нужна
Регистрация пройдена
*/

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Luggage luggage1 = new Luggage((double) 10);
        double weight = scan.nextDouble();

        try {
            System.out.println("Надо пройти регистрацию на рейс");
            luggage1.checkLuggage(weight);
            System.out.println("Доплата за вес не нужна");
        } catch (HeavyLuggageException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Нужно оплатить превышение веса по тарифу");
        } finally {
            System.out.println("Регистрация пройдена");
        }
    }
}

class HeavyLuggageException extends Exception {
    public HeavyLuggageException() {
        super("Превышение веса багажа");
    }
}

class Luggage {
    private final double maxWeight;

    public Luggage(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void checkLuggage (double weight) throws HeavyLuggageException {
        System.out.println("Взвесим багаж");
        if (weight > maxWeight) {
            throw new HeavyLuggageException();
        }
        System.out.println("Допустимый вес багажа");
    }
}
