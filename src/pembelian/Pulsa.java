package pembelian;

public class Pulsa extends Pembelian {

	private String noHp;
	
	public String getNoHp() {
		return noHp;
	}

	public void setNoHp(String noHp) {
		this.noHp = noHp;
	}
	
	public int hargaSaldo(int saldo) {
		int harga = saldo + (saldo * 10/100);
		harga(harga);
		return harga;
	}
	
	public void harga(int saldo) {
		System.out.println("Harga saldo adalah: " + saldo);
	}
	

	public boolean cekNohp(String noHp) {
		if (noHp.length()<=11 || noHp.length()>13 || noHp.charAt(0) != '0' || noHp.charAt(1) != '8') {
			return true;
		} else {
			return false;
		}
	}

}
