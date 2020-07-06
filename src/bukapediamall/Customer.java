package bukapediamall;
import java.util.Random;

public class Customer {
	
	static Random rand = new Random();
	
	private String nama;
	private int totalHarga;
	private String barcode;

	String getNama() {
		return nama;
	}

	void setNama(String nama) {
		this.nama = nama;
	}

	int getTotalHarga() {
		return totalHarga;
	}

	void setTotalHarga(int totalHarga) {
		this.totalHarga = totalHarga;
	}

	String getBarcode() {
		return barcode;
	}

	void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	
	//random char
	public static String getRandom() {

        return String.valueOf((char)(rand.nextInt(26)+'a'));
	}
	
	//barcode atau kode pembelian
	public static String barcode() {
		String barcode = "";
		for (int i = 0; i < 7; i++) {
			barcode += getRandom();
		}
		return barcode;
	}

	public Customer(String nama, int totalHarga, String barcode) {
		super();
		this.nama = nama;
		this.totalHarga = totalHarga;
		this.barcode = barcode;
	}

}
