//Java döngüler ile kullanıcının banka hesabını yönetebildiği bir ATM projesini
//"Switch-Case" kullanarak yapınız.

import java.util.Scanner;

public class atm {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userName, password;
        int right = 3, balance = 1500, select, price, check;

        while (right > 0) {
            System.out.print("Kullanıcı Adınız: ");
            userName = input.nextLine();
            System.out.print("Parolanız: ");
            password = input.nextLine();

            switch (userName) {    //sisteme girişi kısmı için yazlan döngüyü "switch case" ile değiştirildi
                case "patika":
                    switch (password) {
                        case "dev123":
                            System.out.println("Merhaba, Kodluyoruz Bankasına Hoşgeldiniz!");

                            do {
                                System.out.println("1-Para yatırma\n" +
                                        "2-Para Çekme\n" +
                                        "3-Bakiye Sorgula\n" +
                                        "4-Çıkış Yap");
                                System.out.print("Lütfen yapmak istediğiniz işlemi seçiniz: ");
                                select = Integer.parseInt(input.nextLine());

                                switch (select) {
                                    case 1:
                                        System.out.print("Para miktarı: ");
                                        price = Integer.parseInt(input.nextLine());
                                        balance += price;
                                        System.out.println("Bakiyeniz: " + balance);
                                        break;
                                    case 2:
                                        System.out.print("Para miktarı: ");
                                        price = Integer.parseInt(input.nextLine());
                                        check = balance - price;
                                        check = (check < 0) ? -1: 1;
                                        switch (check) {
                                            case 1:
                                                balance -= price;
                                                System.out.println("Bakiyeniz: " + balance);
                                                break;
                                            default:
                                                System.out.println("Bakiye yetersiz.");
                                                break;
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Bakiyeniz: " + balance);
                                        break;
                                    case 4:
                                        System.out.println("Tekrar görüşmek üzere.");
                                        break;
                                    default:
                                        System.out.println("Geçersiz işlem seçimi.");
                                        break;
                                }
                            } while (select != 4);
                            return; // Exit the program after successful login
                        default:
                            right--;
                            System.out.println("Hatalı kullanıcı adı veya şifre.");
                            switch (right) {
                                case 2:
                                    System.out.println("Kalan Hakkınız: " + right);
                                    break;
                                case 1:
                                    System.out.println("Kalan Hakkınız: " + right);
                                    break;
                                default:
                                    System.out.println("Hesabınız bloke olmuştur, lütfen banka ile iletişime geçiniz.");
                                    return; // Exit the program if the number of login attempts is exceeded
                            }
                            break;
                    }
                    return; // Exit the program if the username is incorrect
                default:
                    right--;
                    System.out.println("Hatalı kullanıcı adı veya şifre.");
                    switch (right) {
                        case 2:
                            System.out.println("Kalan Hakkınız: " + right);
                            break;
                        case 1:
                            System.out.println("Kalan Hakkınız: " + right);
                            break;
                        default:
                            System.out.println("Hesabınız bloke olmuştur, lütfen banka ile iletişime geçiniz.");
                            return; // Exit the program if the number of login attempts is exceeded
                    }
                    break;
            }
        }
    }
}
