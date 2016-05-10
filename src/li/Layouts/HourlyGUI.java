package li.Layouts;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

public class HourlyGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HourlyGUI window = new HourlyGUI();
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
	public HourlyGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 840, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextField newTitle = new JTextField("Hourly Employee");
        newTitle.setBounds(80, 40, 225, 20);
        frame.setTitle(newTitle.getText());
        
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFirstName.setBounds(37, 36, 82, 30);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLastName.setBounds(37, 108, 82, 30);
		frame.getContentPane().add(lblLastName);
		
		textField = new JTextField();
		textField.setBounds(266, 108, 135, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblSocialSecurityNumber = new JLabel("Social Security Number");
		lblSocialSecurityNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSocialSecurityNumber.setBounds(37, 167, 219, 30);
		frame.getContentPane().add(lblSocialSecurityNumber);
		
		textField_1 = new JTextField();
		textField_1.setBounds(266, 167, 135, 30);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(266, 36, 135, 30);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBirthday.setBounds(37, 226, 114, 30);
		frame.getContentPane().add(lblBirthday);
		
		textField_3 = new JTextField();
		textField_3.setBounds(266, 229, 135, 30);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblWage = new JLabel("Wage");
		lblWage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblWage.setBounds(453, 36, 97, 30);
		frame.getContentPane().add(lblWage);
		
		JLabel lblHour = new JLabel("Hour");
		lblHour.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHour.setBounds(453, 108, 99, 30);
		frame.getContentPane().add(lblHour);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdd.setBounds(453, 319, 107, 39);
		frame.getContentPane().add(btnAdd);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancel.setBounds(623, 319, 97, 39);
		frame.getContentPane().add(btnCancel);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(560, 36, 135, 30);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(562, 108, 135, 30);
		frame.getContentPane().add(textField_5);
	}
}
