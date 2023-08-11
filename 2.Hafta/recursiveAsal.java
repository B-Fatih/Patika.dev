import java.util.Scanner;

public class recursiveAsal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Sayı Giriniz: ");
        int sayi = scanner.nextInt();

        scanner.close();

        if (isAsal(sayi, sayi / 2)) {
            System.out.println(sayi + " sayısı ASALDIR !");
        } else {
            System.out.println(sayi + " sayısı ASAL değildir !");
        }
    }

    static boolean isAsal(int sayi, int i) {
        if (i == 1) {
            return true;
        } else {
            if (sayi % i == 0) {
                return false;
            } else {
                return isAsal(sayi, i - 1);
            }
        }
    }
}
