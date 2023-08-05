import java.util.Scanner;
public class minMax {
    public static void main(String[] args){
        int k, i, big, smal;
        Scanner input = new Scanner(System.in);
        System.out.print("Kaç tane sayı gireceksiniz : ");
        k= input.nextInt();
        System.out.print("1. Sayıyı giriniz : ");
        big = input.nextInt();
        smal= big;
        for(i=2; i<=k; i++){
            System.out.print(i + " Sayıyı giriniz : ");
            int number2 =input.nextInt();

            if(number2 > big){
                big= number2;
            }
            if(number2 < smal){
                smal= number2;
            }
            }



        System.out.println("En büyük sayı : " + big );
        System.out.println("En küçük sayı : " + smal);

    }
}
