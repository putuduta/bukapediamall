import java.util.Scanner;

public class Main {

	
	Scanner scan = new Scanner(System.in);
	
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
