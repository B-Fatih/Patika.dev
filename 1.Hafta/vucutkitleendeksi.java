//Vücut Kitle İndeksi Hesaplama
//Java ile kullanıcıdan boy ve kilo değerlerini alıp bir değişkene atayın. Aşağıdaki formüle göre kullanıcının
// "Vücut Kitle İndeks" değerini hesaplayıp ekrana yazdırın.
//
//Formül
//Kilo (kg) / Boy(m) * Boy(m)
import java.util.Scanner;
public class vucutkitleendeksi {
    public static void main(String[] args){
        double boy, kilo, endeks;
        Scanner inp = new Scanner(System.in);
        System.out.print("Boyunuzu metre cinsinden giriniz :");
        boy = inp.nextDouble();
        System.out.print("Kilonuzu giriniz :");
        kilo = inp.nextDouble();

        endeks = kilo / (boy * boy);
        System.out.print("Vücut Kitle Endeksiniz :" + endeks);
    }
}
