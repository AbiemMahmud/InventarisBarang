/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventaris.kontrol;

import inventaris.dao.DaoBarang;
import inventaris.model.Barang;
import inventaris.model.TabelBarang;
import inventaris.view.InventarisFrame;
import java.util.List;

/**
 *
 * @author admin
 */
public class KontrolInventaris {
    InventarisFrame f;
    DaoBarang db;
    List<Barang> lb;
    
    public KontrolInventaris(InventarisFrame f) {
        this.f = f;
        db = new DaoBarang();
    }
    
    public void isiTabel() {
        lb = db.getAll();
        TabelBarang tb = new TabelBarang(lb);
        f.getTabelInv().setModel(tb);
    }
    
    public void isiTabelFilter() {
        String sel = f.getKategoriCB().getSelectedItem().toString();
        lb = db.getBarangKate(sel);
        TabelBarang tb = new TabelBarang(lb);
        f.getTabelInv().setModel(tb);
    }
}
