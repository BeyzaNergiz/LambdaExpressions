import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {

    public static void main(String[] args) {

        List<Integer> sayilar = new ArrayList<>(Arrays.asList(6,5,8,7,4,5,8,4,2,6,6,5,4,7,8));

        // listedeki her elemanın küpünü alıp bir ekleyip sonucu yazdirin.
        sayilarinKupuArtiBir(sayilar);

        // listedeki tek sayıların küpünü alıp 2 çıkartın.
        tekSayilarinKupuEksiIki(sayilar);

        // listedeki çift sayıların karekökünü yazdirin.
        ciftSayiKarakokYazdir(sayilar);

        // max sayiyi bul.
        maxSayiyiBul(sayilar);

        // bütün sayiların toplamı
        butunToplam(sayilar);

        //çift sayilarin hepsinin çarpımı
        ciftSayilariCarp(sayilar);

        // liste içindeki min sayi
        listedeMinSayiBul(sayilar);

    }
    public static void listedeMinSayiBul(List<Integer> sayilar) {
        System.out.println("\nListedeki min elemen");
        // Integer classı kullanarak
        System.out.println(sayilar.stream().reduce(Integer::min));
        // Math classı kullanarak
        System.out.println(sayilar.stream().reduce(Math::min));

        // Lambda Expression ile çözüm
        int minSayiLambda = sayilar.stream().reduce(Integer.MAX_VALUE, (x,y) -> x<y ? x : y);
        System.out.println(minSayiLambda);



    }

    public static void ciftSayilariCarp(List<Integer> sayilar) {
        System.out.println("\nListedeki Bütün Çift Sayilarin Çarpimi");
        System.out.println("Butun Sayilarin Carpımı : "+sayilar.stream().filter(Lambda01::ciftMi).reduce(Math::multiplyExact));

        System.out.println("Function Kullanarak : "+sayilar.stream().filter(Lambda01::ciftMi).reduce(1, (a, b) -> (a * b)));


    }

    public static void butunToplam(List<Integer> sayilar) {
        System.out.println("\nListedeki Bütün Sayilarin Toplami");
        System.out.println(sayilar.stream().reduce(0, (a, b) -> (a + b)));

        Integer toplam = sayilar.stream().reduce(0, (a, b) -> (a + b));
        System.out.println("Genel toplam : " + toplam);

        System.out.println(sayilar.stream().reduce(Integer::sum));
    }

    public static void maxSayiyiBul(List<Integer> sayilar) {
        System.out.println("\nListedeki En Büyük Sayi");
        System.out.println(sayilar.stream().reduce(Math::max));
        Optional<Integer> maxSayi = sayilar.stream().reduce(Math::max);
        /*
        reduce() ==> azaltmak işlemini yapıyor.
                     Sonucun tek elemana inmesini istediğimiz durumlarda kullanilir.
                     Mesela bütün sayilarin toplamı, bütün sayiların min/max yada çarpımı.
         */
    }

    public static void ciftSayiKarakokYazdir(List<Integer> sayilar) {
        System.out.println("\nCift Sayilarin Karakökü");
        sayilar.stream().filter(Lambda01::ciftMi).map(Math::sqrt).forEach(t -> System.out.print(t + ", "));
    }

    public static void tekSayilarinKupuEksiIki(List<Integer> sayilar) {
        System.out.println("\nTek Sayilarin Kupu -2");
        sayilar.stream().filter(t -> t %2 !=0).map(t -> (t*t*t)-2).forEach(Lambda01::yazdir);
    }

    public static void sayilarinKupuArtiBir(List<Integer> sayilar) {
        System.out.println("\nSayilarin Kupu +1");
        sayilar.stream().map(t -> (t*t*t)+1).forEach(Lambda01::yazdir);
    }
}