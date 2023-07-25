//Ödev
//Java ile kullanıcının girdiği değerler ile üslü sayı hesaplayan programı "For Döngüsü" kullanarak yapınız.
import java.util.Scanner;
public class usluSayilar {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int i, power, base, result=1;
        System.out.print("Üssü alınacak sayı : ");
        base = input.nextInt();
        System.out.print("Üs olacak sayı : ");
        power = input.nextInt();
        for(i=1; i<=power; i++){
            result *= base;
        }

        System.out.print(base + " üssü " + power + " : " + result);
    }
}
