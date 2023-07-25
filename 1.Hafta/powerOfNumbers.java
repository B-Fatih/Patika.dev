//Ödev
//Java döngüler ile girilen sayıya kadar olan 4 ve 5'in kuvvetlerini ekrana yazdıran programı yazıyoruz.
import java.util.Scanner;
public class powerOfNumbers {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int number,i,j;
        System.out.print("Bir sayı giriniz : ");
        number = input.nextInt();
        for(i=1; i <= number ; i*=4){
            System.out.println("4'ün katları : " + i);
        }
        for(j=1;j<=number;j*=5){
            System.out.println("5'in katları : " + j);
        }
    }
}
