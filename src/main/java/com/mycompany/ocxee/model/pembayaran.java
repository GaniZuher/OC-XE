package com.mycompany.ocxee.model;

public class pembayaran {
    private int id_pembayaran;
    private int nominal;
    private String jenis_pembayaran;
    private int id_tiket;
    private int id_penyelam;

    public pembayaran(int id_pembayaran, int nominal, String jenis_pembayaran,int id_penyelam,int id_tiket) {
        this.id_pembayaran = id_pembayaran;
        this.nominal = nominal;
        this.jenis_pembayaran = jenis_pembayaran;
        this.id_tiket = id_tiket;
        this.id_penyelam = id_penyelam;
    }

    public int getId_pembayaran() {
        return id_pembayaran;
    }

    public int getNominal() {
        return nominal;
    }

    public String getJenis_pembayaran() {
        return jenis_pembayaran;
    }

    public int getId_tiket() {
        return id_tiket;
    }

    public int getId_penyelam() {
        return id_penyelam;
    }

    public void setId_pembayaran(int id_pembayaran) {
        this.id_pembayaran = id_pembayaran;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public void setJenis_pembayaran(String jenis_pembayaran) {
        this.jenis_pembayaran = jenis_pembayaran;
    }

    public void setId_tiket(int id_tiket) {
        this.id_tiket = id_tiket;
    }

    public void setId_penyelam(int id_penyelam) {
        this.id_penyelam = id_penyelam;
    }
    
}