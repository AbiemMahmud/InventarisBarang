/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventaris.model;

import java.util.List;
import javafx.beans.binding.Bindings;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author admin
 */
public class TabelBarang extends AbstractTableModel{
    List<Barang> lb;

    public TabelBarang (List lb) {
        this.lb = lb;
    }
    @Override
    public int getRowCount() {
        return lb.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column){
            case 0:
                return lb.get(row).getId_barang();
            case 1:
                return lb.get(row).getNama_barang();
            case 2:
                return lb.get(row).getHarga_barang();
            case 3:
                return lb.get(row).getJumlah_barang();
            case 4:
                return lb.get(row).getId_kategori();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nama";
            case 2:
                return "Jumlah";
            case 3:
                return "Harga";
            case 4:
                return "Kategori";
            default:
                return null;
        }
    }
}
