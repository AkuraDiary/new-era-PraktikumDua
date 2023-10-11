package Perbankan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Rekening {
    private String noRekening;

    public String getNoRekening() {
        return noRekening;
    }

    public String getIdRekening() {
        return idRekening;
    }

    public double getSaldoRekening() {
        return saldoRekening;
    }

    public Nasabah getNasabah() {
        return nasabah;
    }

    private String idRekening;
    private String pinRekening;
    private double saldoRekening;
    private Nasabah nasabah;
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public Rekening(String noRekening, String idRekening, String pinRekening, double saldoRekening, Nasabah nasabah) {
        this.noRekening = noRekening;
        this.idRekening = idRekening;
        this.pinRekening = pinRekening;
        this.saldoRekening = saldoRekening;
        this.nasabah = nasabah;
    }

    public void showDetailRekening() {
        System.out.println("=== DATA REKENING ANDA ===");
        System.out.println("No Rekening : " + this.noRekening);
        System.out.println("ID Rekening : " + this.idRekening);
        System.out.println("Saldo Rekening : " + Perbankan.formatRupiah(this.saldoRekening));
        nasabah.showDataNasabah();
        System.out.println();
    }

    public void setorSaldo(double setoran) {
        System.out.println("=== SETOR SALDO ===");
        System.out.println("No Rekening : " + this.noRekening);
        System.out.println("A.N Nasabah : " + this.nasabah.getNamaNasabah());
        System.out.println("Nominal Setoran : " + setoran);
        this.saldoRekening += setoran;
        System.out.println("Setoran Berhasil");
        System.out.println("Saldo Rekening : " + Perbankan.formatRupiah(this.saldoRekening));
        System.out.println();
    }

    public void tarikSaldo(double nominal, String pin) {
        System.out.println("=== TARIK SALDO ===");
        System.out.println("No Rekening : " + this.noRekening);
        System.out.println("A.N Nasabah : " + this.nasabah.getNamaNasabah());
        System.out.println("Nominal Penarikan : " + nominal);

        if (pin.equals(this.pinRekening)) {
            if (nominal <= this.saldoRekening) {
                this.saldoRekening -= nominal;
                System.out.println("Penarikan Berhasil");
                System.out.println("Saldo Rekening : " + Perbankan.formatRupiah(this.saldoRekening));
            } else {
                System.out.println("Penarikan Gagal, Saldo Tidak Mencukupi");
            }
        } else {
            System.out.println("Penarikan Gagal, PIN Salah");
        }

        System.out.println();
    }

    public Rekening registrasiRekeningBaru(Nasabah nasabah) {

        String noRekening = "";
        String pinRekening = "";
        double saldoAwalRekening = 50000.0;

        try {
            System.out.println("=== REGISTRASI REKENING BARU ===");
            nasabah.showDataNasabah();

//            System.out.print("No Rekening : ");
//            noRekening = input.readLine();

            System.out.println("PIN Rekening : ");
            pinRekening = input.readLine();

            System.out.print("Saldo Awal Rekening : ");
            saldoAwalRekening = Double.parseDouble(input.readLine());

        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        // generate random value for nomorRekening with 17 digits
        Random rand = new Random();
        long x = (long)(rand.nextDouble()*100000000000000L);
        noRekening =  String.format("%017d", x);

        String idRekening = nasabah.getIdNasabah() + noRekening;
        return new Rekening(
                noRekening,
                idRekening,
                pinRekening,
                saldoAwalRekening,
                nasabah
        );
    }

}
