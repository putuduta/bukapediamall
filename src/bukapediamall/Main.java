package bukapediamall;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import pembelian.*;
import java.util.Scanner;


public class Main {
	
	Scanner scan = new Scanner(System.in);
	
	//make arrayList object
	List<Pulsa> arrPulsa = new ArrayList<Pulsa>();
	List<Barang> arrBarang = new ArrayList<Barang>();
	
	ArrayList<Customer> arrCustomer = new ArrayList<Customer>();

	
	//total harga pulsa
	public int totalHargaP() {
		int totalHarga = 0;
		for (int i = 0; i < arrPulsa.size(); i++) {
			totalHarga += arrPulsa.get(i).getHarga();
		}
		return totalHarga;
	}
	
	
	public void printPulsa() {
		
		String nHp = "No Hp", hP = "Harga Saldo", no = "No";
		System.out.println("\n     	     Detail Transaksi   \n");
		System.out.println("------------------------------------");
		System.out.printf("| %2s | %12s | %12s |\n", no, nHp, hP);
		System.out.println("------------------------------------");
		
		for (int i = 0; i < arrPulsa.size(); i++) {
			
			Pembelian p = arrPulsa.get(i);
			Pulsa pl = (Pulsa) p;
			
			System.out.printf("| %2d | %12s | %12d |\n", (i+1), pl.getNoHp(), p.getHarga());
	
		}
		System.out.println("------------------------------------");
	}
	
