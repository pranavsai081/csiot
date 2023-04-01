package markslist;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Marksregistering {

	private JFrame frame;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Marksregistering window = new Marksregistering();
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
	public Marksregistering() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 504, 385);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 77, 54, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblSno = new JLabel("SNo");
		lblSno.setFont(new Font("Sitka Subheading", Font.BOLD, 18));
		lblSno.setBounds(10, 47, 54, 23);
		frame.getContentPane().add(lblSno);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Sitka Subheading", Font.BOLD, 18));
		lblEmail.setBounds(10, 111, 54, 23);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblMarks = new JLabel("Marks");
		lblMarks.setFont(new Font("Sitka Subheading", Font.BOLD, 18));
		lblMarks.setBounds(10, 146, 54, 23);
		frame.getContentPane().add(lblMarks);
		
		t1 = new JTextField();
		t1.setBounds(85, 47, 143, 20);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(85, 77, 143, 20);
		frame.getContentPane().add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(85, 111, 143, 20);
		frame.getContentPane().add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(85, 146, 143, 20);
		frame.getContentPane().add(t4);
		
		JButton b = new JButton("Submit");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sn=t1.getText();
				int sno=Integer.parseInt(sn);
				String name=t2.getText();
				String email=t3.getText();
				String m=t4.getText();
				float marks=Float.parseFloat(m);
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/markslist","root","mrec");
					String q="Insert into marks values('"+sno+"','"+name+"','"+email+"','"+marks+"')";
					Statement sta=con.createStatement();
					sta.executeUpdate(q);
					con.close();
					JOptionPane.showMessageDialog(b, "Done");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			
				
				
			}
		});
		b.setBounds(112, 275, 89, 23);
		frame.getContentPane().add(b);
	}
}
