package Perbankan;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//2.5 TEST AKHIR
// Buatlah sebuah aplikasi Perbankkan sederhana, yang dapat melakukan beberapa proses berikut ini.
//      a. Penambahan rekening baru
//      b. Lihat Saldo,
//      c. Menambah saldo,
//      d. Menarik saldo.
// Catatan :
//  1. Tentukan parameter-parameter yang dibutuhkan pada setiap fungsionalitas diatas.
//  2. Proses pengecekan kecukupan saldo belum dibutuhkan pada bagian ini.
public class Perbankan {
    static Nasabah tempSelectedNasabah = null;
    static BufferedReader inputAplikasi = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {

        System.out.println("===== WELCOME TO BANK ITTS ERPEEL DJAYA DJAYA DJAYA =====");
        System.out.println("GETTING DATA PLEASE WAIT");

        System.out.println();

        DataSource.initDatasource();
        DataSource.fetchData();
    }

    public static void subLogicNasabah(){

    }

    public static String formatRupiah(double nominal) {
        String hasil = String.format("%,.2f", nominal).replaceAll(",", ".");
        return "Rp. " + hasil;
    }
}
