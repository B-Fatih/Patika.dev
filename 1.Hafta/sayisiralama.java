import java.util.Scanner;
public class sayisiralama {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int a, b, c;
        System.out.print("1. sayı : ");
        a = input.nextInt();
        System.out.print("2. sayı : ");
        b = input.nextInt();
        System.out.print("3. sayı : ");
        c = input.nextInt();
        if (a < b && a < c){
            if (b < c){
                System.out.print("Küçükten büyüğe " + a + " < " + b+ " < "+ c);
            }else {
                System.out.print("Küçükten büyüğe " + a + " < " + c+ " < "+ b);
            }
        }else if(b < a && b < c){
            if (a < c){
                System.out.print("Küçükten büyüğe " + b + " < " + a+ " < "+ c);
            }else {
                System.out.print("Küçükten büyüğe " + b + " < " + c+ " < "+ a);
            }
        }else if(c < a && b < a){
            if (b < a){
                System.out.print("Küçükten büyüğe " + c + " < " + b+ " < "+ a);
            }else {
                System.out.print("Küçükten büyüğe " + c + " < " + a+ " < "+ b);
            }
        }else{
            System.out.print("Birbirine eşit sayılar var");
        }
    }
}
