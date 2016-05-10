package li.Layouts;

import li.com.*;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Color;
import java.awt.Dialog;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import li.com.Department;
import li.com.Employee;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainScreen {

	private JFrame frame;
	private JTable table;
	private JTextField text_sum;
	private String path;
	private ArrayList company;
	private int nDepartment;
	
	
	// elements of the main windows
	private JMenuBar menuBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)  {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
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
	public MainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 840, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JList list;
		// Create some items to add to the list
		final Color[] colors = { Color.BLACK, Color.BLUE,
						Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN,
						Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK,
						Color.RED, Color.WHITE, Color.YELLOW };
		list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 15));
		list.setBounds(10, 11, 128, 395);
		frame.getContentPane().add(list);
		list.setVisibleRowCount( 5 );
		// do not allow multiple selections
		list.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		
		/**
		 * handle list event
		 */
		// add a JScrollPane containing JList to frame
		list.addListSelectionListener(new ListSelectionListener() { // anonymous inner class
			// handle list selection events
			public void valueChanged( ListSelectionEvent event )
			{
				int index = list.getSelectedIndex();
				Department d = (Department) company.get(index);
				Employee es[] = d.getEmployees();
				int size = d.getCurrentSize();
				Object obs[][] = new Object[size][5];
				for(int i = 0; i < size; i++) {
					obs[i][0] = new Integer(i);
					obs[i][1] = es[i].getFirstName() + " " + es[i].getLastName();
					obs[i][2] = es[i].getBirthday().toString();
					obs[i][3] = es[i].getSocialSecurityNumber();
					obs[i][4] = es[i].getPaymentAmount();
				}
				table.setModel(new DefaultTableModel(obs,
						new String[] {
							"STT", "Name", "Birthday", "SSN", "Wage"
						}
				));
				TableColumnModel columnModel = table.getColumnModel();
				columnModel.getColumn(0).setPreferredWidth(30);
				columnModel.getColumn(1).setPreferredWidth(150);
				columnModel.getColumn(2).setPreferredWidth(100);
				columnModel.getColumn(3).setPreferredWidth(130);
				columnModel.getColumn(4).setPreferredWidth(150);
			} // end method valueChanged
		}); // end call to addListSelectionListener
		//test
		JButton btn_Add = new JButton("Add");
		btn_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddEmployee addEmployee = new AddEmployee();
				addEmployee.setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);
				addEmployee.setVisible(true);
			}
		});
		btn_Add.setFont(new Font("Tahoma", Font.PLAIN, 18));

		btn_Add.setBounds(718, 40, 89, 42);
		frame.getContentPane().add(btn_Add);
		
		JButton btn_delete = new JButton("Delete");
		btn_delete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO:
			}
		});
		btn_delete.setBounds(718, 101, 89, 42);
		frame.getContentPane().add(btn_delete);
		
		JButton btn_Mod = new JButton("Modify");
		btn_Mod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO
				JOptionPane.showMessageDialog(null, "huyhuyhuy ", "ThÃ´ng bÃ¡o", JOptionPane.CLOSED_OPTION);
			}
		});
		btn_Mod.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_Mod.setBounds(718, 164, 89, 42);
		frame.getContentPane().add(btn_Mod);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(160, 23, 548, 364);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.setRowHeight(40);
		
		table.setModel(new DefaultTableModel(
				new Object[][]{},
				new String[] {
					"STT", "Name", "Birthday", "SSN", "Wage"
				}
			));

		
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(10);
		columnModel.getColumn(1).setPreferredWidth(150);
		columnModel.getColumn(2).setPreferredWidth(100);
		columnModel.getColumn(3).setPreferredWidth(100);
		columnModel.getColumn(4).setPreferredWidth(180);
		scrollPane.setViewportView(table);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
		table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
		table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
		
		int sum = 0;
		for (int i = 1; i < table.getRowCount(); i++) {
			sum = sum + Integer.parseInt(table.getValueAt(i, 4).toString());
		}
		final int sumfinal = sum;
		
		text_sum = new JTextField();
		text_sum.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_sum.setHorizontalAlignment(SwingConstants.RIGHT);
		text_sum.setText("0");
		text_sum.setBounds(382, 416, 177, 45);
		frame.getContentPane().add(text_sum);
		text_sum.setColumns(10);
		JButton btn_Sum = new JButton("SUM");
		btn_Sum.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_Sum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				text_sum.setText(Integer.toString(sumfinal));
			}
		});
		btn_Sum.setBounds(173, 416, 111, 45);
		frame.getContentPane().add(btn_Sum);
		
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		JMenu mFile = new JMenu("File");
		JMenuItem itemAbout = new JMenuItem("About");
	    JMenuItem itemNew = new JMenuItem("New");
	    itemNew.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		 JOptionPane.showMessageDialog(null, "Báº¡n vá»«a chá»�n New ", "ThÃ´ng bÃ¡o", JOptionPane.CLOSED_OPTION);
	    	}
	    });
	    JMenuItem itemOpen = new JMenuItem("Open");
	    itemOpen.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		System.out.println("ok");
	    		JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
	    		int returnVal = chooser.showOpenDialog(frame);
	    		if(returnVal == JFileChooser.APPROVE_OPTION) {
	    			path = chooser.getCurrentDirectory().getPath()
	    					+ File.separator
	    					+ chooser.getSelectedFile().getName();
	    			loadData(path);
    		    }
	    	}
	    	
	    	public void loadData(String path) {
	    		try{
					FileInputStream fileIn = new FileInputStream(path);
		            ObjectInputStream in = new ObjectInputStream(fileIn);// input the read file.
		            company = (ArrayList) in.readObject();// allocate it to the object file already instanciated.
		            in.close();//closes the input stream.
		            fileIn.close();//closes the file data stream.
		            nDepartment = company.size();
		            setDepartmentList(company);
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e.toString(), "alert", JOptionPane.ERROR_MESSAGE);;
				}
	    	}
	    	
	    	public void setDepartmentList(ArrayList company) {
	    		String dNames[] = new String[nDepartment];
	    		for(int i = 0; i < nDepartment; i++){
	    			dNames[i] = ((Department) company.get(i)).getName();
	    		}
	    		list.setListData(dNames);
	    	}
	    });
	    itemOpen.addMouseListener(new MouseAdapter() {
	    	/**
	    	 * handle open menu
	    	 */
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		
	    	}
	    });
	    JMenuItem itemSave = new JMenuItem("Save");
	    JMenuItem itemSaveAs = new JMenuItem("Save As");
	    
	    // thÃªm cÃ¡c má»¥c menu con vÃ o menu cha lÃ  File
        mFile.add(itemNew);
        mFile.add(itemOpen);
        mFile.add(itemSave);
        mFile.add(itemSaveAs);
        
        // Táº¡o phÃ­m táº¯t cho cÃ¡c menu tÆ°Æ¡ng á»©ng
        itemNew.setMnemonic(KeyEvent.VK_N);
        itemOpen.setMnemonic(KeyEvent.VK_O);
        itemSave.setMnemonic(KeyEvent.VK_S);
        itemSaveAs.setMnemonic(KeyEvent.VK_A);
 
        // ThÃªm cÃ¡c má»¥c menu cha vÃ o menu chÃ­nh cá»§a Frame
        menuBar.add(mFile);
        menuBar.add(itemAbout);
        // RiÃªng menu cha About ta khÃ´ng thÃªm menu con vÃ o vÃ¬ má»¥c About chá»‰ cÃ³ 1 lá»±a chá»�n duy nháº¥t

	}
}
