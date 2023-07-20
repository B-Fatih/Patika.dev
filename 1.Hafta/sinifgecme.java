//Dersler : Matematik, Fizik, Türkçe, Kimya, Müzik
//
//Geçme Notu : 55
//
//Ödev
//Eğer girilen ders notları 0 veya 100 arasında değil ise ortalamaya katılmasın.
import java.util.Scanner;

public class sinifgecme {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int mat, fizik, turkce, kimya, muzik, total = 0, i = 0;
        System.out.print("Matematik notunuz : ");
        mat = input.nextInt();
        if (mat <= 100 && mat >= 0){
            i++;
            total += mat;
        }else {
            System.out.println("Notunuz 0 ile 100 arasında olmalı!");
        }
        System.out.print("Fizik notunuz : ");
        fizik = input.nextInt();
        if (fizik <= 100 && fizik >= 0){
            i++;
            total += fizik;
        }else {
            System.out.println("Notunuz 0 ile 100 arasında olmalı!");
        }
        System.out.print("Türkçe notunuz : ");
        turkce = input.nextInt();
        if (turkce <= 100 && turkce >= 0){
            i++;
            total += turkce;
        }else {
            System.out.println("Notunuz 0 ile 100 arasında olmalı!");
        }
        System.out.print("Kimya notunuz : ");
        kimya = input.nextInt();
        if (kimya <= 100 && kimya >= 0){
            i++;
            total += kimya;
        }else {
            System.out.println("Notunuz 0 ile 100 arasında olmalı!");
        }
        System.out.print("Müzik notunuz : ");
        muzik = input.nextInt();
        if (muzik <= 100 && muzik >= 0){
            i++;
            total += muzik;
        }else {
            System.out.println("Notunuz 0 ile 100 arasında olmalı!");
        }
        if (i>0) {
            double avarage = total / i;
            System.out.print("Ortalamanız : " + avarage);
            if (avarage >= 55) {
                System.out.print("Geçtiniz.");
            } else {
                System.out.print("Kaldınız.");
            }
        }else {
            System.out.print("Ortalama hesaplanamıyor.");
        }
    }
}
