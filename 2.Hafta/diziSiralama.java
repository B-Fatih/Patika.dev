import java.util.Scanner;
import java.util.Arrays;

public class diziSiralama {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dizinin boyutu n: ");
        int n = scanner.nextInt();

        int[] array = new int[n];

        System.out.println("Dizinin elemanlarını giriniz:");
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + ". Elemanı: ");
            array[i] = scanner.nextInt();
        }

        Arrays.sort(array); // Diziyi küçükten büyüğe sıralar

        System.out.print("Sıralama: ");
        for (int num : array) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
