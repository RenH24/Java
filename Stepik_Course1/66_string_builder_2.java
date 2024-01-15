Пользователь вводит строку из слов, разделенных одним пробелом. 
Переставить слова местами так, чтобы каждое следующее слово начиналось с буквы, которой заканчивается предыдущее слово (существование такого слова в тестах гарантируется).
  
Sample Input:
trolli emodji road tiger dog insert game
Sample Output:
trolli insert tiger road dog game emodji

//put your code here
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        String[] words = text.split(" +");
        StringBuilder sb = new StringBuilder(words[0]);
        for(int i = 1; i < words.length; i++) {
            char simb = sb.charAt(sb.length() - 1);
            for(int j = 1; j < words.length; j++) {
                if(words[j].charAt(0) == simb) {
                    sb.append(" ").append(words[j]);
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
