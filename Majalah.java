/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uasasli;

/**
 *
 * @author Rama2
 */
class Majalah extends Buku {
    private int nomorEdisi;
            
    public Majalah(String judul, double hargaBeli, double hargaJual, int stok, int nomorEdisi) {
        super(judul, hargaBeli, hargaJual, stok);
        this.nomorEdisi = nomorEdisi;
    }
    public int getNomorEdisi(){
        return nomorEdisi;
    }
}
