import java.util.Scanner;

//Manav Kasa Programı
//Java ile kullanıcıların manavdan almış oldukları ürünlerin kilogram
// değerlerine göre toplam tutarını ekrana yazdıran programı yazın.
//
//Meyveler ve KG Fiyatları
//
//Armut : 2,14 TL
//Elma : 3,67 TL
//Domates : 1,11 TL
//Muz: 0,95 TL
//Patlıcan : 5,00 TL
public class manav {
    public static void main(String[] args){
        double armut = 2.14, elma = 3.67, domates = 1.11, muz = 0.95, patlican = 5.00, e, a, m, d, p, toplam;
        Scanner inp =new Scanner(System.in);
        System.out.print("Elma(kg) : ");
        e = inp.nextDouble();
        System.out.print("Armut(kg) : ");
        a = inp.nextDouble();
        System.out.print("Muz(kg) : ");
        m = inp.nextDouble();
        System.out.print("Domates(kg) : ");
        d = inp.nextDouble();
        System.out.print("Patlıcan(kg) : ");
        p = inp.nextDouble();
        toplam = ((a * armut) + (e * elma) + (m * muz) + (d * domates) + (p * patlican));
        System.out.print("Toplam : " + toplam);





    }
}
