/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CIAGamester
 */
public class Model_Menu {

    private String kode_menu;
    private String kategori_menu;
    private String nama_menu;
    private Long harga_pokok;
    private Long harga_jual;
    private Integer stok;
    
    public String getKode_menu() {
        return kode_menu;
    }

    /**
     * @param kode_menu the kode_menu to set
     */
    public void setKode_menu(String kode_menu) {
        this.kode_menu = kode_menu;
    }

    /**
     * @return the kategori_menu
     */
    public String getKategori_menu() {
        return kategori_menu;
    }

    /**
     * @param kategori_menu the kategori_menu to set
     */
    public void setKategori_menu(String kategori_menu) {
        this.kategori_menu = kategori_menu;
    }

    /**
     * @return the nama_menu
     */
    public String getNama_menu() {
        return nama_menu;
    }

    /**
     * @param nama_menu the nama_menu to set
     */
    public void setNama_menu(String nama_menu) {
        this.nama_menu = nama_menu;
    }

    /**
     * @return the harga_pokok
     */
    public Long getHarga_pokok() {
        return harga_pokok;
    }

    /**
     * @param harga_pokok the harga_pokok to set
     */
    public void setHarga_pokok(Long harga_pokok) {
        this.harga_pokok = harga_pokok;
    }

    /**
     * @return the harga_jual
     */
    public Long getHarga_jual() {
        return harga_jual;
    }

    /**
     * @param harga_jual the harga_jual to set
     */
    public void setHarga_jual(Long harga_jual) {
        this.harga_jual = harga_jual;
    }
    

    /**
     * @return the stok
     */
    public Integer getStok() {
        return stok;
    }

    /**
     * @param stok the stok to set
     */
    public void setStok(Integer stok) {
        this.stok = stok;
    }
}
