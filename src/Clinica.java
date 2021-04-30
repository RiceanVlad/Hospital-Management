/**
 * Clasa Clinica, contine numele clincii, ID-ul clinicii si legatura cu sectiile ei
 * 
 */

public class Clinica {
	
	/**
	 * @param clno, reprezinta ID-ul clinicii(nu exista 2 clinici cu acelasi ID)
	 * @param nume, reprezinta numele clinicii
	 * @param spno, reprezinta ID-ul sectiei
	 */
	private int clno;
	private String nume;
	private int spno;
	
	public Clinica() {
	}

	public Clinica(int clno, String nume, int spno) {
		super();
		this.clno = clno;
		this.nume = nume;
		this.spno = spno;
	}

	public int getClno() {
		return clno;
	}

	public void setClno(int clno) {
		this.clno = clno;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public int getSpno() {
		return spno;
	}

	public void setSpno(int spno) {
		this.spno = spno;
	}

	@Override
	public String toString() {
		return "Clinica [clno=" + clno + ", nume=" + nume + ", spno=" + spno + "]";
	}
	
	
}
