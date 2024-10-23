package com.mycompany.ocxee.view;

import com.mycompany.ocxee.DAO.DestinasiDAO;
import com.mycompany.ocxee.DAO.PesanTiketDAO;
import com.mycompany.ocxee.DAO.PenyelamDAO;
import com.mycompany.ocxee.model.Destinasi;
import com.mycompany.ocxee.model.PesanTiket;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Beranda {
    private DestinasiDAO destinasiDAO;
    private PenyelamDAO penyelamDAO;
    private PesanTiketDAO pesanTiketDAO;
    private Scanner scanner;

    public Beranda(PesanTiketDAO pesanTiketDAO, DestinasiDAO destinasiDAO, PenyelamDAO penyelamDAO) {
        String jdbcURL = "jdbc:mysql://localhost:3306/oxcee";
        String jdbcUsername = "root";
        String jdbcPassword = "";
        this.destinasiDAO = destinasiDAO;
        this.penyelamDAO = penyelamDAO;
        this.pesanTiketDAO = new pesanTiketDAO(jdbcURL, jdbcUsername, jdbcPassword);
        this.scanner = new Scanner(System.in);
    }



    public void showBeranda() {
        while (true) {
            System.out.println("=== Beranda ===");
            System.out.println("1. Pesan Tiket");
            System.out.println("2. Lihat Tiket Saya");
            System.out.println("3. Lihat Destinasi");
            System.out.println("4. Log Out");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Menyerap newline

            switch (choice) {
                case 1:
                    pesanTiket();
                    break;
                case 2:
                    lihatTiketSaya();
                    break;
                case 3:
                    lihatDestinasi();
                    break;
                case 4:
                    System.out.println("Log out berhasil.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

     private void pesanTiket() {
        System.out.println("=== Pesan Tiket ===");
        System.out.print("Masukkan ID Penyelam: ");
        String idPenyelam = scanner.nextLine();
        System.out.print("Pilih Destinasi: ");
        String idDestinasi = scanner.nextLine();
        System.out.print("Masukkan Tanggal (YYYY-MM-DD): ");
        String tanggalInput = scanner.nextLine();
        
        try {
            Date tanggal = Date.valueOf(tanggalInput);  // Parse the date

            // Create ticket object and insert into database
            PesanTiket tiket = new PesanTiket(generateIdTiket(), idPenyelam, idDestinasi, tanggal);
            pesanTiketDAO.insertPesanTiket(tiket);

            System.out.println("Tiket berhasil dipesan!");
        } catch (IllegalArgumentException e) {
            System.out.println("Tanggal tidak valid. Pastikan menggunakan format YYYY-MM-DD.");
        }
    }

    // Dummy method to generate ticket ID
    private String generateIdTiket() {
        // Logic to generate a unique ID, for now, return a placeholder
        return "TIKET12345";
    }

    private void lihatTiketSaya() {
        // Implementasi lihat tiket saya di sini
        System.out.println("Fitur lihat tiket saya belum tersedia.");
    }

  private void lihatDestinasi() {
    DestinasiDAO destinasiDAO = new DestinasiDAO();
    List<Destinasi> destinasiList = destinasiDAO.getAllDestinasi();
    
    if (destinasiList.isEmpty()) {
        System.out.println("Tidak ada destinasi yang tersedia.");
    } else {
        for (Destinasi destinasi : destinasiList) {
            System.out.println("ID Destinasi: " + destinasi.getIdDestinasi());
            System.out.println("Nama Destinasi: " + destinasi.getNamaDestinasi());
            System.out.println("Kedalaman: " + destinasi.getKedalaman());
            System.out.println("Flora: " + destinasi.getFlora());
            System.out.println("Fauna: " + destinasi.getFauna());
            System.out.println("Pendamping: " + destinasi.getPendamping());
            System.out.println("---------------------------");
        }
    }
}
    private PesanTiketDAO pesanTiketDAO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static class pesanTiketDAO extends PesanTiketDAO {

        public pesanTiketDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        }
    }
}
