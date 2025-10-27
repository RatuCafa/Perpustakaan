package Modul_2.Tugas;

import java.util.Scanner;

/**
 * Kelas utama yang menjalankan program Perpustakaan Sederhana.
 * Bertanggung jawab menampilkan menu dan menangani input/output pengguna (UI).
 */
public class MainApp {

    /**
     * Menampilkan menu interaksi ke konsol.
     */
    private static void tampilkanMenu() {
        System.out.println("\n--- MENU PERPUSTAKAAN SEDERHANA ---");
        System.out.println("1. Tambah Buku Baru");
        System.out.println("2. Tampilkan Semua Buku");
        System.out.println("3. Pinjam Buku (Berdasarkan ISBN)");
        System.out.println("4. Kembalikan Buku (Berdasarkan ISBN)");
        System.out.println("5. Keluar");
        System.out.print("Pilih opsi (1-5): ");
    }

    /**
     * Metode utama (main method) untuk menjalankan aplikasi.
     * @param args Argumen baris perintah (tidak digunakan).
     */
    public static void main(String[] args) {

        KatalogBuku katalog = new KatalogBuku();
        Scanner scanner = new Scanner(System.in);

        int pilihan = 0;

        // Inisialisasi data awal
        katalog.tambahBuku(new Buku("Filosofi Teras", "Henry Manampiring", "978-602-452-974-0"));
        katalog.tambahBuku(new Buku("Atomic Habits", "James Clear", "978-602-06-6927-9"));
        katalog.tambahBuku(new Buku("Laskar Pelangi", "Andrea Hirata", "978-979-306-279-2"));

        do {
            tampilkanMenu();
            if (scanner.hasNextInt()) {
                pilihan = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("⚠️ Input tidak valid. Masukkan angka saja.");
                scanner.nextLine();
                continue;
            }

            switch (pilihan) {
                case 1:
                    tambahBukuUI(scanner, katalog);
                    break;
                case 2:
                    katalog.tampilkanSemuaBuku();
                    break;
                case 3:
                    pinjamBukuUI(scanner, katalog);
                    break;
                case 4:
                    kembalikanBukuUI(scanner, katalog);
                    break;
                case 5:
                    System.out.println("Terima kasih, program berakhir.");
                    break;
                default:
                    System.out.println("Pilihan tidak ada. Silakan coba lagi.");
            }
        } while (pilihan != 5);

        scanner.close();
    }

    /**
     * Menangani interaksi pengguna untuk menambah buku baru.
     * Meminta input detail buku dan memanggil method tambahBuku pada KatalogBuku.
     * @param scanner Objek Scanner untuk membaca input.
     * @param katalog Objek KatalogBuku tempat buku akan ditambahkan.
     */
    private static void tambahBukuUI(Scanner scanner, KatalogBuku katalog) {
        System.out.print("Masukkan Judul: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan Penulis: ");
        String penulis = scanner.nextLine();
        System.out.print("Masukkan ISBN (sebagai kode unik): ");
        String isbn = scanner.nextLine();

        Buku bukuBaru = new Buku(judul, penulis, isbn);
        katalog.tambahBuku(bukuBaru);
    }

    /**
     * Menangani interaksi pengguna untuk meminjam buku.
     * Meminta input ISBN dan memanggil method pinjamBuku pada KatalogBuku.
     * @param scanner Objek Scanner untuk membaca input.
     * @param katalog Objek KatalogBuku tempat operasi peminjaman dilakukan.
     */
    private static void pinjamBukuUI(Scanner scanner, KatalogBuku katalog) {
        System.out.print("Masukkan ISBN buku yang akan dipinjam: ");
        String isbn = scanner.nextLine();
        katalog.pinjamBuku(isbn);
    }

    /**
     * Menangani interaksi pengguna untuk mengembalikan buku.
     * Meminta input ISBN dan memanggil method kembalikanBuku pada KatalogBuku.
     * @param scanner Objek Scanner untuk membaca input.
     * @param katalog Objek KatalogBuku tempat operasi pengembalian dilakukan.
     */
    private static void kembalikanBukuUI(Scanner scanner, KatalogBuku katalog) {
        System.out.print("Masukkan ISBN buku yang akan dikembalikan: ");
        String isbn = scanner.nextLine();
        katalog.kembalikanBuku(isbn);
    }
}
