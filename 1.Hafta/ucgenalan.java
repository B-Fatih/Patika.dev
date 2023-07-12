//Ödev
//Üç kenar uzunluğunu kullanıcıdan aldığınız üçgenin alanını hesaplayan programı yazınız.
//
//Formül
//Üç𝑔𝑒𝑛𝑖𝑛 ç𝑒𝑣𝑟𝑒𝑠𝑖 = 2𝑢
//
//𝑢 = (a+b+c) / 2
//
//Alan * Alan = 𝑢 * (𝑢 − 𝑎)* (𝑢 − 𝑏) * (𝑢 − 𝑐)

import java.util.Scanner;

public class ucgenalan {
    public static void main(String[] args){
        int a, b, c, u;
        double alan;
        Scanner kenar = new Scanner(System.in);
        System.out.print("1. kenar uzunluğu :");
        a = kenar.nextInt();
        System.out.print("2. kenar uzunluğu :");
        b = kenar.nextInt();
        System.out.print("3. kenar uzunluğu :");
        c = kenar.nextInt();

        int cevre = a + b + c;
        u = cevre / 2;
        alan = Math.sqrt(u * (u - a) * (u - b) * (u - c));
        System.out.println("Üçgenin alanı : " + alan);

    }
}
