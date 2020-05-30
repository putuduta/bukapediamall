import java.util.ArrayList;
import java.util.Random;
import pembelian.*;
import java.util.Scanner;


public class Main {
	
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	
	//make arrayList object
	ArrayList<Pembelian> arrPulsa = new ArrayList<Pembelian>();
	ArrayList<Pembelian> arrBarang = new ArrayList<Pembelian>();
	
	int ma = 0;
	
	public void addPulsa() {
		Pulsa pulsa = new Pulsa();
		
		int noHp = 0, saldo = 0, hargaSaldo = 0;				

		System.out.print("Masukan no hp : ");
		noHp = scan.nextInt();
		try {

		} catch (Exception e) {
			System.out.println("Input harus angka");
		}
		 
		System.out.print("Jumlah saldo yang diinginkan: ");
		saldo = scan.nextInt();
		
		hargaSaldo = saldo + (saldo * 10/100);
		System.out.println("Harga saldo adalah: " + hargaSaldo);
			
		pulsa.setNoHp(noHp);
		pulsa.setHarga(hargaSaldo);
	
		arrPulsa.add(pulsa);
	}
	
	public void cekPulsabyHarga() {

		
		for (int i = 0; i < arrPulsa.size(); i++) {
			Pembelian p = arrPulsa.get(i);
			System.out.println(p.getHarga());
			Pulsa pl = (Pulsa) p;
			System.out.println(pl.getNoHp());
		}
	}
	
	//Menu beli pulsa
	public void beliPulsa() {
		
		
		int pilih = 0;
		do {
			System.out.println("1. Add Item");
			System.out.println("2. Lihat Keranjang (berdasarkan harga)");
			System.out.println("3. Lihat Keranjang (berdasarkan nama item)");
			System.out.println("4. Checkout");
			System.out.print(">> ");
			pilih = scan.nextInt();
			clearScreen();
			
			if(pilih == 1) {
				addPulsa();
				
			} else if (pilih == 2) {
				cekPulsabyHarga();
			}
			
		} while (pilih != 4);

	}
	
	public void addBarang() {
		
		Barang barang = new Barang();
		
		String nama;
		int harga;
		System.out.print("Masukan nama barang : ");
		nama = scan.nextLine();
		scan.nextLine();
		harga = rand.nextInt(100000);
		System.out.print("Harga : " + harga);
		System.out.println("");
		
		barang.setNama(nama);
		barang.setHarga(harga);
		
		arrBarang.add(barang);
	}
	
	public void cekBarangbyHarga() {
				
		for (int i = 0; i < arrBarang.size(); i++) {
			Pembelian p = arrBarang.get(i);
			System.out.println(p.getHarga());
			Barang br = (Barang) p;
			System.out.println(br.getNama());
		}
	}
	
	
	//Menu beli barang
	public void beliBarang() {
		
		
		int pilih = 0;
		do {
			System.out.println("1. Add Item");
			System.out.println("2. Lihat Keranjang (berdasarkan harga)");
			System.out.println("3. Lihat Keranjang (berdasarkan nama item)");
			System.out.println("4. Checkout");
			System.out.print(">> ");
			pilih = scan.nextInt();
			clearScreen();
			
			if(pilih == 1) {
				addBarang();
			} else if(pilih == 2) {
				cekBarangbyHarga();
			}
			
			
		} while (pilih != 4);
		
	}
	
	public void clearScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println("");
		}
	}
	
	public Main() {
		
		System.out.println(" Bukapediamal");
		System.out.println("--------------");
		
		int pilih = 0;
		do {
			
			System.out.println("1. Beli Pulsa");
			System.out.println("2. Beli Barang");
			System.out.println("3. Exit");
			System.out.print(">> ");
			pilih = scan.nextInt();
			
			clearScreen();
			
			if(pilih == 1) {
				beliPulsa();
				clearScreen();
			} else if(pilih == 2) {
				beliBarang();
				clearScreen();
			} else {
				System.out.println("Terima kasih sudah menggunakan Bukapediamall!!");
				System.out.println("");
			}
			
		} while (pilih != 3);
		
	}

	public static void main(String[] args) {
		new Main();
	}
}
