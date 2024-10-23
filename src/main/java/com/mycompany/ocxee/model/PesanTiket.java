package com.mycompany.ocxee.model;

import java.sql.Date;

public class PesanTiket {
    private String idTiket;
    private String idPenyelam;
    private String idDestinasi;
    private Date tanggal;

    public PesanTiket(String idTiket, String idPenyelam, String idDestinasi, Date tanggal) {
        this.idTiket = idTiket;
        this.idPenyelam = idPenyelam;
        this.idDestinasi = idDestinasi;
        this.tanggal = tanggal;
    }

    public String getIdTiket() {
        return idTiket;
    }

    public String getIdPenyelam() {
        return idPenyelam;
    }

    public String getIdDestinasi() {
        return idDestinasi;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setIdTiket(String idTiket) {
        this.idTiket = idTiket;
    }

    public void setIdPenyelam(String idPenyelam) {
        this.idPenyelam = idPenyelam;
    }

    public void setIdDestinasi(String idDestinasi) {
        this.idDestinasi = idDestinasi;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
    
}
