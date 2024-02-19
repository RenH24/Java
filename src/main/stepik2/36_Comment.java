
/*
Опишите класс Comment (комментарий) с полями: автор, текст, количество лайков.
В классе Main создайте массив комментариев, данные вводятся с консоли. В первой строке вводится количество элементов массива. В последующих строках  - сами комментарии. 
Каждый комментарий на отдельной строке. Элементы отделяются точкой с запятой.  
Отсортируйте массив по убыванию количества лайков. Распечатайте содержимое массива (поля каждого комментария отделяются #). 
Выведите пустую строку. Затем отсортируйте по автору. Распечатайте содержимое массива снова.

Sample Input:
4
Иван;Классное видео!;12
Андрей Петрович;Что за ужас?;3
Анна Семенова;Круто!;10
Иван;Когда еще будет?;5
Sample Output:
Иван#Классное видео!#12
Анна Семенова#Круто!#10
Иван#Когда еще будет?#5
Андрей Петрович#Что за ужас?#3

Андрей Петрович#Что за ужас?#3
Анна Семенова#Круто!#10
Иван#Классное видео!#12
Иван#Когда еще будет?#5
*/

import java.util.Comparator;
import java.util.Scanner;
import static java.util.Arrays.sort;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //создание массива
        Comment[] mas = new Comment[scan.nextInt()];
        scan.useDelimiter(";|\n");
        for (int i = 0; i < mas.length; i++) {
            mas[i] = new Comment(scan.next(), scan.next(), scan.nextInt());
        }

        //сортировка по количеству лайков
        sort(mas, new Comparator<Comment>() {
            @Override
            public int compare(Comment o1, Comment o2) {
                return o2.getLikes() - o1.getLikes();
            }
        });
        for (Comment comm: mas) {
            System.out.println(comm);
        }
        System.out.println();

        //сортировка по автору
        sort(mas, new Comparator<Comment>() {
            @Override
            public int compare(Comment o1, Comment o2) {
                return o1.getAuthor().compareTo(o2.getAuthor());
            }
        });
        for (Comment comm: mas) {
            System.out.println(comm);
        }
    }
}

class Comment {
    private String author;
    private String text;
    private int likes;

    public Comment(String author, String text, int likes) {
        this.author = author;
        this.text = text;
        this.likes = likes;
    }

    @Override
    public String toString() {
        return author + "#" + text + "#" + likes;
    }

    public String getAuthor() {
        return author;
    }

    public int getLikes() {
        return likes;
    }
}
