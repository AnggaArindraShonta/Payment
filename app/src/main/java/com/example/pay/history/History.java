package com.example.pay.history;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "history_table")
public class History {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String namapembayaran;
    private String tanggal;
    private String metodepembayaran;
    private String status;

    public History(String namapembayaran, String tanggal, String metodepembayaran, String status) {
        this.namapembayaran = namapembayaran;
        this.tanggal = tanggal;
        this.metodepembayaran = metodepembayaran;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamapembayaran() {
        return namapembayaran;
    }

    public void setNamapembayaran(String namapembayaran) {
        this.namapembayaran = namapembayaran;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getMetodepembayaran() {
        return metodepembayaran;
    }

    public void setMetodepembayaran(String metodepembayaran) {
        this.metodepembayaran = metodepembayaran;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
