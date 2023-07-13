//Taksimetre Programı
//Java ile gidilen mesafeye (KM) göre taksimetre tutarını ekrana yazdıran programı yazın.
//
//Taksimetre KM başına 2.20 TL tutmaktadır.
//Minimum ödenecek tutar 20 TL'dir. 20 TL altında ki ücretlerde yine 20 TL alınacaktır.
//Taksimetre açılış ücreti 10 TL'dir.
import java.util.Scanner;

public class taksimetre{
    public static void main(String[] args){
        int km;
        double perkm = 2.20, total;

        Scanner inp = new Scanner(System.in);
        System.out.print("KM'yi giriniz :");
        km = inp.nextInt();
        total = km * perkm;
        double fee = (total > 20) ? total : 20;
        System.out.print("Taksimetre Ücreti : " + fee + "TL");

    }

}