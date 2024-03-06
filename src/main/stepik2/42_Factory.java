
/*
Нужно использовать паттерн “Фабричный метод” для создания кросс-платформенных элементов интерфейса, не привязывая основной код программы к конкретным классам элементов.
Имеется базовый класс Dialog, который представляет собой диалоговое окно. В нашем простейшем случае он умеет только рисовать кнопку с надписью “ОК”. 
При этом этот класс не должен быть привязан к конкретной реализации кнопок. Кнопки (как и другие элементы, которые появятся в будущем), могут быть в стиле  Windows либо выполненные на HTML. 
Соответственно у класса Dialog имеются наследники WindowsDialog и HtmlDialog (диаграмма классов этой задачи показана ниже).
В методе main() класса Main  у пользователя запрашивается тип окна (Windows или Html). Затем создается окно  и в нем кнопка.  Вид экрана показан в примере тестов. Код метода main() менять нельзя!
Главное условие – код должен быть максимально приспособлен для модификации (появление новых типов элементов и окон).

Sample Input:
Windows
Sample Output:
Рисуем окно диалога
Отрисовали кнопку в стиле Windows с надписью OK
*/

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String type = scan.nextLine();
        Dialog dialog = null;
        if ("Windows".equals(type)) {
            dialog = new WindowsDialog();
        } else if ("Html".equals(type)) {
            dialog = new HtmlDialog();
        } else {
            System.out.println("ERROR");
            return;
        }
        dialog.renderWindow();
    }
}

abstract class Button {
    public abstract void render();
}

class WindowsButton extends Button {
    @Override
    public void render() {
        System.out.println("Отрисовали кнопку в стиле Windows с надписью OK");
    }
}

class HtmlButton extends Button {
    @Override
    public void render() {
        System.out.println("Отрисовали кнопку в стиле Html с надписью OK");
    }
}

abstract class Dialog {
    public void renderWindow() {
        System.out.println("Рисуем окно диалога");
        Button button = createButton();
        button.render();
    }

    public abstract Button createButton();
}

class WindowsDialog extends Dialog {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}

class HtmlDialog extends Dialog {
    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
