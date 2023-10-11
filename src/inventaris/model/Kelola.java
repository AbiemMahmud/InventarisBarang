/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventaris.model;

/**
 *
 * @author admin
 */
public class Kelola {
    private String id_user, id_barang;
    private int tambah, kurang;
    private String tanggal;

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getId_barang() {
        return id_barang;
    }

    public void setId_barang(String id_barang) {
        this.id_barang = id_barang;
    }

    public int getTambah() {
        return tambah;
    }

    public void setTambah(int tambah) {
        this.tambah = tambah;
    }

    public int getKurang() {
        return kurang;
    }

    public void setKurang(int kurang) {
        this.kurang = kurang;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
