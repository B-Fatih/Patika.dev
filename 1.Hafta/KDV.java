//Ödev
//Eğer girilen tutar 0 ve 1000 TL arasında ise KDV oranı %18 ,
// tutar 1000 TL'den büyük ise KDV oranını %8 olarak KDV tutarı hesaplayan programı yazınız.
import java.util.Scanner;
public class KDV {
    public static void main(String[] args){
        int kdv1 = 18, kdv2 = 8;
        double fiyat;
        Scanner fiat = new Scanner(System.in);
        System.out.print("Ürün Fiyatını Giriniz :");
        fiyat = fiat.nextInt();
        double kdv = (fiyat > 1000) ? kdv2 : kdv1;
        double kdvtut = (fiyat * kdv) / 100;
        double kdvli = kdvtut + fiyat;
        System.out.println("KDV'siz  fiyat :" + fiyat);
        System.out.println("KDV'li fiyat : " + kdvli);
        System.out.println("KDV tutarı : " + kdvtut);
        System.out.println("KDV oranı : " + kdv);

    }
}
