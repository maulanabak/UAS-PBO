/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uasasli;

/**
 *
 * @author Rama2
 */
import java.util.ArrayList;
import java.util.Scanner;

public class ManajemenPenjualanBuku {
    private static double modalAwal = 0;
    private static double modalBerjalan = modalAwal;
    private static ArrayList<Buku> daftarBuku = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int jumlahTerjual;
    
    public static void main(String[] args){
        boolean exit = false;
        
        while(!exit){
            
            System.out.println("**********************************************");
            System.out.println("*           Sistem Penjulan Buku             *");
            System.out.println("*      By: <Maulana Baktiar>, <22201304>     *");
            System.out.println("**********************************************");
            System.out.println("Silahkan pilih menu : ");
            System.out.println("1. Beli Buku");
            System.out.println("2. Jual Buku");
            System.out.println("3. Lihat Stok Buku");
            System.out.println("4. Lihat Laporan Keuangan");
            System.out.println("5. Exit");
            System.out.print("Pilihan : ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); //untuk membersihkan newline di buffer setelah membaca jumlahTerjual
           
            switch (pilihan){
                case 1:
                   tampilkanLaporanModal();
                   break;
                case 2:
                   tampilkanStokBuku();
                   break;
                case 3:
                   penjualan();
                   break;
                case 4:
                   pembelian();
                   break;
                case 5:
                   exit = true;
                   System.out.println("Program Telah Selesai dan Berakhir");
                   break;
                default:
                   System.out.println("Pilihan tidak valid");
                   break;
            }
            System.out.println();
       }
        scanner.close();
    }
    private static void tampilkanLaporanModal(){
        System.out.println("Modal Awal : " + modalAwal);
        System.out.println("Modal Berjalan : " + modalBerjalan); 
    }
    private static void tampilkanStokBuku(){
        if (daftarBuku.isEmpty()){
            System.out.println("Stok buku kosong.");
            return;
        }
        
        System.out.println("=== Stok Buku ===");
        for (Buku buku : daftarBuku){
            if(buku instanceof Majalah){
                Majalah majalah = (Majalah) buku;
                System.out.println("Judul : " + buku.judul + ", Stok" + buku.stok +", Nomor Edisi : " + majalah.getNomorEdisi());
            }else{
                System.out.println("Judul : " + buku.judul + ", Stok" + buku.stok);
            }
        }
    }
    private static void penjualan(){
        if(daftarBuku.isEmpty()){
            System.out.println("Stok buku kosong. Tidak dapat melakukan penjualan.");
            return;
        }
        
        System.out.println("=== Penjualan ===");
        tampilkanStokBuku();
        System.out.println("Masukkan judul buku yang terjual : ");
        String judulBuku = scanner.nextLine();
        System.out.println("Masukkan jumlah buku yang terjual : ");
        int jumlahBuku = scanner.nextInt();
        scanner.nextLine(); //Membersihkan newLine di buffer setelah membaca jumlahTerjual
        
        Buku bukuTerjual = cariBuku(judulBuku);
        if (bukuTerjual == null){
            System.out.println("Buku dengan judul " + judulBuku + " tidak ditemukan.");
            return;
        }
        
        if (bukuTerjual.stok < jumlahTerjual){
            System.out.println("Stok buku tidak mencukupi.");
            return;
        }
        
        bukuTerjual.kurangiStok(jumlahTerjual);
        modalBerjalan += (bukuTerjual.hargaJual - bukuTerjual.hargaBeli) * jumlahTerjual;
        System.out.println("Penjualan berhasil. Modal berjalan: " + modalBerjalan);
    }
     private static void pembelian(){
        System.out.println("=== Pembelian ===");
        System.out.print("Masukkan judul buku yang akan akan diberi : ");
        String judulBuku = scanner.nextLine();
        System.out.print("Masukkan jumlah buku yang akan dibeli : ");
        int jumlahDibeli = scanner.nextInt();
        scanner.nextLine();//Membersihkan newLine di buffer setelah membaca jumlahDibeli
         
        Buku buku = cariBuku(judulBuku);
        if(buku == null){
            System.out.println("Buku dengan judul " +judulBuku +"tidak ditemukan.");
            return;
        }
        
        double totalHarga = buku.hargaBeli * jumlahDibeli;
        if (modalBerjalan < totalHarga){
            System.out.println("Modal berjalan tidak mencukupi unutk melakukan pembelian.");
            return;
        }
        buku.tambahStok(jumlahDibeli);
        modalBerjalan -= totalHarga;
        System.out.println("pembelian berhasil. Modal berjalan : "+ modalBerjalan);
    }
    private static Buku cariBuku(String judul){
        for(Buku buku : daftarBuku){
            if (buku.judul.equalsIgnoreCase(judul)){
                return buku;
            }
        }
        return null;
    }
}
