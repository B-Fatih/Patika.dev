import java.util.Scanner;

public class desen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("N Sayısı: ");
        int n = scan.nextInt();

        pattern(n, n);

        scan.close();
    }

    static void pattern(int originalValue, int currentValue) {
        System.out.print(currentValue + " ");

        if (currentValue <= 0) {
            return;
        }

        pattern(originalValue, currentValue - 5);

        if (currentValue != originalValue) {
            System.out.print(currentValue + " ");
        }
    }
}
