import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Clasa Test contine 3 liste(clinici, sectii, pacienti) si functii care extrag data din baza de date si care adauga pacienti/sectii/clinici
 * si care afiseaza informatii despre spital
 * @author Vlad
 * @version 1.01
 * 
 */

public class Test {
	/**
	 * @param pacienti, contine o lista de obiecte de tip Pacient	
	 * @param sectii, contine o lista de obiecte de tip Sectie	
	 * @param clinici, contine o lista de obiecte de tip Clinica
	 */
	protected static List<Pacient> pacienti = new ArrayList<Pacient>();
	protected static List<Sectie> sectii = new ArrayList<Sectie>();
	protected static List<Clinica> clinici = new ArrayList<Clinica>();

	
	public static void main(String[] args) {
		extragePacienti();
		extrageSectii();
		extrageClinici();
		Meniu nw = new Meniu();
		nw.fereastraMeniu();
	}
	
	/**
	 * functia addDiscount() adauga discount tuturor pacientilor care au cel putin 2 vizite in anul curent la spital
	 */
	public static void addDiscount() {
		try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd","vlad","vlad4567");
            Statement comanda = myConn.createStatement();
            comanda.executeUpdate("UPDATE bd.pacient SET discount=0");
	    }
	    catch (Exception exc) {
	       exc.printStackTrace();
	       System.exit(1);
	    }
		
