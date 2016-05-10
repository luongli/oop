package Layouts;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BasePlusCommissionGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BasePlusCommissionGUI window = new BasePlusCommissionGUI();
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
	public BasePlusCommissionGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 840, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextField newTitle = new JTextField("Base Plus Commission Employee");
        newTitle.setBounds(80, 40, 225, 20);
        frame.setTitle(newTitle.getText());
        frame.getContentPane().setLayout(null);
        
        JLabel label = new JLabel("First name");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(36, 41, 82, 30);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Last name");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(36, 109, 82, 30);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Social Security Number");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_2.setBounds(36, 175, 219, 30);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Birthday");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_3.setBounds(36, 244, 114, 30);
		frame.getContentPane().add(label_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(265, 175, 135, 30);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(265, 41, 135, 30);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(265, 109, 135, 30);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(265, 244, 135, 30);
		frame.getContentPane().add(textField_3);
		
		JLabel lblGrossSales = new JLabel("Gross Sales");
		lblGrossSales.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGrossSales.setBounds(465, 41, 135, 30);
		frame.getContentPane().add(lblGrossSales);
		
		JLabel lblCommissionRate = new JLabel("Commission Rate");
		lblCommissionRate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCommissionRate.setBounds(465, 109, 148, 30);
		frame.getContentPane().add(lblCommissionRate);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(623, 44, 135, 30);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(623, 109, 135, 30);
		frame.getContentPane().add(textField_5);
		
		JButton button = new JButton("Add");
		button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button.setBounds(453, 319, 107, 39);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Cancel");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_1.setBounds(623, 319, 97, 39);
		frame.getContentPane().add(button_1);
		
		JLabel lblBaseSalary = new JLabel("Base Salary");
		lblBaseSalary.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBaseSalary.setBounds(465, 175, 148, 30);
		frame.getContentPane().add(lblBaseSalary);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(623, 175, 135, 30);
		frame.getContentPane().add(textField_6);
	}

}
