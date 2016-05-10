package li.Layouts;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import li.com.Date;
import li.com.HourlyEmployee;
import li.com.SalariedEmployee;

public class HourlyGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField fname_tf;
	private JTextField lname_tf;
	private JTextField ssn_tf;
	private JTextField birthday_tf;
	private JTextField wage_tf;
	private JTextField hours_tf;
	
	private HourlyEmployee he;

	public HourlyEmployee getHe() {
		return he;
	}

	public void setHe(HourlyEmployee he) {
		this.he = he;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			HourlyGUI dialog = new HourlyGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public HourlyGUI() {
		setBounds(100, 100, 620, 310);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		JTextField newTitle = new JTextField("Hourly Employee");
        newTitle.setBounds(80, 40, 225, 20);
        setTitle(newTitle.getText());
		{
			JLabel lblFirstName = new JLabel("First name");
			lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblFirstName.setBounds(51, 21, 80, 27);
			contentPanel.add(lblFirstName);
		}
		{
			fname_tf = new JTextField();
			fname_tf.setBounds(206, 26, 86, 20);
			contentPanel.add(fname_tf);
			fname_tf.setColumns(10);
	

		}
		{
			JLabel lblLastName = new JLabel("Last name");
			lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblLastName.setBounds(51, 81, 80, 14);
			contentPanel.add(lblLastName);
		}
		{
			lname_tf = new JTextField();
			lname_tf.setBounds(206, 80, 86, 20);
			contentPanel.add(lname_tf);
			lname_tf.setColumns(10);
			
		}
		{
			JLabel lblNewLabel = new JLabel("Social Security Number");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(51, 135, 146, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			ssn_tf = new JTextField();
			ssn_tf.setBounds(206, 134, 86, 20);
			contentPanel.add(ssn_tf);
			ssn_tf.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Birthday");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(51, 191, 80, 19);
			contentPanel.add(lblNewLabel_1);
		}
		{
			birthday_tf = new JTextField();
			birthday_tf.setBounds(206, 190, 86, 20);
			contentPanel.add(birthday_tf);
			birthday_tf.setColumns(10);
		}
		{
			JLabel lblWage = new JLabel("Wage");
			lblWage.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblWage.setBounds(376, 27, 46, 14);
			contentPanel.add(lblWage);
		}
		{
			wage_tf = new JTextField();
			wage_tf.setBounds(459, 24, 86, 20);
			contentPanel.add(wage_tf);
			wage_tf.setColumns(10);
		}
		{
			JLabel lblHours = new JLabel("Hours");
			lblHours.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblHours.setBounds(376, 81, 46, 14);
			contentPanel.add(lblHours);
		}
		{
			hours_tf = new JTextField();
			hours_tf.setBounds(459, 78, 86, 20);
			contentPanel.add(hours_tf);
			hours_tf.setColumns(10);
		}
	
	
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try{
							String fname = fname_tf.getText();
							String lname = lname_tf.getText();
							String ssString = ssn_tf.getText();
							Date birthday = Date.parseDate(birthday_tf.getText());
							double wage = Double.parseDouble(wage_tf.getText());
							double hours = Double.parseDouble(hours_tf.getText());
							he = new HourlyEmployee(fname, lname, ssString, birthday, wage, hours);
							dispose();
						}catch(Exception exc){
							JOptionPane.showMessageDialog(null,
									exc.toString(),
									"Error",
									JOptionPane.ERROR_MESSAGE
							);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
