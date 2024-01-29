import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {

    /*

    1) Lambda "Functional Pragramming" --> method (action) kullanarak programlama
    ** genellikle method create etmek yerine hazir method'lar kullanarak yazilir
    ** methodlarin calismasi icin gerekli düzenekler önceden hazirlanmistir
    ** cok az kod kullanarak, komplex islemler yapilabilir

    2) Nasil yapabilirim den ziyade ne yapabilirim sorusunun cevabini lambda ile verebiliriz
    ** "Structered Programmming" kodlari kendimiz yazdigimiz,
    ** "Functional Programming" hazir methodlar kullanarak, cok daha kisa ve oz, hatasiz calisma

    3) Collection'lar kullanilir. (List, Queue, Set vs), Map'ler kullanilamaz

     */

    public static void main(String[] args) {

        List<Integer> sayilar = new ArrayList<>(Arrays.asList(54,50,95,45,56,12,65,48,87,98,61,23,31,45,57,89,88,44,77,44,11,55,11));

        elemanlariYazdirForEach(sayilar);
        elemanlariYazdirlambda(sayilar);
        elemanlariYazdirFunctionlambda(sayilar);
        System.out.println("\nListemizdeki cift sayilari java ile yazdiralim");
        ciftSayilariYazdirStructered(sayilar);
        System.out.println("\nListemizdeki cift sayilari lambda ile yazdiralim");
        ciftSayilariYazdirFunctional(sayilar);
        System.out.println("\nListedeki 50 den kücük çift sayilari yazdiralim");
        ellidenKucukCiftSayilariYazdir(sayilar);


    }

    public static void ellidenKucukCiftSayilariYazdir(List<Integer> sayilar) {
        sayilar.stream().filter(Lambda01::ciftMi).filter(Lambda01::ellidenKucukMu).forEach(Lambda01::yazdir);

    }
    public static Boolean ellidenKucukMu(Integer a){

     /*
     Boolean ellidenKucukKontrol = a<50;
        if (a<50){
            ellidenKucukKontrol = true;
        }else {
            ellidenKucukKontrol = false;
        }
      */
       return a<50;
    }

    public static Boolean ciftMi(Integer a){
        boolean ciftKontrolu = a % 2 == 0;

        return ciftKontrolu;
    }
    public static void ciftSayilariYazdirFunctional(List<Integer> sayilar) {
        sayilar.stream().filter(t-> t % 2 ==0).forEach(Lambda01::yazdir);
    }

    public static void ciftSayilariYazdirStructered(List<Integer> sayilar) {
        for (Integer eachSayi: sayilar
             ) {

            if(eachSayi % 2 == 0){
                System.out.print(eachSayi + " ");
            }
        }
    }

    public static void elemanlariYazdirFunctionlambda(List<Integer> sayilar) {
        System.out.println("\nFunction olarak method kullanma");
        sayilar.stream().forEach(Lambda01::yazdir);
    }

    public static void elemanlariYazdirlambda(List<Integer> sayilar) {
        System.out.println("\nlambda");
        sayilar.stream().forEach((t) -> System.out.print(t+" "));
    }
    public static void yazdir(int t) {
        System.out.print(t+" ");

    }

    public static void elemanlariYazdirForEach(List<Integer> sayilar) {

        System.out.println("foreach loop");
        for (Integer eachSayi : sayilar){
            System.out.print(eachSayi+" ");
        }
    }
}
