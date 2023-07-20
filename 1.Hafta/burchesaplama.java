//Koç Burcu : 21 Mart - 20 Nisan
//
//Boğa Burcu : 21 Nisan - 21 Mayıs
//
//İkizler Burcu : 22 Mayıs - 22 Haziran
//
//Yengeç Burcu : 23 Haziran - 22 Temmuz
//
//Aslan Burcu : 23 Temmuz - 22 Ağustos
//
//Başak Burcu : 23 Ağustos - 22 Eylül
//
//Terazi Burcu : 23 Eylül - 22 Ekim
//
//Akrep Burcu : 23 Ekim - 21 Kasım
//
//Yay Burcu : 22 Kasım - 21 Aralık
//
//Oğlak Burcu : 22 Aralık - 21 Ocak
//
//Kova Burcu : 22 Ocak - 19 Şubat
//
//Balık Burcu : 20 Şubat - 20 Mart
//
//Ödev
//Aynı örneği switch-case kullanmadan yapınız.
import java.util.Scanner;
public class burchesaplama {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int day, month;
        System.out.print("Doğduğunuz ay(kaçıncı ay) : ");
        month = input.nextInt();
        System.out.print("Doğduğunuz gün : ");
        day = input.nextInt();
        if (((31 >= day && day >= 21) && month == 3) || (day <= 20 && month == 4)){
            System.out.print("Koç burcusunuz.");
        }else if(((30 >= day && day >= 21) && month == 4) || (day <= 21 && month == 5)){
            System.out.print("Boğa burcusunuz.");
        }else if(((31 >= day && day >= 22) && month == 5) || (day <= 22 & month == 6)){
            System.out.print("İkizler burcusunuz.");
        }else if(((30 >= day && day >= 23) && month == 6) || (day <= 22 & month == 7)) {
            System.out.print("Yengeç burcusunuz.");
        }else if(((31 >= day && day >= 23) && month == 7) || (day <= 22 & month == 8)) {
            System.out.print("Aslan burcusunuz.");
        }else if(((31 >= day && day >= 23) && month == 8) || (day <= 22 & month == 9)) {
            System.out.print("Başak burcusunuz.");
        }else if(((31 >= day && day >= 23) && month == 9) || (day <= 22 & month == 10)) {
            System.out.print("Terazi burcusunuz.");
        }else if(((30 >= day && day >= 23) && month == 10) || (day <= 21 & month == 11)) {
            System.out.print("Akrep burcusunuz.");
        }else if(((31 >= day && day >= 22) && month == 11) || (day <= 21 & month == 12)) {
            System.out.print("Yay burcusunuz.");
        }else if(((30 >= day && day >= 22) && month == 12) || (day <= 21 & month == 1)) {
            System.out.print("Oğlak burcusunuz.");
        }else if(((31 >= day && day >= 22) && month == 1) || (day <= 19 & month == 2)) {
            System.out.print("Kova burcusunuz.");
        }else if(((28 >= day && day >= 20) && month == 2) || (day <= 20 & month == 3)) {
            System.out.print("Balık burcusunuz.");
        }else{
            System.out.print("tarihi yanlış girdiniz.");
        }
    }
}
