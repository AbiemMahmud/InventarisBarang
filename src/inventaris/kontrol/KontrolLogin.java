/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventaris.kontrol;

import inventaris.dao.DaoUser;
import inventaris.model.User;
import inventaris.view.LoginFrame;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class KontrolLogin {
    LoginFrame lf;
    DaoUser du;
    
    public KontrolLogin(LoginFrame lf) {
        this.lf = lf;
        du = new DaoUser();
    }
    
    public void cekLogin() {
        String username = lf.getUserId().getText();
        char[] pass = lf.getPass().getPassword();
        String c_username; char[] c_pass;
        List<User> lu = du.getAll();
        int i;
        
//        Cek username
        for (i=0;i<lu.size();i++){
            c_username = lu.get(i).getId_user();
            c_pass = lu.get(i).getPassword().toCharArray();
            if (username.equals(c_username)) {
                if (Arrays.equals(pass, c_pass)){
                    JOptionPane.showMessageDialog(null, "Login Sukses!");
                    lf.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Password Salah!!");
                }
                return;
            } else {
                continue;
            }
        }
        
        JOptionPane.showMessageDialog(null, "Login Gagal!");
        
        
    }
}
