//Ödev
//Bir sayının basamak sayılarının toplamını hesaplayan program yazınız.
//
//Örnek : 1643 = 1 + 6 + 4 + 3 = 14
import java.util.Scanner;
public class basamakToplama {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int number, division, i, step=0, multiples=1, digit, number2, sum= 0;
        System.out.print("Sayıyı giriniz :");
        number = input.nextInt();
        division = number;
        while(division >0){
            division = division / 10;
            step++;
        }
        System.out.println("Girilen sayı '" + step + "' basamaklı bir sayıdır.");
        i = step;
        while (i > 1){
            i--;
            multiples *= 10;
        }
        number2 = number;
        System.out.println("Sayı basamakları :");
        while(step >0){
            digit = number2 / multiples;
            number2 = number2 % multiples;
            multiples = multiples / 10;
            sum += digit;
            step--;
            System.out.print(digit + ", ");
        }
        System.out.println("Girilen sayının basamak değerleri toplamı : " + sum);

    }
}
