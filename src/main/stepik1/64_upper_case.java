package stepik1;
/* Введите строку, состоящую из слов, отделенных ровно одним пробелом.
Замените первую букву каждого слова на прописную. Выведите полученную строку.

Sample Input:
one apple a day keeps a doctor away
Sample Output:
One Apple A Day Keeps A Doctor Away
*/
//put your code here
import java.util.Scanner;

class Main64 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        String[] words = text.split(" +");
        String result = "";
        for(int i = 0; i < words.length; i++) {
            String symb1 = words[i].substring(0, 1).toUpperCase();
            words[i] = symb1 + words[i].substring(1);
            result += words[i];
            result += " ";
        }
        result = result.trim();
        System.out.println(result);
    }
}
