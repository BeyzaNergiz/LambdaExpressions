import java.util.stream.IntStream;

public class Lambda05 {


    public static void main(String[] args) {

        // birden yüze kadar olan sayıların toplamını bulunuz// liste yok, liste oluşturmalıyız

        forLoopIleToplama(100);
        lambdaIleToplama(100);

        // birden yüze kadar olan sayilardan çift olanları toplayın
        ciftSayilariTopla(100);

        // birden yüze kadar olan sayilardan çift olanları toplayın sınırlar dahil
        ciftSayilariToplaSinirlarDahil(100);

        // ilk 5  çift sayıyı toplayan bir method oluşturun
        ilkXCiftSayiyiToplayanMethod(5);

        // ilk 5 tek sayıyı toplayan bir method oluşturun

        System.out.println(ilkXTekSayiyiToplayanMethod(5));

        // ikinin x. kuvvetini bulan bir method create ediniz ve sırayla hepsini yazdıran
        ikininXKuvvetiniEkranaYazanMethod(5);

        // istenen bir sayının ilk x adet kuvvetini ekrana yazdıran bir program yazınız
        istenenBirSayininIlkXKuvvetiniYazdiranMethod(5,4);

        // istenilen bir sayıın faktoriyelini hesaplama
        istenilenBirSayininFaktoriyeliniHesaplama(6);





    }

    public static void istenilenBirSayininFaktoriyeliniHesaplama(int istenilenSayi) {
        System.out.println("\nfaktoriel: ");
        System.out.println(IntStream
                .rangeClosed(1, istenilenSayi)
                .reduce(Math::multiplyExact));

    }

    public static void istenenBirSayininIlkXKuvvetiniYazdiranMethod(int istenenSayi, int kuvvet) {
        System.out.println("\n"+istenenSayi +"'nın "+kuvvet+". kuvveti");
        IntStream
                .iterate(istenenSayi, t -> t *istenenSayi)
                .limit(kuvvet)
                //.skip(kuvvet-1)  // sadece son sayıyı görmek istersek
                .forEach(t -> System.out.print(t+" "));



    }

    public static void ikininXKuvvetiniEkranaYazanMethod(int kuvvet) {

        IntStream
                .iterate(2, t -> t*2)
                .limit(kuvvet)
                .forEach(t -> System.out.print(t + " "));

    }

    public static int ilkXTekSayiyiToplayanMethod(int sayiAdedi){

        return IntStream
                .iterate(1, t -> t+2)
                .limit(sayiAdedi)
                .sum();

    }

    public static void ilkXCiftSayiyiToplayanMethod(int sayiAdedi) {

        System.out.println(IntStream
                .iterate(2, t -> t + 2) // belli bir kurala göre bir akış(stream) oluşturmak için iterate kullanırız
                .limit(sayiAdedi)
                .sum());


    }

    public static void ciftSayilariToplaSinirlarDahil(int sinir) {

        System.out.println(IntStream
                .rangeClosed(1, sinir)
                .filter(Lambda01::ciftMi)
                .sum());

    }

    public static void ciftSayilariTopla(int sinir) {

        System.out.println(IntStream // intlerden oluşan bir akış oluşturmayı planlıyorum
                .range(1, sinir + 1)  // akışa sunulan sayı aralığı, *** son sayı aralığa dahil değildir.
                .filter(Lambda01::ciftMi)   // Lambda01 classında oluşturdğumuz ciftMi methodu ile sayıları elekten geçiriyoruz
                .sum());


    }

    public static void lambdaIleToplama(int sinir) {

        System.out.println(IntStream // intigerlardan oluşan bir stream oluştur
                .range(1, sinir + 1)    // sınırın toplama (akış) içinde olmasını istiyorsak +1 yazmamzı gerekiyor
                .sum());
    }

    public static void forLoopIleToplama(int sinir) {
        int toplam = 0;

        for (int i = 1; i <= sinir; i++) {

            toplam += i;

        }
        System.out.println(toplam);


    }
}
