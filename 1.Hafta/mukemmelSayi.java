//Klavyeden girilen bir sayının mükemmel sayı olup/olmadığını bulan ve sayı mükemmel sayı ise ekrana “mükemmel sayıdır.” değilse “mükemmel sayı değildir.” ifadelerini ekrana yazan programı Java dilinde yazınız.

//Senaryolar
//Bir sayı giriniz: 28
//28 Mükemmel sayıdır
//Bir sayı giriniz: 1
//1 Mükemmel sayı değildir.
//Bir sayı giriniz: 496
//496 Mükemmel sayıdır

import java.util.Scanner;
public class mukemmelSayi {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int num, total=0;
        System.out.print("Bir sayı girin : ");
        num = input.nextInt();
        for(int i = 1; i < num; i++){
            if(num % i == 0){
                total += i;
            }
        }
        if(total == num ){
            System.out.print(num + " Bir mükemmel sayıdır.");
        }else{
            System.out.print(num + " Bir mükemmel sayı değildir.");
        }
    }
}
