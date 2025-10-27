package Modul_2.Tugas;

/**
 * Kelas yang merepresentasikan entitas tunggal sebuah Buku.
 * Bertanggung jawab menyimpan data dan status ketersediaan buku (isDipinjam).
 */
public class Buku {
    private String judul;
    private String penulis;
    private String isbn;
    private boolean isDipinjam;

    /**
     * Konstruktor untuk membuat objek Buku baru.
     * @param judul Judul buku.
     * @param penulis Nama penulis buku.
     * @param isbn Nomor International Standard Book Number (sebagai ID unik).
     */
    public Buku(String judul, String penulis, String isbn) {
        this.judul = judul;
        this.penulis = penulis;
        this.isbn = isbn;
        this.isDipinjam = false;
    }

    /**
     * Mengembalikan ISBN dari buku.
     * @return String yang berisi ISBN buku.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Mengembalikan judul dari buku.
     * @return String yang berisi judul buku.
     */
    public String getJudul() {
        return judul;
    }

    /**
     * Memeriksa status peminjaman buku.
     * @return boolean; true jika sedang dipinjam, false jika tersedia.
     */
    public boolean isDipinjam() {
        return isDipinjam;
    }

    /**
     * Mengatur status peminjaman buku.
     * @param dipinjam Status baru (true untuk dipinjam, false untuk dikembalikan).
     */
    public void setDipinjam(boolean dipinjam) {
        this.isDipinjam = dipinjam;
    }

    /**
     * Representasi String dari objek Buku, termasuk status peminjaman.
     * @return String format ISBN | Judul | Penulis (Status).
     */
    @Override
    public String toString() {
        String status = isDipinjam ? " (DIPINJAM)" : " (TERSEDIA)";
        return "ISBN: " + isbn + " | Judul: " + judul + " | Penulis: " + penulis + status;
    }
}
