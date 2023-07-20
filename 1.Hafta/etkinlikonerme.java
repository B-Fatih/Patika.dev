import java.util.Scanner;
public class etkinlikonerme {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int heat;
        System.out.print("Hava Sıcaklığını Giriniz : ");
        heat = input.nextInt();
        if (heat < 5){
            System.out.print("Kayak yapabilirsiniz.");
        }else if (heat <= 25){
            if(heat >= 15){
                System.out.println("Piknik yapabilirsiniz.");
                System.out.println("Sinemaya gidebilirsiniz.");
            }else {
                System.out.print("Piknik yapabilirsiniz.");
            }


        }else{
            System.out.print("Yüzmeye gidebilirsiniz");
        }
    }

}
