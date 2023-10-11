package RitelMakanan;

public class Ritel {

// Pengamatan
// Gabungkan kode program diatas, sehingga dapat menjadi sebuah kode program yang lengkap. (done)

// Pada proses penjualan barang (method jualStock()),
// masih belum didapatkan total harga yang harus dibayarkan pada saat proses jual barang.
// Tambahkan kode baru, yang digunakan untuk menghitung besaran harga
// yang harus dibayarkan pada transaksi tersebut.
// Silahkan menyisipkan pada kode yang telah ada, atau membuat sebuah method baru pada kelas barang.

// Pada kode diatas, hanya terdapat proses pengurangan jumlah stock saja. Buatlah sebuah method
// baru, yang digunakan untuk melakukan proses penambahan stock barang.

    public static void main(String[] args) {
        Barang brg1 = new Barang();
        Barang brg2 = new Barang();
        brg1.inputData();
        brg2.inputData();

        brg1.tambahStock(50);
        brg1.jualStock(33);

        brg2.tambahStock(55);
        brg2.jualStock(45);

        brg1.viewData();
        brg2.viewData();
    }
}
