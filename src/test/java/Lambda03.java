import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {

    public static void main(String[] args) {

        List<String> menu = new ArrayList<>(Arrays.asList("kusleme", "adana", "trilece","havucDilim","buryan",
                "yaglama","kokorec","arabAsi","guvec","waffle","menemen","xcacik","adana"));

        // alfabetik sıralama ile tekrarsiz olarak menüdeki yemekleri yazdirin
        alfabetikTekrarsizMenu(menu);

        // menudeki yemekleri karakter sayisina göre yazdirin
        karakterSayilariniYazdir(menu);

        // menudeki yemekleri son harflerine göre yazdirin
        elemanlariSonHarflerineGoreYazdir(menu);

        // karakter sayisi çift olanlari tekrarsiz büyükten küçüğe sirala.
        ciftKarakterliElemanlariSiraliYazdir(menu);

        // listede 7 karakterden az yemek olmamasi gerekiyor
        listede7KarakterdenAzKarakterliVarMi(menu);

        // r harfiyle başlayan yemek olmamasi gerekiyor
        rHarfiyleBaslayanYemekOlmamali(menu);

        // x harfiyle başlayan yemek olmasını test edelim.
        xHarfiyleBaslayanYemekVarMi(menu);

        // menüde karakter sayisi en fazla olan yemeği yazdirin
        karakterSayisiEnFazlaOlanYemekYazdir(menu);

        // yemekleri son harfine göre sıralayıp ilk elemanı yazdırmayın
        sonHarfeGoreSiralaIlkYemegiAtla(menu);

    }
    public static void sonHarfeGoreSiralaIlkYemegiAtla(List<String> menu) {
        System.out.println("\nYemekler son harfine gore sıralandı, ilk yemek atlandı");
        menu
                .stream()
                .sorted(Comparator.comparing(t -> t.charAt(t.length()-1)))
                .skip(1)
                .forEach(t -> System.out.print(t + " "));


    }

    public static void karakterSayisiEnFazlaOlanYemekYazdir(List<String> menu) {
        System.out.println("\nListedeki en uzun harfli yemek");
        System.out.println(menu.stream().sorted(Comparator.comparing(t -> t.toString().length()).reversed()).findFirst());

        System.out.println("\nListedeki en uzun harfli ilk 3 yemek");
        Stream<String> ilkUcYemek = menu.stream().sorted(Comparator.comparing(t -> t.toString().length()).reversed()).limit(3);
        System.out.println(Arrays.toString(ilkUcYemek.toArray()));
        // limit() fonksiyonu bize bir Stream döndürdüğü için direk yazdıramıyoruz. Stream'i array'e çevirip Arrays.toString() ile yazdırabiliyoruz.
        System.out.println(Arrays.toString(menu.stream().sorted(Comparator.comparing(t -> t.toString().length()).reversed()).limit(3).toArray()));


        }

    public static void xHarfiyleBaslayanYemekVarMi(List<String> menu) {

        System.out.println("\nListede x harfiyle başlayan yemek var mi?");
        System.out.println("Listede x harfiyle başlayan yemek var mi? : " + menu.stream().anyMatch(t -> t.startsWith("x")));

        System.out.println(menu.stream().anyMatch(t -> t.startsWith("x")) ?
                            "x ile başlayan en az bir yemek ismi var" : "x ile başlayan yemek ismi yoktur.");


    }

    public static void rHarfiyleBaslayanYemekOlmamali(List<String> menu) {
        System.out.println("\nListede r harfiyle başlayan yemek olmamasi gerekiyor");

        System.out.println("Listede r harfiyle başlayan yemek yok : " + menu.stream().noneMatch(t -> t.startsWith("r")));
    }

    public static void listede7KarakterdenAzKarakterliVarMi(List<String> menu) {
        System.out.println("\nListede 7 karakterden fazla olan yemekler");
        System.out.println(menu.stream().allMatch(t -> t.length() >= 7));
        boolean kontrol = menu.stream().allMatch(t -> t.length() >= 7);
        System.out.println((kontrol ? "Bütün yemek isimleri en az 7 karakterli" : "En az bir yemek ismi 7 den daha az karaktere sahip"));
    }

    public static void ciftKarakterliElemanlariSiraliYazdir(List<String> menu) {
        System.out.println("\nKarakter sayisi çift olanlari tekrarsiz büyükten küçüğe sirala.");
        menu.stream().map(String::length).filter(Lambda01::ciftMi).distinct().sorted(Comparator.reverseOrder())
                .forEach(Lambda01::yazdir);
    }

    public static void elemanlariSonHarflerineGoreYazdir(List<String> menu) {
        System.out.println("\nMenüdeki yemekleri son harflerine göre yazdirin");
        menu.stream().sorted(Comparator.comparing(t -> (t.toString().charAt(t.toString().length()-1))).reversed())
                .forEach(t-> System.out.print(t+", "));
    }

    public static void karakterSayilariniYazdir(List<String> menu) {
        System.out.println("\nMenüdeki yemekleri karakter sayisi kadar yazdirin");
        menu.stream().map(String::length).sorted(Comparator.reverseOrder()).distinct().forEach(Lambda01::yazdir);
    }

    public static void alfabetikTekrarsizMenu(List<String> menu) {

        System.out.println("Alfabetik sıralama ile tekrarsiz olarak menüdeki yemekleri yazdirin");
        menu.stream()
                //.map( t -> t.toUpperCase())
                .map(String::toUpperCase)
                .sorted().distinct().forEach(t -> System.out.print(t +", "));

    }
}
