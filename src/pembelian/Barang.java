package pembelian;

import java.util.Random;

public class Barang extends Pembelian{
	static Random rand = new Random();
	

	private String nama;
	
	
	public String getNama() {
		return nama;
	}
	
	public void setNama(String nama) {
		this.nama = nama;
	}
	

	public static int hargaBarang(String nama) {
		int harga = rand.nextInt(100000);
		harga(harga);
		return harga;
	}
	
	public static void harga(int hargaBarang) {
		System.out.print("Harga : " + hargaBarang + "\n");
	}
		
	public int cekNama(String nama, int panjang) {
		int i = 0, count = 0;
		while(i!=panjang) {
			if(nama.charAt(i) >= 'a' && nama.charAt(i) <= 'z' || nama.charAt(i) >= 'A' && nama.charAt(i) <= 'Z' || nama.charAt(i) == ' ' || nama.charAt(i) >='0' && nama.charAt(i) <= '9') {
				count++;
			}
			i++;
		}
		return count;
	}
	
}