	public void addPulsa() {
		Pulsa pulsa = new Pulsa();
		
		String noHp = " ";
		int saldo = 0, hargaSaldo = 0;				
		int flag=0;
		do {
			System.out.print("Masukan no hp : ");
			
			try {
				noHp = scan.nextLine();
			} catch (Exception e) {
				System.out.println("Input harus angka");
			}
		}while(pulsa.cekNohp(noHp));

		
		 
		System.out.print("Jumlah saldo yang diinginkan: ");
		saldo = scan.nextInt();
		scan.nextLine();
		
		hargaSaldo = pulsa.hargaSaldo(saldo);

		pulsa.setNoHp(noHp);
		pulsa.setHarga(hargaSaldo);
	
		arrPulsa.add(pulsa);
		System.out.print("Sedang kami proses");
		
		while(flag!=3){
			try {
				Thread.sleep(1000);
				flag++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(".");
		}
		clearScreen();
		System.out.print("Sukses Menambah Keranjang!  ");
		scan.nextLine();
		clearScreen();
	}
	
	public void cekPulsabyHarga() {
		
		if (arrPulsa.isEmpty()) {
			System.out.println("List pulsa masih kosong!\n");
		} else {
			//sort by harga
			Collections.sort(arrPulsa);
			printPulsa();
		}
		
		System.out.print("\nLanjut...");
		scan.nextLine();
	}
	
	public void  cekPulsabyNoHp() {
		
		if (arrPulsa.isEmpty()) {
			System.out.print("List pulsa masih kosong!\n");
		} else {
			//Sort by no hp
			Collections.sort(arrPulsa, new Comparator<Pulsa>() {

				@Override
				public int compare(Pulsa arg0, Pulsa arg1) {
					return arg0.getNoHp().compareTo(arg1.getNoHp());
				}

			});
			
			printPulsa();
		}
		

		System.out.print("\nLanjut....");
		scan.nextLine();
	}
	
	// untuk menghapus pulsa didalam keranjang
	public void deletePulsa() {
		int number;
		if(arrPulsa.isEmpty()) {
			System.out.println("\nTidak Ada Isi");
		}
		else {
			cekPulsabyNoHp();
			do {
				System.out.print("Pilih nomor untuk menghapus pembelian pulsa dari keranjang : ");
				number = scan.nextInt();
				scan.nextLine();
			}while(number<1 || number>arrPulsa.size());
			
			arrPulsa.remove(number-1);
			System.out.println("Sedang diproses :)");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("\nPembelian Pulsa Sudah Dihapus dari Keranjang");		
		}
		
		System.out.println("Tekan Enter Untuk Melanjutkan...");
		scan.nextLine();
	}
	


	
	public void checkOutPulsa() {	
		String nama = "";
		
		System.out.print("Tolong masukan nama: ");
		nama = scan.nextLine();
		clearScreen();
		
		
		if(arrPulsa.isEmpty()) {
			System.out.println("Keranjang Kosong, Harap Menambahkan Pulsa Yang Ingin Dibeli Kedalam Keranjang Terlebih Dahulu...");
			scan.nextLine();
		}
		else {
			LocalDate date = LocalDate.now();
			System.out.println("Tanggal Pembelian : " + date);
			printPulsa();
			
			int totalHargaP = totalHargaP();
			String barcode = Customer.barcode();
			
			System.out.println("Total Harga: " + totalHargaP);
			System.out.println("Kode Pembelian : " + barcode + "\n");
			
			System.out.print("Lanjut ke pembayaran...");
			scan.nextLine();
			
			Customer customer = new Customer(nama, totalHargaP, barcode);
			
			arrCustomer.add(customer);

			new Pembayaran().pembayaran();

			arrPulsa.clear();
		}
		

	}
	
	
	//Menu beli pulsa
	public void beliPulsa() {
		
		
		int pilih = 0;
		do {
			System.out.println("1. Add Item");
			System.out.println("2. Lihat Keranjang (berdasarkan harga saldo)");
			System.out.println("3. Lihat Keranjang (berdasarkan no pulsa)");
			System.out.println("4. Hapus Pulsa dari Keranjang");
			System.out.println("5. Checkout");
			System.out.print(">> ");
			pilih = scan.nextInt(); scan.nextLine();
			clearScreen();
			
			if (pilih == 1) {
				addPulsa();
				clearScreen();
			} else if (pilih == 2) {
				cekPulsabyHarga();
				clearScreen();
			} else if (pilih == 3) {
				cekPulsabyNoHp();
				clearScreen();
			}else if(pilih == 4) {
				deletePulsa();
				clearScreen();
			}else if (pilih == 5) {
				checkOutPulsa();
				clearScreen();
			}
			
		} while (pilih != 5);

	}
	
	public int totalHargaB() {
		int totalHarga = 0;
		for (int i = 0; i < arrBarang.size(); i++) {
			Pembelian p = arrBarang.get(i);
			totalHarga += p.getHarga();
		}
		return totalHarga;

	}
	
	public void printBarang() {
		
		String nHp = "Nama", hP = "Harga Barang", no = "No";
		
		System.out.println("\n     Detail Transaksi   \n");
		System.out.println("------------------------------------");
		System.out.printf("| %2s | %12s | %12s |\n", no, nHp, hP);
		System.out.println("------------------------------------");
		for (int i = 0; i < arrBarang.size(); i++) {
			
			Pembelian p = arrBarang.get(i);
			Barang br = (Barang) p;

			System.out.printf("| %2d | %12s | %12d |\n", (i+1), br.getNama(), p.getHarga());

		}
		System.out.println("------------------------------------");
		
	}
	
	
	public void addBarang() {
		
		Barang barang = new Barang();
		
		String nama;
		int harga;
		int count;
		int panjang;
		int flag=0;
		do {
			
			System.out.print("Masukan nama barang : ");
			nama = scan.nextLine();
			
			panjang = 0;
			panjang = nama.length();

			count = (int) barang.cekNama(nama, panjang);
			
		}while(nama.length()<=0 || nama.charAt(0) == ' ' || count!=panjang);
		
		harga = Barang.hargaBarang(nama);
		

		
		barang.setNama(nama);
		barang.setHarga(harga);
		
		arrBarang.add(barang);
		
		System.out.print("Sedang kami proses");
		
		while(flag!=3){
			try {
				Thread.sleep(1000);
				flag++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(".");
		}
		clearScreen();
		System.out.print("Sukses Menambah Barang!  ");
		scan.nextLine();
		clearScreen();
	}
	
	
	//sort by harga
	public void cekBarangbyHarga() {
		
		if (arrBarang.isEmpty()) {
			System.out.println("Tidak ada barang\n");
		} else {
			Collections.sort(arrBarang);
			printBarang();
		}
		
		System.out.print("\nLanjut...");
		scan.nextLine();
	}
	
	public void cekBarangbyNama() {
		
		if (arrBarang.isEmpty()) {
			System.out.println("Tidak ada barang!\n");
		} else {
			//sort by nama
			Collections.sort(arrBarang, new Comparator<Barang>() {

				@Override
				public int compare(Barang arg0, Barang arg1) {
					return arg0.getNama().compareTo(arg1.getNama());
				}

			});
			
			printBarang();
		}

		System.out.print("\nLanjut...");
		scan.nextLine();
	}
	
	public void checkOutBarang() {
		
		String nama = "";
		
		System.out.print("Tolong masukan nama: ");
		nama = scan.nextLine();
		clearScreen();
		
		if(arrBarang.isEmpty()) {
			System.out.println("Keranjang Kosong, Harap Menambahkan Barang Yang Ingin Dibeli Kedalam Keranjang Terlebih Dahulu...");
			scan.nextLine();
		}
		else {
			String alamat = "";
			
			System.out.print("Masukan Alamat Pengiriman: ");
			alamat = scan.nextLine();
			clearScreen();
			
			LocalDate date = LocalDate.now();
			System.out.println("Tanggal Pembelian : " + date);
			printBarang();
			int totalHargaB = totalHargaB();
			String barcode = Customer.barcode();
			
			System.out.println("Total Harga: " + totalHargaB);
			System.out.println("Alamat Pengiriman : " + alamat);
			System.out.println("Kode Pembelian : " + barcode);
			
			System.out.println("");
			System.out.print("Lanjut ke pembayaran...");
			scan.nextLine();
			Customer customer = new Customer(nama, totalHargaB, barcode);
			arrCustomer.add(customer);
			
			new Pembayaran().pembayaran();
			
			arrBarang.clear();

		}

	}
	
	// untuk menghapus  barang didalam keranjang


		public void deleteBarang() {
				int number;
				if(arrBarang.isEmpty()) {
					System.out.println("\nTidak Ada Isi");
				}
				else {
					cekBarangbyHarga();
					do {
						System.out.print("Pilih nomor untuk menghapus pembelian barang dari keranjang : ");
						number = scan.nextInt();
						scan.nextLine();
					}while(number<1 || number>arrBarang.size());
					
					arrBarang.remove(number-1);
					System.out.println("Sedang diproses :)");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("\nBarang Sudah Dihapus Dari Keranjang");		
				}
				
				System.out.println("Tekan Enter Untuk Melanjutkan...");
				scan.nextLine();
			}
	
	//Menu beli barang
	public void beliBarang() {
		
		
		int pilih = 0;
		do {
			clearScreen();
			System.out.println("1. Add Item");
			System.out.println("2. Lihat Keranjang (berdasarkan harga)");
			System.out.println("3. Lihat Keranjang (berdasarkan nama item)");
			System.out.println("4. Hapus Barang dari Keranjang");
			System.out.println("5. Checkout");
			System.out.print(">> ");
			pilih = scan.nextInt(); scan.nextLine();
			
			if (pilih == 1) {
				clearScreen();
				addBarang();
			} else if (pilih == 2) {
				clearScreen();
				cekBarangbyHarga();
			} else if (pilih == 3) {
				clearScreen();
				cekBarangbyNama();
			} else if(pilih == 4) {
				clearScreen();
				deleteBarang();
			}else if (pilih == 5) {
				clearScreen();
				checkOutBarang();				
			}
			
			
		} while (pilih != 5);
		
	}
	
	//clear screen
	public void clearScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println("");
		}
	}
	
