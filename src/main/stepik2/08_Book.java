package stepik2;
/*
Создайте класс Book: Название, Автор(ы), Издательство, Год издания. Определите несколько конструкторов. 
Если в конструктор не передается значение какого-то поля, то этому полю присваиваются значения по умолчанию. Для строк это пустая строка: "", для чисел 0.

Переопределите метод toString(). Он должен формировать строку в csv - формате, в которой значения всех полей отделяются точками с запятыми.

В классе Main выполняется тестирование  созданного класса: вводятся данные  книги (каждое значение с новой строки) и создается объект класса Book.  
Данные о годе издания или данные об издательстве могут отсутствовать. Также может вообще отсутствовать информация о книге (тогда создается объект конструктором без параметров). 
Затем выводится информация о книге в csv - формате.

Sample Input:
Ведьмак. Последнее желание
Анджей Сапковский
Москва:ACT
2014
  
Sample Output:
Ведьмак. Последнее желание;Анджей Сапковский;Москва:ACT;2014
*/
import java.util.Scanner;

class Main8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name;
        String author;
        String publisher;
        int year;
        Book myBook = null;
        if (!scan.hasNextLine()) {
            myBook = new Book();
        } else {
            name = scan.nextLine();
            author = scan.nextLine();
            if (!scan.hasNextLine()) {
                myBook = new Book(name, author);
            } else {
                publisher = scan.nextLine();
                if (!scan.hasNextInt()) {
                    myBook = new Book(name, author, publisher);
                } else {
                    year = scan.nextInt();
                    myBook = new Book(name, author, publisher, year);
                }
            }
        }
        System.out.println(myBook);
    }   
}  

class Book {
    private String name;
    private String author;
    private String publisher;
    private int year;

    public Book() {
        this.name = "";
        this.author = "";
        this.publisher = "";
        this.year = 0;
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
        this.publisher = "";
        this.year = 0;
    }

    public Book(String name, String author, String publisher) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.year = 0;
    }

    public Book(String name, String author, String publisher, int year) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
    }

    @Override
    public String toString() {
        return name + ";" + author + ";" + publisher + ";" + year;
    }
}