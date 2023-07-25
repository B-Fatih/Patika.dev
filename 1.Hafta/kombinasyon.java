//Ödev
//N elemanlı bir kümenin elemanları ile oluşturulacak r elemanlı farklı grupların sayısı n’in r’li
// kombinasyonu olarak adlandırılır. N’in r’li kombinasyonu C(n,r) şeklinde gösterilir.
//
//Java ile kombinasyon hesaplayan program yazınız.
//
//Kombinasyon formülü
//C(n,r) = n! / (r! * (n-r)!)
import java.util.Scanner;
public class kombinasyon {
    public static void main(String[] args){
        int n, r,i,j,k,nFactorial=1, rFactorial=1, minusFactorial=1, minus,kombination;
        Scanner input = new Scanner(System.in);
        System.out.print("Kombinasyonun 'N' değerini giriniz : ");
        n = input.nextInt();
        System.out.print("Kombinasyonun 'r' değerini girinz : ");
        r = input.nextInt();
        for(i=1 ; i<=n; i++){
            nFactorial *= i;
        }
        for(j=1; j<=r ; j++){
            rFactorial *=j;
        }
        minus = n-r;
        for(k=1 ; k<=minus ; k++){
            minusFactorial *=k;
        }
        kombination = nFactorial/ (rFactorial * minusFactorial);
        System.out.print("N'in r' kombinasyonun sonucu : " + kombination);
    }
}