		for(Pacient pacient : pacienti) {
			try {
				int cnt=0;
	            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd","vlad","vlad4567");
	            Statement comanda = myConn.createStatement();
	            
	            ResultSet rs = comanda.executeQuery("SELECT COUNT(*) as count "
	            		+ "FROM bd.dataie dataie "
	            		+ "inner join bd.pacient pacient ON pacient.cnp=dataie.cnp "
	            		+ "where dataie.datai>='2020-01-01' and dataie.cnp='"+pacient.getCnp()+"'");
	            if(rs.next()) {
	            	cnt=rs.getInt("count");
	            }
	            if(cnt>=2) {
	            	comanda.executeUpdate("UPDATE bd.pacient SET discount=1 where bd.pacient.cnp='"+pacient.getCnp()+"'");
	            }
		    }
		    catch (Exception exc) {
		       exc.printStackTrace();
		       System.exit(1);
		    }
		}
	}
	
	/**
	 * functia internariExternari() returneaza informatiile despre un spital (clinicile pe care le contine, si pentru fiecare clinica afiseaza cate femei 
	 * si barbati sunt internati in sectii, in ziua curenta)
	 * @return
	 */
	public static String internariExternari() {
		StringBuilder sb = new StringBuilder();
		for(Clinica clinica : clinici) {
			sb.append("Clinica "+clinica.getNume()+"\n");
			for(Sectie sectie : sectii) {
				if(sectie.getClno()==clinica.getClno()) {
					sb.append(" Sectia "+sectie.getSectno()+"\n");
					int cnt=0;
					try {
						//barbati internati
			            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd","vlad","vlad4567");
			            Statement comanda = myConn.createStatement();
			            ResultSet rs = comanda.executeQuery("SELECT COUNT(*) as count  "
			            		+ "FROM bd.dataie dataie "
			            		+ "inner join bd.pacient pacient ON pacient.cnp=dataie.cnp "
			            		+ "inner join bd.sectie sectie ON sectie.sectno=pacient.sectno "
			            		+ "inner join bd.clinica clinica ON clinica.clno=sectie.clno "
			            		+ "where sectie.sectno="+ sectie.getSectno() +" and clinica.clno="+ clinica.getClno() +" and str_to_date(curdate(),'%Y-%m-%d')=dataie.datai and pacient.cnp like '1%'");
			            if(rs.next()) {
			            	cnt = rs.getInt("count");
			            }
			            //barbati externati
			            	ResultSet rs1 = comanda.executeQuery("SELECT COUNT(*) as count  "
				            		+ "FROM bd.dataie dataie "
				            		+ "inner join bd.pacient pacient ON pacient.cnp=dataie.cnp "
				            		+ "inner join bd.sectie sectie ON sectie.sectno=pacient.sectno "
				            		+ "inner join bd.clinica clinica ON clinica.clno=sectie.clno "
				            		+ "where sectie.sectno="+ sectie.getSectno() +" and clinica.clno="+ clinica.getClno() +" and str_to_date(curdate(),'%Y-%m-%d')=dataie.datae and pacient.cnp like '1%'");
				            if(rs1.next()) {
				            	cnt += rs1.getInt("count");
				            	sb.append("  Barbati internati/externati: "+cnt+"\n");
				            }
			            //
			            //femei internate
			            cnt=0;
			            ResultSet rs0 = comanda.executeQuery("SELECT COUNT(*) as count "
			            		+ "FROM bd.dataie dataie "
			            		+ "inner join bd.pacient pacient ON pacient.cnp=dataie.cnp "
			            		+ "inner join bd.sectie sectie ON sectie.sectno=pacient.sectno "
			            		+ "inner join bd.clinica clinica ON clinica.clno=sectie.clno "
			            		+ "where sectie.sectno="+ sectie.getSectno() + " and clinica.clno="+ clinica.getClno() +" and str_to_date(curdate(),'%Y-%m-%d')=dataie.datai and pacient.cnp like '2%'");
			            if(rs0.next()) {
			            	cnt = rs0.getInt("count");
			 
			            }
			            //femei externate
			            ResultSet rs2 = comanda.executeQuery("SELECT COUNT(*) as count "
			            		+ "FROM bd.dataie dataie "
			            		+ "inner join bd.pacient pacient ON pacient.cnp=dataie.cnp "
			            		+ "inner join bd.sectie sectie ON sectie.sectno=pacient.sectno "
			            		+ "inner join bd.clinica clinica ON clinica.clno=sectie.clno "
			            		+ "where sectie.sectno="+ sectie.getSectno() + " and clinica.clno="+ clinica.getClno() +" and str_to_date(curdate(),'%Y-%m-%d')=dataie.datae and pacient.cnp like '2%'");
			            if(rs2.next()) {
			            	cnt += rs2.getInt("count");
			            	sb.append("  Femei internate/externate: "+cnt+"\n");
			            }
			            //
			            
				    }
				    catch (Exception exc) {
				       exc.printStackTrace();
				       System.exit(1);
				    }
				}//if sectie.clno=clinica.clno
				
			}
			sb.append("----------------------------------------"+"\n");
		}
		return sb.toString();
	}
	
	/**
	 * functia addPacientiInSectii returneaza pentru o clinica data, gradul de ocupare al fiecarei sectii
	 * @param c clinica
	 * @return
	 */
	public static String addPacientiInSectii(Clinica c) {
		try {
			StringBuilder sb = new StringBuilder();
	        sb.append("UPDATE bd.sectie SET locuriOcupate=0");
			
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd","vlad","vlad4567");
            Statement comanda = myConn.createStatement();
            comanda.executeUpdate(sb.toString());
            
            StringBuilder sbAdd = new StringBuilder();
            ResultSet rs0 = comanda.executeQuery("SELECT COUNT(*) as count "
            		+ "FROM bd.sectie "
            		+ "WHERE bd.sectie.clno="+c.getClno());
            if(rs0.next()) {
            	sbAdd.append("Clinica " + c.getNume()+" are "+rs0.getInt("count") + " sectii"+"\n");
            }
            
            for(Sectie sectie : sectii) {
            	if(c.getClno()==sectie.getClno()) {
            		
	            	sbAdd.append(" Sectia " + sectie.getSectno()+"\n");
	            	StringBuilder sbQ = new StringBuilder();
	            	sbQ.append("SELECT COUNT(*) as count "
	            			+ "from bd.dataie dataie "
	            			+ "inner join bd.pacient pacient ON dataie.cnp=pacient.cnp "
	            			+ "inner join bd.sectie sectie ON sectie.sectno=pacient.sectno "
	            			+ "inner join bd.clinica clinica ON clinica.clno=sectie.clno "
	            			+ "where str_to_date(curdate(),'%Y-%m-%d')=dataie.datai and sectie.sectno="+ sectie.getSectno() +" and sectie.clno="+c.getClno());
	            	ResultSet rs = comanda.executeQuery(sbQ.toString());
	            	int cnt=0;
	            	if(rs.next()) {
	            		cnt=rs.getInt("count");
	            		sbAdd.append("  "+cnt+"/"+sectie.getLocuri()+" locuri ocupate"+"\n");
	            	}
	            	comanda.executeUpdate("UPDATE bd.sectie SET locuriOcupate="+cnt);
            	}
            }
            return sbAdd.toString();
            
	    }
	    catch (Exception exc) {
	       exc.printStackTrace();
	       System.exit(1);
	    }
		return null;
	}
	
	
	/**
	 * functia addPacient adaugau un pacient in sectie
	 * @param p pacientul ce urmeaza sa fie adaugat
	 */
	public static void addPacient(Pacient p) {
		try {
			StringBuilder sb = new StringBuilder();
	        sb.append("INSERT INTO bd.pacient(cnp,nume,prenume,abonament,discount,sectno) "
	        		+ "values('"+p.getCnp()+"','"+  p.getNume()  +"','"+ p.getPrenume()  +"','"+ p.getAbonament() +"',"+ "0"  +",'"+ p.getSectno() + "')");
			
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd","vlad","vlad4567");
            Statement comanda = myConn.createStatement();
            comanda.executeUpdate(sb.toString());
            pacienti.add(p);
	    }
	    catch (Exception exc) {
	       exc.printStackTrace();
	       System.exit(1);
	    }
	}
	
	/**
	 * functia adauga pentru un CNP dat, intarea si externarea din spital
	 * @param cnp CNP pacient
	 * @param datai data de internare in spital
	 * @param datae data de externare din spital
	 */
	public static void addDataIE(String cnp, String datai, String datae) {
		try {
			StringBuilder sb = new StringBuilder();
	        sb.append("INSERT INTO bd.dataie(cnp,datai,datae) "
	        		+ "values('"+cnp+"','"+  datai  +"','"+ datae + "')");
			
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd","vlad","vlad4567");
            Statement comanda = myConn.createStatement();
            comanda.executeUpdate(sb.toString());
            
	    }
	    catch (Exception exc) {
	       exc.printStackTrace();
	       System.exit(1);
	    }
	}
	
	/**
	 * fucntia addSectie adauga o sectie in clinica
	 * @param s sectia ce urmeaza sa fie adaugata
	 */
	public static void addSectie(Sectie s) {
		try {
			StringBuilder sb = new StringBuilder();
	        sb.append("INSERT INTO bd.sectie(sectno,locuri,locuriOcupate,tip,clno) "
	        		+ "values('"+ s.getSectno() +"','"+  s.getLocuri()+ "',0"  +",'"+ s.getTip() + "','"+ s.getClno() + "')");
			
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd","vlad","vlad4567");
            Statement comanda = myConn.createStatement();
            comanda.executeUpdate(sb.toString());
            sectii.add(s);
	    }
	    catch (Exception exc) {
	       exc.printStackTrace();
	       System.exit(1);
	    }
	}
	
	/**
	 * functia addClinica adauga o noua clinica in spital
	 * @param c clinica ce urmeaza sa fie adaugata
	 */
	public static void addClinica(Clinica c) {
		try {
			StringBuilder sb = new StringBuilder();
	        sb.append("INSERT INTO bd.clinica(clno,nume,spno) "
	        		+ "values('"+ c.getClno() +"','"+ c.getNume() +"','"+ c.getSpno() + "')");
			
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd","vlad","vlad4567");
            Statement comanda = myConn.createStatement();
            comanda.executeUpdate(sb.toString());
            clinici.add(c);
	    }
	    catch (Exception exc) {
	       exc.printStackTrace();
	       System.exit(1);
	    }
	}
	
	/**
	 * functia extragePacienti() extrage pacientii din baza de date, si ii adauga in lista de pacienti
	 */
	public static void extragePacienti() {
        StringBuilder sbPacient=new StringBuilder();
        sbPacient.append("SELECT * FROM bd.pacient");
        try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd","vlad","vlad4567");
            Statement comanda = myConn.createStatement();
            ResultSet rez=comanda.executeQuery(sbPacient.toString());

            int ok=0;
            while(rez.next()) {
                Pacient p=new Pacient(rez.getString("cnp"),rez.getString("nume"),rez.getString("prenume"),rez.getInt("abonament"),rez.getInt("sectno"));
                pacienti.add(p);
            }
        }
        catch (Exception exc) {
    	    exc.printStackTrace();
    	    System.exit(1);
        }
    }
    
	/**
	 * functia extrageSectii() extrage sectiile din baza de date, si le adauga in lista de sectii
	 */
	public static void extrageSectii() {
		try {
			StringBuilder sb = new StringBuilder();
	        sb.append("SELECT * from bd.sectie");
			
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd","vlad","vlad4567");
            Statement comanda = myConn.createStatement();
            ResultSet rs = comanda.executeQuery(sb.toString());
            while(rs.next()) {
            	Sectie s = new Sectie(rs.getInt("sectno"),rs.getInt("locuri"),rs.getString("tip"),rs.getInt("clno"));
            	sectii.add(s);
            }
	    }
	    catch (Exception exc) {
	       exc.printStackTrace();
	       System.exit(1);
	    }
	}
	
	/**
	 * functia extrageClinici() extrage clinicile din baza de date, si le adauga in lista de clinici
	 */
	public static void extrageClinici() {
        StringBuilder sb=new StringBuilder();
        sb.append("SELECT * FROM bd.clinica");
        try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd","vlad","vlad4567");
            Statement comanda = myConn.createStatement();
            ResultSet rez=comanda.executeQuery(sb.toString());

            int ok=0;
            while(rez.next()) {
                Clinica c=new Clinica(rez.getInt("clno"),rez.getString("nume"),rez.getInt("spno"));
                clinici.add(c);
            }

        }
        catch (Exception exc) {
            exc.printStackTrace();
            System.exit(1);
        }

    }
	
}//test





























