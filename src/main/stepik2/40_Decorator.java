
/*
В некоторой системе передаются сообщения. Класс сообщения представлен классом Message, инкапсулирующим строку.
В классе Message имеется  метод String getMessage(), который эту строку возвращает.
Необходимо добавить возможности:
сделать все буквы прописными (класс CapitalLetters);
удалить все лишние пробелы в начале и в конце, а также между словами оставить ровно один пробел (класс NoExtraSpaces);
удалить все цифры в строке (класс NoDigits). 
Нужно учесть, что в будущем могут добавляться другие преобразования сообщений (например, шифрование строки). Используйте паттерн “Декоратор”.
В классе Main в методе main() вводится строка, которая состоит из слов, разделенных пробелами. 
Затем пользователь в цикле вводит строки, означающие всевозможные преобразования, которые применяются к исходной строке. 
Ввод слова "end" означает завершение редактирования строки. После этого полученная строка выводится на консоль.

Sample Input:
    mama235    mylA    45Ramy  
NoDigits NoExtraSpaces Caps end

Sample Output:
MAMA MYLA RAMY
*/

import java.util.Scanner;

class Main {
     public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Message message = new Message(scan.nextLine());

        String type = scan.next();
        while (!"end".equals(type)) {
            switch (type) {
                case "Caps":
                    message = new CapitalLetters(message);
                    break;
                case "NoDigits":
                    message = new NoDigits(message);
                    break;
                case "NoExtraSpaces":
                    message = new NoExtraSpaces(message);
                    break;
            }
            type = scan.next();
        }

        System.out.println(message.getMessage());
    }
}

class Message {
    private String message;

    public Message() {
    }

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

abstract class MessageDecorator extends Message {
    @Override
    public abstract String getMessage();
}

class CapitalLetters extends MessageDecorator {
    private Message message;

    public CapitalLetters(Message message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message.getMessage().toUpperCase();
    }
}

class NoExtraSpaces extends MessageDecorator {
    private Message message;

    public NoExtraSpaces(Message message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message.getMessage().trim().replaceAll("[\\s]{2,}", " ");
    }
}

class NoDigits extends MessageDecorator {
    private Message message;

    public NoDigits(Message message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message.getMessage().replaceAll("[0-9]", "");
    }
}
