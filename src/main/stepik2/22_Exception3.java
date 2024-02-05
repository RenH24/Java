package stepik2;
/*
Создайте класс-исключение BakingException. Предусмотрите конструктор этого класса, в который передается сообщение о причине  неудачи с выпечкой.
Создайте класс Cook (повар), который содержит:
метод turnOvenOn() – выводит на консоль сообщение “Включаю плиту”;
метод turnOvenOff() - выводит на консоль сообщение “Выключаю плиту”
метод bake(String product). Этот метод сначала выводит на консоль сообщение “Готовлю блюдо”. Затем анализирует строку-параметр. 
Если она имеет значение “Прогорклое масло” или “Низкосортная мука”, то выбрасывается исключение BakingException (в конструктор этого исключения передается строка product). 
В конце метода выводится на консоль “Конец приготовления блюда”. Метод bake() исключений не обрабатывает.
В классе Main создайте метод main().  В нем введите с консоли строку с описанием продукта. 
Затем создайте объект класса Cook и вызовите последовательно методы turnOvenOn() и bake() c параметром-продуктом, который ввел пользователь. 
Если приготовление блюда прошло успешно, выведите на консоль “Блюдо готово”. 
Если нет – то выведите “Блюдо полностью испортилось” с сообщением о некачественном продукте. 
Обеспечьте выключение плиты (вызов метода turnOvenOff()) в любом случае: как при удачном, так и при неудачном завершении готовки.


Sample Input 1:
Прогорклое масло
Sample Output 1:
Включаю плиту
Готовлю блюдо
Блюдо полностью испортилось: Прогорклое масло
Выключаю плиту
  
Sample Input 2:
Свежие яйца
Sample Output 2:
Включаю плиту
Готовлю блюдо
Конец приготовления блюда
Блюдо готово
Выключаю плиту
*/

import java.util.Scanner;

class Main22 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        //ввод продукта и создание объекта
        String product = scan.nextLine();
        Cook dish = new Cook();        
        dish.turnOvenOn();
        
        //обработка исключений
        try {
            dish.bake(product);
            System.out.println("Блюдо готово");
        } catch (BakingException ex) {
            System.out.println("Блюдо полностью испортилось: " + ex.getMessage());
        } finally {
            dish.turnOvenOff();
        }
    }
}

class BakingException extends Exception {
    public BakingException() {
    }

    public BakingException(String message) {
        super(message);
    }
}

class Cook {
    public void turnOvenOn() {
        System.out.println("Включаю плиту");
    }

    public void turnOvenOff() {
        System.out.println("Выключаю плиту");
    }

    public void bake(String product) throws BakingException {
        System.out.println("Готовлю блюдо");
        if (product.equals("Прогорклое масло") || product.equals("Низкосортная мука")) {
            throw new BakingException(product);
        }
        System.out.println("Конец приготовления блюда");
    }
}
