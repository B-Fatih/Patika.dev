//Java ile basamak sayısının kullanıcıdan alınan ve döngüler kullanılarak, yıldızlar(*) ile ekrana ters üçgen çizen programı yazın.
//
//Örnek
//Basamak Sayısı : 10
//
// ******************* ***************** *************** *************
//*********** ********* ******* ***** *** *
import java.util.Scanner;
public class tersUcgen {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Basamak Sayısı giriniz : ");
        int number = input.nextInt();
        for (int i = number; i >=0  ; i--) {
            for (int j = (number - i); j >0 ; j--) {
                System.out.print(" ");
            }
            for (int k = (2 * i)-1; k >=1 ; k--) {
                System.out.print("*");
            }
            System.out.println(" ");
        }

    }
}
