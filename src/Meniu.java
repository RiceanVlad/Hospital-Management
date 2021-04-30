import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
/**
 * 
 * Clasa Meniu reprezinta interfata grafica a meniului principal
 */
public class Meniu extends Test{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void fereastraMeniu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Meniu window = new Meniu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Meniu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(201,236,255));
		frame.setBounds(100, 100, 588, 365);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Spitalul Municipal Medias");
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 17));
		lblNewLabel.setBounds(188, 21, 240, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnAddPacient = new JButton("Add Pacient");
		btnAddPacient.setFont(new Font("Century", Font.PLAIN, 11));
		btnAddPacient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PacientGUI nw = new PacientGUI();
				nw.fereastraPacient();
			}
		});
		btnAddPacient.setBounds(101, 116, 164, 30);
		frame.getContentPane().add(btnAddPacient);
		
		JButton btnAddSectie = new JButton("Add Sectie");
		btnAddSectie.setFont(new Font("Century", Font.PLAIN, 11));
		btnAddSectie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SectieGUI nw = new SectieGUI();
				nw.fereastraSectie();
			}
		});
		btnAddSectie.setBounds(101, 156, 164, 30);
		frame.getContentPane().add(btnAddSectie);
		
		JButton btnAddClinica = new JButton("Add Clinica");
		btnAddClinica.setFont(new Font("Century", Font.PLAIN, 11));
		btnAddClinica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClinicaGUI nw = new ClinicaGUI();
				nw.fereastraClinica();
			}
		});
		btnAddClinica.setBounds(101, 196, 164, 30);
		frame.getContentPane().add(btnAddClinica);
		
		JButton btnAddDataIE = new JButton("Add internare/externare");
		btnAddDataIE.setFont(new Font("Century", Font.PLAIN, 11));
		btnAddDataIE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataIEGUI nw = new DataIEGUI();
				nw.fereastraDataIE();
			}
		});
		btnAddDataIE.setBounds(101, 236, 164, 30);
		frame.getContentPane().add(btnAddDataIE);
		
		JButton btnInfoSpital = new JButton("Info spital");
		btnInfoSpital.setFont(new Font("Century", Font.PLAIN, 11));
		btnInfoSpital.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoSpitalGUI nw = new InfoSpitalGUI();
				nw.fereastraInfoSpital();
			}
		});
		btnInfoSpital.setBounds(361, 116, 114, 30);
		frame.getContentPane().add(btnInfoSpital);
		
		JButton btnDiscount = new JButton("Add Discount");
		btnDiscount.setFont(new Font("Century", Font.PLAIN, 11));
		btnDiscount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDiscount();
				DiscountGUI nw = new DiscountGUI();
				nw.fereastraDiscount();
			}
		});
		btnDiscount.setBounds(361, 236, 114, 30);
		frame.getContentPane().add(btnDiscount);
	}
}
