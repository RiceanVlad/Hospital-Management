
/**
 * Clasa Spital, contine numele, localitatea spitalului si un ID
 * 
 */

public class Spital {
	
	/**
	 * @param spno, reprezinta ID-ul spitalului
	 * @param nume, reprezinta numele spitalului
	 * @param loc, reprezinta localitatea spitalului
	 */
	private int spno;
	private String nume;
	private String loc;
	
	public Spital() {
	}

	public Spital(int spno, String nume, String loc) {
		super();
		this.spno = spno;
		this.nume = nume;
		this.loc = loc;
	}

	public int getSpno() {
		return spno;
	}

	public void setSpno(int spno) {
		this.spno = spno;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Spital [spno=" + spno + ", nume=" + nume + ", loc=" + loc + "]";
	}
	
	
}
