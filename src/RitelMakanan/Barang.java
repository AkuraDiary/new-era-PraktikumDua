package RitelMakanan;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Barang {

    // Pengamatan
    // Gabungkan kode program diatas, sehingga dapat menjadi sebuah kode program yang lengkap. (done)

    // Pada proses penjualan barang (method jualStock()),
    // masih belum didapatkan total harga yang harus dibayarkan pada saat proses jual barang.
    // Tambahkan kode baru, yang digunakan untuk menghitung besaran harga
    // yang harus dibayarkan pada transaksi tersebut.
    // Silahkan menyisipkan pada kode yang telah ada, atau membuat sebuah method baru pada kelas barang.

    // Pada kode diatas, hanya terdapat proses pengurangan jumlah stock saja. Buatlah sebuah method
    // baru, yang digunakan untuk melakukan proses penambahan stock barang.

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

    // Pada kode diatas, hanya terdapat proses pengurangan jumlah stock saja. Buatlah sebuah method
    // baru, yang digunakan untuk melakukan proses penambahan stock barang.
    public void tambahStock(int ubah) {
        System.out.println("Menu Penambahan Stock Barang " + nama );
        System.out.println("Stok awal : " + stock);
        this.stock = this.stock + ubah;
        System.out.println("Penambahan : " + ubah);

        System.out.println("Stok akhir : " + stock);

        System.out.println("Data telah diubah");
        pressEnter();
    }

    public void jualStock(int ubah) {
        System.out.println("Menu Penjualan Barang " + nama );
        System.out.println("Stok awal : " + stock);

        this.stock = this.stock - ubah;

        System.out.println("Harga satuan : " + hargaJual);
        System.out.println("Pengurangan : " + ubah);

        // Tambahan untuk total harga yang harus dibayarkan
        int totalHarga = hitungTotalHarga(ubah);
        System.out.println("Total harga yang harus dibayarkan: " + totalHarga);

        System.out.println("Stok akhir : " + stock);

        System.out.println("Data telah diubah");
        pressEnter();
    }

    // method untuk menghitung total harga, dengan parameter jumlah
    // jumlah * hargaJual
    int hitungTotalHarga(int jumlah) {
        return jumlah * this.hargaJual;
    }

    private void pressEnter() {
        try {
            System.out.println("Tekan enter untuk melanjutkan");
            input.readLine();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
