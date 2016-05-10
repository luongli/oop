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
import java.util.function.DoubleToIntFunction;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;

public class MainScreen {

	private JFrame frame;
	private JTable table;
	private JTextField text_sum;
	private String path;
	private ArrayList company;
	private int nDepartment;
	private int index;
	private Department currentDepartment = null;
	
	
	public Department getCurrentDepartment() {
		return currentDepartment;
	}

	public void setCurrentDepartment(Department currentDepartment) {
		this.currentDepartment = currentDepartment;
	}

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
				index = list.getSelectedIndex();
				currentDepartment = (Department) company.get(index);
				Employee es[] = currentDepartment.getEmployees();
				int size = currentDepartment.getCurrentSize();
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
				
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
				table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
				table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
				table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
				table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
			} // end method valueChanged
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(160, 23, 608, 359);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {  
			   
            public void valueChanged(ListSelectionEvent e) {  
                //I want something to happen before the row change is triggered on the UI.  
               //System.out.println("activated"); 
            }  
        }); 
		
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				System.out.println("activated");
				String s = (String) table.getModel().getValueAt(
						table.getEditingColumn(),
						table.getEditingRow()
				);
				System.out.println(s);
			}
			@Override
			public void keyPressed(KeyEvent arg0) {
				System.out.println("activated");
			}
		});
		table.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}
			public void inputMethodTextChanged(InputMethodEvent arg0) {
			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.setRowHeight(40);
		
		table.setModel(new DefaultTableModel(
				new Object[][]{},
				new String[] {
					"STT", "Name", "Birthday", "SSN", "Wage"
				}
			));

		
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(30);
		columnModel.getColumn(1).setPreferredWidth(150);
		columnModel.getColumn(2).setPreferredWidth(100);
		columnModel.getColumn(3).setPreferredWidth(100);
		columnModel.getColumn(4).setPreferredWidth(180);
		scrollPane.setViewportView(table);
		
		
		
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
				if(currentDepartment == null){
					JOptionPane.showMessageDialog(null,
							"You must select a department first",
							"Error", JOptionPane.ERROR_MESSAGE);
				}else{
					Employee es[] = currentDepartment.getEmployees();
					double sum = 0;
					for(int i = 0; i < currentDepartment.getCurrentSize(); i++) {
						sum += es[i].getPaymentAmount();
					}
					text_sum.setText(new Double(sum).toString());
				}
			}
		});
		btn_Sum.setBounds(173, 416, 111, 45);
		frame.getContentPane().add(btn_Sum);
		
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		JMenu mFile = new JMenu("File");
		JMenu mFile1 = new JMenu("Edit");
		JMenu mFile2 = new JMenu("About");
		
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
	    
	    JMenuItem itemAdd1 = new JMenuItem("Add Hourly Employee");
	    itemAdd1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		HourlyGUI hourlyEmployee = new HourlyGUI();
				hourlyEmployee.setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);
				hourlyEmployee.setVisible(true);
	    	}
	    });
	    JMenuItem itemAdd2 = new JMenuItem("Add Salaried Employee");
	    itemAdd2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		SalariedGUI salariedEmployee = new SalariedGUI();
				salariedEmployee.setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);
				salariedEmployee.setVisible(true);
	    	}
	    });
	    JMenuItem itemAdd3 = new JMenuItem("Add Commission Employee");
	    itemAdd3.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		CommissionGUI commissionEmployee = new CommissionGUI();
				commissionEmployee.setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);
				commissionEmployee.setVisible(true);
	    	}
	    });
	    JMenuItem itemAdd4 = new JMenuItem("Add Base Plus Commission Employee");
	    itemAdd4.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		BasePlusCommissionGUI BPCEmployee = new BasePlusCommissionGUI();
				BPCEmployee.setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);
				BPCEmployee.setVisible(true);
	    	}
	    	
	    });
	    JMenuItem itemDel = new JMenuItem("Delete Employee");
	    
	    // add item for menu FILE
        mFile.add(itemNew);
        mFile.add(itemOpen);
        mFile.add(itemSave);
        mFile.add(itemSaveAs);
        
        // add item for menu EDIT
        mFile1.add(itemAdd1);
        mFile1.add(itemAdd2);
        mFile1.add(itemAdd3);
        mFile1.add(itemAdd4);
        mFile1.add(itemDel);
        
        
        // create an shortcut for item
        itemNew.setMnemonic(KeyEvent.VK_N);
        itemOpen.setMnemonic(KeyEvent.VK_O);
        itemSave.setMnemonic(KeyEvent.VK_S);
        itemSaveAs.setMnemonic(KeyEvent.VK_A);
 
        // add menu in menubar
        menuBar.add(mFile);
        menuBar.add(mFile1);
        menuBar.add(mFile2);
        

	}
}
