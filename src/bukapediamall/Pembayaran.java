package bukapediamall;
import java.util.Scanner;

public class Pembayaran {
	
	Scanner scan = new Scanner(System.in);
	
	public void ovo() {
		String nomor = "";
		
		clearScreen();
		do {
			System.out.print("Masukan no hp : ");
			try {
				nomor = scan.nextLine();
			} catch (Exception e) {
				System.out.println("Input harus angka");
			}
		}while(nomor.length()<=11 || nomor.length()>13 || nomor.charAt(0) != '0' || nomor.charAt(1) != '8');
		scan.nextLine();
		System.out.println("Konfirmasi pembayaran via aplikasi OVO anda");
		scan.nextLine();
		clearScreen();
		System.out.println("Menunggu Konfirmasi...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clearScreen();
		System.out.println("Selamat pembayaran anda berhasil, Terima Kasih telah berbelanja di BUKAPEDIAMALL!");	
		scan.nextLine();
	}
	
	public void text() {
		System.out.println("Pilih Menu pembayaran via Virtual Account");
		scan.nextLine();
		clearScreen();
		System.out.println("Masukkan no berikut ke dalam Virtual Account 234172513243");
		scan.nextLine();
		clearScreen();
		System.out.println("Tekan enter jika telah melakukan pembayaran");
		scan.nextLine();
		System.out.println("Sedang diproses :)");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clearScreen();
		System.out.println("Selamat pembayaran anda berhasil,  Terima Kasih telah berbelanja di BUKAPEDIAMALL!");
		scan.nextLine();
	}
	
	
	public void virtualAccount() {
		
		int pilih;
		
		clearScreen();
		System.out.println("Pilihan bank : ");
		System.out.println("1. BCA");
		System.out.println("2. BRI");
		System.out.println("3. Mandiri");
		System.out.printf(">> ");
		pilih = scan.nextInt();
		scan.nextLine();
		System.out.println("Sedang diproses... harap menunggu beberapa detik :)");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(pilih == 1) {
			text();
			
		}
		else if(pilih == 2) {
			text();
			
		}
		else if(pilih == 3) {
			text();
			
		}
		
	}
	
	public void gopay() {
		String nomor = "";
		
		clearScreen();
		do {
			System.out.print("Masukan no hp : ");
			try {
				nomor = scan.nextLine();
			} catch (Exception e) {
				System.out.println("Input harus angka");
			}
		}while(nomor.length()<=11 || nomor.length()>13 || nomor.charAt(0) != '0' || nomor.charAt(1) != '8');
		System.out.println("Konfirmasi pembayaran via aplikasi Gojek anda");
		scan.nextLine();
		clearScreen();
		System.out.println("Menunggu Konfirmasi...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clearScreen();
		System.out.println("Selamat pembayaran anda berhasil, Terima Kasih telah berbelanja di BUKAPEDIAMALL!");	
		scan.nextLine();
		
	}
	
	//clear screen
	public void clearScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println("");
		}
	}

	public void pembayaran() {
		
		int bayar = 0;
		
		clearScreen();
		System.out.println("Pilih Metode Pembayaran : ");
		System.out.println("1. OVO");
		System.out.println("2. Virtual Account");
		System.out.println("3. Gopay");
		System.out.printf(">> ");
		bayar = scan.nextInt();
		scan.nextLine();
		System.out.println("Sedang diproses... harap menunggu beberapa detik :)");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bayar == 1) {
			ovo();
			clearScreen();
		}
		else if(bayar == 2) {
			virtualAccount();
			clearScreen();
		}
		else if(bayar == 3) {
			gopay();
			clearScreen();
		}
		
	}


}
