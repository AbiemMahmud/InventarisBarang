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
        try {
            String url = "jdbc:mysql://localhost:3306/java?user=root&password=root";
            con = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
    
    public static void main(String[] args) {
        Connection cn = buatKoneksi();
    }
}