	public void title() {
		int flag=0;
		String [] judul = new String[6];
		judul[0]=" __________       __                            .___.__                      .__  .__   ";
		judul[1]=" \\______   \\__ __|  | ______  ______   ____   __| _/|__|____    _____ _____  |  | |  |  ";
		judul[2]="  |    |  _/  |  \\  |/ |__  \\ \\____ \\_/ __ \\ / __ | |  \\__  \\  /     \\__   \\ |  | |  |  ";
		judul[3]="  |    |   \\  |  /    < / __ \\|  |_> >  ___// /_/ | |  |/ __ \\|  Y Y  \\/ __ \\|  |_|  |__  ";
		judul[4]="  |______  /____/|__|_ (____  /   __/ \\___  >____ | |__(____  /__|_|  (____  /____/____/  ";
		judul[5]="         \\/           \\/    \\/|__|        \\/     \\/         \\/      \\/     \\/        ";
		while(flag!=6){
			System.out.println(judul[flag]);
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			flag++;
			
		}
		System.out.print("\n\nPress Enter to continue... ");
		scan.hasNextLine();
	}
	
	public Main() {
		clearScreen();
		title();
		clearScreen();
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
			
			if (pilih == 1) {
				beliPulsa();
				clearScreen();
			} else if (pilih == 2) {
				beliBarang();
				clearScreen();
			} else if (pilih == 3) {
				System.out.print("Terima kasih sudah menggunakan Bukapediamall!!");
				System.out.println("");
			}
			
		} while (pilih != 3);
		
	}

	public static void main(String[] args) {
		new Main();
	}
}
