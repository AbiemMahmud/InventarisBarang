/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventaris.koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class Koneksi {
    public static Connection buatKoneksi() {
        Connection con = null;
//        Template untuk tabel dan skema database berada di file TabelDatabase.sql
        try {
//            Buat tabel dengan nama java terlebih dahulu
            String url = "jdbc:mysql://localhost:3306/java";
            
//            Masukkan informasi sesuai username dan password database
            String user = "root";
            String pass = "root";
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
}
