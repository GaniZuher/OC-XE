package com.mycompany.ocxee.model;

import java.time.LocalDate;

public class tiket {
    private int id_tiket;
    private int id_penyelam;
    private int id_destinasi;
    private LocalDate tanggal;
    private int waktu;
    private int quantity;
    private int harga;
    private int id_pembayaran;

    public tiket(int id_tiket, int id_penyelam, int id_destinasi, LocalDate tanggal, int waktu, int kuantitas, int harga, int id_pembayaran) {
        this.id_tiket = id_tiket;
        this.id_penyelam = id_penyelam;
        this.id_destinasi = id_destinasi;
        this.tanggal = tanggal;
        this.waktu = waktu;
        this.quantity = kuantitas;
        this.harga = harga;
        this.id_pembayaran = id_pembayaran;
    }

    public int getId_tiket() {
        return id_tiket;
    }

    public int getId_penyelam() {
        return id_penyelam;
    }

    public int getId_destinasi() {
        return id_destinasi;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public int getWaktu() {
        return waktu;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getHarga() {
        return harga;
    }

    public int getId_pembayaran() {
        return id_pembayaran;
    }

    public void setId_tiket(int id_tiket) {
        this.id_tiket = id_tiket;
    }

    public void setId_penyelam(int id_penyelam) {
        this.id_penyelam = id_penyelam;
    }

    public void setId_destinasi(int id_destinasi) {
        this.id_destinasi = id_destinasi;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }

    public void setWaktu(int waktu) {
        this.waktu = waktu;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setId_pembayaran(int id_pembayaran) {
        this.id_pembayaran = id_pembayaran;
    }    
}