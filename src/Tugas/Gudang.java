package Tugas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Gudang {
private final ArrayList<Barang> daftarBarang;

    // Constructor
    public Gudang() {
        this.daftarBarang = new ArrayList<>();
    }

    // Method tambahBarang
    public void tambahBarang(Barang b) {
        daftarBarang.add(b);
    }

    // Method tampilkanSemua
    public void tampilkanSemua() {
        if (daftarBarang.isEmpty()) {
            System.out.println("[Gudang Kosong]");
            return;
        }
        daftarBarang.forEach((b) -> {
            b.info();
    });
    }

    // Method simpanKeBerkas
    public void simpanKeBerkas(String namaFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(namaFile))) {
            for (Barang b : daftarBarang) {
                writer.write(b.keBaris());
                writer.newLine();
            }
            System.out.println("-> Berhasil menyimpan data ke berkas: " + namaFile);
        } catch (IOException e) {
            System.out.println("-> Gagal menyimpan berkas: " + e.getMessage());
        }
    }

    // Method muatDariBerkas
    public void muatDariBerkas(String namaFile) {
        daftarBarang.clear(); // Mengosongkan list sebelum memuat data baru
        try (BufferedReader reader = new BufferedReader(new FileReader(namaFile))) {
            String baris;
            while ((baris = reader.readLine()) != null) {
                // Memisahkan data berdasarkan koma
                String[] data = baris.split(",");
                if (data.length == 3) {
                    String nama = data[0];
                    double harga = Double.parseDouble(data[1]);
                    int stok = Integer.parseInt(data[2]);
                    
                    // Memasukkan objek Barang baru ke ArrayList
                    daftarBarang.add(new Barang(nama, harga, stok));
                }
            }
            System.out.println("-> Berhasil memuat data dari berkas: " + namaFile);
        } catch (IOException e) {
            System.out.println("-> Gagal memuat berkas: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("-> Gagal konversi data (Format Berkas Rusak): " + e.getMessage());
        }
    }

    // Method totalNilai (Harga dikali Stok dari seluruh barang)
    public double totalNilai() {
        double total = 0;
        total = daftarBarang.stream().map((b) -> b.getHarga() * b.getStok()).reduce(total, (accumulator, _item) -> accumulator + _item);
        return total;
    }   
}
