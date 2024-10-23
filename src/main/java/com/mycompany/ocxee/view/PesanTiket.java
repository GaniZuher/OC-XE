package com.mycompany.ocxee.view;

import com.mycompany.ocxee.DAO.DestinasiDAO;
import com.mycompany.ocxee.DAO.PenyelamDAO;
import com.mycompany.ocxee.model.Destinasi;
import com.mycompany.ocxee.model.Penyelam;
import java.sql.Date;

import java.util.List;
import java.util.Scanner;

public class PesanTiket {
   
    private DestinasiDAO destinasiDAO;
    private PenyelamDAO penyelamDAO;
    private Scanner scanner;

    public PesanTiket(DestinasiDAO destinasiDAO, PenyelamDAO penyelamDAO) {
        
        this.destinasiDAO = destinasiDAO;
        this.penyelamDAO = penyelamDAO;
        this.scanner = new Scanner(System.in);
    }

    public void showPesanTiket() {
        System.out.println("=== Pesan Tiket ===");
        
        // 1. Menampilkan Destinasi
        List<Destinasi> destinasiList = destinasiDAO.getAllDestinasi();
        System.out.println("Pilih Destinasi:");
        for (int i = 0; i < destinasiList.size(); i++) {
            System.out.println((i + 1) + ". " + destinasiList.get(i).getNamaDestinasi());
        }
        
        System.out.print("Masukkan nomor destinasi yang dipilih: ");
        int destinasiIndex = scanner.nextInt() - 1;
        if (destinasiIndex < 0 || destinasiIndex >= destinasiList.size()) {
            System.out.println("Destinasi tidak valid.");
            return;
        }

        // 2. Memilih Tanggal
        System.out.print("Masukkan tanggal pemesanan (YYYY-MM-DD): ");
        String tanggal = scanner.next(); // Pastikan format tanggal sesuai

        // 3. Memilih Sesi
        System.out.println("Pilih Sesi:");
        System.out.println("1. Sesi 1 (09:00 - 10:00)");
        System.out.println("2. Sesi 2 (12:00 - 13:00)");
        System.out.println("3. Sesi 3 (16:00 - 17:00)");
        System.out.print("Masukkan nomor sesi yang dipilih: ");
        int sesiPilihan = scanner.nextInt();

        
        

        // 4. Memeriksa Ketersediaan Sesi
        

    }public String getIdTiket() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getIdPenyelam() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getIdDestinasi() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Date getTanggal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}