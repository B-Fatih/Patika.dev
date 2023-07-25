//Ödev
// Java döngüler ile 0'dan girilen sayıya kadar olan sayılardan
// 3 ve 4'e tam bölünen sayıların ortalamasını hesaplayan programı yazınız.
import java.util.Scanner;

public class ortalamahesap {
    public static void main(String[] args){
        int i, number, avarage = 0, j =-1;
        Scanner input = new Scanner(System.in);
        System.out.print("Sayıyı giriniz : ");
        number = input.nextInt();
        for(i = 0; i <= number; i++){
            if(i % 12 != 0){
                continue;
            }
            avarage += i;
            j++;
        }
        if (j != 0) {
            avarage = avarage / j;
        }
        System.out.print("3 ve 4'e bölünebilen sayıların ortalaması: " + avarage);
    }
}
