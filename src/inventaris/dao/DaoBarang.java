/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventaris.dao;

import inventaris.koneksi.Koneksi;
import inventaris.model.Barang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author admin
 */
/**
 * Dao barang berguna untuk menampilkan barang
* 
*/
public class DaoBarang {
    Connection con;
    
    final String INSERT = "INSERT INTO barang (id_barang, nama_barang, jumlah_barang,"
            + "harga_barang, id_kategori) VALUES (?,?,?,?,?)";
    final String UPDATE = "UPDATE barang set nama_barang=?, jumlah_barang=? WHERE id_barang=?";
    final String DELETE = "DELETE FROM barang WHERE id_barang=?";
    final String SELECT = "SELECT b.id_barang,b.nama_barang,b.jumlah_barang,b.harga_barang,k.nama_kategori"
            + " FROM barang AS b LEFT JOIN kategori AS k ON b.id_kategori=k.id_kategori";
    final String GETKATEID = "SELECT id_kategori FROM kategori WHERE nama_kategori=?";
    
    public DaoBarang () {
        con = Koneksi.buatKoneksi();
    }
    
    public List<Barang> getAll() {
        List<Barang> lb = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(SELECT);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Barang b = new Barang();
                b.setId_barang(rs.getString("id_barang"));
                b.setNama_barang(rs.getString("nama_barang"));
                b.setJumlah_barang(rs.getInt("jumlah_barang"));
                b.setHarga_barang(rs.getInt("harga_barang"));
                b.setId_kategori(rs.getString("nama_kategori"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lb;
    }
    
    public void insertBarang (String id, String nama, int jumlah, int harga, String kate) throws SQLException {
        PreparedStatement ps = con.prepareStatement(INSERT);
        ps.setString(1, id);
        ps.setString(2, nama);
        ps.setInt(3, jumlah);
        ps.setInt(4, harga);
        ps.setString(5, kate);
        
        ps.execute();
    }
    
    public String getKate(String nama) throws SQLException {
        String id = "0";
    
        PreparedStatement ps = con.prepareStatement(GETKATEID);
        ps.setString(1, nama);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            id = rs.getString(1);
        }
        
        return id;
    }
}
