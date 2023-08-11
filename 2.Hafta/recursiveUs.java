import java.util.Scanner;

public class recursiveUs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Taban değeri giriniz: ");
        int taban = scanner.nextInt();

        System.out.print("Üs değerini giriniz: ");
        int us = scanner.nextInt();

        scanner.close();

        int sonuc = usAl(taban, us);
        System.out.println("Sonuç: " + sonuc);
    }

    static int usAl(int taban, int us) {
        if (us == 0) {
            return 1;
        } else {
            return taban * usAl(taban, us - 1);
        }
    }
}
