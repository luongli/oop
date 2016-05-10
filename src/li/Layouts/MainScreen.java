package Layouts;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Color;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MainScreen {

	private JFrame frame;
	private JTable table;
	private JTextField text_sum;

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
		final String[] listData = {
					"Phòng R&D", "Phòng Nội Vụ",
					"Phòng Đối Ngoại", "Phòng Kỉ Luật",
					"Phòng Văn Thư", "Phòng Thanh Tra",
					"Phòng Marketing" 	};
		final Color[] colors = { Color.BLACK, Color.BLUE,
						Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN,
						Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK,
						Color.RED, Color.WHITE, Color.YELLOW };
		list = new JList( listData );
		list.setFont(new Font("Tahoma", Font.PLAIN, 15));
		list.setBounds(10, 11, 128, 395);
		frame.getContentPane().add(list);
		list.setVisibleRowCount( 5 );
		// do not allow multiple selections
		list.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		
		JButton btn_Add = new JButton("Add");
		btn_Add.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Add.setBounds(718, 40, 89, 42);
		frame.getContentPane().add(btn_Add);
		
		JButton btn_delete = new JButton("Delete");
		btn_delete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_delete.setBounds(718, 101, 89, 42);
		frame.getContentPane().add(btn_delete);
		
		JButton btn_Mod = new JButton("Modify");
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
			new Object[][] {
				{new Integer(1), "Monkey D. Luffy", null, new Integer(20131802), new Integer(500)},
				{new Integer(2), "Hohohaha", null, new Integer(201343789), new Integer(200)},
				{new Integer(3), "\u0110\u1EA1i du", null, new Integer(201387584), new Integer(100)},
				{new Integer(4), "pikachu", null, new Integer(23901842), new Integer(144)},
			},
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
				
				text_sum.setText(Integer.toString(sumfinal));
			}
		});
		btn_Sum.setBounds(173, 416, 111, 45);
		frame.getContentPane().add(btn_Sum);
		
		
		
		
		// add a JScrollPane containing JList to frame
		list.addListSelectionListener(
				new ListSelectionListener() // anonymous inner class
				{
					// handle list selection events
					public void valueChanged( ListSelectionEvent event )
					{
						frame.getContentPane().setBackground(
								colors[ list.getSelectedIndex() ] );
						
					} // end method valueChanged
				} // end anonymous inner class
		); // end call to addListSelectionListener
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		JMenu mFile = new JMenu("File");
		JMenuItem itemAbout = new JMenuItem("About");
	    JMenuItem itemNew = new JMenuItem("New");
	    itemNew.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		 JOptionPane.showMessageDialog(null, "Bạn vừa chọn New ", "Thông báo", JOptionPane.CLOSED_OPTION);
	    	}
	    });
	    JMenuItem itemOpen = new JMenuItem("Open");
	    JMenuItem itemSave = new JMenuItem("Save");
	    JMenuItem itemSaveAs = new JMenuItem("Save As");
	    
	    // thêm các mục menu con vào menu cha là File
        mFile.add(itemNew);
        mFile.add(itemOpen);
        mFile.add(itemSave);
        mFile.add(itemSaveAs);
        
        // Tạo phím tắt cho các menu tương ứng
        itemNew.setMnemonic(KeyEvent.VK_N);
        itemOpen.setMnemonic(KeyEvent.VK_O);
        itemSave.setMnemonic(KeyEvent.VK_S);
        itemSaveAs.setMnemonic(KeyEvent.VK_A);
 
        // Thêm các mục menu cha vào menu chính của Frame
        menuBar.add(mFile);
        menuBar.add(itemAbout);
        // Riêng menu cha About ta không thêm menu con vào vì mục About chỉ có 1 lựa chọn duy nhất

       
		
		
	}
}
