package stepik2;
/*
Напишите редактор текста, используя паттерн "Стратегия". В архитектуре программы должен быть интеhфейс Editing с единственным методом String edit(String text).
Этот интерфейс реализуют классы:
NoExtraSpaces  - метод edit() удаляет все лишние пробелы в начале и в конце текста, оставляя между словами ровно один пробел;
NoDigits -  метод edit() удаляет все цифры из текста;
CapsFirstLetters - метод edit() делает прописными (заглавными) все первые буквы слов. Пробелы не удаляются.
NoEditing - метод edit() никак не изменяет строку.
Также создайте класс Message с полями: String text и Editing editWay. В конструктор передается строка text.
Для способа редактирования задайте сеттер. Также в классе Message должен быть метод print(), в котором сначала редактируется текст, а потом выводится на консоль.
В методе main() класса Main сначала вводится исходная строка текста и создается объект класса Message. Затем вводится целое число и определяется способ редактирования:
1 - удаление лишних пробелов;
2 - удаление всех цифр;
3 - преобразование в заглавные первых букв слов;
во всех остальных случаях строка остается без изменения.
После задания способа редактирования с помощью сеттера, вызывается метод print(). 

Sample Input:
    mama    myla    ramy 
3
Sample Output:
    Mama    Myla    Ramy 
*/

import java.util.Scanner;

class Main41 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        Message2 message = new Message2(text);
        
        int type = scan.nextInt();        
        Editing editing = null;
        switch (type) {
            case 1:
                editing = new NoExtraSpaces2();
                break;
            case 2:
                editing = new NoDigits2();
                break;
            case 3:
                editing = new CapsFirstLetters2();
                break;
            default:
                editing = new NoEditing2();
                break;
        }
        message.setEditWay(editing);
        message.print();
    }
}

interface Editing {
    String edit(String text);
}

class NoExtraSpaces2 implements Editing {
    @Override
    public String edit(String text) {
        return text.trim().replaceAll("[\\s]{2,}", " ");
    }
}

class NoDigits2 implements Editing {
    @Override
    public String edit(String text) {
        return text.replaceAll("[0-9]", "");
    }
}

class CapsFirstLetters2 implements Editing {
    @Override
    public String edit(String text) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i]) && (i == 0 || chars[i - 1] == ' ')) {
                chars[i] = Character.toUpperCase(chars[i]);
            }
        }
        return new String(chars);
    }
}

class NoEditing2 implements Editing {
    @Override
    public String edit(String text) {
        return text;
    }
}

class Message2 {
    private String text;
    private Editing editWay;

    public Message2(String text) {
        this.text = text;
    }

    public void setEditWay(Editing editWay) {
        this.editWay = editWay;
    }

    public void print() {
        text = editWay.edit(text);
        System.out.println(text);
    }
}
