На вход программы подается размер интервала времени в секундах. Переведите это в часы, минуты и секунды и выведите согласно примеру теста.

Sample Input:
20367
Sample Output:
5 часов 39 минут 27 секунд

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final int HOUR = 3600;
        final int MINUTE = 60;
        Scanner scan = new Scanner(System.in);
        int seconds = scan.nextInt();
        
        int hours = seconds / HOUR;
        seconds %= HOUR;
        int minutes = seconds / MINUTE;
        int remain = seconds % MINUTE;
        System.out.println(hours + " часов " + minutes + " минут " + remain + " секунд");
    }
}
