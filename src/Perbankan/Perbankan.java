package Perbankan;

import java.io.BufferedReader;
import java.io.IOException;
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
        String input = "";

        System.out.println("===== WELCOME TO BANK ITTS ERPEEL DJAYA DJAYA DJAYA =====");
        System.out.println("GETTING DATA PLEASE WAIT");

        System.out.println();

        DataSource.initDatasource();
        DataSource.fetchData();


        while (true) {
            System.out.println();
            System.out.println("===== MENU UTAMA =====");
            System.out.println("Masukkan [IdNasabah] untuk memilih nasabah");
            System.out.println("Masukkan 0 / [exit] untuk keluar");
            System.out.println("Masukkan [register] untuk registrasi nasabah & rekening baru");
            System.out.println("Masukkan [fetch] untuk melihat data nasabah & rekening");
            System.out.println("===== MENU UTAMA =====");

            System.out.println();
            System.out.print("Input : ");
            try {
                input = inputAplikasi.readLine();
                switch (input) {
                    case "0", "exit":
                        System.out.println("Terima kasih telah menggunakan layanan kami");
                        System.exit(0);
                        break;

                    case "register":
                        registerNasabah();
                        break;

                    case "fetch":
                        DataSource.fetchData();
                        break;
                    default:
                        String elseInput = input;
                        tempSelectedNasabah = DataSource.listNasabah
                                .stream()
                                .filter(nasabah -> nasabah.getIdNasabah().equals(elseInput))
                                .findFirst()
                                .orElse(null);
                        if (tempSelectedNasabah != null) {
                            subLogicNasabah();
                        } else {
                            System.out.println("ID Nasabah tidak ditemukan");
                            System.out.println("Masukkan [register] untuk registrasi nasabah & rekening baru");
                        }
                        break;
                }

            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
            }

            System.out.println();

        }
    }

    private static void registerNasabah() {
        Nasabah nasabahBaru  = Nasabah.registrasiNasabahBaru(inputAplikasi);
        DataSource.listNasabah.add(nasabahBaru);
        DataSource.listRekening.add(nasabahBaru.getRekening());
        System.out.println();
        System.out.println("REGISTRASI BERHASIL");
        System.out.println();

        DataSource.fetchData();
    }

    public static void subLogicNasabah() {
        String inputLogicNasabah = "";
        while (tempSelectedNasabah != null) {
            System.out.println("===== MENU NASABAH [ " + tempSelectedNasabah.getNamaNasabah() + " ] =====");
            System.out.println("Masukkan 0 / [exit] untuk keluar");
            System.out.println("Masukkan 1 / [saldo] untuk melihat saldo");
            System.out.println("Masukkan 2 / [setor] untuk menambah saldo");
            System.out.println("Masukkan 3 / [tarik] untuk menarik saldo");
            System.out.println("Masukkan 4 / [info] untuk melihat detail nasabah & rekening");
            System.out.println("===== MENU NASABAH =====");

            System.out.println();
            System.out.print("Input : ");
            try {
                inputLogicNasabah = inputAplikasi.readLine();
                switch (inputLogicNasabah) {
                    case "0", "exit":
                        System.out.println("Logout");
                        tempSelectedNasabah = null;
                        break;

                    case "1", "saldo":
                        System.out.println("===== LIHAT SALDO =====");
                        System.out.println("Saldo anda : " + formatRupiah(tempSelectedNasabah.getRekening().getSaldoRekening()));
                        System.out.println();
                        break;

                    case "2", "setor":
                        System.out.println("===== SETOR SALDO =====");
                        System.out.println("Masukkan nominal saldo yang ingin anda setor");
                        System.out.print("Input : ");
                        double nominalSetor = Double.parseDouble(inputAplikasi.readLine());
                        tempSelectedNasabah.getRekening().setorSaldo(nominalSetor);
                        System.out.println("===== SETOR SALDO =====");
                        break;

                    case "3", "tarik":
                        System.out.println("===== TARIK SALDO =====");
                        System.out.println("Masukkan nominal saldo yang ingin anda tarik");
                        System.out.print("Input : ");
                        double nominalTarik = Double.parseDouble(inputAplikasi.readLine());
                        System.out.println("Masukkan pin anda");
                        System.out.print("Input : ");
                        String pinTarik = inputAplikasi.readLine();
                        tempSelectedNasabah.getRekening().tarikSaldo(nominalTarik, pinTarik);
                        System.out.println("===== TARIK SALDO =====");
                        break;

                    case "4", "info":
                        System.out.println("===== INFO NASABAH =====");
                        tempSelectedNasabah.showDataNasabah();
                        System.out.println("===== INFO NASABAH =====");
                        break;

                    default:
                        System.out.println("Input tidak dikenali");
                }
            } catch (IOException e) {
                System.out.println("Error : " + e.getMessage());
            }

        }
    }

    public static String formatRupiah(double nominal) {
        String hasil = String.format("%,.0f", nominal).replaceAll(",", ".");
        return "Rp" + hasil;
    }
}
