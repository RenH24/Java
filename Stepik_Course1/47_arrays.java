Пользователь вводит размер массива и начальное значение генератора случайных чисел.
Затем он вводит контрольный элемент (целое число).
Создать массив заданного размера и заполнить его случайными числами от 2 до 15. Отсортировать массив по возрастанию. 
Распечатать отсортированный массив, используя метод toString() - в квадратных скобках, элементы через запятую.
Найти в отсортированном массиве индекс контрольного элемента и удалить все элементы после него (создать новый массив нужного размера).
Если контрольный элемент отсутствовал в массиве, то вывести "ERROR". В противном случае распечатать полученный массив методом toString().

Sample Input:
8 11
10
Sample Output:
[5, 6, 7, 10, 11, 13, 14, 15]
[5, 6, 7, 10]

//put your code here
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int gen = scan.nextInt();
        int cont = scan.nextInt();
        
        Random rand = new Random(gen);
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt(2, 16);
        }
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        
        int ind = Arrays.binarySearch(a, cont);
        if(ind >= 0) {
            int[] b = Arrays.copyOf(a, ind + 1);
            System.out.println(Arrays.toString(b));
        } else {        
            System.out.println("ERROR");
        }
    }
}
