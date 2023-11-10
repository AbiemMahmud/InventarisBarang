/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventaris.kontrol;

import inventaris.dao.DaoBarang;
import inventaris.model.ModelCombo;
import inventaris.view.MasukanInv;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class KontrolMasukanInv {
    MasukanInv fr;
    DaoBarang db;

    public KontrolMasukanInv(MasukanInv fr) {
        this.fr = fr;
        db = new DaoBarang();
    }
    
    public void tampilKombo () {
        ModelCombo md = new ModelCombo();
        fr.getKateCombo().setModel(md);
    }
    
    public void inputBarang() throws NumberFormatException, SQLException{
        String id, nama, kate;
        int jumlah, harga;
        
        id = fr.getIdTF().getText();
        nama = fr.getNamaTF().getText();
        kate = (String) fr.getKateCombo().getSelectedItem();
        jumlah = Integer.parseInt(fr.getJumlahTF().getText());
        harga = Integer.parseInt(fr.getHargaTF().getText());
        
        kate = db.getKate(kate);
        
        db.insertBarang(id, nama, jumlah, harga, kate);
    }
    
}
