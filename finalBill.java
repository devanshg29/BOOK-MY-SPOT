import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class finalBill extends JFrame {

	private JPanel contentPane;
	public userbookingdata user = new userbookingdata();
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					finalBill frame = new finalBill( new userbookingdata());
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
	public finalBill(userbookingdata user) {
		this.user = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		DefaultTableModel model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Car number", "SpotNumber", "Date", "Mall Name",
					}
			) ;
		table = new JTable();
		table.setBounds(67, 183, 339, -153);
		contentPane.add(table);
		
		table_1 = new JTable();
		table_1.setModel(model);
		table_1.setBounds(10, 11, 414, 131);
		contentPane.add(table_1);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(173, 212, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 153, 424, 33);
		contentPane.add(lblNewLabel);
		
		
		model.insertRow(0, new Object[] {"Car number", "SpotNumber", "Date", "Mall Name"});

		for(int i=0; i<user.selectedseats.size();i++)
		{
			model.insertRow(i+1, new Object[]{user.carnumbers.get(i), user.selectedseats.get(i), user.bookingdate,user.mallname});
		}
		lblNewLabel.setText("Your Paid Amount is "+ user.billamount+"");
	}
}
