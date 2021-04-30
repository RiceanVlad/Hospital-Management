/**
 * Clasa Pacienti, contine datele despre pacientii din spital
 * 
 */

public class Pacient {
	/**
	 * @param cnp, reprezinta CNP-ul pacientului (este unic)
	 * @param nume, reprezinta numele pacientului
	 * @param prenume, reprezinta prenumele pacientului
	 * @param abonament, are valoarea 1 daca pacientul are abonament, sau 0 in caz contrar
	 * @param discount, are valoarea 1 daca pacientul are discount, sau 0 in caz contrar
	 * @param sectno, reprezinta ID-ul sectiei in care este adaugat pacientul (aici nu mai trebuie sa fie unic)
	 */
	private String cnp;
	private String nume;
	private String prenume;
	private int abonament;
	private int discount;
	private int sectno;
	
	public Pacient() {
	}

	public Pacient(String cnp, String nume, String prenume, int abonament, int sectno) {
		super();
		this.cnp = cnp;
		this.nume = nume;
		this.prenume = prenume;
		this.abonament = abonament;
		this.discount = 0;
		this.sectno = sectno;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public int getAbonament() {
		return abonament;
	}

	public void setAbonament(int abonament) {
		this.abonament = abonament;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getSectno() {
		return sectno;
	}

	public void setSectno(int sectno) {
		this.sectno = sectno;
	}


	
	
	
	
	
}
