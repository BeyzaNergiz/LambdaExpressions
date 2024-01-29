public class Universite {


    //her üniversite içinde Üniversite ismi, Bölüm, öğrenci sayısı, notOrtalaması,

    //pojo class içinde : constructor, variables, getter setter, toString()

    // constructor
    public Universite (){


    }

    public Universite(String uniName, String bolum, int ogrSayisi, int notOrtalama){

        this.uniName = uniName;
        this.bolum = bolum;
        this.ogrSayisi = ogrSayisi;
        this.notOrtalama = notOrtalama;

    }

    //variables
    private String uniName;
    private String bolum;
    private int ogrSayisi;
    private int notOrtalama;

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public int getOgrSayisi() {
        return ogrSayisi;
    }

    public void setOgrSayisi(int ogrSayisi) {
        this.ogrSayisi = ogrSayisi;
    }

    public int getNotOrtalama() {
        return notOrtalama;
    }

    public void setNotOrtalama(int notOrtalama) {
        this.notOrtalama = notOrtalama;
    }


    @Override
    public String toString() {
        return "Universite{" +
                "uniName='" + uniName + '\'' +
                ", bolum='" + bolum + '\'' +
                ", ogrSayisi=" + ogrSayisi +
                ", notOrtalama=" + notOrtalama +
                '}';
    }
}