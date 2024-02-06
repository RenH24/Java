
/*
Создайте класс-исключение TooManyCarsException. Предусмотрите конструктор без параметров, в котором вызывается конструктор суперкласса со строковым аргументом “Вся парковка занята. Свободных мест нет.”
Создайте класс Parking (парковка), который содержит поле maxQuantity типа byte.
В классе Parking создайте:
конструктор c одним параметром для инициализации maxQuantity.
Метод check() с параметром quantity типа byte. Этот метод не возвращает результата. 
В нем сначала на консоль выводится “Ищем место для парковки”. Затем, если параметр больше maxQuantity, то выбрасывается исключение TooManyCarsException. 
В конце метода на консоль выводится: “Нашли место для парковки”. Метод check() не обрабатывает исключений.
В классе Main создайте метод main(). В этом методе создайте объект класса Parking, инициализировав поле maxQuantity значением 10.  
Введите с консоли количество машин. Затем выведите на консоль “Приехали на парковку” и вызовите метод check() с аргументом – количеством машин. 
Если места достаточно, то выведите “Припарковались”. Если нет – то на консоли должно быть сообщение  “Вся парковка занята. Свободных мест нет.”, а затем: “Припарковались в другом месте”. 
В любом случае последнее сообщение на консоли должно быть “Выходим из машин”.


Sample Input 1:
12
Sample Output 1:
Приехали на парковку
Ищем место для парковки
Вся парковка занята. Свободных мест нет.
Припарковались в другом месте
Выходим из машин
  
Sample Input 2:
7
Sample Output 2:
Приехали на парковку
Ищем место для парковки
Нашли место для парковки
Припарковались
Выходим из машин
*/

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Parking park1 = new Parking((byte) 10);
        byte quantity = scan.nextByte();        

        try {
            System.out.println("Приехали на парковку");
            park1.check(quantity);
            System.out.println("Припарковались");
        } catch (TooManyCarsException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Припарковались в другом месте");
        } finally {
            System.out.println("Выходим из машин");
        }
    }
}

class TooManyCarsException extends Exception {
    public TooManyCarsException() {
        super("Вся парковка занята. Свободных мест нет.");
    }
}

class Parking {
    private byte maxQuantity;

    public Parking(byte maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    public void check(byte quantity) throws TooManyCarsException {
        System.out.println("Ищем место для парковки");
        if (quantity > maxQuantity) {
            throw new TooManyCarsException();
        }
        System.out.println("Нашли место для парковки");
    }
}
