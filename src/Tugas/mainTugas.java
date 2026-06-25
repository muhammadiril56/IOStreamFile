package Tugas;

public class mainTugas {
public static void main(String[] args) {
        String namaFileTeks = "barang.txt";

        // -----------------------------------------------------------------
        // Tambahan 1: Menyimpan & menampilkan kategori dalam Array String tetap
        // -----------------------------------------------------------------
        String[] kategori = {"Elektronik", "Pakaian", "Makanan", "Alat Tulis"};
        System.out.println("=== DAFTAR KATEGORI GUDANG ===");
        for (int i = 0; i < kategori.length; i++) {
            System.out.println((i + 1) + ". " + kategori[i]);
        }
        System.out.println();

        // -----------------------------------------------------------------
        // Inisialisasi Gudang Awal & Tambah Minimal 5 Barang
        // -----------------------------------------------------------------
        Gudang gudangAwal = new Gudang();
        gudangAwal.tambahBarang(new Barang("Laptop", 12500000, 5));
        gudangAwal.tambahBarang(new Barang("Smartphone", 4500000, 12));
        gudangAwal.tambahBarang(new Barang("Kemeja Flanel", 175000, 25));
        gudangAwal.tambahBarang(new Barang("Indomie Kardus", 115000, 50));
        gudangAwal.tambahBarang(new Barang("Buku Nota", 12500, 100));

        System.out.println("=== DATA GUDANG AWAL ===");
        gudangAwal.tampilkanSemua();
        System.out.printf("Total Nilai Persediaan Awal: Rp%,10.2f\n\n", gudangAwal.totalNilai());

        // -----------------------------------------------------------------
        // Tambahan 2: Menyimpan seluruh data barang ke berkas teks
        // -----------------------------------------------------------------
        System.out.println("=== PROSES PENYIMPANAN BERKAS ===");
        gudangAwal.simpanKeBerkas(namaFileTeks);
        System.out.println();

        // -----------------------------------------------------------------
        // Tambahan 3: Membuat objek Gudang baru & Memuat kembali data berkas
        // -----------------------------------------------------------------
        System.out.println("=== PROSES PENGECEKAN PERSISTENSI DATA ===");
        Gudang gudangBaru = new Gudang();
        
        // Memuat data dari file ke objek gudang baru
        gudangBaru.muatDariBerkas(namaFileTeks);
        
        System.out.println("\n=== DATA GUDANG BARU (HASIL LOAD) ===");
        gudangBaru.tampilkanSemua();
        
        // Menampilkan total nilai persediaan untuk membuktikan kesamaan data
        System.out.printf("Total Nilai Persediaan Baru: Rp%,10.2f\n", gudangBaru.totalNilai());
        System.out.println("=========================================");
    }    
}
