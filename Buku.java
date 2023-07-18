/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uasasli;

/**
 *
 * @author Rama2
 */
//kelas buku adalah kelas parent
class Buku { 
    String judul;
    double hargaBeli;
    double hargaJual;
    int stok;
    
    //konstruktor
    public Buku(String judul, double hargaBeli, double hargaJual, int stok){
        this.judul = judul;
        this.hargaBeli = hargaBeli;
        this.hargaJual = hargaJual;
        this.stok = stok;
    }
    public void tambahStok(int jumlah){
        stok += jumlah;
    }
    public void kurangiStok(int jumlah){
        stok -= jumlah;
        if (stok <= 0){
            System.out.println("Stok Buku"+ judul + "Telah mencapai 0");
        }
    }  
}
