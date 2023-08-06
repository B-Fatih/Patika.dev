//Java döngüler ile fibonacci serisi bulan program yazıyoruz.
// Fibonacci serisinin eleman sayısını kullanıcıdan alın.
import java.util.Scanner;
public class fibonacci {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Fibonacci serisi kaç elemanlı olsun : ");
        int digit = input.nextInt();
        int total=0, a=0,b=1;
        for(int i =1; i <= digit; i++){
            total =a+b;
            System.out.println(a + " + " + b + " = " + total);
            a=b;
            b=total;


        }
    }
}
