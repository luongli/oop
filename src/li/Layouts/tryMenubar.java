package Layouts;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
 
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
 

public class tryMenubar extends JFrame implements ActionListener{
	private JMenuBar menuBar = new JMenuBar();
    private JMenu mFile = new JMenu("File");
    private JMenuItem itemAbout = new JMenuItem("About");
    private JMenuItem itemNew = new JMenuItem("New");
    private JMenuItem itemOpen = new JMenuItem("Open");
    private JMenuItem itemSave = new JMenuItem("Save");
    private JMenuItem itemSaveAs = new JMenuItem("Save As");
 
    public tryMenubar(){
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
 
        // Thêm menu chính vào Frame
        this.setJMenuBar(menuBar);
        // Vì đây là JMenuBar nên khi đặt menu các bạn phải dùng phương thức setJMenuBar
 
        this.setSize(400, 300);
        this.setVisible(true);
        itemAbout.addActionListener(this);
        itemNew.addActionListener(this);
        itemOpen.addActionListener(this);
        itemSave.addActionListener(this);
        itemSaveAs.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        // bắt sự kiện theo cách 1
        // nếu chọn about
        if(e.getSource() == itemAbout ){
            JOptionPane.showMessageDialog(null, "Bạn vừa chọn About", "Thông báo", JOptionPane.CLOSED_OPTION);
        }
 
        // nếu chọn new
        if(e.getSource() == itemNew ){
            JOptionPane.showMessageDialog(null, "Bạn vừa chọn New ", "Thông báo", JOptionPane.CLOSED_OPTION);
        }
 
        // bắt sự kiện theo cách 2
        // nếu chọn Open
        if(e.getActionCommand().equalsIgnoreCase("Open") ){
            JOptionPane.showMessageDialog(null, "Bạn vừa chọn Open ", "Thông báo", JOptionPane.CLOSED_OPTION);
        }
 
        if(e.getActionCommand().equalsIgnoreCase("Save") ){
            JOptionPane.showMessageDialog(null, "Bạn vừa chọn Save ", "Thông báo", JOptionPane.CLOSED_OPTION);
        }
 
        if(e.getActionCommand().equalsIgnoreCase("Save As") ){
            JOptionPane.showMessageDialog(null, "Bạn vừa chọn Save As", "Thông báo", JOptionPane.CLOSED_OPTION);
        }
    }
 
    public static void main(String[] args) {
        new tryMenubar();
    }
}
