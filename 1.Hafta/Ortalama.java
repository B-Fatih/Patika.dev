//Ödev
//Aynı program içerisinde koşullu ifadeler kullanılarak,
// eğer kullanıcının ortalaması 60'dan büyük ise ekrana "Sınıfı Geçti" , küçük ise "Sınıfta Kaldı" yazsın.
//
//Not : If ve Else kullanılmayacak...
import java.util.Scanner;

public class Ortalama {
    public static void main(String[] args){
        int mat, turk, tari, fiz, muzi, kimya, top;   // değişkenlerimiz
        Scanner inp = new Scanner(System.in);

        System.out.print("Matematik Notunu Gir : ");  // Matematik notu isteniyor
        mat = inp.nextInt();

        System.out.print("Türkçe Notunu Gir :");   // turkçe nottu isteniyor
        turk = inp.nextInt();

        System.out.print("Tarih Notunu Gir :");     //
        tari = inp.nextInt();

        System.out.print("Fizik Notunu Gir :");      //
        fiz = inp.nextInt();

        System.out.print("Kimya Notunu Gir :");     //
        kimya = inp.nextInt();

        System.out.print("Müzik Notunu Gir :");     //
        muzi = inp.nextInt();

        top = mat+turk+tari+fiz+muzi+kimya;          //Ortalama Hesaplaması yapılıyor
        int ort = top/6;                             //
        String x = (ort >= 60) ? "Sınıfı Geçtiniz" : "Sınıfta Kaldınız";

        System.out.print("Ortalamanız : " + ort + " " + x);   //sonuç yazdırılıyor


    }
}
