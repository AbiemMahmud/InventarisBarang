/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventaris.kontrol;

import inventaris.dao.DaoUser;
import inventaris.model.User;
import inventaris.view.LoginFrame2;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class KontrolLogin {
    LoginFrame2 lf;
    DaoUser du;
    
    public KontrolLogin(LoginFrame2 lf) {
        this.lf = lf;
        du = new DaoUser();
    }
    
    public void cekLogin() throws Throwable {
        String username = lf.getUserTF().getText();
        char[] pass = lf.getPwTF().getPassword();
        String c_username; char[] c_pass;
        List<User> lu = du.getAll();
        int i;
        
//        Cek username
        for (i=0;i<lu.size();i++){
            c_username = lu.get(i).getId_user();
            c_pass = lu.get(i).getPassword().toCharArray();
            if (username.equals(c_username)) {
                if (Arrays.equals(pass, c_pass)){
                    JOptionPane.showMessageDialog(null, "Login Berhasil!");
                    lf.dispose();
                    throw new Throwable();
                } else {
                    JOptionPane.showMessageDialog(null, "Login Gagal!\nUsername atau Password Salah");
                }
                return;
            }
        }
        
        JOptionPane.showMessageDialog(null, "Login Gagal!\nUsername atau Password Salah");
    }
}
