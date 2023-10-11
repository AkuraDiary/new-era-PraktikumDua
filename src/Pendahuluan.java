//1. Apakah yang dimaksud dengan :
//        a. Parameter formal : adalah parameter yang ada saat pembuatan fungsi
//        berperan sebagai wadah untuk menampung nilai yang dikirimkan saat pemanggilan fungsi
//
//        b. Parameter aktual : adalah parameter yang ada saat pemanggilan fungsi
//        yaitu nilai yang digunakan untuk mengisi parameter formal atau memanggil fungsi tersebut
//
//        Berikan contoh minimal 3 implementasi dari kedua jenis parameter diatas
//
//        Contoh Implementasi (actual code ada di Pendahuluan.java):

public class Pendahuluan {


//    Berikan contoh minimal 3 implementasi dari kedua jenis parameter diatas
//
//    Contoh Implementasi :

//    1.)

    static int F(
            int x, // x disini adalah parameter formal
            int y // y disini adalah parameter formal
    ) {
        return (x * y) + (2 * x) + (2 * y) + 6;
    }

    // dalam pemanggilan method tersebut
    // parameter x & y (sebagai parameter formal) digunakan untuk
    // menampung nilai 2 & 3 (yang disebut parameter actual)
    // yang di berikan saat memanggil method tersebut

    //    2.)
    static double luasSegitiga(
            int alas, // alas disini adalah parameter formal
            int tinggi // tinggi disini adalah parameter formal
    ) {
        return (alas * tinggi) / 2;
    }


//    3.)

    static String formatRupiah(
            int nominal // nominal disini adalah parameter formal
    ) {
        return "Rp. " + nominal;
    }

    // nb: menggunakan static agar tidak perlu instatiasi kelas
    public static void main(String[] args) {
        // pada saat method F(x,y) dipanggil
        int resultMethodF = F(2, 3); // 2 dan 3 adalah parameter aktual
        System.out.println("method F : " + resultMethodF);

        // pada saat method formatRupiah(nominal) dipanggil
        String resultFormatRupiah = formatRupiah(10000 ); // 10000 adalah parameter aktual
        System.out.println("method formatRupiah : " + resultFormatRupiah);

        // pada saat method luasSegitiga(alas, tinggi) dipanggil
        double resultLuasSegitiga = luasSegitiga(2, 3); // 2 dan 3 adalah parameter aktual
        System.out.println("method luasSegitiga : " + resultLuasSegitiga);

    }
}
