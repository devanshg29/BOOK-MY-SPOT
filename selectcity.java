import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class selectcity extends JFrame {

	private JPanel contentPane;
	public userbookingdata user;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					selectcity frame = new selectcity(new userbookingdata());
					frame.setLocationRelativeTo(null);
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
	public selectcity(userbookingdata user) {
		this.user = user;
		System.out.println(user.name +  "  "+ user.username);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
//		setBounds(100, 100, 450, 176);
		setSize(405,176);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"--SELECT CITY ", "DELHI-NCR", "MUMBAI", "GUJARAT"}));
		comboBox.setBounds(49, 65, 149, 34);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		comboBox_1.setBounds(220, 65, 144, 34);
		contentPane.add(comboBox_1);
		
		JLabel lblusername = new JLabel(user.name);
		lblusername.setForeground(new Color(0, 0, 0));
		lblusername.setText(user.name);
		lblusername.setEnabled(false);
		lblusername.setBackground(new Color(0, 0, 160));
		lblusername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblusername.setBounds(134, 11, 133, 34);
		contentPane.add(lblusername);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(306, 19, 89, 23);
		contentPane.add(btnNewButton);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String str = (String) comboBox.getSelectedItem();
				if(str.equals("DELHI-NCR"))
					comboBox_1.setModel(new DefaultComboBoxModel(new String [] {"", "A", "B", "C"}));
				else if 	(str.equals("MUMBAI"))
					comboBox_1.setModel(new DefaultComboBoxModel(new String [] { "D", "E", "F"}));
				else if 	(str.equals("GUJARAT"))
					comboBox_1.setModel(new DefaultComboBoxModel(new String [] { "G", "H", "I"}));
				else if (str.equals("--SELECT CITY "))
					comboBox_1.removeAllItems();
				else 
					JOptionPane.showMessageDialog(null, "City Not Selected ");
			}
				
		});
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String str = (String) comboBox.getSelectedItem();
//				if (str.equals("--SELECT CITY "))
//						JOptionPane.showMessageDialog(null, "Select Not Selected ");
				
				
				
				parkinglot obj = new parkinglot(user);
				user.mallname = (String) comboBox_1.getSelectedItem();
				user.city = (String) comboBox.getSelectedItem();
				obj.user= user;
				obj.setVisible(true);
				setVisible(false);
			}
		});
	}
}
