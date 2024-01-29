import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Lambda06 {

    public static void main(String[] args) throws IOException {

        // dosyamızdaki yazıları ekrana yazdırın
        Files.lines(Paths.get("src/test/java/Dosya.txt")).forEach(t -> System.out.println(t));

        // dosyadaki bütün yazıları büyük harf ile yazdırın
        Files.lines(Paths.get("src/test/java/Dosya.txt"))
                .map(t -> t.toString().toUpperCase())
                .forEach(t -> System.out.println(t));

        // dosyanın sadece ilk satırını tamamı küçük harf olacak şekilde yazdırın
        System.out.println("*****ilk satır tamamı küçük harf");
        Files.lines(Paths.get("src/test/java/Dosya.txt"))
                .limit(1)
                .map(t -> t.toString().toLowerCase())
                .forEach(t-> System.out.println(t));

        // dosyada geçen kelimeleri yazdirin
        System.out.println("*****dosyanın kelimelerine erişim");
        Files.lines(Paths.get("src/test/java/Dosya.txt"))
                .map(t -> t.split(" ")) // split methodunu kullandığımız zaman, bize bir array dönecektir
                .flatMap(Arrays::stream) // dönen arrayler içindeki kelimeleri akışa sokmak için flatMap kullanabiliriz
                .forEach(t -> System.out.println(t)); // lambda daki her bir kelime direk yazdırılabilir

        // dosyada kaç adet kilo kelimesi  geçtiğini sayınız
        System.out.println("*****yazıda kaç tane kilo kelimesi geçiyor : ");
        System.out.println(Files.lines(Paths.get("src/test/java/Dosya.txt"))
                .map(t -> t.split(" "))
                .flatMap(Arrays::stream)
                .filter(t -> t.equalsIgnoreCase("kilo"))
                .count());

        // dosyada birbirinden farklı kaç kelime kullanılmış
        System.out.println("*****yazıda kaç farklı kelime kullanılmış : ");
        System.out.println(Files.lines(Paths.get("src/test/java/Dosya.txt"))
                .map(t -> t.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .count());

        System.out.println("Farklı yöntem ile");
        System.out.println(Files.lines(Paths.get("src/test/java/Dosya.txt"))
                .map(t -> t.split(" "))
                .flatMap(Arrays::stream)
                .collect(Collectors.toSet()).size());

        // dosyada geçen kelimeleri natural order ile yazıralım
        Files.lines(Paths.get("src/test/java/Dosya.txt"))
                .map(t -> t.split(" "))
                .flatMap(Arrays::stream)
                .sorted()
                .forEach(t -> System.out.print(t+" "));

        // içerisinde "a" harfi geçen kelime sayısı
        System.out.println("\na harfi iceren kelime sayisi");
        System.out.println(Files.lines(Paths.get("src/test/java/Dosya.txt"))
                .map(t -> t.split(" "))
                .flatMap(Arrays::stream)
                .filter(t -> t.contains("a"))
                .count());


        // dosyada harf kullanılmış
        System.out.println(Files.lines(Paths.get("src/test/java/Dosya.txt"))
                .map(t -> t.replaceAll("\\W", "").replaceAll("\\d", "").split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .count());
    }


}
