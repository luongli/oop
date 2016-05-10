package li.Layouts;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CommissionGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CommissionGUI dialog = new CommissionGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CommissionGUI() {
		setBounds(100, 100, 620, 310);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextField newTitle = new JTextField("Commission Employee");
        newTitle.setBounds(80, 40, 225, 20);
        setTitle(newTitle.getText());
        {
			JLabel lblFirstName = new JLabel("First name");
			lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblFirstName.setBounds(51, 21, 80, 27);
			contentPanel.add(lblFirstName);
		}
		{
			textField_6 = new JTextField();
			textField_6.setBounds(206, 26, 86, 20);
			contentPanel.add(textField_6);
			textField_6.setColumns(10);
		}
		{
			JLabel lblLastName = new JLabel("Last name");
			lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblLastName.setBounds(51, 81, 80, 14);
			contentPanel.add(lblLastName);
		}
		{
			textField_7 = new JTextField();
			textField_7.setBounds(206, 80, 86, 20);
			contentPanel.add(textField_7);
			textField_7.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Social Security Number");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(51, 135, 146, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			textField_8 = new JTextField();
			textField_8.setBounds(206, 134, 86, 20);
			contentPanel.add(textField_8);
			textField_8.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Birthday");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(51, 191, 80, 19);
			contentPanel.add(lblNewLabel_1);
		}
		{
			textField_9 = new JTextField();
			textField_9.setBounds(206, 190, 86, 20);
			contentPanel.add(textField_9);
			textField_9.setColumns(10);
		}
		{
			JLabel lblWage = new JLabel("Gross Sales");
			lblWage.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblWage.setBounds(344, 24, 88, 20);
			contentPanel.add(lblWage);
		}
		{
			textField_10 = new JTextField();
			textField_10.setBounds(459, 24, 86, 20);
			contentPanel.add(textField_10);
			textField_10.setColumns(10);
		}
		{
			JLabel lblHours = new JLabel("Commission Rate");
			lblHours.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblHours.setBounds(344, 79, 105, 19);
			contentPanel.add(lblHours);
		}
		{
			textField_11 = new JTextField();
			textField_11.setBounds(459, 78, 86, 20);
			contentPanel.add(textField_11);
			textField_11.setColumns(10);
		}
	
        {
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
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
