import java.util.Scanner;

public class kullanicigirisi {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String userName, password;
        int select;

        System.out.print("Kullanıcı adınızı giriniz: ");
        userName = inp.nextLine();

        System.out.print("Şifrenizi giriniz: ");
        password = inp.nextLine();

        if (userName.equals("patika") && password.equals("java101")) {
            System.out.println("Sisteme giriş yaptınız.");
        } else if (userName.equals("patika")) {
            System.out.println("Girdiğiniz şifre yanlış. Şifrenizi yenilemek ister misiniz?");
            System.out.println("1-evet\n2-hayır");
            select = inp.nextInt();
            inp.nextLine(); // Boşluğu okumak için dummy nextLine() çağrısı

            if (select == 1) {
                System.out.println("Yeni şifrenizi giriniz (yeni şifre eski şifrenizle aynı olamaz): ");
                String newPassword = inp.nextLine();
                if (newPassword.equals("java101")) {
                    System.out.println("Aynı şifreyi kullanamazsınız. Lütfen başka bir şifre giriniz.");
                } else {
                    System.out.println("Yeni şifre oluşturuldu.");
                }
            } else if (select == 2) {
                System.out.println("Şifrenizi hatırlamıyorsanız 'şifremi unuttum' butonuna tıklayın.");
            } else {
                System.out.println("Hatalı seçim yaptınız. Lütfen 1 veya 2 seçeneklerini seçin!");
            }
        } else {
            System.out.print("Kullanıcı adınız hatalı.");
        }
    }
}
