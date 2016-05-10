package li.Layouts;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JMenu;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AddEmployee {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployee window = new AddEmployee();
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
	public AddEmployee() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 748, 333);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextField newTitle = new JTextField("Add Employee");
        newTitle.setBounds(80, 40, 225, 20);
        frame.setTitle(newTitle.getText());
		
		JButton btnNewButton = new JButton("Hourly Employee");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(45, 38, 295, 54);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Salaried Employee");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(45, 138, 295, 54);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Base Plus Commission Employee");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(413, 38, 295, 54);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Commission Employee");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_3.setBounds(413, 138, 295, 54);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Cancel");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_4.setBounds(517, 234, 106, 39);
		frame.getContentPane().add(btnNewButton_4);
	    //Object cmboitem = comboBox.getSelectedItem();
	    
	    frame.setVisible(true);
	}
}
