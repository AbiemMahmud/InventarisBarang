/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventaris.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author admin
 */
public class TabelKelola extends AbstractTableModel{
    List<Kelola> lk;

    public TabelKelola(List<Kelola> lk) {
        this.lk = lk;
    }

    @Override
    public int getRowCount() {
        return lk.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column){
            case 0:
                return lk.get(row).getId_barang();
            case 1:
                return lk.get(row).getId_user();
            case 2:
                return lk.get(row).getKurang();
            case 3:
                return lk.get(row).getTambah();
            case 4:
                return lk.get(row).getTanggal();
            default:
                return null;
        }
    }
    
    
}
