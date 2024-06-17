    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project.View;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Muliani
 */
public class Barang {
    private String ID,nama,tempat,status, tanggal;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    private int jumlah;

    public Barang() {
    }

    public Barang(String ID, String nama, String tempat, String status, String tanggal, int jumlah) {
        this.ID = ID;
        this.nama = nama;
        this.tempat = tempat;
        this.status = status;
        this.tanggal = tanggal;
        this.jumlah = jumlah;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    @Override
    public String toString() {
        return "barangClass{" + "ID=" + ID + ", nama=" + nama + ", tempat=" + tempat + ", tanggal=" + tanggal + ", jumlah=" + jumlah + '}';
    }
    
}
