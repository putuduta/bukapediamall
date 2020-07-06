package pembelian;

public abstract class Pembelian implements Comparable<Pembelian> {

	private Integer harga;
	
	public int getHarga() {
		return harga;
	}

	public void setHarga(int harga) {
		this.harga = harga;
	}
	
	 @Override
	public int compareTo(Pembelian compareHarga) {
		int compareQuantity = ((Pembelian) compareHarga).getHarga();

		//ascending order
		return this.harga - compareQuantity;
	}
}

