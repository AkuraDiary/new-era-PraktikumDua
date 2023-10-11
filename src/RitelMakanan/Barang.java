package RitelMakanan;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Barang {

    String kode;
    String nama;
    int stock;
    int hargaJual;
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public void inputData() {
        System.out.println("==== Input Data Barang ====");
        try {
            System.out.print("Kode Barang : ");
            this.kode = input.readLine();

            System.out.print("Nama Barang : ");
            this.nama = input.readLine();

            System.out.print("Stock Barang : ");
            this.stock = Integer.parseInt(input.readLine());

            System.out.print("Harga Jual : ");
            this.hargaJual = Integer.parseInt(input.readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
    }


    public void viewData() {
        System.out.println("Menampilkan detil barang");
        System.out.println("Nama : " + nama);
        System.out.println("Kode : " + kode);
        System.out.println("Jumlah Stok : " + stock);
        System.out.println("Harga Jual : " + hargaJual);
        pressEnter();
    }

    public void jualStock(int ubah) {
        System.out.println("Menu Penjualan Barang");
        System.out.println("Stok awal : " + stock);
        this.stock = this.stock - ubah;
        System.out.println("Pengurangan : " + ubah);
        System.out.println("Stok akhir : " + stock);
        System.out.println("Data telah diubah");
        pressEnter();
    }

    private void pressEnter() {

        try{
            System.out.println("Tekan enter untuk melanjutkan");
            input.readLine();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
