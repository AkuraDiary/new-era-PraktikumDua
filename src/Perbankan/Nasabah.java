package Perbankan;

import java.io.BufferedReader;

public class Nasabah {

    public String getNamaNasabah() {
        return namaNasabah;
    }

    public String getIdNasabah() {
        return idNasabah;
    }

    private final String idNasabah;
    private final String namaNasabah;
    private final String ktpNasabah;
    private final int umurNasabah;
    private final String jenisKelaminNasabah;
    private final String ttlNasabah;
    private final String alamatNasabah;
    private final String noTelpNasabah;
    private final String emailNasabah;
        private final Rekening rekening;

    public Rekening getRekening() {
        return rekening;
    }

    public Nasabah(
            String idNasabah,
            String namaNasabah,
            String ktpNasabah,
            int umurNasabah,
            String jenisKelaminNasabah,
            String ttlNasabah,
            String alamatNasabah,
            String noTelpNasabah,
            String emailNasabah,
            Rekening rekening
    ) {
        this.idNasabah = idNasabah;
        this.namaNasabah = namaNasabah;
        this.ktpNasabah = ktpNasabah;
        this.umurNasabah = umurNasabah;
        this.jenisKelaminNasabah = jenisKelaminNasabah;
        this.ttlNasabah = ttlNasabah;
        this.alamatNasabah = alamatNasabah;
        this.noTelpNasabah = noTelpNasabah;
        this.emailNasabah = emailNasabah;
        this.rekening = rekening;
    }

    public void showDataNasabah() {
        System.out.println("=== DATA NASABAH ===");
        System.out.println("ID Nasabah : " + this.idNasabah);
        System.out.println("Nama Nasabah : " + this.namaNasabah);
        System.out.println("KTP Nasabah : " + this.ktpNasabah);
        System.out.println("Umur Nasabah : " + this.umurNasabah);
        System.out.println("Jenis Kelamin Nasabah : " + this.jenisKelaminNasabah);
        System.out.println("TTL Nasabah : " + this.ttlNasabah);
        System.out.println("Alamat Nasabah : " + this.alamatNasabah);
        System.out.println("No Telp Nasabah : " + this.noTelpNasabah);
        System.out.println("Email Nasabah : " + this.emailNasabah);
        System.out.println();
        this.rekening.showDetailRekening();
    }

    public static Nasabah registrasiNasabahBaru(BufferedReader input) {
        System.out.println("=== REGISTRASI NASABAH BARU ===");
        String namaNasabah = null;
        String ktpNasabah = null;
        int umurNasabah = 0;
        String jenisKelaminNasabah = null;
        String ttlNasabah = null;
        String alamatNasabah = null;
        String noTelpNasabah = null;
        String emailNasabah = null;
        try {
            System.out.print("Nama Nasabah : ");
            namaNasabah = input.readLine();

            System.out.print("KTP Nasabah : ");
            ktpNasabah = input.readLine();

            System.out.print("Umur Nasabah : ");
            umurNasabah = Integer.parseInt(input.readLine());

            System.out.print("Jenis Kelamin Nasabah : ");
            jenisKelaminNasabah = input.readLine();

            System.out.print("TTL Nasabah : ");
            ttlNasabah = input.readLine();

            System.out.print("Alamat Nasabah : ");
            alamatNasabah = input.readLine();

            System.out.print("No Telp Nasabah : ");
            noTelpNasabah = input.readLine();

            System.out.print("Email Nasabah : ");
            emailNasabah = input.readLine();

        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }

        Rekening rekening = Rekening.registrasiRekeningBaru(input);

        String idNasabah = "N00" + (DataSource.listNasabah.size() + 1);

        return new Nasabah(
                idNasabah,
                namaNasabah,
                ktpNasabah,
                umurNasabah,
                jenisKelaminNasabah,
                ttlNasabah,
                alamatNasabah,
                noTelpNasabah,
                emailNasabah,
                rekening
        );
    }


}
