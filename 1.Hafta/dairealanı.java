
//Ödev
//Yarıçapı r, merkez açısının ölçüsü 𝛼 olan daire diliminin alanı bulan programı yazınız.
//
//𝜋 sayısını = 3.14 alınız.
//
//Formül : (𝜋 * (r*r) * 𝛼) / 360
import java.util.Scanner;

public class dairealanı {
    public static void main(String[] args){
        double pi = 3.14, r, a, alan;
        Scanner inp = new Scanner(System.in);
        System.out.print("Dairenin yarıçapını giriniz :");
        r = inp.nextInt();
        System.out.print("Merkez açısının ölçüsünü giriniz :");
        a = inp.nextInt();
        alan = (a * (r * r) * pi) / 360;
        System.out.print("Daire diliminin alanı : " + alan);
    }
}
