package com.mycompany.ocxee.view;

import com.mycompany.ocxee.DAO.PenyelamDAO;
import com.mycompany.ocxee.DAO.DestinasiDAO;
import com.mycompany.ocxee.DAO.PesanTiketDAO;
import com.mycompany.ocxee.model.Penyelam;
import java.util.Scanner;

public class PenyelamView {
    private Scanner scanner;
    private PenyelamDAO penyelamDAO;
    private DestinasiDAO destinasiDAO;
    private Beranda beranda;
    private PesanTiketDAO PesanTiketDAO;

    public PenyelamView(PenyelamDAO penyelamDAO) {
        this.scanner = new Scanner(System.in);
        this.penyelamDAO = penyelamDAO;
        this.beranda = new Beranda(PesanTiketDAO, destinasiDAO, penyelamDAO); // Membuat instance dari kelas Beranda
    }

    public void showMenu() {
        while (true) {
            System.out.println("=== Aplikasi Penyelam ===");
            System.out.println("1. Daftar");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Menyerap newline

            switch (choice) {
                case 1:
                    signIn();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Keluar dari aplikasi.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private void signIn() {
        System.out.print("Masukkan ID Penyelam: ");
        String idPenyelam = scanner.nextLine();

        // Check if ID already exists
        if (penyelamDAO.getPenyelam(idPenyelam) != null) {
            System.out.println("ID Penyelam sudah terdaftar. Silakan gunakan ID lain.");
            return;
        }

        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Umur: ");
        int umur = scanner.nextInt();
        scanner.nextLine(); // Menyerap newline

        // Age validation
        if (umur < 18 || umur > 60) {
            System.out.println("Umur harus antara 18 dan 60 tahun.");
            return;
        }

        System.out.print("Masukkan Alamat: ");
        String alamat = scanner.nextLine();
        System.out.print("Masukkan Password: ");
        String password = scanner.nextLine();

        // Password validation
        if (password.length() < 6 || password.length() > 10) {
            System.out.println("Password harus terdiri dari 6 hingga 10 karakter.");
            return;
        }

        System.out.print("Masukkan No HP: ");
        String noHp = scanner.nextLine();

        // Phone number validation
        if (!noHp.matches("\\d{11}")) {
            System.out.println("No HP harus terdiri dari 11 angka.");
            return;
        }

        // Membuat objek Penyelam dan menyimpannya ke database
        Penyelam penyelam = new Penyelam(idPenyelam, nama, umur, alamat, password, noHp);
        penyelamDAO.insertPenyelam(penyelam);
        System.out.println("Penyelam berhasil didaftarkan!");
    }

    private void login() {
        System.out.print("Masukkan ID Penyelam: ");
        String idPenyelam = scanner.nextLine();
        System.out.print("Masukkan Password: ");
        String password = scanner.nextLine();

        // Mengambil data penyelam dari database
        Penyelam penyelam = penyelamDAO.getPenyelam(idPenyelam);
        if (penyelam != null && penyelam.getPassword().equals(password)) {
            System.out.println("Login berhasil! Selamat datang, " + penyelam.getNama());
            beranda.showBeranda(); // Memanggil beranda setelah login berhasil
        } else {
            System.out.println("ID atau password salah. Silakan coba lagi.");
        }
    }
}