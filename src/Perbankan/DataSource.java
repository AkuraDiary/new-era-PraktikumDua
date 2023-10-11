package Perbankan;

import java.util.ArrayList;
import java.util.Random;

public class DataSource {

    static ArrayList<Nasabah> listNasabah = new ArrayList<Nasabah>();
    static ArrayList<Rekening> listRekening = new ArrayList<Rekening>();

    public static String generateNoRek(){
        // generate random value for nomorRekening with 17 digits
        Random rand = new Random();
        long x = (long)(rand.nextDouble()*100000000000000L);
        return  String.format("%017d", x);

    }
    public static void initDatasource() {
        Nasabah nasabah1 = new Nasabah(
                "N001",
                "Rizky Khapidsyah",
                "1234567890",
                23,
                "Laki-Laki",
                "Jakarta, 20 Januari 2000",
                "Jl. Kebon Jeruk Raya No. 20",
                "081234567890",
                "rizkypasuruan@gmail.com"
        );
        Rekening rekening1 = new Rekening(
                generateNoRek(),
                "R001",
                "123456",
                1000000,
                nasabah1
        );

        Nasabah nasabah2 = new Nasabah(
                "N002",
                "Rifqy Arrasssy",
                "190283109284",
                18,
                "Laki-Laki",
                "Jakarta, 20 Januari 2005",
                "Jl. Jalan Jalan",
                "08123124124",
                "rifqieslilin@gmail.com"
        );
        Rekening rekening2 = new Rekening(
                generateNoRek(),
                "R002",
                "123123",
                10000000,
                nasabah2
        );

        listNasabah.add(nasabah1);
        listNasabah.add(nasabah2);

        listRekening.add(rekening1);
        listRekening.add(rekening2);

    }

    public static void fetchData() {
        System.out.println("===== FETCHING DATA                      =====");
        System.out.println("===== BANK ITTS ERPEEL DJAYA DJAYA DJAYA =====");
        // print both the listNasabah & listRekening in a table format
        System.out.println("_______________________________________________________________________________________");
        System.out.format("%8s %20s %50s \n", "ID Nasabah", "No Rekening", "Nama Nasabah");
        System.out.println("_______________________________________________________________________________________");
//        System.out.println("ID Nasabah | No Rekening | Nama Nasabah");
        listRekening
                .stream()
                .iterator()
                .forEachRemaining(
                        rekening -> {
                            String idNasabah = rekening.getNasabah().getIdNasabah();
                            String noRekeningNasabah = rekening.getNoRekening();
                            String namaNasabah = rekening.getNasabah().getNamaNasabah();
                            System.out.format("%10s %20s %50s \n", idNasabah, noRekeningNasabah, namaNasabah);
//                            System.out.println(rekening.getNasabah().getIdNasabah() + " | " + rekening.getNoRekening() + " | " + rekening.getNasabah().getNamaNasabah());
                        }
                );
    }

}
