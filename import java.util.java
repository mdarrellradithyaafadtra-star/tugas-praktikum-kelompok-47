import java.util.Scanner;

// Class Bioskop yang memiliki method
class Bioskop {
    private String[] daftarFilm = {"Avengers: Endgame", "Interstellar", "Spiderman"};
    private int[] hargaTiket = {50000, 45000, 40000};

    // 1. Non-return type (void) tanpa parameter (METHOD)
    public void tampilkanHeader() {
        System.out.println("========================================");
        System.out.println("      SISTEM PEMESANAN TIKET BIOSKOP    ");
        System.out.println("            WATERMARK: KELOMPOK 47      ");
        System.out.println("========================================");
    }

    // 2. Non-return type (void) berparameter (METHOD)
    public void tampilkanDaftarFilm() {
        System.out.println("\nDaftar Film Hari Ini:");
        for (int i = 0; i < daftarFilm.length; i++) {
            System.out.println((i + 1) + ". " + daftarFilm[i] + " - Rp" + hargaTiket[i]);
        }
    }

    // 3. Return type tanpa parameter (METHOD)
    public int getJumlahFilm() {
        return daftarFilm.length;
    }

    // 4. Return type berparameter (METHOD)
    public int getHargaFilm(int pilihan) {
        if (pilihan >= 1 && pilihan <= daftarFilm.length) {
            return hargaTiket[pilihan - 1];
        }
        return 0;
    }

    public String getJudulFilm(int pilihan) {
        if (pilihan >= 1 && pilihan <= daftarFilm.length) {
            return daftarFilm[pilihan - 1];
        }
        return "Tidak Valid";
    }
}

public class Main {

    // 5. Return type berparameter (FUNCTION static)
    public static int hitungTotalBayar(int harga, int jumlahTiket) {
        return harga * jumlahTiket;
    }

    // 6. Non-return type / void berparameter (FUNCTION static)
    public static void cetakStruk(String judul, int jumlah, int total) {
        System.out.println("\n----------------------------------------");
        System.out.println("             STRUK PEMBAYARAN           ");
        System.out.println("----------------------------------------");
        System.out.println("Film         : " + judul);
        System.out.println("Jumlah Tiket : " + jumlah);
        System.out.println("Total Bayar  : Rp" + total);
        System.out.println("----------------------------------------");
        System.out.println(" Terima kasih! Watermark: Kelompok 47 ");
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bioskop bioskop = new Bioskop();

        // Pemanggilan Method Void tanpa parameter
        bioskop.tampilkanHeader();

        boolean lanjut = true;

        // Perulangan (while)
        while (lanjut) {
            // Pemanggilan Method Void
            bioskop.tampilkanDaftarFilm();

            System.out.print("\nPilih nomor film (1-" + bioskop.getJumlahFilm() + "): ");
            int pilihan = scanner.nextInt();

            // Pengkondisian (if-else)
            if (pilihan >= 1 && pilihan <= bioskop.getJumlahFilm()) {
                System.out.print("Masukkan jumlah tiket yang ingin dibeli: ");
                int jumlah = scanner.nextInt();

                // Pemanggilan Method dengan return type & parameter
                String judul = bioskop.getJudulFilm(pilihan);
                int harga = bioskop.getHargaFilm(pilihan);

                // Pemanggilan Function dengan return type & parameter
                int total = hitungTotalBayar(harga, jumlah);

                // Pemanggilan Function void berparameter
                cetakStruk(judul, jumlah, total);
            } else {
                System.out.println("Pilihan tidak valid!");
            }

            System.out.print("\nApakah ingin memesan lagi? (y/n): ");
            char ulang = scanner.next().charAt(0);
            if (ulang == 'n' || ulang == 'N') {
                lanjut = false;
            }
        }

        System.out.println("\nProgram Selesai. (Kelompok 47)");
        scanner.close();
    }
}