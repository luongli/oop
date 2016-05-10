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

import li.com.BasePlusCommissionEmployee;
import li.com.CommissionEmployee;
import li.com.Date;

public class BasePlusCommissionGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField fname_tf;
	private JTextField lname_tf;
	private JTextField ssn_tf;
	private JTextField birthday_tf;
	private JTextField gsales_tf;
	private JTextField crate_tf;
	private JTextField bsalary_tf;
	
	private BasePlusCommissionEmployee bce;

	public BasePlusCommissionEmployee getBce() {
		return bce;
	}

	public void setBce(BasePlusCommissionEmployee bce) {
		this.bce = bce;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BasePlusCommissionGUI dialog = new BasePlusCommissionGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BasePlusCommissionGUI() {
		setBounds(100, 100, 620, 310);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextField newTitle = new JTextField("Base Plus Commission Employee");
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
			JLabel lblWage = new JLabel("Gross Sales");
			lblWage.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblWage.setBounds(344, 24, 88, 20);
			contentPanel.add(lblWage);
		}
		{
			gsales_tf = new JTextField();
			gsales_tf.setBounds(459, 24, 86, 20);
			contentPanel.add(gsales_tf);
			gsales_tf.setColumns(10);
		}
		{
			JLabel lblHours = new JLabel("Commission Rate");
			lblHours.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblHours.setBounds(344, 79, 105, 19);
			contentPanel.add(lblHours);
		}
		{
			crate_tf = new JTextField();
			crate_tf.setBounds(459, 78, 86, 20);
			contentPanel.add(crate_tf);
			crate_tf.setColumns(10);
		}
		{
			JLabel lblBaseSalary = new JLabel("Base Salary");
			lblBaseSalary.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblBaseSalary.setBounds(344, 137, 105, 19);
			contentPanel.add(lblBaseSalary);
		}
		{
			bsalary_tf = new JTextField();
			bsalary_tf.setColumns(10);
			bsalary_tf.setBounds(459, 134, 86, 20);
			contentPanel.add(bsalary_tf);
		}
	
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try{
							String fname = fname_tf.getText();
							String lname = lname_tf.getText();
							String ssString = ssn_tf.getText();
							Date birthday = Date.parseDate(birthday_tf.getText());
							double grossSales = Double.parseDouble(gsales_tf.getText());
							double cRate = Double.parseDouble(crate_tf.getText());
							double bsalary = Double.parseDouble(bsalary_tf.getText());
							bce = new BasePlusCommissionEmployee(
									fname, lname, ssString, birthday,
									grossSales, cRate, bsalary
							);
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
