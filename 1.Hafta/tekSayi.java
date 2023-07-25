import java.util.Scanner;

public class tekSayi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int multiples4 = 0, number;
        do {
            System.out.print("Bir sayı giriniz : ");
            number = input.nextInt();

            if (number % 4 == 0) {
                multiples4 += number;
            }
        } while (number % 2 == 0);

        System.out.print("Girilen ve 4'e bölünebilen sayıların toplamı : " + multiples4);
    }
}
