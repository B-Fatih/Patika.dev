//Java ile mesafeye ve şartlara göre uçak bileti fiyatı hesaplayan programı yapın.
// Kullanıcıdan Mesafe (KM), yaşı ve yolculuk tipi (Tek Yön, Gidiş-Dönüş) bilgilerini alın.
// Mesafe başına ücret 0,10 TL / km olarak alın. İlk olarak uçuşun toplam fiyatını hesaplayın ve
// sonrasında ki koşullara göre müşteriye aşağıdaki indirimleri uygulayın ;
//
//Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı, yolculuk tipi ise 1 veya 2) olmalıdır.
// Aksi takdirde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.
//Kişi 12 yaşından küçükse bilet fiyatı üzerinden %50 indirim uygulanır.
//Kişi 12-24 yaşları arasında ise bilet fiyatı üzerinden %10 indirim uygulanır.
//Kişi 65 yaşından büyük ise bilet fiyatı üzerinden %30 indirim uygulanır.
//Kişi "Yolculuk Tipini" gidiş dönüş seçmiş ise bilet fiyatı üzerinden %20 indirim uygulanır.
import java.util.Scanner;
public class ucakbileti {
    public static void main(String[] args){
        int distance, age, select;
        Scanner input = new Scanner(System.in);
        System.out.print("Mesafeyi km cinsinden girin : ");
        distance = input.nextInt();
        double discount, discount1, price = distance * 0.10;
        System.out.print("Yaşınızı girin : ");
        age = input.nextInt();
        System.out.println("Yolculuk tipini seçiniz.");
        System.out.println("1-Tek yön\n2-Gidiş-Dönüş");
        select = input.nextInt();
        if(age < 12 ){
            discount = price * 0.5;
        }else if (age <= 24 && age >= 12){
            discount = price * 0.10;
        }else if (age > 65){
            discount = price * 0.30;
        }else{
            discount = 0;
        }
        price = price - discount;
        if(select == 2){
            discount1 = price * 0.20;
            price = (price - discount1) * 2;
            System.out.print("Bilet Fiyatınız : " + price);
        }else if(select == 1){
            System.out.print("Bilet Fiyatınız : " + price);
        }else{
            System.out.print("Yanlış değer seçtiniz");
        }

    }
}
