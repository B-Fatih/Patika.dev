import java.util.Scanner;
public class obebOkek {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n1, n2, i=1, ebob;
        System.out.print("1. Sayıyı girinşz : ");
        n1 = input.nextInt();
        System.out.print("2. Sayıyı giriniz : ");
        n2 = input.nextInt();
        while (i <= n1 * n2) {
            if (i % n1 == 0 && i % n2 == 0) {
                System.out.println("Ekok 'n1, n2' : " + i);
                break;
            }
            i++;
        }
        int k=n1;
        while (k >= 1) {
            if (n1 % k == 0 && n2 % k == 0) {
                ebob = k;
                System.out.println("Ebob 'n1, n2' : " + ebob);
                break;
            }
            k--;
        }
    }
}
