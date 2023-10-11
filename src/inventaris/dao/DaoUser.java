/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventaris.dao;

import static inventaris.koneksi.Koneksi.buatKoneksi;
import inventaris.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class DaoUser {
    
    Connection con;
    
    final String INSERT = "INSERT INTO user (id_user, password, posisi) VALUES (?,?,?)";
    final String UPDATE = "UPDATE user set password=?, posisi=? WHERE id_user=?";
    final String DELETE = "DELETE FROM user WHERE id_user=?";
    final String SELECT = "SELECT * FROM user";
    
    public DaoUser() {
        con = buatKoneksi();
    }

    public void insert(String id, String pass, String pos) {
        try {
            PreparedStatement ps = con.prepareStatement(INSERT);
            ps.setString(1, id);
            ps.setString(2, pass);
            ps.setString(3, pos);
            
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(String id) {
        try {
            PreparedStatement ps = con.prepareStatement(DELETE);
            ps.setString(1, id);
            
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(String id, String pass, String pos) {
        try {
            PreparedStatement ps = con.prepareStatement(UPDATE);
            ps.setString(1, pass);
            ps.setString(2, pos);
            ps.setString(3, id);
            
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<User> getAll() {
        List<User> lu = new ArrayList<User>();
        try {
            PreparedStatement ps = con.prepareStatement(SELECT);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setId_user(rs.getString("id_user"));
                u.setPassword(rs.getString("password"));
                u.setPosisi(rs.getString("posisi"));
                lu.add(u);
            }
        } catch (SQLException e) {
        }
        return lu;
    }
    
    
    
}
