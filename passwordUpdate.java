import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Color;


/*
 * Author : Devansh 
 */

public class passwordUpdate extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	public String username;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					passwordUpdate frame = new passwordUpdate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public passwordUpdate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 434, 260);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENTER NEW PASSWORD ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(103, 45, 233, 13);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
			@Override
			public void keyTyped(KeyEvent e) {
				if((e.getKeyCode() == KeyEvent.VK_SPACE))
					e.consume();					
			}
		});
		textField.setBounds(111, 68, 207, 42);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CONFIRM NEW PASSWORD ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(89, 120, 262, 13);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					if(textField.getText().equals(textField_1.getText()))
					{
						  final String url = "jdbc:mysql:///bookmyspot";
					      final String user = "root";
					      final String password = "root";
					      Connection con = null;
					      try {
								con = DriverManager.getConnection(url, user, password);
								// display status message
							    if (con == null) {
							         System.out.println("JDBC connection is not established");
							         return;
							   } else
							         System.out.println("Congratulations," + 
							              " JDBC connection is established successfully.\n");
								String query = "update users set password = '" + textField_1.getText() + "' where username = '" +username +"';";
								Statement st = con.createStatement();
								st.executeUpdate(query);
								//con.commit();
								con.close();
								JOptionPane.showMessageDialog(null, "Password Updates. Please Login !!");
								setVisible(false);
								loginpage obj = new loginpage();
								obj.setVisible(true);
						      
					      } catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					}
				}
			}
		});
		textField_1.setBounds(111, 143, 207, 42);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
