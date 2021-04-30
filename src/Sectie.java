/**
 * Clasa Sectie, contine informatii despre o sectie si legatura cu clinica
 * 
 */
public class Sectie {
	/**
	 * @param sectno, reprezinta ID-ul sectiei (nu exista 2 sectii cu acelasi ID)
	 * @param locuri, reprezinta numarul efectiv de locuri din sectie
	 * @param locuriOcupate, reprezinta numarul de locuri ocupate din sectie
	 * @param tip, reprezinta tipul sectiei
	 * @param clno, reprezinta ID-ul clinicii(pot exista mai multe sectii in aceeasi clinica)
	 */
	private int sectno;
	private int locuri;
	private int locuriOcupate;
	private String tip;
	private int clno;
	
	public Sectie() {
	}

	public Sectie(int sectno, int locuri, String tip, int clno) {
		super();
		this.sectno = sectno;
		this.locuri = locuri;
		this.locuriOcupate = 0;
		this.tip = tip;
		this.clno = clno;
	}

	public int getSectno() {
		return sectno;
	}

	public void setSectno(int sectno) {
		this.sectno = sectno;
	}

	public int getLocuri() {
		return locuri;
	}

	public void setLocuri(int locuri) {
		this.locuri = locuri;
	}

	public int getLocuriOcupate() {
		return locuriOcupate;
	}

	public void setLocuriOcupate(int locuriOcupate) {
		this.locuriOcupate = locuriOcupate;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public int getClno() {
		return clno;
	}

	public void setClno(int clno) {
		this.clno = clno;
	}

	@Override
	public String toString() {
		return "Sectie [sectno=" + sectno + ", locuri=" + locuri + ", locuriOcupate=" + locuriOcupate + ", tip=" + tip
				+ ", clno=" + clno + "]";
	}

	
	
	 
}
