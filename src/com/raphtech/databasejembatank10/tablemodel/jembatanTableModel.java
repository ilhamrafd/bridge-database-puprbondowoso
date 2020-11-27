package com.raphtech.databasejembatank10.tablemodel;

import com.raphtech.databasejembatank10.domain.jembatanDomain;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class jembatanTableModel extends AbstractTableModel {

    List<jembatanDomain> listOfData = new ArrayList<>();
    private final String[] header = {"No Ruas","Pangkal-Ujung","Kecamatan","Nama Jembatan", 
        "Jumlah","Panjang","Lebar Jalur","Lebar Total","Bangunan Atas","Bangunan Bawah", 
        "Kondisi","Akses","Koordinat","Gambar 1","Gambar 2"};

    public jembatanTableModel(List<jembatanDomain> listOfData) {
        this.listOfData = listOfData;
    }

    public void delete(int index) {
        listOfData.remove(index);
        fireTableRowsDeleted(index, index);
    }

    public void save(jembatanDomain dom) {
        listOfData.add(dom);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    public jembatanDomain getData(int index) {
        return listOfData.get(index);
    }

    @Override
    public int getRowCount() {
        return listOfData.size();
    }

    @Override
    public int getColumnCount() {
        return 15;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "No Ruas";
            case 1:
                return "Pangkal - Ujung";
            case 2:
                return "Kecamatan";
            case 3:
                return "Nama Jembatan";
            case 4:
                return "Jumlah";
            case 5:
                return "Panjang";
            case 6:
                return "Lebar";
            case 7:
                return "Lebar Total";
            case 8:
                return "Bangunan Atas";
            case 9:
                return "Bangunan Bawah";
            case 10:
                return "Kondisi";
            case 11:
                return "Akses";
            case 12:
                return "Koordinat";
            case 13:
                return "Gambar 1";
            case 14:
                return "Gambar 2";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        jembatanDomain dom = listOfData.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return dom.getNo_ruas();
            case 1:
                return dom.getPangkal_ujung();
            case 2:
                return dom.getId_kec();
            case 3:
                return dom.getNama_jbt();
            case 4:
                return dom.getJml();
            case 5:
                return dom.getUk_panjang();
            case 6:
                return dom.getUk_lebar();
            case 7:
                return dom.getUk_lebartot();
            case 8:
                return dom.getBangun_atas();
            case 9:
                return dom.getBangun_bawah();
            case 10:
                return dom.getId_kondisi();
            case 11:
                return dom.getId_akses();
            case 12:
                return dom.getKoordinat();
            case 13:
                return dom.getImage1();
            case 14:
                return dom.getImage2();
            default:
                return null;
        }
    }

}
