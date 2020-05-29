import java.util.Random;
import java.util.Scanner;

public class Main {

	
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	
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
	
				
			}
			
		} while (pilih != 4);

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
				String nama;
				int harga;
				System.out.print("Masukan nama barang : ");
				nama = scan.nextLine();
				scan.nextLine(); 
				System.out.print("Harga : " + rand.nextInt(100000));
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
