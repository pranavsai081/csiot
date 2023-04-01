package markslist;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class checkmarks {

	private JFrame frame;
	private JTextField t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkmarks window = new checkmarks();
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
	public checkmarks() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 483, 354);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Your SNo");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 17));
		lblNewLabel.setBounds(23, 35, 104, 14);
		frame.getContentPane().add(lblNewLabel);
		
		t1 = new JTextField();
		t1.setBounds(154, 35, 153, 20);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		JLabel lb1 = new JLabel("Name");
		lb1.setFont(new Font("Verdana", Font.BOLD, 17));
		lb1.setBounds(23, 147, 313, 14);
		frame.getContentPane().add(lb1);
		
		JLabel lb2 = new JLabel("Marks");
		lb2.setFont(new Font("Verdana", Font.BOLD, 17));
		lb2.setBounds(23, 201, 313, 14);
		frame.getContentPane().add(lb2);
		
		JButton btnNewButton = new JButton("Click");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=t1.getText();
				int sno=Integer.parseInt(s);
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/markslist","root","mrec");
					String q="select name,marks from marks where sno=?";
					PreparedStatement ps=con.prepareStatement(q);
					ps.setInt(1, sno);
					ResultSet rs=ps.executeQuery();
					rs.next();
					lb1.setText("Name:"+rs.getString(1));
					lb2.setText("Marks:"+rs.getInt(2)); 
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(154, 92, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
