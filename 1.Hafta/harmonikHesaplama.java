//Java ile girilen sayının harmonik serisini bulan program
import java.util.Scanner;
public class harmonikHesaplama {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double result= 0.0;
        double n,i;
        System.out.print("Sayı giriniz : ");
        n = input.nextInt();
        for(i=1 ; i <= n; i++){
            result += 1/i;
        }
        System.out.print(result);
    }
}
