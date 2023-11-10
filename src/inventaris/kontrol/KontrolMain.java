/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventaris.kontrol;

import inventaris.view.InventarisFrame;
import inventaris.view.LoginFrame;
import inventaris.view.MainFrame;
import inventaris.view.MasukanInv;

/**
 *
 * @author admin
 */
public class KontrolMain {
    MainFrame mf;
    
    public KontrolMain (MainFrame fr) {
        this.mf = fr;
    }
    
    public void tampilLogin () {
        LoginFrame lf = new LoginFrame();
        mf.getDesk().add(lf);
    }
    
    public void tampilInv () {
        InventarisFrame f = new InventarisFrame();
        f.setVisible(true);
        mf.getDesk().add(f);
    }
    
    public void tampilMasukInv () {
        MasukanInv f = new MasukanInv();
        f.setVisible(true);
        mf.getDesk().add(f);
    }
}
