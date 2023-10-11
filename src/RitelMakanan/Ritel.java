package RitelMakanan;

public class Ritel {
    public static void main(String[] args) {
        Barang brg1 = new Barang();
        Barang brg2 = new Barang();
        brg1.inputData();
        brg2.inputData();

        brg1.jualStock(33);
        brg2.jualStock(45);

        brg1.viewData();
        brg2.viewData();
    }
}
