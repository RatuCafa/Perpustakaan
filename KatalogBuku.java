package Modul_2.Tugas;

import java.util.ArrayList;
import java.util.List;

/**
 * Kelas yang bertanggung jawab mengelola koleksi Buku menggunakan ArrayList.
 * Menangani semua operasi bisnis seperti menambah, mencari, meminjam, dan mengembalikan buku.
 */
public class KatalogBuku {
    // Atribut: Menggunakan ArrayList untuk menyimpan semua objek Buku
    private List<Buku> koleksiBuku;

    /**
     * Konstruktor untuk inisialisasi KatalogBuku.
     */
    public KatalogBuku() {
        this.koleksiBuku = new ArrayList<>();
    }

    /**
     * Mencari objek Buku berdasarkan ISBN menggunakan pencarian linear (iterasi seluruh list).
     * @param isbn Nomor ISBN yang dicari.
     * @return Objek Buku jika ditemukan, null jika tidak.
     */
    private Buku cariBuku(String isbn) {
        for (Buku buku : koleksiBuku) {
            if (buku.getIsbn().equals(isbn)) {
                return buku;
            }
        }
        return null;
    }

    /**
     * Menambahkan objek Buku baru ke dalam katalog.
     * Akan gagal jika ISBN buku sudah ada di dalam koleksi.
     * @param buku Objek Buku yang akan ditambahkan.
     */
    public void tambahBuku(Buku buku) {
        if (cariBuku(buku.getIsbn()) != null) {
            System.out.println("⚠️ ERROR: Buku dengan ISBN " + buku.getIsbn() + " sudah ada.");
        } else {
            koleksiBuku.add(buku);
            System.out.println("✅ Buku '" + buku.getJudul() + "' berhasil ditambahkan.");
        }
    }

    /**
     * Mengubah status buku menjadi 'dipinjam'.
     * Akan gagal jika buku tidak ditemukan atau sudah dalam status dipinjam.
     * @param isbn Nomor ISBN buku yang akan dipinjam.
     * @return true jika peminjaman berhasil, false jika gagal.
     */
    public boolean pinjamBuku(String isbn) {
        Buku buku = cariBuku(isbn);
        if (buku == null) {
            System.out.println("❌ Gagal! Buku dengan ISBN " + isbn + " tidak ditemukan.");
            return false;
        }
        if (buku.isDipinjam()) {
            System.out.println("❌ Gagal! Buku '" + buku.getJudul() + "' sedang dipinjam.");
            return false;
        }

        buku.setDipinjam(true);
        System.out.println("➡️ Berhasil meminjam buku: " + buku.getJudul());
        return true;
    }

    /**
     * Mengubah status buku menjadi 'tersedia'.
     * Akan gagal jika buku tidak ditemukan atau tidak sedang dalam status dipinjam.
     * @param isbn Nomor ISBN buku yang akan dikembalikan.
     * @return true jika pengembalian berhasil, false jika gagal.
     */
    public boolean kembalikanBuku(String isbn) {
        Buku buku = cariBuku(isbn);
        if (buku == null) {
            System.out.println("❌ Gagal! Buku dengan ISBN " + isbn + " tidak ditemukan.");
            return false;
        }
        if (!buku.isDipinjam()) {
            System.out.println("❌ Gagal! Buku '" + buku.getJudul() + "' tidak dalam status dipinjam.");
            return false;
        }

        buku.setDipinjam(false);
        System.out.println("⬅️ Berhasil mengembalikan buku: " + buku.getJudul());
        return true;
    }

    /**
     * Mencetak semua buku yang ada di dalam koleksi beserta statusnya.
     */
    public void tampilkanSemuaBuku() {
        if (koleksiBuku.isEmpty()) {
            System.out.println("Katalog kosong. Silakan tambahkan buku terlebih dahulu.");
            return;
        }
        System.out.println("\n=== KOLEKSI BUKU PERPUSTAKAAN ===");
        for (Buku buku : koleksiBuku) {
            System.out.println(buku);
        }
        System.out.println("=================================\n");
    }
}
