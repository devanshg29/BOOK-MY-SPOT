import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Font;
class userbookingdata{
	public String username;
	public String name;
	public String mallid;
	public String mallname;
	public String city;
	public List <String> selectedvar = new ArrayList<>();
	public List <String> selectedseats = new ArrayList<>();
	public List <String> carnumbers = new ArrayList<>();
	
	public float billamount;
	public String bookingdate;
	//public List <Time> bookingtime;
	//public List <Time> slottime;
}
public class billPayment1 extends JFrame {

	private JPanel contentPane;
	public userbookingdata user;
	private JTable bookinginfo;
	private JButton btnNewButton;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					billPayment1 frame = new billPayment1(new userbookingdata());
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
	public billPayment1(userbookingdata user) {
		this.user = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 381, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlShadow);
		panel.setBounds(10, 11, 344, 205);
		contentPane.add(panel);
		panel.setLayout(null);
		DefaultTableModel model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Slot ", "Date ", "Time ","Charges Per/ Hr" ,"Car Number "
				}
			) ;
		bookinginfo = new JTable(model);
		bookinginfo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bookinginfo.setEnabled(false);
//		bookinginfo.setModel();
		bookinginfo.getColumnModel().getColumn(0).setPreferredWidth(120);
		bookinginfo.getColumnModel().getColumn(0).setMinWidth(25);
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		model.insertRow(0, new Object[] {"Slot ", "Date ", "Time ","Charges Per/ Hr"});
//		int i=1;
		//for(String s: user.selectedseats)
		user.bookingdate = date.toString();
		for(int i=0; i<user.selectedseats.size();i++)
		{
			model.insertRow(i+1, new Object[]{user.selectedseats.get(i), date, time, 100, user.carnumbers.get(i)});
		}
		bookinginfo.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bookinginfo.setBackground(Color.GRAY);
		bookinginfo.setBounds(10, 11, 324, 179);
		panel.add(bookinginfo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(153, 180, 209), null, null, null));
		panel_1.setBackground(SystemColor.controlShadow);
		panel_1.setBounds(20, 221, 321, 39);
		contentPane.add(panel_1);
		
		btnNewButton = new JButton("Pay ");
		
		panel_1.add(btnNewButton);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.GRAY);
		panel2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, SystemColor.textHighlight, null, null, null));
		panel2.setBounds(10, 266, 344, 99);
		contentPane.add(panel2);
		panel2.setLayout(null);
		panel2.setVisible(false);
		ButtonGroup bg=new ButtonGroup();    
		    
		rdbtnNewRadioButton = new JRadioButton("Debit / Credit ");
		rdbtnNewRadioButton.setBounds(22, 27, 109, 23);
		panel2.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("UPI / Wallet");
		rdbtnNewRadioButton_1.setBounds(195, 27, 109, 23);
		panel2.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton);bg.add(rdbtnNewRadioButton_1);
		JButton btnNewButton_1 = new JButton("Continue");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				billPayment2 obj  = new billPayment2(user);
				setVisible(false);
				obj.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(121, 57, 89, 23);
		panel2.add(btnNewButton_1);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(panel2.isVisible())
					panel2.setVisible(false);
				else
					panel2.setVisible(true);
			}
		});
	}
}
