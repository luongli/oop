package li.Layouts;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JButton;

public class SalariedGUI {

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
					SalariedGUI window = new SalariedGUI();
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
	public SalariedGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 840, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextField newTitle = new JTextField("Salaried Employee");
        newTitle.setBounds(80, 40, 225, 20);
        frame.setTitle(newTitle.getText());
        frame.getContentPane().setLayout(null);
        
        JLabel label = new JLabel("First name");
        label.setFont(new Font("Tahoma", Font.PLAIN, 18));
        label.setBounds(42, 44, 82, 30);
        frame.getContentPane().add(label);
        
        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(255, 47, 135, 30);
        frame.getContentPane().add(textField);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(255, 104, 135, 30);
        frame.getContentPane().add(textField_1);
        
        JLabel label_1 = new JLabel("Last name");
        label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        label_1.setBounds(42, 101, 82, 30);
        frame.getContentPane().add(label_1);
        
        JLabel label_2 = new JLabel("Social Security Number");
        label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        label_2.setBounds(42, 165, 219, 30);
        frame.getContentPane().add(label_2);
        
        JLabel label_3 = new JLabel("Birthday");
        label_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        label_3.setBounds(42, 225, 114, 30);
        frame.getContentPane().add(label_3);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(255, 168, 135, 30);
        frame.getContentPane().add(textField_2);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(255, 228, 135, 30);
        frame.getContentPane().add(textField_3);
        
        JLabel lblWeeklySalary = new JLabel("Weekly Salary");
        lblWeeklySalary.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblWeeklySalary.setBounds(453, 44, 135, 30);
        frame.getContentPane().add(lblWeeklySalary);
        
        JLabel lblBaseSalary = new JLabel("Base Salary");
        lblBaseSalary.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblBaseSalary.setBounds(453, 101, 118, 30);
        frame.getContentPane().add(lblBaseSalary);
        
        JButton button = new JButton("Add");
        button.setFont(new Font("Tahoma", Font.PLAIN, 18));
        button.setBounds(453, 319, 107, 39);
        frame.getContentPane().add(button);
        
        JButton button_1 = new JButton("Cancel");
        button_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        button_1.setBounds(623, 319, 97, 39);
        frame.getContentPane().add(button_1);
        
        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(598, 44, 135, 30);
        frame.getContentPane().add(textField_4);
        
        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(598, 104, 135, 30);
        frame.getContentPane().add(textField_5);
	}

}
