
/**
 * Clasa DataIE, continte internarile si externarile unui pacient al carui CNP il stim
 * 
 */
public class DataIE {
	/**
	 * @param cnp reprezinta CNP-ul pacientului (pot exista mai multe internari si externari pentru acelasi CNP)
	 * @param datai, reprezinta data de internare in spital
	 * @param datae, reprezinta data de externare din spital
	 */
	private int cnp;
	private String datai;
	private String datae;
	
	public DataIE() {
	}

	public DataIE(int cnp, String datai, String datae) {
		super();
		this.cnp = cnp;
		this.datai = datai;
		this.datae = datae;
	}

	public int getCnp() {
		return cnp;
	}

	public void setCnp(int cnp) {
		this.cnp = cnp;
	}

	public String getDatai() {
		return datai;
	}

	public void setDatai(String datai) {
		this.datai = datai;
	}

	public String getDatae() {
		return datae;
	}

	public void setDatae(String datae) {
		this.datae = datae;
	}

	@Override
	public String toString() {
		return "DataIE [cnp=" + cnp + ", datai=" + datai + ", datae=" + datae + "]";
	}
	
	
}
