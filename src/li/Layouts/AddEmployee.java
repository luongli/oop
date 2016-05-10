package li.Layouts;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddEmployee extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddEmployee dialog = new AddEmployee();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddEmployee() {
		setBounds(250, 250, 554, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnNewButton = new JButton("Hourly Employee");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					HourlyGUI hourlyEmployee = new HourlyGUI();
					hourlyEmployee.setVisible(true);
				}
			});
			btnNewButton.setBounds(43, 44, 194, 36);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnNewButton_1 = new JButton("Salaried Employee");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SalariedGUI salariedEmployee = new SalariedGUI();
					salariedEmployee.setVisible(true);
				}
			});
			btnNewButton_1.setBounds(309, 44, 194, 36);
			contentPanel.add(btnNewButton_1);
		}
		{
			JButton btnNewButton_2 = new JButton("Commission Employee");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CommissionGUI commissionEmployee = new CommissionGUI();
					commissionEmployee.setVisible(true);
				}
			});
			btnNewButton_2.setBounds(43, 120, 194, 36);
			contentPanel.add(btnNewButton_2);
		}
		{
			JButton btnNewButton_3 = new JButton("Base Plus Commission Employee");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					BasePlusCommissionGUI BPCEmployee = new BasePlusCommissionGUI();
					BPCEmployee.setVisible(true);
				}
			});
			btnNewButton_3.setBounds(309, 120, 194, 36);
			contentPanel.add(btnNewButton_3);
		}
		{
			JTextField newTitle = new JTextField("Add Employee");
	        newTitle.setBounds(80, 40, 225, 20);
	        setTitle(newTitle.getText());
			
			
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
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
