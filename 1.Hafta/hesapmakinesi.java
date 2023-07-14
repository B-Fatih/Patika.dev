//hesap makinesi programı
//hesap makinesini switch-case kullanarak yapınız.

import java.util.Scanner;
public class hesapmakinesi {
    public static void main(String[] args){
        int n1, n2, select, top;
        Scanner inp = new Scanner(System.in);
        System.out.print("Birinci Sayı :");
        n1 = inp.nextInt();
        System.out.print("İkinci Sayı :");
        n2 = inp.nextInt();
        System.out.println("1-Toplama\n2-Çıkarma\n3-Çarpma\n4-Bölme");
        System.out.print("Seçiniz : ");
        select = inp.nextInt();
        switch (select) {
            case 1:
                top = n1 + n2;
                System.out.print("Sonuç :" + top);
                break;
            case 2:
                top = n1 - n2;
                System.out.print("Sonuç :" + top);
                break;
            case 3:
                top = n1 * n2;
                System.out.print("Sonuç :" + top);
            case 4:
                top = n1 / n2;
                System.out.print("Sonuç :" + top);
                break;
            default:
                System.out.print("1 ile 4 arasında bir şık seçin");


        }

    }
}
