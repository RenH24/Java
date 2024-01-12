Ввести строку из слов, разделенных пробелами. Между словами может быть любое количество пробелов. 
Также пробелы могут быть перед первым и после последнего слова.
Найти и распечатать первое слово максимальной длины.

Sample Input:
   Свиристелки прилетели     и    запели в унисон   
Sample Output:
Свиристелки

//put your code here
import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        str=str.trim();
        String[] words = str.split(" +");
        int imax = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > words[imax].length()) {
                imax = i;
            }
        }
        System.out.println(words[imax]);      
    }
}
