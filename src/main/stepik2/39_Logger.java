package stepik2;
/*
Логгер - это класс, который будет записывать ошибки во внутреннюю строку методом putError() по принципу стека (т.е. последняя ошибка будет в этой строке первой). 
Метод getErrors() позволяет получить список ошибок в виде итоговой строки.
Логгер должен быть единственным в программе. Т.е. сколько бы раз мы его не создавали, это должен быть один и тот же логгер!

Sample Input:
34 67 proba 45 end
Sample Output:
45 proba 67 34
*/

import java.util.Scanner;

class Main39 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Logger logger = Logger.getInstance();

        String text = scan.next();
        while (!"end".equals(text)) {
            logger = Logger.getInstance();
            logger.putError(text);
            text = scan.next();
        }

        System.out.println(logger.getErrors());
    }
}

class Logger {
    private StringBuilder errors;
    private static Logger item;
    
    private Logger() {
        errors = new StringBuilder();
    }
    
    public static Logger getInstance() {
        if (item == null) {
            synchronized (Logger.class) {
                if (item == null) {
                    item = new Logger();
                }
            }
        }
        return item;
    }
    
    public void putError(String str) {
        errors.insert(0, " ").insert(0, str);
    }
    
    public String getErrors() {
        return errors.toString().trim();
    }
}
